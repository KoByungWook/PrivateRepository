package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;

@Component
public class PhotoBoardDaoImpl implements PhotoBoardDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoardDaoImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public String memberInsert(PhotoBoardMember member) {

		String sql = "insert into member ";
		sql += "(mid, mpassword, mname, mage, mdate, moriginalfilename, msavedfilename, mfilecontent) ";
		sql += "values ";
		sql += "(?, ?, ?, ?, sysdate, ?, ?, ?)";

		jdbcTemplate.update(sql, member.getMid(), member.getMpassword(), member.getMname(), member.getMage(),
				member.getMoriginalfilename(), member.getMsavedfilename(), member.getMfilecontent());

		String mid = member.getMid();

		return mid;
	}

	@Override
	public String checkMid(String mid) {
		String result = "fail";

		RowMapper<PhotoBoardMember> rowMapper = new RowMapper<PhotoBoardMember>() {
			@Override
			public PhotoBoardMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				PhotoBoardMember member = new PhotoBoardMember();
				member.setMid(rs.getString("mid"));
				return member;
			}
		};

		String sql = "select * from member where mid=?";

		try {
			jdbcTemplate.queryForObject(sql, rowMapper, mid);

			result = "success";
			return result;

		} catch (Exception e) {
			return result;
		}
	}

	@Override
	public String checkMpassword(String mid, String mpassword) {
		String result = "fail";

		String sql = "select * from member where mid=?";

		RowMapper<PhotoBoardMember> rowMapper = new RowMapper<PhotoBoardMember>() {
			@Override
			public PhotoBoardMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				PhotoBoardMember member = new PhotoBoardMember();
				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				return member;
			}
		};

		PhotoBoardMember member = jdbcTemplate.queryForObject(sql, rowMapper, mid);

		if (member.getMpassword().equals(mpassword)) {
			result = "success";
		}
		return result;
	}

	@Override
	public PhotoBoardMember memberSelectByMid(String mid) {

		String sql = "select * from member where mid=?";

		RowMapper<PhotoBoardMember> rowMapper = new RowMapper<PhotoBoardMember>() {
			@Override
			public PhotoBoardMember mapRow(ResultSet rs, int rowNum) throws SQLException {
				PhotoBoardMember member = new PhotoBoardMember();

				member.setMid(rs.getString("mid"));
				member.setMpassword(rs.getString("mpassword"));
				member.setMname(rs.getString("mname"));
				member.setMage(rs.getInt("mage"));
				member.setMdate(rs.getDate("mdate"));
				member.setMoriginalfilename(rs.getString("moriginalfilename"));
				member.setMsavedfilename(rs.getString("msavedfilename"));
				member.setMfilecontent(rs.getString("mfilecontent"));

				return member;
			}
		};

		PhotoBoardMember member = jdbcTemplate.queryForObject(sql, rowMapper, mid);

		return member;
	}

	@Override
	public void memberUpdate(PhotoBoardMember member) {

		String sql;
		if (member.getMoriginalfilename() != null) {
			sql = "update member set mpassword=?, mname=?, mage=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=? ";
			jdbcTemplate.update(sql, member.getMpassword(), member.getMname(), member.getMage(),
					member.getMoriginalfilename(), member.getMsavedfilename(), member.getMfilecontent());
		} else {
			sql = "update member set mpassword=?, mname=?, mage=? where mid=? ";
			jdbcTemplate.update(sql, member.getMpassword(), member.getMname(), member.getMage());
		}

	}
	//////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public int boardInsert(PhotoBoard board) {

		int bno = -1;

		final String sql = "insert into board "
		+ "(bno, bid, btitle, bdate, bcontent, boriginalfilename, bsavedfilename, bfilecontent, bhitcount) "
		+ "values "
		+ "(board_bno_seq.nextval, ?, ?, sysdate, ?, ?, ?, ?, 0)";

		PreparedStatementCreator psc = new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
				pstmt.setString(1, board.getBid());
				pstmt.setString(2, board.getBtitle());
				pstmt.setString(3, board.getBcontent());
				pstmt.setString(4, board.getBoriginalfilename());
				pstmt.setString(5, board.getBsavedfilename());
				pstmt.setString(6, board.getBfilecontent());
				return pstmt;
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(psc, keyHolder);
		bno = keyHolder.getKey().intValue();

		LOGGER.info(String.valueOf(bno));

		return bno;
	}

	@Override
	public List<PhotoBoard> boardSelectPage(int pageNo, int rowsPerPage) {
		
			String sql = "select * ";
			sql += "from ( ";
			sql += "  select rownum as r, bno, btitle, bid, bdate, bhitcount, boriginalfilename, bsavedfilename ";
			sql += "  from ( ";
			sql += "    select bno, btitle, bid, bdate, bhitcount, boriginalfilename, bsavedfilename from board order by bno desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += "  ) ";
			sql += "where r>=? ";
			
			Object[] args = { (pageNo*rowsPerPage), ((pageNo-1)*rowsPerPage+1) };
			
			RowMapper<PhotoBoard> rowMapper = new RowMapper<PhotoBoard>() {
				@Override
				public PhotoBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
					PhotoBoard board = new PhotoBoard();
					board.setBno(rs.getInt("bno"));
					board.setBoriginalfilename(rs.getString("boriginalfilename"));
					board.setBtitle(rs.getString("btitle"));
					board.setBid(rs.getString("bid"));
					board.setBdate(rs.getDate("bdate"));
					board.setBhitcount(rs.getInt("bhitcount"));
					board.setBsavedfilename(rs.getString("bsavedfilename"));
					return board;
				}
			};
			
			List<PhotoBoard> list = jdbcTemplate.query(sql, args, rowMapper);
			return list;
	}

	@Override
	public int boardCountAll() {
		String sql = "select count(*) from board ";
		
		int count = jdbcTemplate.queryForObject(sql, Integer.class);

		return count;
	}

	@Override
	public PhotoBoard boardSelectByBno(int bno) {
		String sql = "select * from board where bno=?";
		
		RowMapper<PhotoBoard> rowMapper = new RowMapper<PhotoBoard>() {
			@Override
			public PhotoBoard mapRow(ResultSet rs, int rowNum) throws SQLException {
				PhotoBoard board = new PhotoBoard();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBid(rs.getString("bid"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
				return board;
			}
		};
		
		PhotoBoard board = jdbcTemplate.queryForObject(sql, rowMapper, bno);
		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		String sql = "update board set bhitcount=? where bno=? ";
		
		jdbcTemplate.update(sql, bhitcount, bno);
	}

	@Override
	public void boardUpdate(PhotoBoard board) {

		String sql;
		if (board.getBoriginalfilename() != null) {
			sql = "update board set btitle=?, bcontent=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=? ";
			jdbcTemplate.update(board.getBtitle(), board.getBcontent(), board.getBoriginalfilename(),
					board.getBsavedfilename(), board.getBfilecontent(), board.getBno());
		} else {
			sql = "update board set btitle=?, bcontent=?, bdate=sysdate where bno=? ";
			jdbcTemplate.update(board.getBtitle(), board.getBcontent(), board.getBno());
		}
	}

	@Override
	public void boardDelete(int bno) {
		String sql = "delete from board where bno=? ";
		jdbcTemplate.update(sql, bno);
	}

	@Override
	public List<PhotoBoard> boardSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}
}

package com.mycompany.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;

@Component
public class PhotoBoardDaoImpl implements PhotoBoardDao {
	private static final Logger LOGGER = LoggerFactory.getLogger(PhotoBoardDaoImpl.class);

	@Override
	public String memberInsert(PhotoBoardMember member) {
		String mid = null;
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");

			LOGGER.info("연결 성공");

			String sql = "insert into member ";
			sql += "(mid, mpassword, mname, mage, mdate, moriginalfilename, msavedfilename, mfilecontent) ";
			sql += "values ";
			sql += "(?, ?, ?, ?, sysdate, ?, ?, ?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpassword());
			pstmt.setString(3, member.getMname());
			pstmt.setInt(4, member.getMage());
			pstmt.setString(5, member.getMoriginalfilename());
			pstmt.setString(6, member.getMsavedfilename());
			pstmt.setString(7, member.getMfilecontent());
			pstmt.executeUpdate();

			mid = member.getMid();
			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return mid;
	}

	@Override
	public String checkMid(String mid) {
		String result = "fail";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");

			LOGGER.info("연결 성공");

			String sql = "select * from member where mid=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			LOGGER.info(mid);
			
			ResultSet rs = pstmt.executeQuery();

			if(rs.next()) {
				result = "success";
			}
			
			LOGGER.info(result);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
	@Override
	public String checkMpassword(String mid, String mpassword) {
		String result = "fail";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");

			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";

			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");

			LOGGER.info("연결 성공");

			String sql = "select * from member where mid=?";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			
			if(rs.getString("mpassword").equals(mpassword)) {
				result = "success";
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return result;
	}
	
@Override
	public PhotoBoardMember memberSelectByMid(String mid) {
	PhotoBoardMember member = null;
	Connection conn = null;

	try {
		Class.forName("oracle.jdbc.OracleDriver");

		String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";

		conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
		LOGGER.info("연결 성공");

		String sql = "select * from member where mid=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			member = new PhotoBoardMember();

			member.setMid(rs.getString("mid"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMname(rs.getString("mname"));
			member.setMage(rs.getInt("mage"));
			member.setMdate(rs.getDate("mdate"));
			member.setMoriginalfilename(rs.getString("moriginalfilename"));
			member.setMsavedfilename(rs.getString("msavedfilename"));
			member.setMfilecontent(rs.getString("mfilecontent"));
		}
		rs.close();
		pstmt.close();

	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return member;
	}

	@Override
	public void memberUpdate(PhotoBoardMember member) {
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql;
			if (member.getMoriginalfilename() != null) {
				sql = "update member set mpassword=?, mname=?, mage=?, moriginalfilename=?, msavedfilename=?, mfilecontent=? where mid=? ";
			} else {
				sql = "update member set mpassword=?, mname=?, mage=? where mid=? ";
			}
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMpassword());
			pstmt.setString(2, member.getMname());
			pstmt.setInt(3, member.getMage());
			
			if (member.getMoriginalfilename() != null) {
				pstmt.setString(4, member.getMoriginalfilename());
				pstmt.setString(5, member.getMsavedfilename());
				pstmt.setString(6, member.getMfilecontent());
				pstmt.setString(7, member.getMid());
				LOGGER.info(member.getMid());
			} else {
				pstmt.setString(4, member.getMid());
			}
			pstmt.executeUpdate();

			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public int boardInsert(PhotoBoard board) {
		LOGGER.info("실행");
		int bno = -1;
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql = "insert into board ";
			sql += "(bno, bid, btitle, bdate, bcontent, boriginalfilename, bsavedfilename, bfilecontent, bhitcount) ";
			sql += "values ";
			sql += "(board_bno_seq.nextval, ?, ?, sysdate, ?, ?, ?, ?, 0)"; 
			LOGGER.info("실행2");													
			PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
			pstmt.setString(1, board.getBid());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBoriginalfilename());
			pstmt.setString(5, board.getBsavedfilename());
			pstmt.setString(6, board.getBfilecontent());
			pstmt.executeUpdate();
			LOGGER.info("실행3");
			ResultSet rs = pstmt.getGeneratedKeys();
			
			rs.next();
			
			bno = rs.getInt(1);
			
			pstmt.close();
			
			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return bno;
	}

	@Override
	public List<PhotoBoard> boardSelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PhotoBoard> boardSelectPage(int pageNo, int rowsPerPage) {
		List<PhotoBoard> list = new ArrayList<>();
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql = "select * ";
			sql += "from ( ";
			sql += "  select rownum as r, bno, btitle, bid, bdate, bhitcount, boriginalfilename, bsavedfilename ";
			sql += "  from ( ";
			sql += "    select bno, btitle, bid, bdate, bhitcount, boriginalfilename, bsavedfilename from board order by bno desc ";
			sql += "  ) ";
			sql += "  where rownum<=? ";
			sql += "  ) ";
			sql += "where r>=? ";
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pageNo * rowsPerPage);
			pstmt.setInt(2, (pageNo - 1) * rowsPerPage + 1);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				PhotoBoard board = new PhotoBoard();
				
				board.setBno(rs.getInt("bno"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBtitle(rs.getString("btitle"));
				board.setBid(rs.getString("bid"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));

				list.add(board);
			}

			rs.close();
			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return list;
	}

	@Override
	public int boardCountAll() {
		int count = 0;
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql = "select count(*) from board ";
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			rs.next();
			count = rs.getInt(1);

			rs.close();
			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return count;
	}

	@Override
	public PhotoBoard boardSelectByBno(int bno) {
		PhotoBoard board = null;
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql = "select * from board where bno=?";
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new PhotoBoard();

				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBid(rs.getString("bid"));
				board.setBdate(rs.getDate("bdate"));
				board.setBhitcount(rs.getInt("bhitcount"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBoriginalfilename(rs.getString("boriginalfilename"));
				board.setBsavedfilename(rs.getString("bsavedfilename"));
				board.setBfilecontent(rs.getString("bfilecontent"));
			}

			rs.close();
			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql = "update board set bhitcount=? where bno=? ";
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bhitcount);
			pstmt.setInt(2, bno);
			pstmt.executeUpdate();

			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void boardUpdate(PhotoBoard board) {
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql;
			if (board.getBoriginalfilename() != null) {
				sql = "update board set btitle=?, bcontent=?, bdate=sysdate, boriginalfilename=?, bsavedfilename=?, bfilecontent=? where bno=? ";
			} else {
				sql = "update board set btitle=?, bcontent=?, bdate=sysdate where bno=? ";
			}
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());

			if (board.getBoriginalfilename() != null) {
				pstmt.setString(3, board.getBoriginalfilename());
				pstmt.setString(4, board.getBsavedfilename());
				pstmt.setString(5, board.getBfilecontent());
				pstmt.setInt(6, board.getBno());
			} else {
				pstmt.setInt(3, board.getBno());
			}
			pstmt.executeUpdate();

			pstmt.close();

			LOGGER.info("행 추가 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void boardDelete(int bno) {
		Connection conn = null;
		try {
			// JDBC Driver Class 로딩
			Class.forName("oracle.jdbc.OracleDriver");
			// 연결 문자열 작성
			String connectionString = "jdbc:oracle:thin:@localhost:1521:orcl";
			// 연결 객체 얻기
			conn = DriverManager.getConnection(connectionString, "photoboard", "iot12345");
			LOGGER.info("연결 성공");
			// SQL 작성
			String sql;
			sql = "delete from board where bno=? ";
			// SQL문 전송해서 실행
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			pstmt.executeUpdate();
			pstmt.close();

			LOGGER.info("행 삭제 성공");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 연결 끊기
			try {
				conn.close();
				LOGGER.info("연결 끊기");
			} catch (SQLException e) {
			}
		}
	}
}

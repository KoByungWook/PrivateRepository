package com.mycompany.myapp.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dto.Exam12Board;
import com.mycompany.myapp.dto.Exam12Member;

@Component
public class Exam12DaoImpl3 implements Exam12Dao {
	private static final Logger LOGGER = LoggerFactory.getLogger(Exam12DaoImpl3.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int boardInsert(Exam12Board board) {
		sqlSessionTemplate.insert("board.insert", board);	//�궫�엯�맂 �뻾�쓽 �닔瑜� 由ы꽩
		return board.getBno();
	}

	@Override
	public List<Exam12Board> boardSelectAll() {
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectAll");
		return list;
	}

	@Override
	public List<Exam12Board> boardSelectPage(int pageNo, int rowsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo-1)*rowsPerPage+1);
		map.put("endNum", pageNo*rowsPerPage);
		List<Exam12Board> list = sqlSessionTemplate.selectList("board.selectByPage", map);
		
		return list;
	}

	@Override
	public int boardCountAll() {
		int count = sqlSessionTemplate.selectOne("board.countAll");
		return count;
	}

	@Override
	public Exam12Board boardSelectByBno(int bno) {
		Exam12Board board = sqlSessionTemplate.selectOne("board.selectByBno", bno);
		return board;
	}

	@Override
	public void boardUpdateBhitcount(int bno, int bhitcount) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bno", bno);
		map.put("bhitcount", bhitcount);
		sqlSessionTemplate.update("board.updateBhitcount", map);
	}

	@Override
	public void boardUpdate(Exam12Board board) {
		sqlSessionTemplate.update("board.update", board);	
	}

	@Override
	public void boardDelete(int bno) {
		sqlSessionTemplate.update("board.delete", bno);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public String memberInsert(Exam12Member member) {
		sqlSessionTemplate.insert("member.insert", member);
		return member.getMid();
	}

	@Override
	public List<Exam12Member> memberSelectPage(int pageNo, int rowsPerPage) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("startNum", (pageNo-1)*rowsPerPage+1);
		map.put("endNum", pageNo*rowsPerPage);
		List<Exam12Member> list = sqlSessionTemplate.selectList("member.selectByPage", map);
		
		return list;
	}

	@Override
	public int memberCountAll() {
		int count = sqlSessionTemplate.selectOne("member.countAll");
		return count;
	}

	@Override
	public Exam12Member memberSelectByMid(String mid) {
		Exam12Member member = sqlSessionTemplate.selectOne("member.selectByMid", mid);
		return member;
	}

	@Override
	public void memberUpdate(Exam12Member member) {
		sqlSessionTemplate.update("member.update", member);
	}

	@Override
	public void memberDelete(String mid) {
		sqlSessionTemplate.update("member.delete", mid);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
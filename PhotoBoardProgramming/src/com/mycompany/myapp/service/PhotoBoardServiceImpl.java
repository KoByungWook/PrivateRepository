package com.mycompany.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myapp.dao.PhotoBoardDao;
import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;

@Component
public class PhotoBoardServiceImpl implements PhotoBoardService {
	@Autowired
	private PhotoBoardDao dao;
	
	@Override
	public void memberJoin(PhotoBoardMember member) {
		dao.memberInsert(member);
	}

	@Override
	public String checkMid(String mid) {
		String result = dao.checkMid(mid);
		return result;
	}
	
	@Override
	public String checkMpassword(String mid, String mpassword) {
		String result = dao.checkMpassword(mid, mpassword);
		return result;
	}
	
	@Override
	public PhotoBoardMember getMember(String mid) {
		PhotoBoardMember member = dao.memberSelectByMid(mid);
		return member;
	}
	
	@Override
	public void memberUpdate(PhotoBoardMember member) {
		dao.memberUpdate(member);
	}
	//////////////////////////////////////////////////////////////////////
	
	@Override
	public void boardWrite(PhotoBoard board) {
		dao.boardInsert(board);
	}

	@Override
	public List<PhotoBoard> boardListAll() {
		List<PhotoBoard> list = dao.boardSelectAll();
		return list;
	}

	@Override
	public List<PhotoBoard> boardListPage(int pageNo, int rowsPerPage) {
		List<PhotoBoard> list = dao.boardSelectPage(pageNo, rowsPerPage);
		return list;
	}

	@Override
	public int boardTotalRows() {
		int totalRows = dao.boardCountAll();
		return totalRows;
	}

	@Override
	public PhotoBoard getBoard(int bno) {
		PhotoBoard board = dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount() + 1);
		return board;
	}
	
	@Override
	public PhotoBoard getBoardDetail(int bno) {
		PhotoBoard board = dao.boardSelectByBno(bno);
		board.setBhitcount(board.getBhitcount() + 1);
		dao.boardUpdateBhitcount(bno, board.getBhitcount());
		return board;
	}
	
	@Override
	public String boardCheckMid(String bid, String mid) {
		String result = "fail";
		
		if(bid.equals(mid)) {
			result = "success";
		}
		
		return result;
	}
	
	@Override
	public void boardUpdate(PhotoBoard board) {
		dao.boardUpdate(board);
	}

	@Override
	public void boardDelete(int bno) {
		dao.boardDelete(bno);
	}
}

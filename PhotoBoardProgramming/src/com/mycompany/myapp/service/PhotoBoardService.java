package com.mycompany.myapp.service;

import java.util.List;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;

public interface PhotoBoardService {
	public void memberJoin(PhotoBoardMember member);
	public String checkMid(String mid);
	public String checkMpassword(String mid, String mpassword);
	public PhotoBoardMember getMember(String mid);
	public void memberUpdate(PhotoBoardMember member);
	
	public void boardWrite(PhotoBoard board);
	public List<PhotoBoard> boardListAll();
	public List<PhotoBoard> boardListPage(int pageNo, int rowsPerPage);
	public int boardTotalRows();
	public PhotoBoard getBoard(int bno);
	public PhotoBoard getBoardDetail(int bno);
	public String boardCheckMid(String bid, String mid);
	public void boardUpdate(PhotoBoard board);
	public void boardDelete(int bno);
}
	
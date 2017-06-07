package com.mycompany.myapp.dao;

import java.util.List;

import com.mycompany.myapp.dto.PhotoBoard;
import com.mycompany.myapp.dto.PhotoBoardMember;

public interface PhotoBoardDao {
	public String memberInsert(PhotoBoardMember member);
	public String checkMid(String mid);
	public String checkMpassword(String mid, String mpassword);
	public PhotoBoardMember memberSelectByMid(String mid);
	public void memberUpdate(PhotoBoardMember member);
	
	public int boardInsert(PhotoBoard board);
	public List<PhotoBoard> boardSelectAll();
	public List<PhotoBoard> boardSelectPage(int pageNo, int rowsPerPage);
	public int boardCountAll();
	public PhotoBoard boardSelectByBno(int bno);
	public void boardUpdateBhitcount(int bno, int bhitcount);
	public void boardUpdate(PhotoBoard board);
	public void boardDelete(int bno);
}

package ch15.homework;

import java.util.ArrayList;
import java.util.List;

public class BoardDao {
	public List<Board2> getBoardList() {
		List<Board2> list = new ArrayList<Board2>();
		list.add(new Board2("����1", "����1"));
		list.add(new Board2("����2", "����2"));
		list.add(new Board2("����3", "����3"));
		return list;
	}
}

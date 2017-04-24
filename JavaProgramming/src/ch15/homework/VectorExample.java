package ch15.homework;

import java.util.List;
import java.util.Vector;

public class VectorExample {
	public static void main(String[] args) {
		List<Board> list = new Vector<>();
		
		list.add(new Board("제목 1", "내용 1", "글쓴이 1"));
		list.add(new Board("제목 2", "내용 2", "글쓴이 2"));
		list.add(new Board("제목 3", "내용 3", "글쓴이 3"));
		list.add(new Board("제목 4", "내용 4", "글쓴이 4"));
		list.add(new Board("제목 5", "내용 5", "글쓴이 5"));
		
		list.remove(2);
		list.remove(3);
		
		for(int i=0; i<list.size(); i++) {
			Board board = list.get(i);
			System.out.println(board.subject + "\t" + board.content + "\t" + board.writer);
		}
	}

}

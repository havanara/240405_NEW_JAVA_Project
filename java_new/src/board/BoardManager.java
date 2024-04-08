package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager implements BoardInterface{
	
	ArrayList<Board> list = new ArrayList<Board>();

	public void addBoard(Scanner scan) {
		System.out.println("게시글 등록");
		System.out.println("제목 > ");
		scan.nextLine(); //메뉴에서 입력된 엔터를 인식하기 때문에 해당 처리용
		String title = scan.nextLine(); //nextLine 공백포함
		System.out.println("작성자 > ");
		String writer = scan.next();
		System.out.println("내용 > ");
		scan.nextLine();
		String content = scan.nextLine();
		
		Board b = new Board(title, content, writer);
		list.add(b);
		System.out.println("등록 완료!");
	}

	public void searchBoard(Scanner scan) {
		System.out.println("조회할 게시글 번호 > ");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		//indexOf : 해당 객체의 번지를 리턴, 없으면 -1을 리턴
		if(index != -1) {
			//해당 게시글이 있다는 의미
			Board tmp = list.get(index);
			tmp.print();
			return;
		}else {
			System.out.println("일치하는 게시글이 없습니다.");
		}
	}

	public void modifyBoard(Scanner scan) {
		System.out.println("수정할 게시글 번호 > ");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		//indexOf : 해당 객체의 번지를 리턴, 없으면 -1을 리턴
		if(index != -1) {
			//수정 작업
			System.out.println("제목 > ");
			scan.nextLine();
			String title = scan.nextLine();
			System.out.println("내용 > ");
			String content = scan.nextLine();
			
			Board tmp = list.get(index);
			tmp.setTitle(title);
			tmp.setContent(content);
			tmp.print();
			System.out.println("수정 완료!");
			return;
		}else {
			System.out.println("일치하는 게시글이 없습니다.");
		}		
	}

	public void removeBoard(Scanner scan) {
		System.out.println("삭제할 게시글 번호 > ");
		int num = scan.nextInt();
		int index = list.indexOf(new Board(num));
		
		if(index != -1) {
			list.remove(index);
			System.out.println("삭제 완료!");
		}else {
			System.out.println("일치하는 게시글이 없습니다.");
		}
	}

	public void printBoard() {
		//toString 이용
		for(Board b : list) {
			System.out.println(b);
		}
	}

	public void printMenu() {
		System.out.println("-------menu-------");
		System.out.println("1.등록 2.검색 3.수정");
		System.out.println("4.삭제 5.목록 6.종료");
		System.out.println("menu > ");
	}


}

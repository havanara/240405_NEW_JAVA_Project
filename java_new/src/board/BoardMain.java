package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		/* Board class 생성
		 * 번호, 제목, 내용, 작성자, 작성일
		 * - 번호 : 객체 생성시 자동으로 증가
		 * - 작성일 : 오늘 날짜로 자동 생성 date형태 now 심플데이트포맷 날짜클래스 참고
		 * - 번호가 일치하면 같은 게시물로 인지 equals 추가
		 * 	 ex)1번 게시물 지워줘 -> 1번 게시물 삭제 처리
		 * */ 
		
		Scanner scan = new Scanner(System.in);
		
		BoardManager bm = new BoardManager();
		
		int menu = 0;
		
		do {
			bm.printMenu();
						
			menu = scan.nextInt();
			
			switch(menu) {
			case 1 : bm.addBoard(scan); break;
			case 2 : bm.searchBoard(scan); break;
			case 3 : bm.modifyBoard(scan); break;
			case 4 : bm.removeBoard(scan); break;
			case 5 : bm.printBoard(); break;
			case 6 : System.out.println("종료합니다."); break;
			default : System.out.println("잘못된 메뉴입니다."); break;
			}			
		}while(menu != 6); //menu가 6이 아니면 반복해서 돌아가
		
		scan.close();
	}

}

package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 : 의미
		 * map으로 생성
		 * 입력받을 단어의 갯수를 입력받아 갯수만큼 map에 추가
		 * 콘솔 출력
		 * */
		
		Scanner scan = new Scanner(System.in);
		
		HashMap<String, String> map = new HashMap<>();
		
		System.out.println("단어장 만들기");
		System.out.println("단어 개수를 입력하세요.");
		int num = scan.nextInt();
		while(!(num==map.size())) {			
			System.out.println("단어를 입력하세요.");
			String word = scan.next();
			System.out.println("단어의 뜻을 입력하세요.");
			String mean = scan.next();
			map.put(word, mean);
		}
		
		System.out.println();
		System.out.println("[단어장]");
		
		for(String key : map.keySet()) {
			System.out.println(key+" : "+map.get(key));
		}
		
		scan.close();

	}

}

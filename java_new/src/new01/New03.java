package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class New03 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크
		 * - List : 순서를 보장, 중복 저장 가능
		 * - Set : 순서보장x, 중복x
		 * - Map : 순서보장x, 데이터를 쌍으로 저장(key, value)
		 * key(중복불가), value(중복 가능)
		 * */
		
		// 리스트를 생성하고 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		for(Integer tmp : list) {
			System.out.print(tmp+" ");
		}
		
		System.out.println();
		
		// map을 이용하여 이름 : 점수 형태로 3명만 입력
		HashMap<String, Integer> map = new HashMap<>();
		map.put("kim", 89);
		map.put("lee", 75);
		map.put("hong", 95);
		System.out.println(map);
		
		//key : value 형태로 출력
		//for문 사용
		for(String key : map.keySet()) {
			System.out.println(key+" : "+map.get(key));
		}
		
		//Iterator 사용
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key+" : "+map.get(key));
		}
	}

}

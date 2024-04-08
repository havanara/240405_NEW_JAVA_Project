package new01;

public class New01 {

	public static void main(String[] args) {
		/* 홍길동 주민등록번호 881122-1234567이다
		 * 출력형태 -> 생년월일 : 881122, 성별 : 남
		 * 성별이 남인 경우는 1또는 3
		 * */
		
		String pin = "881122-1234567";
		
		String birth = pin.substring(0,pin.indexOf("-"));
		System.out.println(birth);
		
		String gender = pin.substring(pin.indexOf("-")+1,8);
		System.out.println(gender);
		
		if(gender.equals("1")||gender.equals("3")) {
			System.out.println("생년월일 : "+birth+", 성별 : 남");
		}else if(gender.equals("2")||gender.equals("4")){
			System.out.println("생년월일 : "+birth+", 성별 : 여");
		}else {
			System.out.println("잘못 입력된 값입니다.");
		}
		
	}

}

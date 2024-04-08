package new02;

public class Singleton {
	/* 싱글톤 패턴 : 디자인 패턴 중 하나
	 * 단 1개만 존재해야하는 객체를 생성하여 공유하고자 할 때 사용
	 * */
	
	private static Singleton instance;
	
	//생성자를 통해 객체 생성을 막기 위해 생성자 private 설정
	private Singleton() {}
	
	//getter getInstance() 메서드를 사용하여 instance 생성
	//instance가 있으면 기존의 instance를 리턴
	public static Singleton getInstance() {
		if(instance == null) { //1번 : 쓰레드가 동시 접근시 문제
			instance = new Singleton(); //2번 : 쓰레드가 동시 접근시 인스턴스 여러번 생성
		}
		return instance;
}
}

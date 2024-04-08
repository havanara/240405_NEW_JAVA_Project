package new02;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Network01 {

	public static void main(String[] args) throws UnknownHostException {
		InetAddress ip = null;
		ip = InetAddress.getByName("www.naver.com");
		System.out.println("HostAddress : "+ip.getHostAddress()); //www.naver.com의 ip주소를 얻을 수 있음
		System.out.println("HostAddress : "+ip.getHostName());//www.naver.com의 주소를 얻을 수 있음
		System.out.println(ip.toString()); //www.naver.com의 ip와 주소 모두를 얻을 수 있음
	}

}

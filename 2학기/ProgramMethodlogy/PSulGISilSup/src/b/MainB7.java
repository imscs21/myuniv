package b;

import java.util.*;

import base.BaseMain;
public class MainB7 extends BaseMain{
	public static void main(String...strings ){
		Scanner sc = getScanner();
		print("파일 용량을 메바이트 단위로 입력하세요. ");
		final int megabytes = sc.nextInt();
		long bytes = megabytes*1024*1024;
		
		print("USB 포트가 2.0 이면 Y , 아니면 N을 입력하세요. ");
		String usb2=sc.next();
		
	long[] unit = {1500000,60000000};
		int time = usb2.toLowerCase().equals("y")?(int)(bytes/unit[1]):(int)(bytes/unit[0]);
	printline("파일 전송 시간은 "+time+" 초 입니다.");
		
	}
}

package c;

import java.util.Scanner;

public class C7 extends base.BaseMain{
	public static void main(String...strings ){
		final int megabytes = getInput().readInt("파일 용량을 메바이트 단위로 입력하세요. ");
		long bytes = megabytes*1024*1024;
		
		print("USB 포트가 2.0 이면 Y , 아니면 N을 입력하세요. ");
		byte kind=getInput().readByte("전송 방식을 1: Wi-Fi, 2:BlueTooth, 3:LTE, 4:USB 에서 선택하여 입력하세요. ");
		
	long[] unit = {0,1500000,300000,1000000,60000000};
		float time = Math.round( (bytes+0.0f)/(unit[kind]+0.0f)*10.0f)/10.0f;
	printline("파일 전송 시간은 "+time+" 초 입니다.");
		
	}
}

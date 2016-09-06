package a;
import java.util.*;

import base.BaseMain;
public class Main7 extends BaseMain{

	public static void main(String...strings ){
		Scanner sc = getScanner();
		print("파일 용량을 기가바이트 단위로 입력하세요. ");
		final int gigabytes = sc.nextInt();
		int megabytes,kilobytes;
		String[] unit = {""," 메가바이트,"," 킬로바이트,"};
	
		int[] d = new int[3];
		d[0]=gigabytes;
		printline("입력하신 파일 용량은 ");
		
		for(int i=1;i<d.length;i++){
			d[i]=d[i-1]*1024;
		printline(d[i]+unit[i]);
		}
		long bytes = d[2]*1024;
		printline(bytes+" 바이트 입니다 ");
		
	}
}

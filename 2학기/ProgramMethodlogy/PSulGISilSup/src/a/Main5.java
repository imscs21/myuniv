package a;
import java.util.*;

import base.BaseMain;
public class Main5 extends BaseMain{
	
public static void main(String... arg){
	Scanner sc = getScanner();
	
	print("날 수를 입력하세요. ");
	final int days = sc.nextInt();
	final int seconds = days*24*60*60;
	printline("날 수에 해당되는 시간은 모두 "+seconds + " 초 입니다.");

}

}

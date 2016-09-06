package b;

import java.util.Scanner;

import a.Main5;

public class MainB5 extends Main5{

	
public static void main(String... arg){
	Scanner sc = getScanner();
	
	print("날 수를 입력하세요. ");
	final int days = sc.nextInt();
	final int seconds = days*24*60*60;
	printline("날 수에 해당되는 시간은 모두 "+seconds + " 초 입니다.");
	int m_count = seconds/1000000;
	if(m_count>0)
	printline("100만 초가 모두 2번이나 포함됩니다.");
}
}

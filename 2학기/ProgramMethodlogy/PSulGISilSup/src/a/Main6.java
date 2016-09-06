package a;
import java.util.*;

import base.BaseMain;
public class Main6 extends BaseMain{
public static void main(String...strings ){
	Scanner sc = getScanner();
	int kor,eng,math,total;
	int[] d = new int[4];
	String[] str = {"국어 ","영어 ","수학 "};
for(int i =0;i<str.length;i++){
	print(str[i]+"점수를 입력하세요. ");
	d[i] = sc.nextInt();
	d[3]+=d[i];
}
double average = (d[3]+0.0f)/str.length;
printline("입력하신 총점은 "+d[3]+" 이고,");
printline("평균은 "+Math.round( average*10)/10.0f+" 입니다.");
	
}
}

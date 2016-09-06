package b;

import java.util.*;

import base.BaseMain;
public class MainB4 extends BaseMain {
	public static void main(String...strings){
		Scanner sc = getScanner();
		print("아파트의 분양 면적을 입력하시오. ");
	final	double m2_area=sc.nextDouble();
	final double pyung_area = m2_area/3.305; 	
	printline("아파트의 평형은 "+Math.round(pyung_area*10)/10.0f+" 이고.");
if(pyung_area<30){
	printline("30평 미만이므로 작은 아파트입니다.");
}
else{
	printline("30평 이상이므로 큰 아파트입니다.");
}
	}
}

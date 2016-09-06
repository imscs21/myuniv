package c;
import base.BaseMain;
public class C4 extends BaseMain{
public static void main(String...strings){
	final double m2_area=getInput().readDouble("면적? "); // 면적 (제곱미터) 
	final double pyung_area = Math.round((10*m2_area)/3.305)/10.0d; // 면적 (평수)
	printline("아파트의 평형은 "+pyung_area+" 입니다.");
	if(pyung_area<15){
		print("소형 ");
	}
	else if(pyung_area<30){
		print("중소형 ");
	}
	else if(pyung_area<50){
		print("중형 ");
	}
	else {
		print("대형 ");
	}
	print("아파트입니다\n");
	
}
}

package b;

import java.util.*;

import base.BaseMain;
public class MainB9 extends BaseMain{
public static void main(String...strings){
	int height,weight,bmi=0;
	print("신장(cm단위)을 입력하세요 ");
height = getScanner().nextInt();

	print("체중(kg단위)를 입력하세요 ");
	weight=getScanner().nextInt();
bmi = weight/(int)Math.pow((height/100.0f), 2);
	if(bmi>=25){
	printline("당신은 비만이십니다");
	}
	else{
		printline("당신은 비만이 아니군요.");
	}
}
}

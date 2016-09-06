package b;

import java.util.*;

import base.BaseMain;
public class MainB2 extends BaseMain {
	public static void main(String... args){
		Scanner sc = getScanner();
		print("온도를 입력하세요. ");
	final double input_degree=sc.nextDouble();
	String kind;
	print("입력하신 온도가 섭씨온도이면 C를, 화씨온도이면 F를 입력하세요. ");
	kind = sc.next();
	if(kind.equals("C")){
		double f_degree = input_degree*1.8d+32;
		System.out.println("변환된 온도는 "+f_degree+"도 입니다.");
	}
	else if(kind.equals("F")){
		double f_degree = (input_degree-32)/1.8d;
		System.out.println("변환된 온도는 "+f_degree+"도 입니다.");
	}
	
	}
}

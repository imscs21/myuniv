package c;
import java.util.*;

import base.BaseMain;
public class MainC2 extends BaseMain{
public static void main(String...strings ){
	double input_degree = getInput().readDouble("물의 온도를 입력하세요 ");
	if(input_degree<0){
		printline("잘못입력하셨습니다. ");
		
	}
	else if(input_degree<25){
		printline("냉수 입니다.");
		
	}else if(input_degree<40){
		printline("미온수 입니다.");
	}
	else if(input_degree<80){
		printline("온수입니다.");
	}
	else {
		printline("끓는 물입니다.");
	}
}
}

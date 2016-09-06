package c;
import java.util.*;

import base.BaseMain;
public class MainC1 extends BaseMain {
public static void main(String...strings ){
	int birth_year ,age;
	birth_year=getInput().readInt("태어난 년도를 입력하세요. ");
	age = 2013-birth_year;
	if(age<7){
		print("유아");
	}
	else if(age<13){
		print("어린이");
	}
	else if(age<20){
		print("청소년");
	}
	else if(age<30){
		print("청년");
	}
	else if(age<60){
		print("중년");
	}
	else{
		print("노년");
	}
	print("입니다.");
}
}

package b;

import java.util.*;

import base.BaseMain;
public class MainB1  extends BaseMain{

	public static void main(String...strings){
		Scanner sc = getScanner();
		print("태어난 년도를 입력하세요. ");
	int birth_year,age;
	birth_year=sc.nextInt();
	age = 2014+1-birth_year;
	if(age<20){
		printline("미성년자입니다.");
	}
	else{
		printline("미성년자가 아닙니다.");
	}
		
	}
}

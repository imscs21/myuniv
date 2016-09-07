package c;

public class C11 extends base.BaseMain{
	
public static void main(String...strings){
	int year = getInput().readInt("year? ");
	if(year%4==0&&(year%100!=0||(year%400==0&&year%100==0))){
		printline("입력하신 년도는 윤년입니다.");
	}
	else{
	printline("입력하신 년도는 윤년이 아닙니다.");
	}
}
}

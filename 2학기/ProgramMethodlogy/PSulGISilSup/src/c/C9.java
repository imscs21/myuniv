package c;

public class C9 extends base.BaseMain{
public static void main(String...strings){
	int income = getInput().readInt("연봉(원 단위)? ");
	int tax;
	if(income < 10000000){
		tax = (int)(income*0.095f);
	}
	else if(income < 40000000){
		tax = (int)(income*0.19f);
	}
	else if(income <80000000){
		tax = (int)(income*0.28f);
	}
	else{
		tax = (int)(income*0.37f);
	}
	printline("소득세 = " + tax+"원 입니다.");
	
}
}

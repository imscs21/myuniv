package c;

public class C10 extends base.BaseMain{
public static void main(String...strings){
	int num1=getInput().readInt("number1? "), num2=getInput().readInt("number2? ");
	String operator=getInput().readString("operator(support operator sush as +,-,*,/)? ");
	
	int result = operator.equals("+")?
			num1+num2:
				operator.equals("-")?num1-num2:operator.equals("*")?num1*num2:num1/num2;
	printline("result is "+result);
	//첫 번째 숫자, 두 번째 숫자
	// 연산기호문자('+', '-', '*', '/' 중 1개) // 연산 결과
	
	
}
}

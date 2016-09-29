package d;

public class D3 extends base.BaseMain{
public static void main(String...strings){
	int number ,count=0,totalsum=0;
	double average;
	while((number=getInput().readInt("number? "))<=100&&number>=0){
++count;
	totalsum+=number;

	}
	average = Math.round(10*(totalsum+0.0f)/count)/10.0d;
	
	printline("입력한 10개의 숫자들의 총합계는 "+totalsum+" 이고, 평균 값은 "+average+"　です。");
}
}

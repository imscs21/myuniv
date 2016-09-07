package d;

public class D9 extends base.BaseMain{
public static void main(String...strings){
	int dan; // 출력하려는 구구단의 단 수
	int i; // 반복문을 위한 변수
	while((dan=getInput().readInt("출력하고 싶은 구구단의 단 수를 입력하시오(2-9) "))<2 || dan >9 ){
	printline("잘못 입력하셨습니다. ");
	}
	for(i=1;i<10;i++){
		printline(String.format("%d X %d = %d", dan,i,dan*i));
	}
}
}

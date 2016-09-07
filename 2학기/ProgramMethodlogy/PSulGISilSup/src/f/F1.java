package f;

public class F1 extends base.BaseMain{
public static void main(String...strings){
	int[] num = new int[10]; int first=Integer.MIN_VALUE;
	int second=Integer.MIN_VALUE;
	int second_max_index=-1; int newnum;
	int i;
	for(i=0;i<num.length;i++){
		num[i] = getInput().readInt((i+1)+"번째 수를 입력하시오. ");
		first=Math.max(first,num[i]);
	}
	for(i=0;i<num.length;i++){
		if(num[i]!=first){
			newnum=second;
			second=Math.max(second, num[i]);
			if(newnum!=second){
				second_max_index = i;
			}
		}

	}
	printline("두 번째로 큰 수는 "+(1+second_max_index)+"번째 수 "+second+" 입니다. ");
	// 10개의 숫자를 담을 리스트 // 첫 번째로 큰 수
	// 두 번째로 큰 수
	// 두 번째로 큰 수의 인덱스 // 숫자 입력을 위한 변수
	// 반복문을 위한 변수
}
}

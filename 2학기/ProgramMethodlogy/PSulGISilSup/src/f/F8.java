package f;

import base.BaseMain;

public class F8 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number[] = new int[10];// 사용자가 입력한 숫자 10개
		int newnum; int count=0; boolean dup=false; int i;
		// 입력받은 숫자
		// 현재까지 입력된 숫자의 개수(0~10)
		// 중복검사 통과 여부 (true : 중복, false : 중복없음) // 반복문을 위한 변수
		printline("1부터 100사이의 숫자를 입력하시오.");
		while(count<10){
			newnum=0;
			dup=((number[count]=getInput().readInt((count+1)+"번째 숫자를 입력하시오. "))<=100&& number[count]>0);
					for(i=0;i<number.length;i++){
						if(number[count]==number[i]){
							newnum++;
						}
					}
		dup = dup&&(newnum<2);
		dup=!dup;
			if(dup){
				printline("잘못 입력하였습니다. 다시 입력하세요.");
			}
			else{
			++count;
			}
		}
		for(i=0;i<number.length;i++){
			printline((i+1)+"번째 숫자는 "+number[i]+"입니다.");
		}
	}

}

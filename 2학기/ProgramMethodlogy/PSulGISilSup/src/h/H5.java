package h;

import base.BaseMain;

public class H5 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int coins=getInput().readInt("사용하실 코인의 개수를 입력하세요. "); // 사용자의 코인 수. (최초에 입력받음)
		int number[] = new int[3]; // 랜덤하게 만들어진 슬롯 머신의 숫자 3개의 리스트 
		int dummy=1; // 게임스타트를 위한 의미 없는 입력 숫자
		int i;
		while(coins>0){
			getInput().readInt(String.format("게임 %d회 Start!!! (아무 숫자나 입력하세요)", dummy++));
		for(i=0;i<number.length;i++){
			number[i] = (int)(Math.random()*10)%9+1;
		}
		print("게임 결과 : ");
	for(i=0;i<number.length;i++){
		print(number[i]+" ");
	}
	print("----> ");
			if(number[0]==number[1]&&number[0]==number[2]&&number[1]==number[2]){
			printline("숫자 3개 일치... 코인 4개 증정");
				coins+=4;
			}
			else if((number[0]==number[1]&&number[0]!=number[2])||(number[0]==number[2]&&number[0]!=number[1])||(number[1]==number[2]&&number[1]!=number[0])){
				printline("숫자 2개 일치... 코인 2개 증정");
				coins+=2;
			}
			else{
				printline("꽝입니다... 아쉽군요..");
			}
			printline("남아있는 코인은 "+(--coins)+"개 입니다.");
		}
printline("\n게임 종료!!");
	}

}

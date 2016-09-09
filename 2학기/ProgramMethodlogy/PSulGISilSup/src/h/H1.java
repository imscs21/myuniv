package h;

import base.BaseMain;

public class H1 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int answer = ((int)(Math.random()*2000))%100+1;
		int number_try; int count=1;
		while((number_try=getInput().readInt("1부터 100까지의 숫자 하나를 맞춰보세요 "))!=answer && (count++)>0){
			print("좀 더 ");
			if(number_try<answer){
				print("큰 ");
			}
			else if(number_try>answer){
				print("작은 ");
			}
			printline("수 입니다.");
			
		}
		printline(count+" 번 만에 숫자를 맞추셨습니다.");
	}

}

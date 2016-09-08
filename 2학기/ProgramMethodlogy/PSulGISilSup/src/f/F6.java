package f;

import base.BaseMain;

public class F6 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number[][] = new int[5][3]; int newnum;
		int total=0;
		int ho;
		int i, j;
		
		// 각 집의 거주자 수, 층별, 호수별 중복 리스트 // 입력받은 숫자
		// 아파트의 총 거주자 수
		// 아파트 호를 나타내는 변수
		// 반복문 사용을 위한 변수
		for(i=0;i<number.length;i++){
			for(j=0;j<number[i].length;j++){
				number[i][j] = getInput().readInt((100*(i+1)+j+1)+"호에 살고 있는 사람의 숫자를 입력하시오. ");
				total+=number[i][j];
			}
		}
		
		printline("이 아파트에 사는 거주자는 모두 "+total+"명 입니다. ");
	}

}

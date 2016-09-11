package h;

import base.BaseMain;

public class H6 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number[] = new int[5];
		int pow_value[][] = new int[5][5]; int max, min;
		int max_a=0, max_b=0;
		int min_a=Integer.MAX_VALUE, min_b=Integer.MAX_VALUE;
		int i, j;
		// 입력받은 5개의 숫자 리스트
		//임의의 두 수 a, b로 만들 수 있는 ab의 값 들, 5 * 5 리스트 // 최댓값과 최솟값
		// 최댓값을 만들어 내는 경우의 a와 b의 값
		// 최솟값을 만들어 내는 경우의 a와 b의 값
		// 반복문을 위한 변수
		print("2에서 9사이의 숫자 5개를 입력하세요.");
		for(i=0;i<number.length;i++){
			number[i] = getInput().readInt();
		}
		for(i=0;i<number.length;i++){
for(j=0;j<number.length;j++){
	pow_value[i][j] = (int)Math.pow( number[i],number[j]);
	if(i!=j){
	max_b = Math.max(max_b, pow_value[i][j]);
	
	min_b = Math.min(min_b, pow_value[i][j]);
	}
}
		}
		for(i=0;i<number.length;i++){
			for(j=0;j<number.length;j++){
			if(pow_value[i][j]==max_b&&i!=j){
				max_a = number[i];
				max_b = number[j];
				
			}
			if(pow_value[i][j]==min_b&&i!=j){
				min_a = number[i];
				min_b = number[j];
			}
			pow_value[i][j]=-1;
			}
			}
		printline("입력하신 5개의 수로 제곱수를 만들면...");
		printline(String.format("가장 큰 수는 %d 의 %d 승인 %.0f 입니다.", max_a,max_b,Math.pow(max_a, max_b)));
		printline(String.format("가장 작은 수는 %d 의 %d 승인 %.0f 입니다.", min_a,min_b,Math.pow(min_a, min_b)));
	
	}

}

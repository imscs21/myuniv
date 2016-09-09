package g;

import base.BaseMain;

public class G2 extends BaseMain {

	public static void main(String[] args) {
		int input_degree;
		double degrees[] = new double[10]; // 온도 리스트
		String degree_name[] = {"냉수", "미온수", "온수", "끓는물"};
		int[] count = {0,0,0,0};// 수,온수입력횟수, 끓는물입력횟수)
		int i; int sel=0;
		for(i=0;i<10;i++){
			while((degrees[i] =getInput().readDouble((i+1)+"번 물의 온도를 입력하시오. "))<0){
			printline("wrong number.");	
			}
			
		}
		for(i=0;i<10;i++){
			if(degrees[i]<25){
				sel=0;
			}else if(degrees[i]<40){
				sel=1;
			}
			else if(degrees[i]<80){
				sel=2;
			}
			else {
				sel=3;
			}
			
			
			printline(String.format("%d번 물의 온도는 %.1f도 입니다. %s", i+1,degrees[i],degree_name[sel]));
		count[sel]+=1;
		}
		for(i=0;i<count.length;i++){
			printline(String.format("%s 입력 횟수: %d", degree_name[i],count[i]));
		}
		
		// 입력받은 온도
		// 입력 횟수 목록 (순서대로 냉수 입력 횟수, 미온수 입력 횟
		// 반복문을 위한 변수
		// 온도 판정 번호 (0,1,2,3)
		
	}

}

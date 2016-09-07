package f;

import base.BaseMain;

public class F2 extends BaseMain {
	//なんか　へんだよ、　この　もんだい。
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			double score[] = new double[10]; // 심사점수 리스트
			int maxscore=Integer.MIN_VALUE, minscore=Integer.MAX_VALUE; int total=0;
			int average=0;
			int newnum;
			int i;
			// 가장 큰 점수, 가장 작은 점수 // 점수 총 합계
			// 평균점수
			// 숫자 입력을 위한 변수
			// 반복문을 위한 변수
			for(i = 0;i<10;i++){
				score[i]=getInput().readDouble((i+1)+"번 심사점수를 입력하시오. ");
				//total+=score[i];
				maxscore =(int) Math.max(score[i],maxscore);
				minscore =(int) Math.min(score[i],minscore);
			}
			for(i=0;i<10;i++){
				if(score[i]==maxscore){
					maxscore=i;
				}
				else if(score[i]==minscore){
					minscore=i;
				}
				else total+=score[i];
			}
			printline(String.format("가장 큰 점수와 가장 작은 점수를 제외한 8개의 점수에 대한 평균은 %f 입니다.",Math.round((total)/8.0f*10)/10.0f));
			
		}

}

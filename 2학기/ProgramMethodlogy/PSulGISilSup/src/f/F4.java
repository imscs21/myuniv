package f;

import base.BaseMain;

public class F4 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jumsu[][] = new int[5][3];
		int sum[] = new int[5];
		double average[] = new double[5]; int kor, eng, mat;
		int i, j;
		for(i=0;i<jumsu.length;i++){
			for(j=0;j<jumsu[i].length;j++){
				if(j==0){
					jumsu[i][j]=getInput().readInt((i+1)+"번 학생 국어,영어,수학 점수를 입력하시오. ");
					
				}
				else{
					jumsu[i][j]=getInput().readInt();
				}
				sum[i]+=jumsu[i][j];
			}
			average[i]=sum[i]/(0.0f+jumsu[i].length);
		}
		for(i=0;i<average.length;i++){
			
			printline(String.format((i+1)+"번 학생의 총점은 %d 이고, 평균은 %.1f 입니다.", sum[i],average[i]));
		}
		// 5명의 3과목 점수를 저장하고 있는 중복 리스트 // 3과목 총점 리스트
		// 3과목 평균 리스트
		// 3과목 점수 입력을 위한 변수
		// 반복문을 위한 변수
	}

}

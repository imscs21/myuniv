package f;

import base.BaseMain;

public class F3 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jumsu[][] = new int[5][3];
		int sum[] = new int[3];
		double average[] = new double[3]; int kor, eng, mat;
		int i, j;
		for(i=0;i<jumsu.length;i++){
			for(j=0;j<jumsu[i].length;j++){
				if(j==0){
					jumsu[i][j]=getInput().readInt((i+1)+"번 학생 국어,영어,수학 점수를 입력하시오. ");
					
				}
				else{
					jumsu[i][j]=getInput().readInt();
				}
				average[j]+=jumsu[i][j];
			}
		}
		for(i=0;i<average.length;i++){
			if(i==0){
				print("국어");
			}
			else if(i==1){
				print("영어");
			}
			else if(i==2){
				print("수학");
			}
			printline(String.format("의 총점은 %.0f 이고, 평균은 %.1f 입니다.", average[i],average[i]/(jumsu.length+0.0f)));
		}
		// 5명의 3과목 점수를 저장하고 있는 중복 리스트 // 3과목 총점 리스트
		// 3과목 평균 리스트
		// 3과목 점수 입력을 위한 변수
		// 반복문을 위한 변수
	}
}

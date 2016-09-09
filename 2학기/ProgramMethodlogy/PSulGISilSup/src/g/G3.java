package g;

import base.BaseMain;

public class G3 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int jumsu[][]=new int[5][3];
		int c_average[] = new int[3];
		String[] class_name={"국어","영어","수학"}; 
		int kor, eng, mat;
		int sum, average, grade=0;
		int i, j ;// 반복문을 위한 변수
		for(i=0;i<jumsu.length;i++){
			print((i+1)+"번 학생의 국어, 영어, 수학 점수는? ");
			for(j=0;j<jumsu[i].length;j++){	
			c_average[j] +=(jumsu[i][j] = getInput().readInt()); 
			}
		}
		printline("\n1)각 과목별 총점과 평균 점수");
		for(i=0;i<class_name.length;i++){
		printline(
				String.format( class_name[i]+" 과목 총점은 %d 평균은 %.1f입니다.",c_average[i],c_average[i]/(jumsu.length+0.0f)
				)
		);
			
			
		}
		
		printline("\n2) 각 학생별 총점과 평균 점수");
		for(i=0;i<jumsu.length;i++){
			sum=0;
			
			for(j=0;j<jumsu[i].length;j++){
				sum+=jumsu[i][j];
			}
			
			if(sum/(class_name.length+0.0d)>=90){
		grade='A';		
			}
			else if(sum/(class_name.length+0.0d)>=80){
				grade='B';
			}
	else if(sum/(class_name.length+0.0d)>=70){
		grade='C';
			}
	else if(sum/(class_name.length+0.0d)>=60){
		grade='D';
	}
	else {
		grade='F';
	}
			
printline(String.format("%d번 학생 점수 : 총점 %d, 평균 %.1f 등급 %c",i+1,sum,sum/3.0f,grade ));
		}
	}

}

package g;

import base.BaseMain;

public class G1 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int birth_year; // 입력받은 태어난 년도
		int age[] = new int[100];
		// 각 사람들의 나이 (최대 100명)
		int count_person; int count_baby=0; int count_child=0; int count_youth=0; int count_young=0; int count_adult=0; int count_old=0;
		int i=0;
		// 입력된 인원 수 // 유아 수
		// 어린이 수
		// 청소년 수
		// 청년 수
		// 중년 수
		// 노년 수
		// 반복문을 위한 변수
		while((birth_year=getInput().readInt((i+1)+"번째 사람의 태어난 년도를 입력하시오. "))<=2012){
			age[i]=2012-birth_year+1;
			if(age[i]<7){
				count_baby++;
			}
			else if(age[i]<13){
				count_child++;
			}
			else if(age[i]<20){
	count_youth++;
}
			else if(age[i]<30){
				count_young++;
			}
			else if(age[i]<60){
				
			count_adult++;
}
else{
	count_old++;
}
			i++;
		}
		count_person=i;
		for(i=0;i<count_person;i++){
			printline((i+1)+"번쨰 사람의 나이는 "+age[i] + "입니다. ");
		}
	printline(String.format("유아"+"는 %d명 입니다.", count_baby));
	printline(String.format("어린이"+"는 %d명 입니다.", count_child));
	printline(String.format("청소년"+"는 %d명 입니다.", count_youth));
	printline(String.format("청년"+"는 %d명 입니다.", count_young));
	printline(String.format("중년"+"는 %d명 입니다.", count_adult));
	printline(String.format("노년"+"는 %d명 입니다.", count_old));
	}

}

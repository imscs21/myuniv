package f;

public class F5 extends base.BaseMain{
public static void main(String...strings){
	int height, weight;
	int bmi;
	int bmilist[][] = new int[10][3]; int count=0;
	int i;
	// 입력받은 신장(cm), 체중(kg)
	// 계산된 비만도 수치
	// 10명에 대한 신장, 체중, 비만도수치를 담고 있는 리스트 // 비만인 사람의 숫자
	// 반복문을 위한 변수
	for(i=0;i<bmilist.length;i++){
		bmilist[i][0] = getInput().readInt((i+1)+"번째 사람의 신장(cm)과 체중(kg)을 입력하시오. ");
		bmilist[i][1]= getInput().readInt();
		bmilist[i][2] =(int)(bmilist[i][1] / ((bmilist[i][0]/100.0f)*(bmilist[i][0]/100.0f)));
		
	}
	for(i=0;i<bmilist.length;i++){
		if(bmilist[i][2]>=25){
			printline((i+1)+"번째 사람은 비만입니다. ");
			count++;
		}
	}
	printline("");
	printline("총 "+count+"명의 사람이 비만입니다. ");
}
}

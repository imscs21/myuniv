package d;

public class D6 extends base.BaseMain{
public static void main(String...strings){
	double m2_area; double pyung_area; int count1=0;
	int count2=0;
	int count3=0; int count4=0; int i;
	// 면적 (제곱미터)
	// 면적 (평수) //소형아파트개수 // 중소형 아파트 개수 //중형아파트개수 //대형아파트개수 // 반복문을 위한 변수
	for(i =0;i<10;i++){
	m2_area=getInput().readDouble("면적? "); // 면적 (제곱미터) 
	pyung_area = Math.round((10*m2_area)/3.305)/10.0d; // 면적 (평수)
	
	printline("-->이 아파트의 평형은 "+pyung_area+" 입니다.");
	if(pyung_area<15){
		count1++;
	}
	else if(pyung_area<30){
		++count2;
	}
	else if(pyung_area<50){
		count3++;
	}
	else {
		count4++;
	}
}
	printline("*소형 아파트의 개수는 "+ count1+" 입니다.");
	printline("*중소형 아파트의 개수는 "+ count2+" 입니다.");
	printline("*중형 아파트의 개수는 "+ count3+" 입니다.");
	
	printline("*대형 아파트의 개수는 "+ count4+" 입니다.");
	}
}


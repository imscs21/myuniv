package c;

public class C5 extends base.BaseMain{
public static void main(String...strings){
	int month=getInput().readInt("월? "),day=getInput().readInt("일? "),day_count=0;
int[] info = {-1,31,28,31,30,31,30,31,31,30,31,30,31};
	if(!(
			(month==1&&day>0&&day<=31)||(month==3&&day>0&&day<=31)||(month==5&&day>0&&day<=31)||(month==7&&day>0&&day<=31)||(month==8&&day>0&&day<=31)||(month==10&&day>0&&day<=31)||(month==12&&day>0&&day<=31)||
			(month==4&&day>0&&day<31)||(month==6&&day>0&&day<31)||(month==9&&day>0&&day<31)||
			(month==2&&day>0&&day<=28)
			)){
		printline("잘못 입력하셨습니다.");
	}
else{for(int i=1;i<month;i++){
		day_count+=info[i];
	}
	day_count+=day;
	printline("이 날짜는 1년 중 "+day_count+" 번째 날에 해당됩니다.");}
}
}

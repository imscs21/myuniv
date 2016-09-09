package g;

import base.BaseMain;

public class G5 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int hour, minute=-1; int charge=0;
		int total_charge=0;
		hour=getInput().readInt("사용한 시간을 시간과 분으로 입력하세요 : ");
				minute=getInput().readInt();
		while(!(hour==0&&(minute)==0)){
			charge=((minute+60*hour)/30)*1000+1000;
			/*
			if(hour >=5){
				charge -= (int)(charge*(0.2f));
			}
			else if(hour>=3){
				charge -= (int)(charge*(0.1f));
			}
			else if(hour>=2){
				charge -= (int)(charge*(0.05f));
			}*/
			printline("고객님의 이용료는 "+charge+"원 입니다.");
			total_charge+=charge;
			hour=getInput().readInt("사용한 시간을 시간과 분으로 입력하세요 : ");
			minute=getInput().readInt();
		}
		printline("\n지금까지의 이용료 총금액은 "+total_charge+"원 입니다.");
	}

}

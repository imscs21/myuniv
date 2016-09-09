package g;

import base.BaseMain;

public class G4 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kind;
		int money;
		int charge=0;
		int total_charge=0;
		while((kind=getInput().readInt("부동산 거래종류(1:매매, 2:임대, 0:계산종료)를 입력하세요: "))!=0){
			money=getInput().readInt("부동산 거래금액(원)을 입력하세요: ");
			
			if(kind==1){
				if(money<50000000){
					charge=Math.min(250000, (int)(money*0.006f));
				}
				else if(money<200000000){
					charge=Math.min(800000, (int)(money*0.005f));
				}
				else{
					charge=(int)(money*0.004f);
				}
			}
			else{
				if(money<20000000){
					charge=Math.min(70000, (int)(money*0.005f));
				}
				else if(money<50000000){
					charge=Math.min(200000,  (int)(money*0.005f));
				}
				else if(money<100000000){
					charge=Math.min(300000,  (int)(money*0.004f));
				}
				else{
					charge=(int)(money*0.003f);
				}
			}
			printline("이에 대한 중개 수수료는 "+charge+"원 입니다.");
			total_charge+=charge;
		}
		printline("지금까지의 수수료 총액은 "+total_charge+"원 입니다.");
	}

}

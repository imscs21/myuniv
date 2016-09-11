package h;

import base.BaseMain;

public class H3 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lotto_com[] = new int[6]; int lotto_user[] = new int[6]; int i;
		int count=0;
		int match_count=0;
		while(count<lotto_com.length){
			lotto_com[count] =((int)(Math.random()*2000)%45)+1;
			for(i=0;i<count;i++){
				if(lotto_com[i]==lotto_com[count]){
					lotto_com[count]=0;
					break;
				}
			}
			if(lotto_com[count]>0){
				count++;
			}

	}
		count=0;
		while(count<lotto_user.length){
			while((lotto_user[count] =getInput().readInt("원하는 "+(count+1)+"번째 로또 숫자를 입력하세요 "))<1||lotto_user[count]>45){
				printline("=> 잘못 입력하셨습니다.");
			}
			for(i=0;i<count;i++){
				if(lotto_user[i]==lotto_user[count]){
					lotto_user[count]=0;
					break;
				}
			}
			if(lotto_user[count]>0){
				for(i=0;i<=count;i++){
					if(lotto_user[count]==lotto_com[i]){
						match_count++;
					}
				}
				count++;
			}
			else{
				printline("=> 잘못 입력하셨습니다.");
			}

	}
		printline("");
		print("이번 주의 로또 당첨 번호는 ");
		for(i=0;i<lotto_com.length;i++){
			print(lotto_com[i]+" ");
		}
		printline("입니다.\n");
printf("일치하는 로또 번호는 %d개 입니다.",match_count);
	}

}

package h;

import java.util.Vector;

import base.BaseMain;

public class H2 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lotto[] = new int[6]; int count=0;
		String onemore;
		int i;
		onemore="Y";
		while(onemore.toLowerCase().equals("y")){
			count=0;
			for(i=0;i<lotto.length;i++){
				lotto[i]=0;
			}
		
		while(count<lotto.length){
					onemore=Integer.toString (((int)(Math.random()*2000)%45)+1);
		for(i=0;i<count;i++){
			if(lotto[i]==Integer.parseInt(onemore)){
				i=-1;
				break;
			}
		}
		if(i!=-1){
			lotto[count++]=Integer.parseInt(onemore);
		}
		}
		print("생성된 로또 번호는 ");
		for(i=0;i<lotto.length;i++){
			print(lotto[i]+" ");
		}
		printline("입니다.");
		onemore = getInput().readString("더 만드시겠습니까? (Y/N) ");
		}
	}

}

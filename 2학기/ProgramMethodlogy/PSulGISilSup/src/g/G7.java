package g;

import base.BaseMain;

public class G7 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int team_count=getInput().readInt("오늘 방문한 팀 수를 입력하세요. "); // 방문한 팀수
		int charge[] = {5000, 10000, 15000, 3000};// 연령별 수
		int count[] = new int[4]; int v_count[] = new int[4]; int total_count = 0;
		int sum;
		int total_sum =0;
		int membership = 0;
		int i, j;
	    for(i=0;i<team_count;i++){
	    	sum=0;
	    	print((i+1)+"번팀 인원수(초등학생, 청소년, 일반, 경로대상)를 입력하세요. ");
	    	for(j=0;j<count.length;j++){
	    		v_count[j] += (count[j]=getInput().readInt());
	    		total_count+=count[j];
	    		sum+=count[j]*charge[j];
	    	}
	    	membership=getInput().readInt((i+1)+"번팀 할인카드 종류(카드없음:0, 일반등급: 1, VIP 등급 : 2)를 입력하세요. ");
	    	total_sum+=(sum = (int)((sum+0.0f)*(1f-(membership/10.f))));
	    	printline((i+1)+"번팀 입장료는 "+sum+"원 입니다.");
	    }
		printline("오늘 총 방문자 수는 "+total_count+"명 입니다.");
		printf("초등학생 수는 %d명 입니다.\n",v_count[0]);
		printf("청소년 수는 %d명 입니다.\n",v_count[1]);
		printf("일반인 수는 %d명 입니다.\n",v_count[2]);
		printf("경로대상 수는 %d명 입니다.\n",v_count[3]);
		printline("\n총 입장료는 "+total_sum+"원 입니다.");
		
	}

}

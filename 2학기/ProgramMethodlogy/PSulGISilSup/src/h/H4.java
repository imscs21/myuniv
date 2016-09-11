package h;

import base.BaseMain;

public class H4 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com_finger; // 컴퓨터가 낸 가위(1), 바위(2), 보(3)
		int my_finger; //사용자가 낸 가위(1), 바위(2), 보(3)
		int score[][] = new int[2][3];//결과 횟수 리스트 [[컴퓨터의 승, 무, 패], [사용자의 승, 무, 패]] int i, j;
	while((my_finger=getInput().readInt("가위(1), 바위(2), 보(3)를 입력하세요. "))!=0){
		com_finger =(int)( Math.random()*10)%3+1;
		print("컴퓨터가 낸 것은 ");
		if(com_finger==1){
			print("가위");
			
		}else if(com_finger==2){
			print("바위");
		}
		else if(com_finger==3){
			print("보");
		}
		print("입니다. ----> ");
		if(my_finger==com_finger){
			printline("비김~\n");
			score[1][1]+=1;
					score[0][1]+=1;
		}
		else if((my_finger==1&&com_finger==3)||(my_finger==2&&com_finger==1)||(my_finger==3&&com_finger==2)){
			printline("사용자 승!");
			score[1][0]+=1;
			score[0][2]+=1;
		}
		else if((my_finger==3&&com_finger==1)||(my_finger==1&&com_finger==2)||(my_finger==2&&com_finger==3)){
			printline("컴퓨터 승");
			score[1][2]+=1;
			score[0][0]+=1;
		}
		printline("");
	}
	printline("");
	printf("컴퓨터 : 이긴 횟수는 %d회, 진 횟수는 %d회, 비긴 횟수는 %d 입니다.\n",score[0][0],score[0][2],score[0][1]);
	printf("사용자 : 이긴 횟수는 %d회, 진 횟수는 %d회, 비긴 횟수는 %d 입니다.\n",score[1][0],score[1][2],score[1][1]);
	}

}

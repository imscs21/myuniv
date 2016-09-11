package h;

import base.BaseMain;

public class H9 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		String userList[];
		String userInfo[];
		int i, j;
		while(!(input=getInput().readLineWithNewLine("======================\n=> 문자열을 입력하세요 (x: 종료) : ")).toLowerCase().equals("x")){
			printline("");
			userList = input.split("###");
			userInfo = new String[userList.length];
			for(i = 0 ;i<userList.length;i++){
				userInfo[i] = userList[i].split("\\|")[1];
				
				userList[i] = userList[i].split("\\|")[0];
				
			}
			printline("=> 총 "+userList.length+"명이 등록되었습니다.");
			for(i=0;i<userList.length;i++){
				printline((i+1)+" "+ userList[i]+" "+userInfo[i]);
			}
		}
		printline("*종료되었습니다.");
	}

}

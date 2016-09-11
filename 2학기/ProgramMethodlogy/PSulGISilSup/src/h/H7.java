package h;

import base.BaseMain;

public class H7 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input; // 입력받는 문자열
		int i;
while(!(input=getInput().readLine("======================\n=> 문자열을 입력하세요 (x: 종료) : ")).toLowerCase().equals("x")){
	printline("=> 총 문자의 개수는 "+input.length()+"개 입니다.");
	for(i=0;i<input.length();i++){
	print("=> ");
printline(input.substring(i, i+1));
	}
	printline("");
}
printline("*종료되었습니다.");
	}

}

package h;

import base.BaseMain;

public class H8 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		String findStr;
		String replaceStr;
		int i=0;
		while(!(input=getInput().readLineWithNewLine("======================\n=> 문자열을 입력하세요 (x: 종료) : ")).toLowerCase().equals("x")){
			findStr = getInput().readLine("=> 찿을 문자열을 입력하세요");
			replaceStr = getInput().readLine("=> 바꿀 문자열을 입력하세요");
			while(input.contains(findStr)){
				i++;
				input = input.replaceFirst(findStr, replaceStr);
			}
			printline("");
		printline("=> 총 "+i+"번 바뀌었습니다.");
		printline("=> "+input);
		printline("");
		}
		printline("*종료되었습니다.");
	}

}

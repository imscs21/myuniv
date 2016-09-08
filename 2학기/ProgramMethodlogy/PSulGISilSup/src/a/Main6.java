package a;
import java.util.*;

import base.BaseMain;
public class Main6 extends BaseMain{
public static void main(String...strings ){
	int kor=getInput().readInt("국어점수를 입력하세요. "),eng=getInput().readInt("영어점수를 입력하세요. "),math=getInput().readInt("수학점수를 입력하세요. "),total=0;
	


double average = ((total=kor+math+eng)+0.0f)/3;
printline("입력하신 총점은 "+total+" 이고,");
printline("평균은 "+Math.round( average*10)/10.0f+" 입니다.");
	
}
}

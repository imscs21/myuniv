package b;

import java.util.*;

import base.BaseMain;
public class MainB8 extends BaseMain{
public static void main(String...strings ){
	int num1,num2,num3;
	int[] d = new int[3];
	String[] ds= {"첫","두.","세."};
for(int i =0;i<d.length;i++){
	print(ds[i]+"번째 숫자를 입력하세요. ");
d[i] = getScanner().nextInt();
}
String[] condi = {"3개의 숫자 중 적어도 두 수의 값이 같다.","3개의 숫자 중 적어도 두 수의 크기가 모두 50 보다 크다.","3개의 숫자 중 어떤 두 수의 합이 나머지 하나의 숫자와 같다.",
		"3개의 숫자 중 어떤 하나의 수로 다른 두 수를 나누면 나누어떨어지는 경우가 있다."};
StringBuffer sb = new StringBuffer();
for(int i =0;i<condi.length;i++){
	if(i==0&&(d[0]==d[1]||d[1]==d[2]||d[0]==d[2])){
		sb.append((i+1)+"번 조건 만족 : "+condi[i]+"\n");
	}
	else if(i==1 && ( 
			(d[0]>50&&d[1]>50)||(d[0]>50&&d[2]>50)||(d[1]>50&&d[2]>50)
			)){
		sb.append((i+1)+"번 조건 만족 : "+condi[i]+"\n");
	}
	else if(i==2 && (
			(d[0]+d[1]==d[2])||(d[1]+d[2]==d[0])||(d[0]+d[2]==d[1])
			)){
		sb.append((i+1)+"번 조건 만족 : "+condi[i]+"\n");
	}
	else if(i==3 && (
			(d[0]%d[2]==0)||(d[0]%d[1]==0)||(d[1]%d[2]==0)||(d[2]%d[0]==0)||(d[1]%d[0]==0)||(d[2]%d[1]==0)
			)){
		sb.append((i+1)+"번 조건 만족 : "+condi[i]+"\n");
	}
}
printline(sb.toString());
}
}

package c;

public class C8 extends base.BaseMain{
public static void main(String...strings){
	int num1,num2,num3;
	int max_num=Integer.MIN_VALUE,min_num=Integer.MAX_VALUE;
	int[] d = new int[3];
	String[] des={"첫","두","세"};
	for(int i=0;i<d.length;i++){
		d[i]=getInput().readInt(des[i]+"번째 숫자를 입력하세요. ");
		max_num=Math.max(max_num, d[i]);
		min_num=Math.min(min_num, d[i]);
	}
	printline(String.format("가장 큰 수는 %d 이고, 가장 작은 수는 %d 입니다.", max_num,min_num));
}
}

package d;

public class D2 extends base.BaseMain{
public static void main(String...strings){
	int number ,max_num=Integer.MIN_VALUE,min_num = Integer.MAX_VALUE;
	while((number=getInput().readInt("number? "))<=100&&number>=0){
		min_num = Math.min(number, min_num);
		max_num = Math.max(number, max_num);
	}
	printline("max value is "+max_num+" , and min value is "+min_num);
}
}

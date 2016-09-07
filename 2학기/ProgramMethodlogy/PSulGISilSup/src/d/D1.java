package d;

public class D1 extends base.BaseMain{
public static void main(String...strings){
	int number=getInput().readInt("number? "),totalsum=0,i;
	for(i=1;i<=number;i++){
		totalsum+=i;
	}
	if(totalsum==0){
		printline("you sent wrong number.");
	}
	else{
		printline("result of sum 1 to "+number+" is "+totalsum+" です。");
	}
	
}
}

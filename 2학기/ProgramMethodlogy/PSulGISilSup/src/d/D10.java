package d;

public class D10 extends base.BaseMain{
public static void main(String...strings){
	int num1=getInput().readInt("2개의 숫자를 입력하세요. "), num2=getInput().readInt(); // 입력받은 두 수
	int i; // 반복문을 위한 변수
	print(Math.min(num1,num2));
	for(i = Math.min(num1, num2)+1;i<=100;i++){
		if((i%(num1*num2)!=0&&i%num1==0)||(i%num2==0&&i%(num1*num2)!=0))
		print(String.format(", %d", i));
	}
}
}

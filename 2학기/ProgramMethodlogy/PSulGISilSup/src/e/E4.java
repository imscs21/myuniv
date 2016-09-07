package e;

public class E4 extends base.BaseMain{
public static void main(String...strings){
	int mode=getInput().readInt("구구단의 출력모드(1: 홀수단, 2:짝수단)를 입력하시오. "); // 출력모드(1: 홀수단, 2: 짝수단)
	int i, j; // 반복문 사용을 위한 변수
	for(i =2+mode%2;i<10;i+=2){
		for(j=1;j<10;j++){
			print(String.format("%d x %d = %2d    ", i,j,i*j));
			if(j%3==0){
				print("\n");
			}
		}
		print("\n");
	}
	
}
}

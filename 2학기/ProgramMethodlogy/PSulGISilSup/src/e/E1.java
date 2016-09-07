package e;

public class E1 extends base.BaseMain{
public static void main(String... strs){
	int length=getInput().readInt("size? "); // 입력받은 정사각형 한 변의 길이 
	int i, j; // 반복문 사용을 위한 변수
	for( i = 0;i<length;i++){
		print("#");
		for(j=1;j<length; j++){
			print(" #");
		}
		print("\n");
	}
}
}

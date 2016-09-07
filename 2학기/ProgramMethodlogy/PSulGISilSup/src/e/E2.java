package e;

public class E2 extends base.BaseMain{
public static void main(String... strs){
	int height=getInput().readInt("height and blank size? "); int blank=getInput().readInt(); int i, j;
	// 입력받은 높이
	// 입력받은 여백 크기
	// 반복문 사용을 위한 변수
	for(i=1;i<=height;i++){
		for(j=0;j<blank;j++){
			print(" ");
		}
		for(j=1;j<=height;j++){
			if(j<=height-i){
				print(" ");
			}
			else{
				print("*");
			}
		}
		print("\n");
	}
}
}

package e;

public class E6 extends base.BaseMain{
public static void main(String...strings){
	int rows=getInput().readInt("row size and column size? "), columns=getInput().readInt();
	int number; int i, j;
	for(i=1;i<=rows;i++){
		for(j=1;j<=columns;j++){
			print(String.format("%"+(2+(int)Math.log10(rows*columns))+"d", i*j));
		}
		print("\n");
	}
	// 행의 개수, 열의 개수 //각 칸에 출력하는 값
	// 반복문 사용을 위한 변수
}
}

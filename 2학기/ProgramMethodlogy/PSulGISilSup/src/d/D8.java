package d;

public class D8 extends base.BaseMain{
	public static void main(String...strings ){
		int a=getInput().readInt("2차 함수 y=ax^2+b의 계수 a와b, c 를 입력하시오. "), b=getInput().readInt(),c=getInput().readInt(); // 1차 메소드의 계수 a, b
		int x_begin=getInput().readInt("x좌표의 시작 값과 끝값을 입력하시오. "), x_end=getInput().readInt(); // x좌표의 시작 값과 끝 값
		int x, y; // x좌표, y좌표
	for(int i = x_begin; i<=x_end;i++){
		printline(String.format("좌표 (%d,%d)",i,a*i*i+b*i+c));
		
	}
	}
}

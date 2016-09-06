package c;
import base.*;
public class C3 extends BaseMain{
public static void main(String...strings ){
	int width = getInput().readInt("직사각형의 가로크기 "),height = getInput().readInt("직사각형의 세로크기");
	if(width==height){
		printline( "정사각형입니다.");
	}
	else if(width>=height*2){
		printline("좌우로 길쭉한 직사각형입니다.");
	}
	else if(height >= width*2){
		printline("위아래로 길쭉한 직사각형입니다.");
	}
	else if(width>height){
		printline("일반적인 가로형 직사각형입니다");
	}
	else if(height>width){
		printline("일반적인 세로형 직사각형입니다");
	}
}
}

package d;

public class D5 extends base.BaseMain{
public static void main(String...strings){
	int width, height; int count1=0;
	int count2=0;
	int count3=0;
	int count4=0;
	int count5=0;
	// 가로크기, 세로크기
	// "정사각형"의 개수
	// "좌우로 길쭉한 직사각형"의 개수 // "위아래로 길쭉한 직사각형"의 개수 // "일반적인 가로형 직사각형"의 개수 // "일반적인 세로형 직사각형"의 개수
while((width=getInput().readInt("squire of width and height? "))>0 && (height = getInput().readInt())>0){
	if(width==height){
		count1++;
	}
	else if(width>=height*2){
		count2++;
	}
	else if(height >= width*2){
		count3++;
	}
	else if(width>height){
		count4++;
	}
	else if(height>width){
		count5++;
	}
}

printline("정사각형의 개수는 "+count1+" 입니다.");
printline("좌우로 길쭉한 정사각형의 개수는 "+count2+" 입니다.");
printline("위아래로 길쭉한 정사각형의 개수는 "+count3+" 입니다.");
printline("일반적인 가로형 정사각형의 개수는 "+count4+" 입니다.");
printline("일반적인 세로형 정사각형의 개수는 "+count5+" 입니다.");
}
}

package a;
import java.util.*;

import base.BaseMain;
public class Main3 extends BaseMain{
public static void main(String... args){
	System.out.print("직사각형의 가로 크기를 입력하시오. ");
	int width=getScanner().nextInt();
System.out.print("직사각형의  세로 크기를 입력하시오.");
			int height=getScanner().nextInt();
			final int area=width*height;
	System.out.println("직사각형의 넓이는 "+area+"입니다.");
}
}

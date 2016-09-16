package a;
import java.util.*;

import base.BaseMain;
public class Main2 extends BaseMain{
public static void main(String... args){
	
final double c_degree = getInput().readDouble("c_degree? ");	
double f_degree = c_degree*1.8d+32;
System.out.println("화씨온도는 "+f_degree+"도 입니다.");

}
}

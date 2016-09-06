package a;
import java.util.*;

import base.BaseMain;
public class Main1 extends BaseMain{
public static void main(String...strings){
	Scanner sc = getScanner();
	Date d = new Date();
int birth_year,age;
birth_year=sc.nextInt();
age = 2014+1-birth_year;
	System.out.println("당신의 나이는 "+age+"살 입니");
	
}
}

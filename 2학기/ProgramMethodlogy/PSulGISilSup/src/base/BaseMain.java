package base;
import java.util.*;
public class BaseMain  {
	public static BaseInjection inj=null;
	private static BaseInput binput = new BaseInput();
	public static BaseInput getInput(){
		return binput;
	}
	public static void onBeforeCode(Scanner sc,Object...objects){
		
	}
	public static void onAfterCode(Scanner sc,Object...objects){
		
	}
	//private final static Scanner sc = new Scanner(System.in);
public static Scanner getScanner(){
	return binput.getScanner();
	
}
public static void print(Object s){
	System.out.print(s);
}
public static void printline(String s){
	System.out.println(s);
}
}

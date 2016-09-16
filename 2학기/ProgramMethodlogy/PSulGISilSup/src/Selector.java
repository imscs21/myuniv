import java.lang.reflect.*;
import a.*;
import b.*;
//import java.lang.reflect.
/*
 * made by HSH
 */
public class Selector extends base.BaseMain{
	protected interface ForEclipse{
		public boolean isInherited();
		public String desc();
		//public void onStartProgram(String[] args);
		//public void onEndProgram(String[] args);
	}
	public ForEclipse getInheritedInterface(){
		return null;
	}
	public static final String COMMAND_FINISH = "program://finish";
	public static final String COMMAND_HELP = "program://help";
	public static final String COMMAND_PROBLEM_RANGE = "program://exeRange";
	public static final String COMMAND_VERSION = "program://version";
	
	public static boolean checkFormat(String d){
		if(d.startsWith("program://")){
			return true;
		}
		else if(d.length()>1){
			 if(( d.charAt(0)>='A'&&d.charAt(0)<='Z')||(d.charAt(0)>='a'&&d.charAt(0)<='z')){
				 try{
				 int a =Integer.parseInt( d.substring(1));
				 return true;
				 }catch(Exception e){
					 
				 }
			 }
			 
		}
		return false;
	}
	public synchronized static void execute(final String command,String[] strings){
		final String executeMessage = ("[Program] 실행됨(에러를 제외하고 프로그램이 끝나지 않았는데 아무응답이 없을 경우 입력을 받기위한 대기모드일 가능성이 높음).");
		try{
		Class<?> cls = Class.forName(command.substring(0, 1).toLowerCase()+"."+command.substring(0, 1).toUpperCase()+Integer.parseInt(command.substring(1)));
	Method m = cls.getMethod("main", new Class[]{strings.getClass()});
	printline(executeMessage);
	m.invoke(null,new Object[]{strings});
	}catch(Exception e1){
		
		//e1.printStackTrace(System.out);
		if(!(e1 instanceof ClassNotFoundException)){
			e1.printStackTrace(System.out);
		}
		try{
			Class<?> cls = Class.forName(command.substring(0, 1).toLowerCase()+"."+"Main"+command.substring(0,1).toUpperCase()+Integer.parseInt(command.substring(1)));
			Method m = cls.getDeclaredMethod("main", new Class[]{String[].class});
			printline(executeMessage);
			m.invoke(null,new Object[]{strings});
		}catch(Exception e2){
			if(!(e2 instanceof ClassNotFoundException)){
				e2.printStackTrace(System.out);
			}
			try{
				Class<?> cls = Class.forName(command.substring(0, 1).toLowerCase()+"."+"Main"+Integer.parseInt(command.substring(1)));
				Method m = cls.getDeclaredMethod("main", new Class[]{String[].class});
				printline(executeMessage);
				m.invoke(null,new Object[]{strings});
			}catch(Exception e3){
				e3.printStackTrace(System.out);
			}	
		}
	}
	}
	public static void showprogramversion(){
		printline("\n=====VERSION=====");
	printline("VERSION: 0.1");
printline("BUILD DATE: 2016-9-16 FRI PM 07:12");
		printline("=====VERSION=====\n");
	}
	public static void helpmessage(){
		printline("\n==H==E==L==P==");
		final String ft = "%-20s";
		printline(String.format(ft, COMMAND_FINISH)+"exit program");
		printline(String.format(ft, COMMAND_HELP)+"show program command");
		printline(String.format(ft, COMMAND_PROBLEM_RANGE)+"auto start problem with range");
		printline(String.format(ft, COMMAND_VERSION)+"show version");
		
		printline("==H==E==L==P==\n");
		
	}
	protected static char min(char a,char b){
		return a>b? b:a;
	}
protected static char max(char a,char b){
	return a>b? a:b;
	}
public static void main(String...strings){

	String command = "";
	while(!(command=getInput().readLine("\ncommand(문제 번호나 프로그램 커멘드(program://help) 입력-예)A1혹은 G10)> ")).contains(COMMAND_FINISH)){
		
		boolean isFinishCommandOnCheckFormat = false;
		while(!checkFormat(command)){
			printline("invalid format");
			command = getInput().readLine("> ");
			isFinishCommandOnCheckFormat=command.contains(COMMAND_FINISH);
					if(isFinishCommandOnCheckFormat){
						break;
					}
		}
		if(isFinishCommandOnCheckFormat){
			break;
		}
if(command.startsWith("program://")){
	if(command.equals(COMMAND_VERSION)){
	showprogramversion();}
			if(command.equals(COMMAND_HELP)){
				helpmessage();
			}else if(command.equals(COMMAND_PROBLEM_RANGE)){
				int stlv,edlv;
				char convstcls,convedcls;
				try{
				String stcls,edcls;
			
				print("[PROGRAM::RANGE]시작할 스텝(영어문자), 끝날 스텝문자, 시작 번호 , 끝날 번호를 차례대로 입력(예: A A 1 2)  \n");
				stcls = getInput().readString().toUpperCase();
				edcls = getInput().readString().toUpperCase();
				convstcls=min(stcls.charAt(0),edcls.charAt(0));
				convedcls=max(stcls.charAt(0),edcls.charAt(0));
				stlv=getInput().readInt();
				edlv = getInput().readInt();
				int tmp = edlv;
				edlv = Math.max(edlv,stlv);
				stlv = Math.min(tmp, stlv);
				int rangelength = convedcls-convstcls+2+edlv-stlv;
				String[][] commands = new String[convedcls-convstcls+1][edlv-stlv+1];
				
				for(char i=convstcls;i<=convedcls;i++){
					for(int j=stlv;j<=edlv;j++){
					printf("debug: %c %d, idx:%d\n",i,j,i+j-convstcls-stlv);
						commands[i-convstcls][j-stlv]=Character.toString(i)+j;
					
				}
				}
				for(int i=0;i<commands.length;i++){
					for(int j=0;j<commands[i].length;j++){
					printline(commands[i][j]);
					if(commands[i][j]!=null)
					execute(commands[i][j],strings);
					}
				}
				}
				catch(Exception e){
					e.printStackTrace(System.out);
					printline("range input error > reset");
				}
			}
		}
else{
		execute(command,strings);
}
	}
	
	//printline(Package.getPackage("a").getName());
	//Class.forName("");
}
}

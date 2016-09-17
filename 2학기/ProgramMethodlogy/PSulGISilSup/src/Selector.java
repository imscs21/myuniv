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
	public static final String COMMAND_LIST = "program://list";
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
				if(!(e3 instanceof ClassNotFoundException))
				e3.printStackTrace(System.out);
				else{
					printline("[PROGRAM::EXECUTE] " + command+" is not found and can`t execute");
				}
			}	
		}
	}
	}
	public static void showprogramversion(){
		printline("\n=====VERSION=====");
	printline("VERSION: 0.21");
printline("BUILD DATE: 2016-9-17 SAT PM 07:12");
		printline("=====VERSION=====\n");
	}
	public static void helpmessage(){
		printline("\n==H==E==L==P==");
		final String ft = "%-20s";
		printline(String.format(ft, COMMAND_FINISH)+"exit program");
		printline(String.format(ft, COMMAND_HELP)+"show program command");
		printline(String.format(ft, COMMAND_PROBLEM_RANGE)+"auto start problem with range");
		printline(String.format(ft, COMMAND_LIST)+"show list of available level");
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
			}
			else if(command.equals(COMMAND_LIST)){
				StringBuffer sb = new StringBuffer();
				printline("\n==L==I==S==T==");
				for(char i='A';i<='Z';i++){
					boolean isSomeAdded = false;
					for(int j=1;j<=100;j++){
						final String step = Character.toString(i);
						final String level = Integer.toString(j);
						try{
							Class<?> cls = Class.forName(step.toLowerCase()+"."+step.toUpperCase()+level);
						Method m = cls.getMethod("main", new Class[]{strings.getClass()});
sb.append(step+j+" ");
isSomeAdded=true;
						}catch(Exception e1){
							try{
								Class<?> cls = Class.forName(step.toLowerCase()+"."+"Main"+step.toUpperCase()+level);
								Method m = cls.getDeclaredMethod("main", new Class[]{String[].class});
								sb.append(step+j+" ");
								isSomeAdded=true;
							}catch(Exception e2){
								
								try{
									Class<?> cls = Class.forName(step.toLowerCase()+"."+"Main"+level);
									Method m = cls.getDeclaredMethod("main", new Class[]{String[].class});
									sb.append(step+j+" ");
									isSomeAdded=true;
								}catch(Exception e3){
									
								}	
							}
						}	
					}//end for j
					if(isSomeAdded)
					sb.append("\n\n");
				}//end for i
				
				printline(sb.toString());
				printline("==L==I==S==T==\n");
			}
			else if(command.equals(COMMAND_PROBLEM_RANGE)){
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
					//printf("debug: %c %d, idx:%d\n",i,j,i+j-convstcls-stlv);
						commands[i-convstcls][j-stlv]=Character.toString(i)+j;
					
				}
				}
				for(int i=0;i<commands.length;i++){
					for(int j=0;j<commands[i].length;j++){
					
					if(commands[i][j]!=null){
						printline("[PROGRAM::EXECUTE] "+commands[i][j]);
						execute(commands[i][j],strings);
					}
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

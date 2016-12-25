import java.net.*;			
import java.io.*;			
			
public class ChatClient {			
			
	public static void main(String[] args) {		
		if(args.length != 2){ // 커맨드 라인의 파라메터 갯수를 확인합니다.	
			System.out.println("사용법 : java ChatClient id 접속할서버ip");
			System.exit(1);
		}	
		Socket sock = null;//소켓 변수 선언
		BufferedReader br = null;//읽을 스트림 선언	
		PrintWriter pw = null;	//쓸 스트림 선언
		boolean endflag = false;	//종료 확인 변수
		try{	
			sock = new Socket(args[1], 10001);//소켓 객체 생성및 서버에 연결시도
			pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));	//소켓에서 원형 out스트림을 가져와 쓸 스트림으로 객체 생성	
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	//소켓에서 원형 in스트림을 가져와 읽을 스트림으로 객체 생성		
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));		//콘솔창에서 받을 입력을 위한 스트림 객체 생성
			// 사용자의 id를 전송한다.		
			pw.println(args[0]);		//사용자의 아이디 전송
			pw.flush();		//또다른 입력을 위해 스트림 객체 내부의 버퍼를 비운다.
			InputThread it = new InputThread(sock, br);		//서버에서 입력받고 쓰기위한 멀티 쓰레드 객체 생성
			it.start();		//메인이 아닌 자식 쓰레드 실행
			String line = null;	//콘솔 입력값을 체크하기위한 변수 선언	
			while((line = keyboard.readLine()) != null){//콘솔에서 한줄을 입력받음		
				pw.println(line);	//소켓 쓰기 스트림으로 콘솔에서 한줄입력받은 스트링을 전송
				pw.flush();	 //또다른 쓰기를 위해서 스트림버퍼를 비움
				if(line.equals("/quit")){	//받은 입력이 '/quit'라면..
					endflag = true;//종료플래그를 참값으로 설정한다
					break; //콘솔 입력을 중단 시킨다
				}	
			}		
			System.out.println("클라이언트의 접속을 종료합니다.");	//콘솔에 디버깅 로그 출력	
		}catch(Exception ex){	//소켓이나 콘솔입력오류가 발생할 경우...
			if(!endflag)//콘솔입력이 종료되지 않았다면
				System.out.println(ex);	//에러 로그 출력
		}finally{			// try든 throw exception든 간에..
			try{		
				if(pw != null)	//소켓 출력(쓰기)스트림이 정상적으로 생성되었더라면
					pw.close(); //쓰기 스트림을 닫는다
			}catch(Exception ex){}		
			try{		
				if(br != null)	//소켓 읽기스트림이 정상적으로 생성되었더라면
					br.close(); //읽기 스트림을 닫는다
			}catch(Exception ex){}		
			try{		
				if(sock != null) //소켓이 정상적으로 서버와 연결되었더라면	
					sock.close();//소켓을 닫는다
			}catch(Exception ex){}		
		} // finally
//프로그램을 종료한다.		
	} // main				
} // class					
					
class InputThread extends Thread{					
	private Socket sock = null;	//소켓 선언			
	private BufferedReader br = null;	//읽기 스트림 선언			
	public InputThread(Socket sock, BufferedReader br){				
		this.sock = sock; //소켓 객체 설정			
		this.br = br;			//읽기 스트림 객체 생성
	}				
	public void run(){				
		try{			
			String line = null;	//읽는 스트림에서 스트링을 가져오기 위한 변수	
			while((line = br.readLine()) != null){	//스트림에서 스트링을 읽음	
				System.out.println(line);	//스트링을 스트림에서 읽어오면 콘솔창에 스트링을 출력함
			}		
		}catch(Exception ex){			
		}finally{			
			try{		
				if(br != null)	//읽기 스트림 객체가 제대로 생성된 객체로 설정되었고 설정된 스트림 객체가 제대로 연결된 스트림 객체이라면
					br.close(); // 읽기 스트림을 종료합니다
			}catch(Exception ex){}		
			try{		
				if(sock != null)	//소켓 객체가 제대로 생성된 객체로 설정되었고 설정된 소켓 객체가 제대로 연결되어 생성된 소켓 객체라면
					sock.close(); //소켓 양방향 스트림을 닫습니다.
			}catch(Exception ex){}		
		}		
		//자식 프로세스로서 서브 쓰레드를 종료합니다
	} // InputThread				
}					

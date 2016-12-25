import java.net.*;				
import java.io.*;				
				
public class EchoThreadServer {				
				
	public static void main(String[] args) {			
		try{		
			ServerSocket server = new ServerSocket(10001);	//서버를 10001포트로 바인딩합니다
			System.out.println("접속을 기다립니다.");
			while(true){	//무한 접속
				Socket sock = server.accept();//클라이언트를 받아들입니다
				EchoThread echothread = new EchoThread(sock);// 클라이언트를 개별따로 처리를 위해서 쓰레드 객체를 생성합니다
				echothread.start();//자식 프로세스로서 클라이언트를 처리하기 시작합니다
			} // while	
		}catch(Exception e){		
			System.out.println(e);	//서버 바인딩이나 클라이언트와의 연결도중 오류가 발생하면 오류 로그를 출력하고 메인 쓰레드를 종료합니다
		}	
	} // main		
}			
			
class EchoThread extends Thread{			
	private Socket sock; //클라언트소켓을 내부에서 쓰기 위한 전역변수
	public EchoThread(Socket sock){		
		this.sock = sock;	//받아온 클라이언트 소켓을 설정합니다
	} // 생성자		
	public void run(){		
		try{	
			InetAddress inetaddr = sock.getInetAddress();//클라이언트의 연결정보를 가져오는 객체를 가져옵니다
			System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");
			OutputStream out = sock.getOutputStream(); //클라이언트의 원형 쓰기 스트림을 가져옵니다
			InputStream in = sock.getInputStream();//클라이언트의 원형 읽기 스트림을 가져옵니다
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out)); //쓰기 스트림을 변형합니다
			BufferedReader br = new BufferedReader(new InputStreamReader(in));	//읽기 스트림을 변형합니다
			String line = null;	
			while((line = br.readLine()) != null){	//클라이언트로 부터 한 문장을 수신합니다
				System.out.println("클라이언트로 부터 전송받은 문자열 : " + line);//클라이언트로 부터 수신한 문장을 현재 서버 콘솔에 출력합니다
				pw.println(line); //수신한 문장을 그대로 다시 클라인트로 전송합니다
				pw.flush(); //버퍼를 비웁니다
			}	
			pw.close();	//쓰기 스트림을 닫습니다
			br.close();	//읽기 스트림을 닫습니다
			sock.close(); //양방향 스트림을 닫습니다	
		}catch(Exception ex){		
			System.out.println(ex);//에러를 출력합니다	
		}		
	} // run			
}				

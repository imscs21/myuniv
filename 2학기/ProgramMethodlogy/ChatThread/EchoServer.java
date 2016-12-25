import java.net.*;			
import java.io.*;			
			
public class EchoServer {			
			
	public static void main(String[] args) {		
		try{	
			ServerSocket server = new ServerSocket(10001);//10001번 포트로 서버를 바인딩합니다
			System.out.println("접속을 기다립니다.");
			Socket sock = server.accept();//클라이언트 소켓을 받기위해 대기합니다
			InetAddress inetaddr = sock.getInetAddress(); //클라이언트 소켓에 관련된 정보를 담은 객체를 가져옵니다(ip,port같은)
			System.out.println(inetaddr.getHostAddress() + " 로 부터 접속하였습니다.");
			OutputStream out = sock.getOutputStream();//서버입장에서 클라이언트의 원형 쓰기 스트림을 가져옵니다
			InputStream in = sock.getInputStream(); //서버입장에서 클라이언트의 원형 읽기 스트림을 가져옵니다
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));//클라이언트의 쓰기 스트림을 쓰기 편하게 약간 변형된 스트림을 생성합니다
			BufferedReader br = new BufferedReader(new InputStreamReader(in)); //클라이언트의 읽기 스트림을 쓰기 편하게 약간 스트림을 생성합니다
			String line = null;	
			while((line = br.readLine()) != null){	//클라이언트에서 전송된 문자열중에 한 문장을 수신합니다
				System.out.println("클라이언트로 부터 전송받은 문자열 : " + line); //전송받은 문자열을 현재 콘솔에 출력합니다
				pw.println(line); //수신된 클라이언트에서 전송된 문장을 다시 클라이언트로 전송합니다
				pw.flush(); //쓰기 버퍼를 비워 다시 쓸 수 있도록 합니다
			}	
			pw.close();	//쓰기 스트림을 닫습니다
			br.close();	//읽기 스트림을 닫습니다
			sock.close();	//양방향 스트림을 닫습니다
		}catch(Exception e){		
			System.out.println(e);//어디선가 에러가 나면 즉각 중단하고 에러를 출력한뒤 메인 쓰레드를 종료합니다	
		}		
	} // main			
}				

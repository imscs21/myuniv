import java.net.*;				
import java.io.*;				
				
public class EchoClient{				
				
	public static void main(String[] args) {			
		try{		
			Socket sock = new Socket("127.0.0.1", 10001);	//서버에 접속
			BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));	//콘솔 입력 스트림을 가져옴
			OutputStream out = sock.getOutputStream();	//소켓의 쓰기 스트림을 가져옴
			InputStream in = sock.getInputStream();	//소켓의 읽기 스트림을 가져옴
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(out));	//쓰기 스트림을 쓰기 편하게 약간 변형
			BufferedReader br = new BufferedReader(new InputStreamReader(in));	//읽기 스트림을 읽기 편하게 약간 변형
			String line = null;	//스트림에서 읽어올 스트링을 저장할 변수
			while((line = keyboard.readLine()) != null){	//콘솔에서 한줄을 읽어옴
				if(line.equals("quit")) break;//읽어온 스트링이 'quit'이면 콘솔에서 
				pw.println(line); //수신한 콘솔 1문장을 서버로 전송합니다
				pw.flush(); //쓰기 스트림의 버퍼를 지웁니다
				String echo = br.readLine(); //서버에서 전송된 문장을  수신합니다
				System.out.println("서버 로부터 전달받은 문자열 :" + echo); //수신된 문장을 현재 콘솔에 출력을 합니다
			}	
			pw.close();	//쓰기 스트림을 닫습니다
			br.close();	//읽기 스트림을 닫습니다
			sock.close();	//소켓 스트림을 닫습니다
		}catch(Exception e){		
			System.out.println(e);	//에러가 발생하면 에러 로그를 출력합니다
		}		
	} // main			
}				

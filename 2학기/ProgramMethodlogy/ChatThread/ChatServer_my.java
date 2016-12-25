package final_term;
import java.net.*;				
import java.io.*;				
import java.util.*;				
				
public class ChatServer_my {				
				
	public static void main(String[] args) {			
		try{		
			ServerSocket server = new ServerSocket(10001);	//서버 바인딩...
			System.out.println("접속을 기다립니다.");	
			HashMap hm = new HashMap();	//서버에서 클라이언트들의 쓰기 스트림 관리하는 객체로서 hashmap을 씀,클라이언트에서 받아온 아이디를 key로서 각각의 클라이언트 소켓의 쓰기 스트림 객체를 불러오고 저장함
			HashMap<String,HashMap<Integer,ArrayList<String>>> blockHm = new HashMap<String,HashMap<Integer,ArrayList<String>>>();
			ArrayList<String> blockList = new ArrayList<String>();
			
			while(true){	//무한대로 클라이언틀를 받아 들이는 중...
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock, hm,blockHm);//클라이언트 대응 쓰레드 객체 생성
				chatthread.start();//클라이언트 대응 쓰레드 실행
			} // while	
		}catch(Exception e){	//소켓 클라이언트를 받아들이는 도중 오류가 나거나 서버 바인딩 과정에서 오류가 발생하면
			System.out.println(e);//에러 로그 출력
		}	
		//서버 메인 쓰레드 종료
	} // main		
}			
			
class ChatThread extends Thread{			
	private Socket sock;	//클라이언트 소켓 객체 변수 선언
	private String id;		//클라이언트에서 받아온 아이디
	private BufferedReader br;	//클라이언트와의 통신에서 서버측에서 읽는 스트림 객체 선언	
	private HashMap hm;		//아이디와 해당하는 아이디의 소켓 쓰기 스트림 객체를 관리하는 메인 쓰레드의 객체에서 간접 참조해주는 변수
	private boolean initFlag = false;	
	private HashMap<Integer,ArrayList<String>> mBlockHm = null;
	public ChatThread(Socket sock, HashMap hm,HashMap<String,HashMap<Integer,ArrayList<String>>> blockHm){		
		this.sock = sock;	//접속한 클라이언트 객체로서 설정
		this.hm = hm;	//아이디와 비밀번호 관리 객체를 간접참조하기 위해 설정
		
		try{	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));	//클라이언트소켓에서 받아온 스트림을 서버입장에서 읽기 스트림형식으로서 스트림객체 생성
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	//소켓 통신을 위한 소켓 읽기 스트림을 가지고 스트림 객체 생성
			id = br.readLine();	//id를 클라이언트 측에서 받아옴
			broadcast(id + "님이 접속하였습니다.");	
			System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");	
			synchronized(blockHm){
				mBlockHm = blockHm.get(id);
				if(blockHm==null){
					mBlockHm = new HashMap<Integer,ArrayList<String>>();
					mBlockHm.put(1, new ArrayList<String>());
					mBlockHm.put(2, new ArrayList<String>());
					blockHm.put(id, mBlockHm);
				}
			}
			synchronized(hm){	
				hm.put(this.id, pw);//클라이언트 관리객체에 id를 key로서 해당하는 클라이언트의 쓰기 스트림 객체를 저장함-이 소스코드의 경우 쓰레드동기화 문제는 해결했지만 클라이언트의 아이디가 중복된 복수의 클라이언트가 접속하면 마지막에 접속한 클라이언트가 저장되는 중대한 알고리즘적 문제가 존재함-따라서 완성도를 높이려면 hashmap에 클라이언트에서 전송된 아이디가 이미 존재하는지 확인한뒤 다시한번입력하라고 하는 입력코드를 역전송하는 기능을 추가해야 할 것이다.
			}	
			initFlag = true;//객체 생성중에 제대로 설정되었는지 확인 상태를 설정하는 코드(현재로선 글적으로 의미는 있지만 구동상의 의미는 현재로선 존재하는지 않는다.)
		}catch(Exception ex){//객체생성중에 설정한 코드들이 어느하나라도 오류가 발생하게 되면		
			System.out.println(ex);	//에러 로그를 출력하고 아무것도 하지않는다.
		}		
	} // 생성자			
	public void run(){	//쓰레드 내부에 자체적으로 설정되어 있는 runnable 인터페이스의 함수를 재정의		
		try{		
			String line = null;//읽기 스트림에서 스트링을 가져오기위해서 가져옴	
			while((line = br.readLine()) != null){		//한 문장을 읽어오고 설정중...
				if(line.equals("/quit"))	//읽은 스트링이 '/quit'이면
					break;//while문 종료및 읽기 종료
				if(line.indexOf("/to ") == 0){	//문자열이 /to라는 내부 명령어로 시작되면
					sendmsg(line);//지정한 사용자로 메세지를 보내는 메소드를 실행
				}else	
					broadcast(id + " : " + line);//지정된 아이디로 메세지를 보낼것이 아니면 지정된 아이디로 받아온 메세지를 모든 콘솔에 출력하는 메소드 실행
			}		
		}catch(Exception ex){//에러나면			
			System.out.println(ex);		//에러 로그 출력
		}finally{			//위의 코드들을 실행한뒤에
			synchronized(hm){	//쓰레드 동기화	
				hm.remove(id);	//클라이언트 관리객체에서 해당하는 아이디를 포함한 데이터 삭제
			}		
			broadcast(id + " 님이 접속 종료하였습니다.");		
			try{		
				if(sock != null)	//소켓에 에러가 나지않았다면
					sock.close();//소켓을 닫는다
			}catch(Exception ex){}		
		}			
	} // run				
	public void sendmsg(String msg){	//메세지를 전송하는 메소드			
		int start = msg.indexOf(" ") +1;//보낼 아이디를 추출해낼 초기위치 검색			
		int end = msg.indexOf(" ", start);	//보낼 아이디를 추출해낼 마지막위치 검색				
		if(end != -1){			//일단 구분 문자가 ?아지면
			String to = msg.substring(start, end);		//상대의 아이디 추출
			String msg2 = msg.substring(end+1);		//보낼 메세지 추출
			Object obj = hm.get(to);		//추출해낸 아이디를 아이디관리객체에서 불러옴
			if(obj != null){		//해당하는 아이디가 존재하면
				PrintWriter pw = (PrintWriter)obj;//불러온 객체를 강제 형변환을 한다	
				pw.println(id + " 님이 다음의 귓속말을 보내셨습니다. :" + msg2);	//상대 객체의 쓰기 객체에 메세지를 전송
				pw.flush(); //버퍼를 비움
			} // if	
		}		
	} // sendmsg
	public void blockUser(){
		mBlockHm
	}
	public void msgBlockUser(){
		
	}
	public void senduserlist(){
		synchronized(hm){
            Set<String> s = hm.keySet();
            StringBuffer sb = new StringBuffer();
            final String header = "===U-S-E-R--L-I-S-T===";
            sb.append(header+"\n");
            for(String user : s){
            	sb.append(user+"\n");
            }
            sb.append(header);
            pw.println(sb.toString());
            
            pw.flush();
        }
	}
    public void showConnectedList(){
        synchronized(hm){
            Set<String> s = hm.keySet();
            StringBuffer sb = new StringBuffer();
            final String header = "===U-S-E-R--L-I-S-T===";
            sb.append(header+"\n");
            for(String user : s){
            	sb.append(user+"\n");
            }
            sb.append(header);
            pw.println(sb.toString());
            
            pw.flush();
        }
    }
	public void broadcast(String msg){			
		synchronized(hm){	//쓰레드 잠금	
			Collection collection = hm.values();//관리 객체에서 모든 값을 불러옴	
			Iterator iter = collection.iterator();	//한방향 접근객체로서 데이터를 불러옴
			while(iter.hasNext()){	//접근할 데이터가 아직 존재할 경우
				PrintWriter pw = (PrintWriter)iter.next();//접근할 데이터를 가져와 강제 형변환
				pw.println(msg);//가져온 접근 객체에 메세지를 전송
				pw.flush();//데이터의 버퍼를 비움.
			}	
		}		
	} // broadcast			
}				

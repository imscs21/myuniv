package final_term;
//컴퓨터 공학과 1학년:: 학번=2016004011 :: 황세현(Hwang se hyeon)
import java.net.*;
import java.text.SimpleDateFormat;
import java.io.*;				
import java.util.*;				
				
public class ChatServer {				
				
	public static void main(String[] args) {			
		try{		
			ServerSocket server = new ServerSocket(10001);	//서버 바인딩...
			System.out.println("Chat 접속을 기다립니다.");	
			final String[] block_word = {"ㅅㅂ","ㅂㅅ","ㅅ1ㅂ","ㅂ1ㅅ","시발","병신","븅신"};
			HashMap hm = new HashMap();	//서버에서 클라이언트들의 쓰기 스트림 관리하는 객체로서 hashmap을 씀,클라이언트에서 받아온 아이디를 key로서 각각의 클라이언트 소켓의 쓰기 스트림 객체를 불러오고 저장함
			while(true){	//무한대로 클라이언틀를 받아 들이는 중...
				Socket sock = server.accept();
				ChatThread chatthread = new ChatThread(sock, hm,block_word);//클라이언트 대응 쓰레드 객체 생성
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
	private String[] blockword;
	public ChatThread(Socket sock, HashMap hm,String[] blockword){		
		this.sock = sock;	//접속한 클라이언트 객체로서 설정
		this.hm = hm;	//아이디와 비밀번호 관리 객체를 간접참조하기 위해 설정
		this.blockword = blockword;
		try{	
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(sock.getOutputStream()));	//클라이언트소켓에서 받아온 스트림을 서버입장에서 읽기 스트림형식으로서 스트림객체 생성
			if(hm!=null){
				System.out.println("hm not null");
			}
			br = new BufferedReader(new InputStreamReader(sock.getInputStream()));	//소켓 통신을 위한 소켓 읽기 스트림을 가지고 스트림 객체 생성
			id = br.readLine();	//id를 클라이언트 측에서 받아옴
			System.out.println("id: "+id);
			broadcast(id + "님이 접속하였습니다.");	
			System.out.println("접속한 사용자의 아이디는 " + id + "입니다.");	
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
				}
				else if(line.indexOf("/userlist")==0){
					senduserlist();
				}
				else	
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
	/*
	 * 
	 * 3번 설계내용: new Date() 객체를 생성하면 자동으로 내부에서 System.currentTimeMills를 불러와 날자 timestamp를 설정해준다
	 * 			  그리고 simpledateformat 객체를 "[hh시 mm분 ss초]  "이라는 스트링을 생성자 매개변수 생성한뒤 format메소드를 불러 [ %%시 %%분 %%초] 라는 포맷을 가진 날짜스트링 데이터를 생성한다
	 * 			  그런뒤 broadcast할 메세지와 위에서 생성한 날짜 스트링데이터를 서로 합친다, 이때 날짜 스트링데이터가 메세지 스트링보다 앞에 와야하므로 datstr+msg 형식으로 합친다
	 * 			  그리고 이 합친 스트링을 반복문을 돌려 모든 클라이언트에게 날자가 포함된 메세지를 전송해준다
	 * 			  sendmsg에서도 날짜 스트링 데이터를 생성한뒤 datestr+"default format"+msg2로 스트링을 합친뒤 해당하는 클라이언트에게 데이터를 보내준다
	 * 
	 * 
	 * 
	 */
	public void sendmsg(String msg){	//메세지를 전송하는 메소드			
		int start = msg.indexOf(" ") +1;//보낼 아이디를 추출해낼 초기위치 검색			
		int end = msg.indexOf(" ", start);	//보낼 아이디를 추출해낼 마지막위치 검색				
		if(end != -1){			//일단 구분 문자가 ?아지면
			String to = msg.substring(start, end);		//상대의 아이디 추출
			String msg2 = msg.substring(end+1);		//보낼 메세지 추출
		
			Object obj = hm.get(to);		//추출해낸 아이디를 아이디관리객체에서 불러옴
			if(obj != null){		//해당하는 아이디가 존재하면
				PrintWriter pw = (PrintWriter)obj;//불러온 객체를 강제 형변환을 한다	
				pw.println(new SimpleDateFormat("[hh시 mm분 ss초]  ").format(new  Date())+id + " 님이 다음의 귓속말을 보내셨습니다. :" + msg2);	//상대 객체의 쓰기 객체에 메세지를 전송
				pw.flush(); //버퍼를 비움
			} // if	
		}		
	} // sendmsg
	
	/*
	 * 4번 설계 내용: hashmap에는 hm.keySet()라는 메소드가 존재하는데 이메소드는 지금까지 저장한데이터의 모든 키값을 가지고 있는 객체를 리턴해준다
	 * 			   따라서 keySet이라는 객체는 Set이라는 데이터 저장관리객체의 일종인데 이것은 일반 배열처럼 값을 하나하나 반복문을 불러올수 있다
	 *			   이때 우리는 key데이터인 id값을 가져와야하기 때문에 지금 몇번째 반복문을 도는지는 알 필요성이 없다 따라서 반복문을 foreach문으로 돌리고 해당하는 사용자 인원수는 set.size()라는 메소드를 불러온다
	 *				이떄 우리는 클라이언트로 스트링 객체로 데이터를 전송할 것이므로 이것을 StringBuffer객체를 생성한뒤 내부에 append메소드로 각각의 데이터들을 StringBuffer에 저장한뒤 StringBuffer.toString()메소드로 합쳐진 스트링 데이터를 가져와 이것을 현재 쓰레드에 설정되어있는( /userlist를 전송한 클라이언트)클라이언트로 리스트를 보내준다
	 *
	 * 
	 * 
	 */
	public void senduserlist(){
		synchronized(hm){
            Set<String> s = hm.keySet();
            
            StringBuffer sb = new StringBuffer();
            final String header = "===U-S-E-R--L-I-S-T===";
            sb.append(header+"\n");
            sb.append(String.format("총 인원: %d\n",s.size()));
            for(String user : s){
            	sb.append(user+"\n");
            }
            sb.append(header);
            PrintWriter pw = (PrintWriter)hm.get(id);
            pw.println(sb.toString());
            pw.flush();
        }
	}
	/*
	 * 
	 * 3번 설계내용: new Date() 객체를 생성하면 자동으로 내부에서 System.currentTimeMills를 불러와 날자 timestamp를 설정해준다
	 * 			  그리고 simpledateformat 객체를 "[hh시 mm분 ss초]  "이라는 스트링을 생성자 매개변수 생성한뒤 format메소드를 불러 [ %%시 %%분 %%초] 라는 포맷을 가진 날짜스트링 데이터를 생성한다
	 * 			  그런뒤 broadcast할 메세지와 위에서 생성한 날짜 스트링데이터를 서로 합친다, 이때 날짜 스트링데이터가 메세지 스트링보다 앞에 와야하므로 datstr+msg 형식으로 합친다
	 * 			  그리고 이 합친 스트링을 반복문을 돌려 모든 클라이언트에게 날자가 포함된 메세지를 전송해준다
	 * 			  sendmsg에서도 날짜 스트링 데이터를 생성한뒤 datestr+"default format"+msg2로 스트링을 합친뒤 해당하는 클라이언트에게 데이터를 보내준다
	 * 
	 * 
	 * 5번 설계 내용: 5번 문제의 설계는 간단하다, hm객체에서 해당하는 id(현재 작업하는 클라이언트의 아이디)의 저장된 printwriter객체를 가져온다
	 * 				이때 broadcast에서는 모든 클라이언트에게 전송하기위해 Iterator을 이용해 while문을 돌린다
	 * 				이때 while문안에서 Iterator에서 가져온 현재 hm에 저장된 객체와 해당하는 id로 가져온 객체의 메모리 주소가 같거나 해당하는 객체들이 서로 같은지 확인한다 
	 * 				만약 메모리주소가 같게되면 현재 클라이언트에서 서버로 데이터를 전송한 클라이언트가 되기때문에 이때는 broadcast를 포기하고 다음 저장객체에서 조건문을 판단해 메세지를 전송한다.
	 * 
	 * 6번 설계 내용: 솔직히 if문으로 걸러내어 하위 while문을 만나지 않게 할 수 있지만 그냥 보기 편하게 boolean값으로 while문을 제어하려고 한다
	 * 				금지단어는 솔직히 broadcast안에 final String[] 객체를 생성해 관리할 수 있다 하지만 엄밀히보면 이것을 서버와 관련된 쓰레드객체에서 지정하는 것이 서버객체에서 관리하는 것이 아니게 된다
	 * 				따라서 서버 객체의 main 메소드안에서 final String[] filter = {} 객체같은 것을 생성한뒤 쓰레드에게는 hm객체같이 생성자 매개변수로서 전달하고 내부에서 전역변수로 String[]을 설정해 broadcast에서 필터링 값들을 접근할 수 있게 한다
	 * 				그런뒤 가져온 필터링 객체는 json이나 특정 포멧을 이용해 하나의 String에서 관리할 수 도 있겠지만 귀찮으니 편하게 배열객체로서 접근을 한다
	 * 				이때 메세지에 필터링 배열 객체의 데이터가 하나라도 포함되어있으면 필터링이 작동해야하므로 필터링에 걸렸는지 안걸렸는지 판단하는 boolean을 미리 선언해 false로 값을 설정해둔다
	 * 				이때 필터링 배열 객체를 중심으로 포문을 돌린다이때 만약 포문을 돌린 필터링 객체가 하나라도 포함되어 있으면 boolean 값을 true로 설정하고 욕설금지라고 현재 작업중인 클라이언트 스트림에 전송해준뒤 포문을 break로 강제로 빠져나오게 한다
	 * 				그런뒤 필터링이 되면 작업중인 클라이언트에게 금지라고 보낸뒤 다른 클라이언트에게는 보낼수 없으므로 while문의 기존조건문에다가 "그리고 해당하는 boolean변수의 값이 false라면" 을 추가해준다
	 * 				이렇게 되면 필터링이 안걸릴때만 다른 클라이언트에게 문자를 전송해주게 된다.
	 * 			   
	 */
	public void broadcast(String msg){			
		synchronized(hm){	//쓰레드 잠금	
			Collection collection = hm.values();//관리 객체에서 모든 값을 불러옴	
			Iterator iter = collection.iterator();	//한방향 접근객체로서 데이터를 불러옴
			
			StringBuffer sb = new StringBuffer();
			sb.append( new SimpleDateFormat("[hh시 mm분 ss초]  ").format( new  Date()));
			sb.append(msg);
			final String formatted_msg = sb.toString();
			boolean isContainBlockWord = false;
			
			for(String bw:blockword){
				if(msg.contains(bw)){
					isContainBlockWord=true;
					PrintWriter pw =(PrintWriter) hm.get(id);
					pw.println("욕설금지!");
					pw.flush();
					break;
				}
			}
			
			while(!isContainBlockWord&&iter.hasNext()){	//접근할 데이터가 아직 존재할 경우
				PrintWriter pw = (PrintWriter)iter.next();//접근할 데이터를 가져와 강제 형변환
				if(!pw.equals(hm.get(id))&&pw!=(PrintWriter)hm.get(id)){
				pw.println(formatted_msg);//가져온 접근 객체에 메세지를 전송
				pw.flush();//데이터의 버퍼를 비움.
				}
				
			}	
		}		
	} // broadcast			
}				
/*
1번)
	먼저 InputThread를 사용하는 이유는 크게 2가지 이다
	첫째,먼저 client에서는 콘솔의 환경이기 때문에 콘솔에서 서버로 전송할 스트링(메세지)를 입력받고 서버로 전송을 해야하는데 서버로 전송하는 스트림과 콘솔에서 스트링을 입력받는 스트림을 동시에 처리해야 한다
		하지만 네트워크로 소켓을 통해 서버로 데이터를 전송하는 스트림과 콘솔 스트림을 하나의 프로세스에서 작동시키기에는 동시처리가 불가능한 즉 콘솔을 처리한뒤 서버와 통신하거나 서버와 통신한뒤 콘솔데이터를 처리해야하는 문제가 생긴다
		이때 자식프로세스의 개념인 InputThread를 사용해서 콘솔 스트림을 처리하는 도중 네트워크를 통해 서버와의 통신도 동시에 하기위해서 InputThread를 만들어 사용한
	둘째, 소켓은 네트워크를 사용한다, 하지만 네트워크는 응답이 올수도있고 오지 않을 수도 있다, 그런데 이때 해당하는 Thread에 blocking이 걸려버린다(무한루프효과)
		그래서 네트워킹 블럭킹의 문제를 해결하기위해서도 사용한다
	
2번)
	그다음으로 broadcast() 와 sendmsg()에서 hm은 먼저 broadcast함수에서의 사용법을 보면 간단하다,Iterator 객체로 hm객체의 내부 데이터를 readonly이면서 oneway(이전에 불러왔던 것을 불러올 수 없음)방식으로 모든 데이터를 끄집어낸다
	그다음 매개변수인 메세지를 현재 불러져있는 hm데이터, 즉 다른 클라이언트 쓰기스트림(서버기준)을 불러와 메세지를 전송한다, 즉 모든 클라이언트에게 매개변수 msg를 전송하게되고 hm은 모든 클라이언트를 불러오기위해서쓰이고 Collection collection = hm.values(); Iterator iter = collection.iterator(); 으로 불린다
	sendmsg()에서는 단순하게 msg포맷에 포함되어있는 다른 클라이언트의 아이디 (key)를 가져와 hm객체에서 hm.get 메소드로 해당되는 객체를 가져온다
	하지만 사용자가 다른 클라이언트의 아이디를 잘 못 입력했을 수 도있다 그래서 Object obj = hm.get으로 불르고 만약 hm에서 데이터를 가져오는 것이 성공한다면 null이 아닌 객체를 반환한다
	이때 가져온 객체가 null이 아니면 원형타입인 PrintWriter로 강제 형변환해 해당하는 아이디에게 메세지를 전송한다.
	
* 3번 설계내용: new Date() 객체를 생성하면 자동으로 내부에서 System.currentTimeMills를 불러와 날자 timestamp를 설정해준다
	 * 			  그리고 simpledateformat 객체를 "[hh시 mm분 ss초]  "이라는 스트링을 생성자 매개변수 생성한뒤 format메소드를 불러 [ %%시 %%분 %%초] 라는 포맷을 가진 날짜스트링 데이터를 생성한다
	 * 			  그런뒤 broadcast할 메세지와 위에서 생성한 날짜 스트링데이터를 서로 합친다, 이때 날짜 스트링데이터가 메세지 스트링보다 앞에 와야하므로 datstr+msg 형식으로 합친다
	 * 			  그리고 이 합친 스트링을 반복문을 돌려 모든 클라이언트에게 날자가 포함된 메세지를 전송해준다
	 * 			  sendmsg에서도 날짜 스트링 데이터를 생성한뒤 datestr+"default format"+msg2로 스트링을 합친뒤 해당하는 클라이언트에게 데이터를 보내준다
	 * 
	 * 
* 4번 설계 내용: hashmap에는 hm.keySet()라는 메소드가 존재하는데 이메소드는 지금까지 저장한데이터의 모든 키값을 가지고 있는 객체를 리턴해준다
	 * 		  따라서 keySet이라는 객체는 Set이라는 데이터 저장관리객체의 일종인데 이것은 일반 배열처럼 값을 하나하나 반복문을 불러올수 있다
	 *		  이때 우리는 key데이터인 id값을 가져와야하기 때문에 지금 몇번째 반복문을 도는지는 알 필요성이 없다 따라서 반복문을 foreach문으로 돌리고 해당하는 사용자 인원수는 set.size()라는 메소드를 불러온다
	 *		  이떄 우리는 클라이언트로 스트링 객체로 데이터를 전송할 것이므로 이것을 StringBuffer객체를 생성한뒤 내부에 append메소드로 각각의 데이터들을 StringBuffer에 저장한뒤 StringBuffer.toString()메소드로 합쳐진 스트링 데이터를 가져와 이것을 현재 쓰레드에 설정되어있는( /userlist를 전송한 클라이언트)클라이언트로 리스트를 보내준다
	 *
* 5번 설계 내용: 5번 문제의 설계는 간단하다, hm객체에서 해당하는 id(현재 작업하는 클라이언트의 아이디)의 저장된 printwriter객체를 가져온다
	 * 			이때 broadcast에서는 모든 클라이언트에게 전송하기위해 Iterator을 이용해 while문을 돌린다
	 * 			이때 while문안에서 Iterator에서 가져온 현재 hm에 저장된 객체와 해당하는 id로 가져온 객체의 메모리 주소가 같거나 해당하는 객체들이 서로 같은지 확인한다 
	 * 			만약 메모리주소가 같게되면 현재 클라이언트에서 서버로 데이터를 전송한 클라이언트가 되기때문에 이때는 broadcast를 포기하고 다음 저장객체에서 조건문을 판단해 메세지를 전송한다.
	
6번 설계 내용: 솔직히 if문으로 걸러내어 하위 while문을 만나지 않게 할 수 있지만 그냥 보기 편하게 boolean값으로 while문을 제어하려고 한다
	 * 				금지단어는 솔직히 broadcast안에 final String[] 객체를 생성해 관리할 수 있다 하지만 엄밀히보면 이것을 서버와 관련된 쓰레드객체에서 지정하는 것이 서버객체에서 관리하는 것이 아니게 된다
	 * 				따라서 서버 객체의 main 메소드안에서 final String[] filter = {} 객체같은 것을 생성한뒤 쓰레드에게는 hm객체같이 생성자 매개변수로서 전달하고 내부에서 전역변수로 String[]을 설정해 broadcast에서 필터링 값들을 접근할 수 있게 한다
	 * 				그런뒤 가져온 필터링 객체는 json이나 특정 포멧을 이용해 하나의 String에서 관리할 수 도 있겠지만 귀찮으니 편하게 배열객체로서 접근을 한다
	 * 				이때 메세지에 필터링 배열 객체의 데이터가 하나라도 포함되어있으면 필터링이 작동해야하므로 필터링에 걸렸는지 안걸렸는지 판단하는 boolean을 미리 선언해 false로 값을 설정해둔다
	 * 				이때 필터링 배열 객체를 중심으로 포문을 돌린다이때 만약 포문을 돌린 필터링 객체가 하나라도 포함되어 있으면 boolean 값을 true로 설정하고 욕설금지라고 현재 작업중인 클라이언트 스트림에 전송해준뒤 포문을 break로 강제로 빠져나오게 한다
	 * 				그런뒤 필터링이 되면 작업중인 클라이언트에게 금지라고 보낸뒤 다른 클라이언트에게는 보낼수 없으므로 while문의 기존조건문에다가 "그리고 해당하는 boolean변수의 값이 false라면" 을 추가해준다
	 * 				이렇게 되면 필터링이 안걸릴때만 다른 클라이언트에게 문자를 전송해주게 된다.

7번)
	먼저 클라이언트 소스코드에 main메소드에서 콘솔과 서버와의 통신을 하기전에 Hashmap객체를 변수로서 생성해둔다
	이때 상용구는 서버와 통신할 필요없이 콘솔에서 들어오는 값을 체크해 등록하던가 불러오던가 하면 된다.
	따라서 우리가 hm을 이용해 설계해야하는 부분은 콘솔에서 한 문장을 가져오게 된 while문안에서 조건문을 걸어 상용구 기능을 설계하면된다
	우선 콘솔 while문에서 연결된 서버소켓의 쓰기 스트림에 콘솔에서 입력된 값을 전송하기전에 조건문을 걸어줘야한다
	소스코드를 보자면 
	if(line.indexOf("+ ")==0){
					int start = line.indexOf(" ") +1;		
					int end = line.indexOf(" ", start);		
					String key = line.substring(start, end);	
					String value = line.substring(end+1);
					hm.put(key, value);
				}
				else if(line.indexOf("# ")==0){
					int start = line.indexOf(" ") +1;		
					int end = line.indexOf(" ", start);		
					String value = line.substring(start);
					Object t = hm.get(value);
					if(t!=null){
					line =(String) t;
					}
				}
				
				pw.println(line);
	이런 식이된다 가져온 문자가 '+ '로 시작되면 키값과 상용구를 분리해 hm.put(key,expr)로 저장한다
	가져온 문자가 '# '로 시작되고 분리해낸 키값으로 가져온 데이터가 null이 아니면  line을 저장된 상용구로 설정한다
	그렇게 되면 서버에는 상용구가 전송된다
	

8번)
	먼저 이설계는 서버와 클라이언트를 변경할 필요가있다
	우선 서버에서는 서버의 아이디를 받아온 이래로 string으로서 클라이언트에서 받아온 모드데이터를 가져온다
	예를들어 '::mode_chat' 과  '::mode_file'으로 일반적인 채팅작업과 파일작업을 나누게 하는 것이다
	만약 전송해준 클라이언트의 파일과 같은 이름으로 다른 클라이언트에게 전송하고 싶으면 최소 서버로 모드선택문에서 ::mode_file을 받아온뒤 추가로 파일명을 받아오도록 하면 파일명을 지정해 다른 클라이언트로 보내면 된다.
   만약 클라이언트에서 ::mode_chat으로 들어온다면 일반적인 채팅서버로서 작동하고 추가로브로드캐스트하기전에 ::mode_chat 을 다른 클라이언트에 메세지보다 먼저 전송을 해주고 그외에 ::mode_file이 들어온다면 BufferedReader를 readline메소드로 읽지말고 어떤 버퍼를 생성해 BufferedReader내부에서 read(buffer) 메소드를 호출하는 것이다
   이때 buf을 사용한 while문 내부에서 broadcast 함수같이 이터레이터로 포문을 돌리고 버퍼데이터를 전송하기전에 ::mode_file을 해당하는 클라이언트에게 미리보내준다 그리고 해당하는 클라이언트에게 버퍼로서 데이터를 전송한다
   이렇게해서 전송된 파일데이터가 끝에 도달하면 서버는 파일전송을 그만두고 모드 선택 문으로 돌아간다
   클라이언트에서는 '$ '으로 시작되면 new File("파일이름") 을 가져와 우선 스트림화 되기전에 파일이 존재하는 지 체크한다 전송할 파일이 폴터이거나  존재하지 않는 파일이라면 파일명을 제대로 입력하라고 출력하고 다시 콘솔입력문으로 돌아간다
   만약 제대로 파일이 존재하면 new FileInputStream(file)로 파일을 스트림화하고 이것을 버퍼를 이용해 파일 데이터를 가져온다
   버퍼데이터를 전송하기전에 즉,버퍼와 관련된 while문을 돌리기 전에 '::mode_file' 을 서버로 전송해주고 그런뒤 버퍼데이터를 보내준다
   그리고 파일 스트림의 버퍼가 끝이 날때까지 버퍼 변수를 이용해 서버로 전송한다.
   다른 클라이언트에서도 서버와 읽는  입력된 모드를 체크한다 모드가 챗모드면 일반적인 스트링 통신을하고 그것이 아니면 서버와마찬가지로 BufferedReader에서 readline이 아니라 read(buffer)메소드로 읽어온다.
   만약 강제적인 파일명을 원하면 다른클라이언트에서는 버퍼를 수신받기전에 파일명을 수신할수있도록 몇줄을 추가해준다.
	하지만 BufferedReader의buffer 타입은 char이라서  음수를 받을수없다 따라서 BufferedReader를 다른 스트림으로 받거나 BufferedReader말고 원시 스트림을 전역변수로 두고 BufferedReader을 사용할때만 BufferedReader을 생성해 사용하는 것이좋다


*/
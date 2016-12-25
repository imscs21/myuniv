/*
2016-2학기 프로그램설계방법론[담당교수 : 김광] 중간고사

학과 : 컴퓨터 공학과
학년 : 1학년
학번 : 2016004011
이름 : 황세현 (Hwang se hyeon)

주제 : 한양통닭 주문관리 프로그램 HFCManager 
*/

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;					// 주문일시 자동입력을 위한 구문 (주문서 생성자 메소드 내)
import java.util.LinkedList;
import java.util.Queue;
import java.text.SimpleDateFormat;	// 주문일시 자동입력을 위한 구문 (주문서 생성자 메소드 내)

class Order  
{
	int no, price; // 주문일련번호, 총주문가격
	int count[];		// 메뉴별 주문갯수 (count[0]:후라이드 count[1]:양념 count[2]:반반 count[3]:파닭 )
	String buyer, date;	//주문자성명, 주문일시(자동입력됨) 
	
	public Order(int n, int p, int c[], String b) // 주문서 생성자.. 수정할 필요 없음  
	{
		this.no = n;
		this.price = p;
		this.count = new int[4];
		for (int i=0;i<4;i++)
		{
			this.count[i] = c[i];
		}
		this.buyer = b;
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd, hh:mm:ss"); 
		this.date = sdf.format(dt).toString();
	}
	int getPrice()
	{
		return price;
	}
	int[] getCount()
	{
		return count;
	}
	String getBuyer()
	{
		return buyer;
	}
	String getDate()
	{
		return date;
	}
	void setPrice(int new_price)
	{
		this.price = new_price;
	}
	void setCount(int[] new_count)
	{
		//also (count=new_count) can be available
		for(int i =0;i<count.length;i++){
			count[i] = new_count[i];
		}
			// 구현할 것..
	}
	public int getNumber(){
		return no;
	}

}
class HFCManager 
{
	ArrayList<Order> order_list;	// 주문서 객체 리스트
	String menu_name[] = {"후라이드","양념","반반","파닭"};			// 메뉴이름
	int order_menu[];				// 메뉴별 총 주문갯수
	int price_menu[];				// 메뉴별 판매단가
	int orders;					// 현재까지의 주문서 갯수
	int income;					// 현재까지의 총 매출금액

	public HFCManager()	// 관리객체 생성자 
	{
		order_list = new ArrayList<Order>();
		order_menu = new int[4];
		price_menu = new int[4];

		orders = 0;
		income = 0;
		for (int i=0;i<4;i++)
		{
			 order_menu[i]=0;
			 price_menu[i]=0;
		}
	}

	void setPrice() // 관리작업 시작전에 메뉴별 단가 입력을 위한 메소드 
	{
		Scanner s = new Scanner(System.in);

		System.out.println("메뉴별 단가를 입력하시오.");
		for (int i=0;i<4;i++)
		{
			System.out.print(menu_name[i]+" : ");
			price_menu[i]=s.nextInt();
		}
	}

	void printMenu() // 메뉴판(메뉴이름과 가격)을 보여주는 메소드 
	{
		System.out.print("메뉴판 : ");
		for (int i=0;i<4;i++)
		{
			System.out.println("["+(i+1)+"] "+menu_name[i] + " - "+price_menu[i] + "원");
		}
		System.out.println();
	}
	//주문 추가
	void addOrder()
	{
		Scanner s = new Scanner(System.in);
		System.out.print("주문자 이름을 입력하세요 : ");
		String buyer = s.next();
		System.out.print("메뉴별 주문 갯수를 입력하세요 : [1]후라이드 [2]양념 [3]반반 [4]파닭 --> ");
		int amount[] = new int[4];		// 4가지 메뉴별 주문갯
		for (int i=0;i<4;i++)
		{
			amount[i] = s.nextInt();		// 주문갯수 4번 입력받
		}
		int price = 0;						// 주문금액 초기화 
		for (int i=0;i<4;i++)
		{
			price += amount[i] * price_menu[i];		// 주문금액 누산 
			order_menu[i] += amount[i];		// 메뉴별 총 주문갯수에 누적계산  
		}
		// 이부분에서 주문서 추가와 관련된 필요한 작업을 구현해야 함  
		income += price;//현재까지의 총 매출금액 누적
		Order ord = new Order(++orders, price,amount,buyer);// 주문객체생성 
		order_list.add(ord);//주문 배열에 주문 객체를 추가함
		
		
	}
	
	void modifyOrder()
	{
		Scanner s = new Scanner(System.in);//input instance
		listOrder();
		System.out.print("변경할 주문서 번호는? (0 취소) : "); 
		int num = s.nextInt();
		if (num == 0) {
			System.out.println("취소하셨습니다.");
		}
		else if (num > orders){
			System.out.println("없는 주문서 번호입니다.");			
		}
		else {
			// 이부분을 구현해야 
			System.out.print("메뉴별 주문 갯수를 다시입력하세요 : [1]후라이드 [2] 양념 [3] 반반 [4]파닭 ");
			Order ord = null;//해당하는 객체를 찿음
			for(int i = 0;i<order_list.size();i++){
				if(order_list.get(i).getNumber()==num){
					ord = order_list.get(i);
					break;
				}
			}
			int counts[] = new int[4];//각가의 주문 갯수를 임시저장하는 배열
			int total_price = 0;// 각각의 주문한 목록의 금액의 총 합계를 저장
			income -= order_list.get(num-1).getPrice();//원래값에서 변동된 만큼 빼줄수 있지만 귀찮으니 해당하는 주문객체의 금액을 모두 뺌
			for(int i =0;i<counts.length;i++){
				order_menu[i] -= ord.getCount()[i];
				counts[i] = s.nextInt();// 새로운 갯수를 받음
				total_price += price_menu[i]*counts[i];//새로운 갯수에 해당하는 금액들의 총합을 계산
				order_menu[i] += counts[i];//기존에 있던 값들을 제외하고 새로운 총 갯수들을 더 해줌
			}
			income += total_price;//새로운 가격을 더해줌
			ord.setCount(counts);//새로운 갯수를 객체에 적용함
			ord.setPrice(total_price);//기존 주문의 새로운  총가격을 적용함
			System.out.println("변경되었습니다.");
		}
	}
	
	void listOrder()
	{
		final String fnt = "%-3s %-15s %-5s %4s %4s";//출력 포맷
		System.out.printf(fnt+"(후라이드/양념/반반/파닭)\n","번호","주문 일시","주문자", "주문금액", "주문갯수");
		for(int i = 0;i<order_list.size();i++){
			Order ord = order_list.get(i);//배열에 저장되있던 주문 객체를 하나씩 가져옴
			Object[] objs = new Object[5];//출력 포맷을 위해서 임시 저장변수
			objs[0]=Integer.toString(ord.getNumber());//해당하는 출력할 id(number) 가져오기
			objs[1] = 		ord.getDate();//해당하는 출력할 날짜 가져오기
			objs[2] = ord.getBuyer(); //해당하는 출력할 주문자 이름 가져오기
			objs[3]  = Integer.toString( ord.getPrice());
			int[] cnts = ord.getCount();//출력 포맷과 짧은 코드를 위해 불러옴(루프문 돌릴수있는데 포멧쓰면 라인 고려가 귀찮아서 불러온 이유도 있음)
	
			objs[4] = String.format("%d 개/ %d 개/ %d 개/  %d 개/\n", cnts[0],cnts[1],cnts[2],cnts[3]);
		
			System.out.printf(fnt+"\n", objs);
		}
		System.out.print("\n");
	}
	protected void searchOrderByPrice(){
		Scanner s = new Scanner(System.in);
		System.out.print("검색할 최소 주문 금액은? ");//최소 주문금액 받아오기
		listOrder(s.nextInt());//오버라이드된 함수로바로 불러오기
	}
	void listOrder(int price)
	{
		//Queue<Order> resultQuery = new LinkedList<Order>();//결과들을 저장하는 배열
		System.out.println(price+"원 이상 주문한 내역은 다음과 같습니다");
		final String fnt = "%-3s %-15s %-5s %4s %4s";//출력 포맷
		System.out.printf(fnt+" (후라이드/양념/반반/파닭)\n","번호","주문 일시","주문자", "주문금액", "주문갯수");
		
		for(int i = 0;i<orders && order_list.size()>0;i++){
			if(order_list.get(i).getPrice()>=price){//저장된 금액이 지정된 금액보다 이상인지 체크
				Order ord = order_list.get(i);//결과가 될 객체 불러오고 결과 배열에서 제거
				Object[] objs = new Object[5];//출력 포맷을 위한 변수
				objs[0]=Integer.toString(ord.getNumber());//불러오기
				objs[1] = 		ord.getDate();//불러오기
				objs[2] = ord.getBuyer();//불러오기
				objs[3]  = Integer.toString( ord.getPrice());//불러오기
				int[] cnts = ord.getCount();
		
				objs[4] = String.format("%d 개/ %d 개/ %d 개/  %d 개/\n", cnts[0],cnts[1],cnts[2],cnts[3]);//불러오기
			
				System.out.printf(fnt+"\n", objs);
				//resultQuery.add(order_list.get(i));//결과가될 주문 객체를 임시 저장
			}
		}
		
		
	}
	void searchOrderByName(){
		Scanner s = new Scanner(System.in);
		System.out.print("검색할 고객 이름은? ");//고객이름을 입력받음(이경우 이름이 포함된것이 아니라 100%일치할 경우 조회 가능)
		listOrder(s.next());
		
	}
	void listOrder(String name)
	{
		Queue<Order> resultQuery = new LinkedList<Order>();//결과들을 저장하는 배열
		
		for(int i = 0;i<orders && order_list.size()>0;i++){
			if(order_list.get(i).getBuyer().contains(name)){
				resultQuery.add(order_list.get(i));//결과가될 주문 객체를 임시 저장
			}
		}
		
		//이하 불러오고 출력
		System.out.println(name+" 고객님이 주문하신 내역은 다음과 같습니다");
		final String fnt = "%-3s %-15s %-5s %4s %4s (후라이드/양념/반반/파닭)\n";
		System.out.printf(fnt,"번호","주문 일시","주문자", "주문금액", "주문갯수");
		while(resultQuery.size()>0){
			Order ord = resultQuery.poll();
			Object[] objs = new Object[5];
			objs[0]=Integer.toString(ord.getNumber());
			objs[1] = 		ord.getDate();
			objs[2] = ord.getBuyer();
			objs[3]  = Integer.toString(ord.getPrice());
			int[] cnts =  ord.getCount();
	
			objs[4] = String.format("%d 개/ %d 개/ %d 개/  %d 개/\n", cnts[0],cnts[1],cnts[2],cnts[3]);
		
		System.out.printf(fnt, objs);
	}
	
	}
	void findBestOrder(){
		System.out.println("가장 많은 금액을 주문한 주문서는 다음과 같습니다.");
		int max_price = Integer.MIN_VALUE;//주문 배열에서 주문 금액이큰 금액을 찿음
		//Collections.sort를 사용가능하지만 보여주기위해 이렇게 구현
		Order tmp = null;
		for(Order ord:order_list){
			max_price =Math.max(max_price,  ord.getPrice());
		}
		for(Order ord:order_list){
			if(ord.getPrice()==max_price){
				tmp = ord;//최대금액과 현재 객체의 가격이 일치하면 그것은 최대 주문
			}
		}
		final String fnt ="주문일시: %s\n주문고객: %s\n 주문 금액: %d원\n 주문내역: 후라이드 %d 개/ 양념 %d개 / 반반 %d개 /파닭 %d 개/\n";
		System.out.printf(fnt,tmp.getDate(),tmp.getBuyer(),tmp.getPrice(),
			tmp.getCount()[0],
			tmp.getCount()[1],
			tmp.getCount()[2],
			tmp.getCount()[3]);
	}
	protected void report(){
		System.out.printf("매출 보고 (주문횟수: %d건)\n",order_list.size());
		listOrder();//모든 주문 객체를 불러와 출력
		System.out.println("메뉴별 총 주문 갯수");
		for(int i =0;i<menu_name.length;i++){
			System.out.printf("%s : %d개\n", menu_name[i],order_menu[i]);//총 주문 갯수를 출력
		}
		System.out.println("총 판매금액 "+income+"원\n");//총 주문 가격을 출력
		
	}
	//주문관리작업진행(start)
	void start()
	{
		Scanner s = new Scanner(System.in);
		int menu;
		boolean go=true;

		setPrice();
		while(go)
		{
			System.out.println("\n===============================================================");
			System.out.println("1.주문추가, 2.주문변경, 3.주문검색(고객별) 4.주문검색(금액별), 5.베스트, 6.매출, 7.종료");
			System.out.print("메뉴선택 : ");
			menu = s.nextInt();
			switch (menu)
			{
			case 1 : 
				addOrder();	
				break;
			case 2 :
				modifyOrder();
				break;
			case 3 :
				searchOrderByName();
				break;
			case 4 :
				searchOrderByPrice();
				break;
			case 5 :
				findBestOrder();
				break;
			case 6 :
				report();
				break;
			case 7 :
				go=false;
				break;
			
			}
		}
	
	}

	public static void main(String[] args) 
	{
		HFCManager m = new HFCManager();
		m.start();
	}
}

package g;

import base.BaseMain;

public class G6 extends BaseMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int order[] = {0,0,0}; int sale;
		int total_sale;
		// 입력받는 구매 제품 개수 리스트 [가죽장갑, 털장갑, 비닐장갑] // 계산한 판매금액
		int total_order[] = {0,0,0};
		int price[] = {10000, 6000, 3000}; int i;
	printline("세 종류의 제품이 있습니다.\n(1. 가죽장갑 1만원, 2. 털장갑 6천원, 3.비닐장갑 3천원)\n");
	sale=total_sale=0;
	for(i=0;i<order.length;i++){
		total_order[i]+=(order[i]=getInput().readInt((i+1)+"번 제품은 몇개를 구입하실래요? "));
sale+=order[i];
	}
	while(sale>0){
		sale=0;
		for(i=0;i<order.length;i++){
			sale+=price[i]*order[i];
		}
	printline("판매금액은 "+sale+"원 입니다.");
		sale=0;
		for(i=0;i<order.length;i++){
			total_order[i]+=(order[i]=getInput().readInt((i+1)+"번 제품은 몇개를 구입하실래요? "));
	sale+=order[i];
		}
	}
	for(i=0;i<order.length;i++){
		total_sale+=total_order[i]*price[i];
	}
	printline("지금까지의 총 매출금액은 "+total_sale+"원 입니다.");
	}

}

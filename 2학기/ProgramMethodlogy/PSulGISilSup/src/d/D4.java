package d;

public class D4 extends base.BaseMain{
public static void main(String...strings){
	int count_all=getInput().readInt("How many people in family? ");
	int count_young=0; int birth_year; int age;
	int i;
	for( i =0;i<count_all;i++){
		if((age = 2015-(birth_year=getInput().readInt("birth year?")))<20){
			count_young+=1;
		}
	}
	printline(String.format("가족들 중에 미성년자는 모두 %d명입니다.",count_young));

}
}

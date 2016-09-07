package e;

public class E3 extends base.BaseMain{
public static void main(String...strings){
	int height=getInput().readInt("height? "),i, j;
	for(i = 1;i<=height;i++){
		for(j=i;j<=height-1;j++){
			print(" ");
		}
		for(j=1;j<=2*i-1;j++){
			print("*");
		}
		print("\n");
	}
}
}

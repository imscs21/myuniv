#include <stdio.h>
#include <stdlib.h>    /* for atof() */
#include "calc.h"

#define MAXOP   100    /* max size of operand or operator */

/* reverse Polish calculator */
int main(int argc, char* argv[]) {
	int type;
	double op2;
	char s[MAXOP];
	for(int i =1;i<argc;i++){
		if(argv[i]==NULL){
			break;
		}
		int tmp = type = argv[i][0];
		if('0'<=type&&type<='9'){
			type = NUMBER;
			tmp = tmp-'0';
		}
		switch (type) {
			case NUMBER: 
			    push(tmp); 
			    break;
			case '+': 
			case '*': 
			case '-':
			case '/':
				push2(type);
			    break;
		
			default:
			    printf("error: unknown command1 %s\n", s);
			    break;
		}
	}
	int resp;
	while((resp=(int)pop2())){
		switch(resp){
			case '+': 
			    push(pop() + pop()); 
			    break;
			case '*': 
			    push(pop() * pop()); 
			    break;
			case '-':
			    op2 = pop();
			    push(pop() - op2);
			    break;
			case '/':
			    op2 = pop();
			    if (op2 != 0.0)
			    	push(pop() / op2);
			    else
			    	printf("error: zero divisor\n");
			    break;
				default:printf("error: unknown command %c\n", resp);
			    break;
		}
	}
	printf("\t%.8g\n", pop());
	/*while ((type = getop(s)) != EOF) {
		switch (type) {
			case NUMBER: 
			    push(atof(s)); 
			    break;
			case '+': 
			    push(pop() + pop()); 
			    break;
			case '*': 
			    push(pop() * pop()); 
			    break;
			case '-':
			    op2 = pop();
			    push(pop() - op2);
			    break;
			case '/':
			    op2 = pop();
			    if (op2 != 0.0)
			    	push(pop() / op2);
			    else
			    	printf("error: zero divisor\n");
			    break;
			case '\n':
			    printf("\t%.8g\n", pop());
			    break;
			default:
			    printf("error: unknown command %s\n", s);
			    break;
		}
	}*/
	return 0;
}

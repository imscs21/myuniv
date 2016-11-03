#include <stdio.h>
#include "calc.h"
#define MAXVAL   100    /* maximum depth of val stack */

static int sp = 0;             /* next free stack position */
static double val[MAXVAL];     /* value stack */

/* push: push f onto value stack */
void push(double f) {
	if (sp < MAXVAL)
		val[sp++] = f;
	else
		printf("error: stack full, can't push %g\n", f);
}
void top(){
    if(sp>0){
        printf("top: %g\n",val[sp-1]);
    }else{
        printf("error: not enough stack, can't load %g\n");
    }
}
void duplicate(void){
    if(sp>0){
        val[sp] = val[sp-1];
        sp++;
    }else{
         printf("error: not enough stack, can't load %g\n");
    }
}
void swap(){
    if(sp>1){
        double a = val[--sp];
        double b = val[--sp];
        val[sp++] = a;
        val[sp++] = b;
    }
    else{
        printf("error: enough stack, can't swap %g\n");
    }
}
/* pop: pop and return top value from stack */
double pop(void) {
	if (sp >0)
		return val[--sp];
	else {
		printf("error: stack empty\n");
		return 0.0;
	}
}
int main(){
    push(5);
    duplicate();
    top();
    push(4);
    push(5);
    top();
    swap();
    top();
    for(int i =0 ;i <sp;i++){
        printf("%g ", val[i]);
    }
    printf("\n");
    return 0;
}
#include <stdio.h>


/* print Fahrenheit-Celsius table */
int main() {
    char a,v=0;
    while((a=(char)getchar())!=EOF){
        if(a==' '&&!v){
            putchar(a);
            v=1;
        }
        else if(!(a==' '&&v)){
            v=0;
            putchar(a);
        }
    }
}
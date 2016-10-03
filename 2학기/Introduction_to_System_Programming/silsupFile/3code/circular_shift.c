#include <stdio.h>
void debug(unsigned short v){
unsigned short a = v;
int isZero = 0;
while(a){
 
    unsigned short condi = a&((unsigned short)~0<<15);
if((condi)>0){
printf("1 ");
}
else{
printf("0 ");
}
a<<=1;

}
printf("\n");
}

unsigned short  circular_shift(unsigned  short x, int n){
    debug(x);
    unsigned short rst =x; //x<<3;
    for(int i =0;i<n;i++){
        rst = (rst>>15) | (rst<<1);
    }
    debug(rst);
return rst;
}
int main(){
    unsigned short a ;//= 21555;
scanf("%hu",&a);
printf("%d\n",circular_shift(a,3));
    return 0;
}
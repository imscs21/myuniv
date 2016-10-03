/* getbits: get n bits from position p */
#include <stdio.h>
unsigned getbits(unsigned x, int p, int n) {
    return (x >> (p+1-n)) & ~(~0 << n);
}
unsigned binToVal(char* d){
    unsigned rst = 0;
    for(int i=0;d[i];i++){
        rst <<=1;
        rst |= (unsigned)(d[i]-'0');
    }
    return rst;
}
void debug(unsigned short v,int len){
    unsigned short a = v;
    for(int i=0;i<len;i++){
        
        unsigned short condo = a&((unsigned short)~0<<(len-1));
        if((condo)>0){
            printf("1 ");
        }
        else{
            printf("0 ");
        }
        a<<=1;
        
    }
    printf("\n");
}
void setbits(unsigned int x, int p, int n, unsigned y){
    x=((~(~0<<n))&y)<<(p-n+1)| (~((~(~0<<n))<<(p-n+1))&x);
    debug(x,sizeof(unsigned int)*sizeof(unsigned int));
    printf("%d\n",x);
    
}
int main(){
    unsigned int a = 5171;
     setbits(a,12,5 ,27);
    return 0;
}
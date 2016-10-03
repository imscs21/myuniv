/* getbits: get n bits from position p */
#include <stdio.h>


/*int invert(unsigned  int x,int p,int n){
    return (
              (
               ~(x>>(p-n+1) )<<(15-n+1) )
              
              >>(15-p+1)
             
             )
             
              | (x<<(15-(p-n)+1) )>>(15-(p-n+1));
}*/
void debug(unsigned short v,const int len){
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
unsigned binToVal(char* d){
    unsigned rst = 0;
    for(int i=0;d[i];i++){
        rst <<=1;
        rst |= (unsigned)(d[i]-'0');
    }
    return rst;
}
void  invert(unsigned  int* x,int p,int n){
    unsigned int tmp = (*x^((~(~0<<(p+1)))&(~0<<(p-n+1))));
    x=&tmp;
    debug(*x,sizeof(unsigned int)*sizeof(unsigned int));
    printf("%d\n",*x);
    
}

int main(){
    unsigned int a = binToVal("0001010000110011");//5171;
    printf("ori: %d\n",a);
    invert(&a,12,5);
    printf("%d\n",a);
    return 0;
}
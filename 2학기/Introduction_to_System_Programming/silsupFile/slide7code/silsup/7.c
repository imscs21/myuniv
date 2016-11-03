#include <stdio.h>
#include <stdlib.h>
#define LEN 4
void debug(int* val){
for(int i=0;i<2*LEN;i++){
printf("%d ",*(val++));
}
printf("\n");
}
void merge(int *x, int *y, int *z){
    int a,i,b;
    for(int i =b=a=0;i<2*LEN;i++){
        if(*x<*y&&a<LEN){
            *(z++) = *(x++);
            a++;
        }
        else if(b<LEN){
            *(z++) = *(y++);
            b++;
        }
        else{
            *(z++) = *(x++);
            a++;
        }
    }
  
}

int main() {
    int xx[] = {3,7,11,13,0};
    int* x = xx;
    int yy[] = {2,5,6,9};
    int* y = yy;

    int* z= (int*)malloc(sizeof(int)*30);
       merge(x,y,z);
       
    //debug(x);
  //  debug(y);
debug(z);
printf("finish\n");
}

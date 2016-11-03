#include <stdio.h>
void time(int t, int *h, int *m, int *s){
    *h = t/(60*60);
    *m = (t/60)%60;
    *s =t%60;
}
     int main() {
         int h,m,s;
         time(3723,&h,&m,&s);
         printf("%d:%d:%d\n",h,m,s);
}

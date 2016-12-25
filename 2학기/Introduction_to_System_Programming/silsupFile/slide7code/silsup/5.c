#include <stdio.h>

int palindrome(char * val, int len){
    for(int i=0;i<len/2;val++,i++,len--){
        while(val[len-1-i]==' '){
            i++;
        }
        while(*val==' '){
            val++;
            len--;
        }
        
        if(*val!=val[len-1-i]){
            return 0;
        }
        
      
    }
    return 1;
}
int strlen2(char *s) { /* same as char s[] */
int n;
    for (n = 0; *s != '\0'; s++)
        n++;
return n; }
     int main() {
        
         char* ds[] ={"C","civic","kayak","madam","racecar","radar","rotator","step on no pets","no lemon no melon","mar q ii m ar",NULL};
    for(int i=0;ds[i];i++){
        printf("%d\n",palindrome(ds[i],strlen2(ds[i])));
    }
        
         /* while(*ds!=NULL){
        
printf("%d\n",palindrome(*ds,strlen(*ds)));
ds++;
        }*/
}

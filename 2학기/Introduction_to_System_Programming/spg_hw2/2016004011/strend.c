#include <stdio.h>

/* strend: return 1 if the string t occurs at the end of the string s,
           0 otherwise */
int strend(char *s, char *t) {
   int len = 0,srclen=0;
    while(*s!=0){
       s++;
        srclen++;
   }
   while(*t!=0){
       len++;
       t++;
   }
    if(srclen>=len){
        while((len--)>=0){
            if(*(t--)!=*(s--)){
                return 0;
            }
        }
        return 1;
    }
    else{
        return 0;
    }
}

int main() {
    printf("%d\n", strend("RICA", "ERICA"));
    printf("%d\n", strend("HanyangERICA", "ERICA"));
    printf("%d\n", strend("HanyangERICAERICA", "ERICA"));
    printf("%d\n", strend("HanyangERICAnsan", "ERICA"));
    printf("%d\n", strend("Hanyang", "ERICA"));
}

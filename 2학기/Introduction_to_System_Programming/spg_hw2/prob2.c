#include <stdio.h>

char *strncopy(char *s, char *t, int n);
char *strncat(char *s, char *t, int n);
int strncmp(char *s, char *t, int n);
int main(){
   char d[300] =  "abcd";
char *d1 = d;
    printf("%s\n",strncopy(d1,"efgh",2));
    char* tmp2 = strncopy(d1,"abcdefg",8);
    *(tmp2+3)=0;
    printf("init spec: ");
    for(int i =0;i<30;i++,tmp2++){
        printf("%c(%d)",*tmp2,*tmp2);
    }
    printf("\n");
    char* tmp = strncopy(d1,"123456",5);
    printf("spec: %s\n",tmp);
    printf("spec2: ");
    for(int i =0;i<30;i++,tmp++){
        printf("%c(%d)",*tmp,*tmp);
    }
    printf("\n");
    
    strncopy(d1,"abcd",4);
    printf("%s\n",strncat(d1,"efgh",2));
    strncopy(d1,"abcd",4);
    printf("%d\n",strncmp("abcd","efgh",2));
return 0;
}


char *strncopy(char *s, char *t, int n){
    const char* offset = s;
    while((n--)>0&&(*(s++)=*(t++))!=0);
    return offset;
}
char *strncat(char *s, char *t, int n){
    const char* offset = s;
    while(*(s)!=0){s++;}
    while((n--)>0&&(*(s++)=*(t++))!=0);
    return offset;
}
int strncmp(char *s, char *t, int n){
  for ( ; n>0&&*s == *t; s++, t++,n--)
        if (*s == '\0')
           return 0;
    return *s - *t;
}

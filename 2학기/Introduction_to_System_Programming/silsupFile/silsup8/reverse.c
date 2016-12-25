#include <stdio.h>
#include <string.h>

/* reverse: reverse string s in place */
void reverse(char s[]) {
  int c, i, j;

  for (i = 0, j = strlen(s)-1; i < j; i++, j--) {
    c = s[i];
    s[i] = s[j];
    s[j] = c;
  }
}

void myreverse(char *s){
  int len = 0;
  while(*s!=0){
    len++;
    s++;
  }
  for(int i = 0;i<len/2;i++){
    const char tmp = *(s-(len-i-1));
    *(s-(len-i-1))=*(s-i);
    *(s-i) = tmp;
  }
}
int main(void){
  char s[100] = "HANYANG";
  reverse(s);
  printf("%s\n", s); // GNAYNAH
}
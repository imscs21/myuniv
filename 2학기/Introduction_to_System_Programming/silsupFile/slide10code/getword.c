#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define BUFSIZE 1000

char buf[BUFSIZE];
int bufp = 0;

int getch();
void ungetch(int c);

int getword(char *word, int lim){
  int c;
  char *w = word;

  while(isspace(c = getch()));

  if(c != EOF) *w++ = c;

  if(!isalpha(c)){
    *w = '\0';
    return c;
  }
  for(;--lim > 0; w++){
    if(!isalnum(*w = getch())){
      if(*w=="’"||*w=="'"){
      while(!isspace(*w)){
        printf("log: %c\n",*w);
        w++;
      }
    }
    ungetch(*w);
       break;
    }
    
  }
  *w = '\0';
  return word[0];
}

int getch(void){
  return (bufp > 0)?buf[--bufp]:getchar();
}
void ungetch(int c){
  if(bufp > BUFSIZE)
    printf("ungetch: too many characters\n");
  else
    buf[bufp++] = c;
  return;
}
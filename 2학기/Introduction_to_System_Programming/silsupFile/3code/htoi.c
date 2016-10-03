#include <stdio.h>

int htoi(char s[]){
int rst =0;
for(int i=0;s[i];i++){
int val=0;
if('0'<=s[i]&&s[i]<='9'){
val =s[i]-'0';
}
else if('a'<=s[i]&&s[i]<='f'){
val = 10+s[i] - 'a';
}
else if('A'<=s[i]&&s[i]<='F'){
val = 10+s[i]-'A';
}
rst = (rst*16+val);
}
return rst;
}
int main(){
char d[30]={0,};
scanf("%s",d);
printf("%d\n",htoi(d));

return 0;
}
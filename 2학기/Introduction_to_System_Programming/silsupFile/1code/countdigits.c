#include <stdio.h>
int main(){
int d[12]={0,};
char c;
while((c = getchar())!=EOF){
if(c>='0' && c<='9'){
d[c-'0']++;
}
else if(c=='\n'||c==' '||c=='\t'){
    d[10]++;
}
else{
    d[11]++;
}
}
for(int i=0;i<sizeof(d)/sizeof(int);i++){
    if(i>=0 && i<=9){
printf("%d ",i);

    }
    else if(i==10){
printf("w ");

    }
    else if(i==11){
printf("o ");
    }
    for(int j=0;j<d[i];j++){
    printf("*");
}
printf("\n");
}
    return 0;
}
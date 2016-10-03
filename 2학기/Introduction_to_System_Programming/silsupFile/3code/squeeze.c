/* squeeze: delete all c from s */
#include <stdio.h>
void squeeze(char s[], char c[]) {
	int i, j;
for (i = j = 0; s[i] != '\0'; i++){
        for(int k=0;c[k];k++){
            if(c[k]==s[i]){
                for(int j=i;s[j-1];j++){
                    s[j]=s[j+1];
                }
                
            }
        }
    }
 
}


int main(){
    char u[10]= "hanyang", v[5]="ng";
   // u = "hanyang";
    //v = "ng";
    squeeze(u,v);
    printf("%s %s\n",u,v);
	return 0;
}
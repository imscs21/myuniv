#include <stdio.h>

void escape(char s[], char t[]) {
    int i, j;

    for (i = j = 0; t[i] != '\0'; i++,j++){
        switch (t[i]) {
            case '\n':{
                s[j]='\\';
                s[++j]='n';
                break;
            }
                /* fill me in */
            case '\t':{
                s[j]='\\';
                s[++j]='t';
                break;
            }
                /* fill me in */
            default:{
                s[j]=t[i];
                break;
            }
                /* fill me in */
        
        }
    //j++;
    }
    s[j]=0;
    /* fill me in */    
}

int main() {
    char u[10] = "ERI\tCA\nHY";
    char v[10];
    printf("Before:\n%s\n", u);
    escape(v, u);
    printf("After:\n%s\n", v);
}
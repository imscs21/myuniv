#include <stdio.h>

void expand(char s[], char t[]) {
    /* fill me in */
    int start = s[0]-'0';
    int end = s[2]-'0';
    if(s[0]=='-'&&s[1]==0){//-
        start = 0;
        end = 9;
    }
    else if(s[0]=='-'&&  '0'<=s[1]&&s[1]<='9'){//-1
        start = 0;
        end = s[1]-'0';
    }
    else if('0'<=s[0]&&s[0]<='9' && s[1]=='-' && s[2]==0){//1-
        start=s[0]-'0';
        end=9;
    }
    else if('0'<=s[0]&&s[0]<='9'&&s[1]=='-' &&'0'<=s[2]&&s[2]<='9'){//1-2
        start = s[0]-'0';
         end = s[2]-'0';
    }
    else{//stand alone
        start=s[0]-'0';
        end = start;
    }
    
    int i=0;
    for( i =start;i<=end;i++){
        t[i-start]=i+'0';
    }
    t[i-start]=0;
}

int main() {
    char u0[10] = "-";
    char u1[10] = "-3";
    char u2[10] = "4-";
    char u3[10] = "5";
    char v[10];
    printf("Before: %s\n", u0);
    expand(u0, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u1);
    expand(u1, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u2);
    expand(u2, v);
    printf("After: %s\n", v);
    printf("Before: %s\n", u3);
    expand(u3, v);
    printf("After: %s\n", v);
}
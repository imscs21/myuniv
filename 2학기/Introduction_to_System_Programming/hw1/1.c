#include <stdio.h>

int any(char s[], char t[]);

int main(void){
	char u1[10] = "Hanyang";
	char u2[10] = "Ansan";
	char u3[10] = "ERICA";
	printf("%d\n", any(u1,u2));		// 1
	printf("%d\n", any(u2,u3));		// 0
	printf("%d\n", any(u3,u1));		// -1
	printf("%d\n", any(u2,u1));		// 1
	printf("%d\n", any(u3,u2));		// 4
	printf("%d\n", any(u1,u3));		// -1
}

int any(char s[], char t[]){
	int i,j;

	for (i = 0; s[i] != '\0'; ++i){
		for(j=0; t[j] != '\0'; ++j){
			if(s[i] == t[j]) return i;
		}
	}
	return -1;
}
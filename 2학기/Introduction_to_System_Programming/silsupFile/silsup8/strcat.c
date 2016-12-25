#include <stdio.h>

/* strcat: concatenate t to end of s;
           s must be big enough to hold the two */
void mystrcat(char s[], char t[]) {
    int i, j;

    i = j = 0;
    while (s[i] != '\0') /* find end of s */
        i++;
    while ((s[i++] = t[j++]) != '\0') /* copy t */
        ;
}

int main() {
	char x[100] = "Hanyang";
	mystrcat(x, "ERICA");
	printf("%s\n", x);
}
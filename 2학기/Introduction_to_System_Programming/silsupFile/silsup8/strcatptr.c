#include <stdio.h>

/* strcat: concatenate t to end of s;
           s must be big enough to hold the two */
void mystrcat(char *s, char *t) {
    while (*s != '\0'){s++;} /* find end of s */
    while ((*(s++) = *(t++)) != '\0'); /* copy t */
}

int main() {
    char x[100] = "Hanyang";
    mystrcat(x, "ERICA");
    printf("%s\n", x);
}

#include <stdio.h>
#define MAXLINE 10  /* maximum input line size */

int max;                 /* maximum length seen so far */
char line[MAXLINE];      /* current input line */
char longest[MAXLINE];   /* longest line saved here */

int readline(void);
void copy(void);

/* print longest input line; specialized version */
int main() {
    int len;

	max = 0;
	while ((len = readline()) > 0)
		if (len > max) {
			max = len;
			copy();
		}
	if (max > 0)  /* there was a line */
		printf("%s", longest);
	return 0;
}

/* readline: specialized version */
int readline(void) {
	int c, i;
	
	for (i = 0; i < MAXLINE - 1 && (c = getchar()) != EOF && c != '\n'; ++i)
		line[i] = c;
	if (c == '\n') {
		line[i] = c;
		++i;
	}
	line[i] = '\0';
	return i;
}

/* copy: specialized version */
void copy(void) {
	int i;
	
	i = 0;
	while ((longest[i] = line[i]) != '\0')
		++i;
}

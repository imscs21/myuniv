#include <stdio.h>

#define MAXLINE 100

/* rudimentary calculator */
int main() {
	double sum, atof(char []);
	char line[MAXLINE];
	int readline(char line[], int max);

	sum = 0;
	while (readline(line, MAXLINE) > 0)
		printf("\t%g\n", sum += atof(line));
	return 0;
}
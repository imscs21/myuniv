#include <stdio.h>
#define MAXLINE 1000 /* maximum input line length */

int readline(char line[], int max);
int strindex(char source[], char searchfor[]);

char pattern[] ="thing"; //"ould"; /* pattern to search for */

/* find all lines matching pattern */
int main() {
	char line[MAXLINE];
	int found = 0;

    while (readline(line, MAXLINE) > 0){
        int idx = strindex(line, pattern);
		if (strindex(line, pattern) >= 0) {
			printf("%s, %d", line,idx);
			found++;
		}
    }
	return found;
}
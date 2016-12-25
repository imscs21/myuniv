#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#define MAXLINES 5000

char *lineptr[MAXLINES];

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);

void Qsort(char *lineptr[], int left, int right);

int main() {
	int nlines;

	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		Qsort(lineptr, 0, nlines-1);
		writelines(lineptr, nlines);
		
	}
	else {
		printf("error: input too big to sort\n");
	}
    return 0;
}


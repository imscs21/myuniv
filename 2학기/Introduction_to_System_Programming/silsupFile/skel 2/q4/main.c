#include <stdio.h>
#include <string.h>

#define MAXLINES 5000  /* max #lines to be sorted */

char *lineptr[MAXLINES];  /* pointers to text lines */

int readlines(char *lineptr[], int nlines);
void writelines(char *lineptr[], int nlines);

void qsort(char *lineptr[], int order,int left, int right,
	       int (*comp)(char *, char *));
int numcmp(char *, char *);
int stricmp( char *,  char *);
/* sort input lines */
int main(int argc, char *argv[]) {
	int nlines;       /* number of input lines read */
	int numeric = 0;  /* 1 if numeric sort */
	char options[2][2]={"-f","-r"};
	int order = 1;
	int strictChar = 1;
	if (argc > 1 && strcmp(argv[1], "-n") == 0)
		numeric = 1;
	for(int i =0;i<2;i++){

	}
	if ((nlines = readlines(lineptr, MAXLINES)) >= 0) {
		qsort(lineptr,order, 0, nlines-1, numeric ? numcmp : strictChar? strcmp:stricmp);
		writelines(lineptr, nlines);
		return 0;
	}
	else {
		printf("input too big to sort\n");
		return 1;
	}
}
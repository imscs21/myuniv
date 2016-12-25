#include <stdio.h>
#include <ctype.h>

#define MAXLINE 100

/* myatof: convert string s to double */
double myatof(char* s) {
	double val, power,tmppower = 1;
	int i, sign;

    while(isspace(*s)){
        s++;
    }
	sign = (*s == '-') ? -1 : 1;
	if (*s == '+' || *s == '-')
		s++;
	for (val = 0.0; isdigit(*s); s++)
		val = 10.0 * val + (*s - '0');
	if (*s == '.')
		s++;
	for (power = 1.0; isdigit(*s); s++) {
		val = 10.0 * val + (*s - '0');
		power *= 10.0;
	}
    if(*s=='e'||*s=='E'){
        int unit =  (int)myatof(++s);
        
        if(unit<0){
            while(unit!=0){
                unit++;
                tmppower/=10.0f;
            }
            
        }
        else{
            while(unit!=0){
                unit--;
                tmppower*=10.0f;
            }
        }
    }
	return sign * val*tmppower / power;
}

/* readline: read line into s, return length */
int readline(char* s, int lim) {
    int c, i;
    
    i = 0;
    while (--lim > 0 && (c = getchar()) != EOF && c != '\n')
        *(s+i++) = c;
    if (c == '\n')
        *(s+i++) = c;
    *(s+i) = '\0';
    return i;
}
/*int readline(char s[], int lim) {
	int c, i;

	i = 0;
	while (--lim > 0 && (c = getchar()) != EOF && c != '\n')
		s[i++] = c;
	if (c == '\n')
		s[i++] = c;
	s[i] = '\0';
	return i;
}
*/
/* rudimentary calculator */
int main() {
	double sum;
	char line[MAXLINE];
	int readline(char line[], int max);

	sum = 0;
	while (readline(line, MAXLINE) > 0)
		printf("\t%g\n", sum += myatof(line));
	return 0;
}

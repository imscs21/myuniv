#include <ctype.h>

/* atof: convert string s to double */
double atof(char s[]) {
	double val, power;
	int i, sign;

	for (i = 0; isspace(s[i]); i++)
		;
	sign = (s[i] == '-') ? -1 : 1;
	if (s[i] == '+' || s[i] == '-')
		i++;
	for (val = 0.0; isdigit(s[i]); i++)
		val = 10.0 * val + (s[i] - '0');
	if (s[i] == '.')
		i++;
	for (power = 1.0; isdigit(s[i]); i++) {
		val = 10.0 * val + (s[i] - '0');
		power *= 10.0;
	}
	return sign * val / power;
}
int stricmp(const char *s1, const char *s2)
{
    for ( ; 1; s1++, s2++){
		char t1 = *s1;
		char t2 = *s2;
		if((('a'<=t1&&t1<='z')|| ('A'<=t1&&t1<='Z')) &&
		 (('a'<=t2&&t2<='z')|| ('A'<=t2&&t2<='Z')) ){
			 if(t1<t2){
				 t1+='a'-'A';
			 }else{
				 t2+='a'-'A';
			 }
		}
		if(t1!= t2){
			break;
		}
		if (t1 == '\0')
	    	return 0;
	}
    return ((*(unsigned char *)s1 < *(unsigned char *)s2) ? -1 : +1);
}
/* numcmp: compare s1 and s2 numerically */
int numcmp(char *s1, char *s2) {
	double v1, v2;

	v1 = atof(s1);
	v2 = atof(s2);
	if (v1 < v2)
		return -1;
	else if (v1 > v2)
		return 1;
	else
		return 0;
}

/* swap: interchange v[i] and v[j] */
void swap(char *v[], int i, int j) {
	char *temp;

	temp = v[i];
	v[i] = v[j];
	v[j] = temp;
}

/* qsort: sort v[left]...v[right] into increasing order */
void qsort(char *v[], int order,int left, int right,
	       int (*comp)(char *, char *)) {
	int i, pivot;

	if (left >= right)
		return;
	swap(v, left, (left + right)/2);
	pivot = left;
	for (i = left+1; i <= right; i++){
		if(order){
			int compRst = (*comp)(v[i], v[left]);
			
			if (compRst < 0){
				swap(v, ++pivot, i);
			}
		}
		else{
			
			const int compRst = (*comp)(v[i], v[left]);
			if(compRst > 0 ){
					swap(v, ++pivot, i);
			}
		}
		
		
	}
	swap(v, left, pivot);
	qsort(v, order,left, pivot-1, comp);
	qsort(v, order,pivot+1, right, comp);
}
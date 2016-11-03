#include <stdio.h>
#include <ctype.h>

/* atof: convert string s to double */
double atof(char s[]) {
	double val, power,tmppower=1;
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
    if(s[i]=='e'||s[i]=='E'){
        int unit =  (int)atof(s+i+1);
       
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


int main() {
	/*char s[10] = "-3.14";
	printf("%g\n", 2 * atof(s));
    */
     char s[15] = "123.45e-6";
    char s2[15] = "123.45E-6";
    printf("val: %g\n",atof(s));
    printf("val: %g\n",atof(s2));
}

#include <stdio.h>

int double_sum_for(int n) {
	int sum = 0, i;
    int offset = n>=0? n:2*n;
    int end = n>=0? 2*n:n;
    for(int i =offset;i<=end;i++){
        sum += i;
    }
	/* fill me */
	return sum;
}

int double_sum_while(int n) {
	int sum = 0,i = n;
    int offset = n>=0? n:2*n;
    int end = n>=0? 2*n:n;
    i=offset;
    while(i<=end){
        sum  += i;
        i++;
    }
	/* fill me */
	return sum;
}

int main() {
	printf("%d\n", double_sum_for(0)); /* 0 */
	printf("%d\n", double_sum_for(1)); /* 3 */
	printf("%d\n", double_sum_for(3)); /* 18 */
	printf("%d\n", double_sum_for(-3)); /* -18 */
	printf("%d\n", double_sum_while(0)); /* 0 */
	printf("%d\n", double_sum_while(1)); /* 3 */
	printf("%d\n", double_sum_while(3)); /* 18 */
	printf("%d\n", double_sum_while(-3)); /* -18 */
}
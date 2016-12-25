#include <stdio.h>

int double_sum_for(int n) {
	int sum = 0, i;
	/*
		양수의 경우와 음수의 경우 두가지로 나누어서 for를 사용합니다.
	*/
	if (n >= 0)
		for (i = n; i <= 2*n; i++)
			// 양수의 경우 n ~ 2*n 까지 더합니다.
			sum += i;
	else
		for (i = n; i >= 2*n; i--)
			// 음수의 경우 n ~ -2*n 까지 더합니다.
			sum += i;
	return sum;
}

int double_sum_while(int n) {
	int sum = 0; i = n;

/*
	for 구문을 while로 바꾸는 방법

	-----
	for(초기화;종료조건;마지막에 실행할 구문) {
		내용 ...
	}
	-----
	초기화
	while(종료조건) {
		내용 ...
		마지막에 실행할 구문
	}

	for(A;B;C) {
		D;
	}

	A
	while(B){
		D;
		C;
	}

 */

	if (n >= 0)
		while (i <= 2*n) {
			sum += i;
			i++;
		}
	else
		while (i >= 2*n) {
			sum += i;
			i--;
		}
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
#include <stdio.h>

void odd_even_sum(int n, int sums[]) {
    int cnt,i,j,odd=0,even=0;
    for (cnt = 0, i = 1, j = 2; cnt < n; ++cnt, i += 2, j += 2)
        odd += i, even += j;
    sums[1]=odd;
    sums[0] = even;
	/* fill me */
}

int main() {
	int sums[2] = {0, 0};

	odd_even_sum(0, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 0 0 */
	odd_even_sum(1, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 1 2 */
	odd_even_sum(2, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 4 6 */
	odd_even_sum(3, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 9 12 */
	odd_even_sum(4, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 16 20 */
	odd_even_sum(5, sums);
	printf("Odd = %d Even = %d\n", sums[1], sums[0]); /* 25 30 */


}
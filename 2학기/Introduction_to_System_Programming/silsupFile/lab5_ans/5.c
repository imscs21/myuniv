#include <stdio.h>


// version 1
void odd_even_sum(int n, int sums[]) {
	int cnt, i, j, odd = 0, even = 0;

	for (cnt = 0, i = 1, j = 2; cnt < n; ++cnt, i += 2, j += 2)
		odd += i, even += j;
	sums[1] = odd, sums[0] = even;

	/*   혹은

	int cnt, i, j;
	sums[0] = 0;
	sums[1] = 0;

	for (cnt = 0, i = 1, j = 2; cnt < n; ++cnt, i += 2, j += 2)
		sums[1] += i, sums[0] += j;
	*/
}

// version 2
void odd_even_sum(int n, int sums[]) {
	int i;

	for (i = 0; i < n; ++i)
		odd += i*2+1, even += (j+1)*2;
	sums[1] = odd, sums[0] = even;
}

// version 3
void odd_even_sum(int n, int sums[]) {
	int i = 0;

	while(i < n) {
		odd += i*2+1;
		even += (j+1)*2;
		++i;
	}
	sums[1] = odd, sums[0] = even;
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
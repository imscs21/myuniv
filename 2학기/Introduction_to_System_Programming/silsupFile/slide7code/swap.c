#include <stdio.h>

void noswap(int x, int y) {
	int temp;

	temp = x;
	x = y;
	y = temp;
}

void swap(int *px, int *py) {
	int temp;

	temp = *px;
	*px = *py;
	*py = temp;
}

int main() {
	int a = 3, b = 7;

	printf("      Before: a = %d, b = %d\n", a, b);
	noswap(a, b);
	printf("After noswap: a = %d, b = %d\n", a, b);
	swap(&a, &b);
	printf("  After swap: a = %d, b = %d\n", a, b);
}
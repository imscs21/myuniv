#include <stdio.h>

void print_bin(unsigned x);
unsigned circular_shift(unsigned x, int n);

int main(void){
	unsigned x = 25;
	print_bin(x);
	print_bin(circular_shift(x,30));
	return 0;
}

void print_bin(unsigned x){
	const int SIZE = sizeof(x) * 8;
	printf("decimal : %u\n", x);
	printf("binary : ");
	for(int i = 0; i < SIZE; ++i)
		printf("%c", (x>>(SIZE-i-1)&1) + 48);
	printf("\n");
}

unsigned circular_shift(unsigned x, int n){
	const int SIZE = sizeof(x) * 8;
	int mod_n = n%SIZE;
	int gap = SIZE - mod_n;
	return (x & ~(~0<<mod_n) << gap) >> gap | (x << mod_n);
}
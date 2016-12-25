#include <stdio.h>
#include <math.h>

void print_bin(unsigned x);
void print_oct(unsigned x);
void print_hex(unsigned x);

int main(void){
	unsigned x = 25;
	print_bin(x);
	print_oct(x);
	print_hex(x);
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

void print_oct(unsigned x){
	const int SIZE = sizeof(x) * 8;
	int i;
	char buffer[SIZE-3];
	for(i=0;x>0; x /= 8)
		buffer[i++] = x % 8 + 48;
	buffer[i] = '\0';
	printf("decimal : %u\n", x);
	printf("octal : ");
	for(i -= 1;i >= 0;--i) printf("%c", buffer[i]);
	printf("\n");
}

void print_hex(unsigned x){
	const int SIZE = sizeof(x) * 8;
	int i;
	char buffer[SIZE-3];
	for(i=0;x>0; x /= 16)
		buffer[i++] = x % 16 + ((x % 16 < 10)?'0':('A'-10));
	buffer[i] = '\0';
	printf("decimal : %u\n", x);
	printf("hex : ");
	for(i -= 1;i >= 0;--i) printf("%c", buffer[i]);
	printf("\n");
}

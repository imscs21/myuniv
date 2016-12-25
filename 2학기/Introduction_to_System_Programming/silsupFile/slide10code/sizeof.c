#include <stdio.h>

int main() {
	printf("char = %lu\n", sizeof(char));
	printf("short = %lu\n", sizeof(short));
	printf("int = %lu\n", sizeof(int));
	printf("long = %lu\n", sizeof(long));
	printf("float = %lu\n", sizeof(float));
	printf("double = %lu\n", sizeof(double));
	printf("char* = %lu\n", sizeof(char*));
	printf("int* = %lu\n", sizeof(int*));

	struct point {
		int x;
		int y;
	};

	printf("struct point = %lu\n", sizeof(struct point));

    int x;
    int a[10];
    struct key {
		char *word;
        int count;
    } keytab[100];

	printf("x = %lu\n", sizeof(x));
	printf("a = %lu\n", sizeof(a));
	printf("struct key = %lu\n", sizeof(struct key));
	printf("keytab = %lu\n", sizeof(keytab));

	printf("size_t = %lu\n", sizeof(size_t));

}
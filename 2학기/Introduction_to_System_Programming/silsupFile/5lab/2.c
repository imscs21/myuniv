#include <stdio.h>

int main() {
    int a = 0, b = 0,x;
    x = 0 && (a = b = 777);
    printf("%d %d %d\n", a, b, x);
    x = 0 || (a =777);
    printf("%d %d %d\n", a, b, x);

}
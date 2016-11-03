#include <stdio.h>
int main() {
    char *pc = NULL;
    int *pi = NULL;
    double *pd = NULL;
    printf("char = %lu byte\n", (unsigned long) (pc + 1));
    printf("int = %lu byte\n", (unsigned long) (pi + 1));
    printf("double = %lu byte\n", (unsigned long) (pd + 1));
}

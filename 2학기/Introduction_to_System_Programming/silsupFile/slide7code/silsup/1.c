#include <stdio.h>
     int main() {
         int i = 4, z=6,j = 7;
         int *p = &i, *q = &j;
         int *r = &j;
         printf("*p + 7 = %d\n", *p + 7);
         printf("3 * **&p + 1 = %d\n", 3 * **&p + 1);
         printf("p = %p\n", p); /* 1 */
         printf("q = %p\n", q); /* 1 */
         printf("r = %p\n", r); /* 1 */
         printf("p - q = %d\n", p - r); /* 2 */
         printf("p - 2 = %p\n", p - 2); /* 3 */
         printf("p - (p - 2) = %d\n", p - (p - 2)); /* 4 */
}

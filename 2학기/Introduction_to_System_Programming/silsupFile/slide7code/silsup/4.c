 #include <stdio.h>
     int main() {
         char *p = "xyz";
         char *q = "xyz";
         char r[] = "xyz";
         if (p == q)
             printf("p and q have the same address!\n");
         else
             printf("p and q have different addresses!\n");
         if (p == r)
             printf("p and r have the same address!\n");
         else
             printf("p and r have different addresses!\n");
}

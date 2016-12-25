#include <stdio.h>

int main() {
	int i = 7, j = 7;

  /*
    dangling-else


    if (A) if (B) else (C) 일때
    
    if (A) { if (B) else (C) } 혹은
    if (A) {} if (B) } else (C) 로 애매한 해석을 할 수 있기떄문에 Warning을 내어준다.

    

   */

	if (i == 1)
		if (j == 2)
			printf("%d\n", i = i + j);
	else
		printf("%d\n", i = i - j);
	printf("%d\n", i);
}
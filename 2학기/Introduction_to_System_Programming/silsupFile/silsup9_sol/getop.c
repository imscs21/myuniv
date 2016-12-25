#include <stdio.h>
#include <ctype.h>
#include "calc.h"

/* getop: get next operator or numeric operand */
int getop(char s[]) {
	int i, c;

	if (!isdigit(s[0]) && s[0] != '.'){
    // 두자리 이상 연산자 추가 예외처리 필요
    return s[0];      /* not a number */
  }
  //숫자 형식(정수, 실수)가 아닌경우 예외처리 필요 (UNDEFINED)

	return NUMBER;
}
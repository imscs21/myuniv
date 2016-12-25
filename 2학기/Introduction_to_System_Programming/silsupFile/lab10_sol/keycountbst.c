/* 해야 할 문제
 * Q1.     기존의 keycountbst.c에서 오류 해결
 * Q2.     기존의 문자열 순으로 정렬된 트리를 수정 및 변경하는 것이 아니라 새로 빈도수로 정렬된 트리를 만든다.
 * Q2-1.   문자열 순으로 정렬하여 노드를 생성하는 addtree 함수를 활용하여 빈도수 순으로 정렬되는 노드를 만든다.
 * Q2-2.   기존의 트리에서 하나씩 값을 가져와 빈도수 트리에 넣는 함수를 만든다.
 * Q3.     문자 필터링: getword.c를 수정하여 문자 필터링이 가능토록 변경
 * Q3-1.   기존의 getword는 [']가 등장하면 앞뒤를 단어로 구분한다.
 *         문자 중간이나 뒤에 나오는 [']를 단어에 포함하도록 수정한다.
 * Q3-2.   일반 명사 소유격의 경우 일반 형으로 변형한다. (ex. else's -> else, others' -> other)
 * Q3-3.   [a, the ,this, is, was, ... etc]을 필터링한다.
 * Q3-3-1. 필터링할 단어들을 정의한다.
 * Q3-3-2. 얻은 단어가 필터링 단어에 해당하는지 탐색하는 함수를 만든다.
 * Q3-3-3. 추가적으로 한글자로 이루어진 단어는 무의미하므로 제거한다.  
 * Q4.     출력하는 부분에서 단어가 두번 이상 나온 단어만 출력한다.
 */

#include <stdio.h>
#include <ctype.h>
#include <string.h>

#define MAXWORD 100

struct tnode {
	char *word;
	int count;
	struct tnode *left;
	struct tnode *right;
}; // Q1: 구조체의 정의 후 뒤에 ';'을 붙여야 한다.

struct tnode *addtree(struct tnode *, char *);
struct tnode *addfreqtree(struct tnode *p, char *w, int count);
struct tnode *createtreefromtree(struct tnode *oldt, struct tnode *freqt);
void treeprint(struct tnode *);
int getword(char *, int);

/* word frequency count */
int main() {
	struct tnode *root, *freqroot;
	char word[MAXWORD];

	root = NULL;
	freqroot = NULL; // 새로운 트리를 위한 뿌리 노드를 만들어야 한다.
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word);
	freqroot = createtreefromtree(root, freqroot);
	// treeprint(root);
	treeprint(freqroot);
	return 0;
}

struct tnode *talloc(void);
/* Q1
 * string.h 안에 strdup 함수가 있다.
 * 이를 해결하기 위해서는 '#include <string.h>'를 제거하거나 함수를 바꿔야 한다.
 * 여기서 string.h 안에 있는 다른 함수를 사용해야 하므로 함수명을 변경해야 한다.
 */
char *mystrdup(char *);

/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w) {
	int cond;

	if (p == NULL) {
		p = talloc();
		p->word = mystrdup(w);
		p->count = 1;
		p->left = p->right = NULL;
	}
	else if ((cond = strcmp(w, p->word)) == 0)
		p->count++;
	else if (cond <0)
		p->left = addtree(p->left, w);
	else
		p->right = addtree(p->right, w);
	return p;
}

/* Q2, Q2-1
 * 기존의 노드에서 문자열 w와 빈도수 count를 받아 새로운 노드를 생성한다.
 * 뿌리 노드부터해서 재귀적으로 노드를 생성할 위치를 찾는데,
 * 비교하는 노드보다 빈도수가 높으면 왼쪽에, 같거나 낮으면 오른쪽에 노드를 생성한다.
 * 비어있는 노드에 도착하면(p == NULL), 새로운 노드를 생성한다.
 * 
 * - w와 count를 받는 것 대신 기존 노드 자체를 인자로 넘겨 받아도 됩니다.
 * - 함수 원형을 만드는 것을 잊지 않도록 합니다.
 */
struct tnode *addfreqtree(struct tnode *p, char *w, int count) {
	if(count>1){
	if (p == NULL) {
		p = talloc();
		p->word = mystrdup(w);
		p->count = count;
		p->left = p->right = NULL;
	}
	else if (count > p->count) // 비교하는 노드의 빈도수(p->count)보다 생성할 노드의 빈도수가 더 크다면 왼쪽에 생성한다.
		p->left = addfreqtree(p->left, w, count);
	else
		p->right = addfreqtree(p->right, w, count);
	}
	return p;
}

/* Q2, Q2-2
 * 기존의 트리를 탐색하면서
 * 노드의 데이터를 이용햐 트리를 생성하는 함수를 호출한다.
 *
 * - 함수 원형을 만드는 것을 잊지 않도록 합니다.
 */
struct tnode *createtreefromtree(struct tnode *oldt, struct tnode *freqt){
	if (oldt != NULL){
		freqt = createtreefromtree(oldt->left, freqt);
		freqt = addfreqtree(freqt, oldt->word, oldt->count);
		freqt = createtreefromtree(oldt->right, freqt);
	}
	return freqt;
}

/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p) {
	if (p != NULL) {
		treeprint(p->left);
		/* Q4
		 * 단어가 2번 이상 나온 경우,
		 * 즉 count가 1보다 큰 경우에만 출력하도록 조건문을 붙인다.
		 */
		if(p->count > 1)
			printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}

#include <stdlib.h>

/* talloc: make a tnode */
struct tnode *talloc(void) {
	return (struct tnode *) malloc(sizeof(struct tnode));
}

/* Q1
 * string.h 안에 strdup 함수가 있다.
 * 이를 해결하기 위해서는 '#include <string.h>'를 제거하거나 함수를 바꿔야 한다.
 * 여기서 string.h 안에 있는 다른 함수를 사용해야 하므로 함수명을 변경해야 한다.
 */
/* mystrdup: make a duplicate of s */
char *mystrdup(char *s) {
	char *p;

	p = (char *) malloc(strlen(s)+1); /* +1 for '\0' */
	if (p != NULL)
		strcpy(p, s);
	return p;
}
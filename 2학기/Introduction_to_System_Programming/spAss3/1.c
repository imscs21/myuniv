

#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define MAXWORD 100
#define MAXKEYLIST 20000
struct tnode {
	char *word;
	int count;
	struct tnode *left;
	struct tnode *right;
}; // Q1: 구조체의 정의 후 뒤에 ';'을 붙여야 한다.
char *mystrdup(char *);
struct tnode *addtree(struct tnode *, char *);
struct tnode *addfreqtree(struct tnode *p, char *w, int count);
struct tnode *createtreefromtree(struct tnode *oldt, struct tnode *freqt);
void treeprint(struct tnode *);
void treeprint2(struct tnode *);
int getword(char *, int);
void inorder_traversal(struct tnode *p, char *key[]);
/* word frequency count */
int main() {
	struct tnode *root, *freqroot;
	char word[MAXWORD];
	char *key[MAXKEYLIST]={NULL,};
	root = NULL;
	freqroot = NULL; // 새로운 트리를 위한 뿌리 노드를 만들어야 한다.
	while (getword(word, MAXWORD) != EOF)
		if (isalpha(word[0]))
			root = addtree(root, word);
	freqroot = createtreefromtree(root, freqroot);
	 treeprint(root);
     printf("==END::raw tree==\n");
	treeprint2(freqroot);
    printf("==END::freq tree==\n");
	inorder_traversal(root,key);
	int ti=0;
	while(key[ti]!=NULL){
        //if(ti<10){
		//root=reducetree(root,key[ti++]);
        //}
		printf("key%d:  %s\n",ti,key[ti++]);
	}
	printf("end key list\n");
	//treeprint(root);
	printf("finish print\n");
	return 0;
}

struct tnode *talloc(void);

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


struct tnode *addfreqtree(struct tnode *p, char *w, int count) {

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
	return p;
}

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
		
		if(p->count > 0)
			printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}
void treeprint2(struct tnode *p) {
	if (p != NULL) {
		treeprint(p->left);
		
		if(p->count > 1)
			printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}
void inorder_traversal(struct tnode *p, char *key[]){
	if(p!=NULL){
		inorder_traversal(p->left,key);
		int index;
        if(p->count>0){
            char* tmp_std =mystrdup( p->word);
	        for (index = 0;
		        key[index]!=NULL&& index < MAXKEYLIST ;
		        index++) {
		            if(strcmp(key[index],p->word)>0) {
			            char* tmp =key[index];
			            key[index] = tmp_std;
			            tmp_std = tmp;
		            }
	            }
	        key[index]=tmp_std;
        }
		inorder_traversal(p->right,key);
	}
}


#include <stdlib.h>

/* talloc: make a tnode */
struct tnode *talloc(void) {
	return (struct tnode *) malloc(sizeof(struct tnode));
}

char *mystrdup(char *s) {
	char *p;

	p = (char *) malloc(strlen(s)+1); /* +1 for '\0' */
	if (p != NULL)
		strcpy(p, s);
	return p;
}

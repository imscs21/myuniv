#include <stdio.h>
#include <ctype.h>
#include <string.h>
#include <stdlib.h>
#define MAXWORD 100

struct tnode {
	char *word;
	int count;
	struct tnode *left;
	struct tnode *right;
};
char* ignore[] = {"a", "the", "is","be","are", "was", "are", "were", "have", "had", "they", "you", "your", "it", 
"don","Don", "of", "in", "with", "that", "which","by","so","else","and","if","on","to","as","an","for","he","not",NULL};

struct tnode *addtree(struct tnode *, char *);
struct tnode *addtree2(struct tnode *, struct tnode *);
struct tnode *addtree3(struct tnode *, struct tnode *);
void treeprint(struct tnode *);
int getword(char *, int);

/* word frequency count */
int main(int argc,char* argv[]) {
	struct tnode *root,*maxNode=NULL,*tmp1=NULL;
	char word[MAXWORD];
	root = NULL;
	while (getword(word, MAXWORD) != EOF){
		char tmpword[MAXWORD];
			strcpy(tmpword,word);
			if('A'<=tmpword[0]&&tmpword[0]<='Z'){
				tmpword[0] += 'a'-'A';
			}
			int isIgnored = 0;
		for(int i =0;ignore[i]!=NULL;i++){
			if(!strcmp(tmpword,ignore[i])||strlen(tmpword)<2){
				isIgnored=1;
				break;
			}
		}
		if (isalpha(word[0])&&!isIgnored){
			printf("find '%s'\n",tmpword);
			root = addtree(root, word);
		}
		
	}
	printf("t print\n");
	treeprint(root);

	printf("start\n");
	
	tmp1 = addtree3(tmp1,root);
	
	printf("pass\n");
	
	treeprint(tmp1);
	//}
	return 0;
}

struct tnode *talloc(void);
char *strdup2(char *);
/* addtree: add a node with w, at or below p */
struct tnode *addtree(struct tnode *p, char *w) {
	int cond;

	if (p == NULL) {
		p = talloc();
		p->word = strdup2(w);
		p->count = 1;
		p->left = p->right = NULL;
	}
	else if ((cond = strcmp(w, p->word)) == 0){
		p->count++;
		
	}
	else if (cond <0){
		
		p->left = addtree(p->left, w);
	}
	else{
		p->right = addtree(p->right, w);
	}
	return p;
}

struct tnode *addtree2(struct tnode *p,struct tnode *root) {
	if (p == NULL&&root!=NULL){//&&root->count>1) {
		p = talloc();
		p->word = strdup2(root->word);
		p->count = root->count;
		p->left= p->right = NULL;
	}
 else if(root!=NULL && root->count>1){
	 printf("wrd: %s\n",root->word);
		if (root->count > p->count)
				p->left = addtree2(p->left,root);
		else
			p->right = addtree2(p->right,root);
	}
	
	return p;
}
struct tnode *addtree3(struct tnode *p, struct tnode *p2) {
	p=addtree2(p,p2);
 if (p2 != NULL) {
		addtree3(p,p2->left);
		addtree3(p,p2->right);
		//printf("%4d %s\n", p->count, p->word);		
	}
	
	return p;
}
/* treeprint: in-order print of tree p */
void treeprint(struct tnode *p) {
	if (p != NULL) {
		treeprint(p->left);
		printf("%4d %s\n", p->count, p->word);
		treeprint(p->right);
	}
}


/* talloc: make a tnode */
struct tnode *talloc(void) {
	return (struct tnode *) malloc(sizeof(struct tnode));
}

/* strdup: make a duplicate of s */

char *strdup2(char *s) {
	char *p;

	p = (char *) malloc(strlen(s)+1); /* +1 for '\0' */
	if (p != NULL)
		strcpy(p, s);
	return p;
}











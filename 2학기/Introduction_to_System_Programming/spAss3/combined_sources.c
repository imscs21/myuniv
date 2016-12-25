

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
struct tnode *reducetree(struct tnode *p, char *w);
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
		root=reducetree(root,key[ti++]);
        //}
		//printf("%s\n",key[ti++]);
	}
	//printf("end key list\n");
	treeprint(root);
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
struct tnode* findParentOfLastNode(struct tnode *,struct tnode *);
struct tnode *findLastNode(struct tnode *,int);
struct tnode *findLastNodeOrOneChildNode(struct tnode *,int );
struct tnode *reducetree(struct tnode *p, char *w){
    if(p!=NULL){
        p->left=reducetree(p->left,w);
        if(!strcmp(p->word,w)){
            p->count-=1;
        }
        if(!p->count){
            struct tnode* emptyChild = findLastNodeOrOneChildNode(p,0);//트리 끝에 존재하는 리프노드(자식 노드가 없는)나 자식이 하나인 노드를 찿음
            struct tnode* parentOfemptyChild = findParentOfLastNode(p,emptyChild);//이중 포인터로 부모와 자식을 한꺼번에 가져오려 했으나 마지막 최종리턴때 2번째 배열이 가리키는게 0xffffffff여서, 가져오기를 실패해 따로 따로 가져오게됨
            struct tnode* tleft = p->left;//현재 탐색중인 노드의 왼쪽자식의 포인터를 임시저장
            struct tnode* tright = p->right;//현재 탐색중인 노드의 오른쪽자식의 포인터를 임시저장
            
            
            if(p==parentOfemptyChild){//3개의 노드로 이루어진 경우를 대비
                if(parentOfemptyChild->left==emptyChild){
                    tleft=p->left=NULL;//마지막 리프노드는 트리의 상위로 올라갈 것이므로 연결만 끊음
                    if(emptyChild!=NULL){
                        if(emptyChild->left!=NULL){
                            emptyChild->right=tright;
                        }
                        else {//if(emptyChild->right!=NULL){
                            emptyChild->left=tright;
                        }
                        
                        
                    }
                }
                else if(parentOfemptyChild->right==emptyChild){
                    tright=p->right=NULL;//마지막 리프노드는 트리의 상위로 올라갈 것이므로 연결만 끊음
                    if(emptyChild!=NULL){
                        if(emptyChild->left!=NULL){
                            emptyChild->right=tleft;
                        }
                        else{ //if(emptyChild->right!=NULL){
                            emptyChild->left=tleft;
                        }
                        
                    }
                }
                if(emptyChild!=NULL){
                    free((void*)p);
                    p=emptyChild;
                }
                else{
                    free((void*)p);
                    return NULL;//마지막 노드가 없으면 노드강제 제거
                }
            }
            else if(emptyChild!=NULL){
                if(parentOfemptyChild!=NULL&&parentOfemptyChild->left==emptyChild){
                    if(emptyChild->left!=NULL){
                        parentOfemptyChild->left=emptyChild->left;
                    }
                    else if(emptyChild->right!=NULL){
                        parentOfemptyChild->left=emptyChild->right;
                    }
                    else{
                        parentOfemptyChild->left=NULL;//마지막 리프노드는 트리의 상위로 올라갈 것이므로 연결만 끊음
                        
                    }
                }
                else if(parentOfemptyChild!=NULL&&parentOfemptyChild->right==emptyChild){
                    if(emptyChild->left!=NULL){
                        parentOfemptyChild->right=emptyChild->left;
                    }
                    else if(emptyChild->right!=NULL){
                        parentOfemptyChild->right=emptyChild->right;
                    }
                    else{
                        parentOfemptyChild->right=NULL;//마지막 리프노드는 트리의 상위로 올라갈 것이므로 연결만 끊음
                    }
                }
                free((void*)p);
                
                emptyChild->left=tleft;
                emptyChild->right=tright;
                
                p=emptyChild;
            }
            else{
                free((void*)p);
                return NULL;//마지막 노드가 없으면 노드강제 제거
                
            }
        }
        p->right=reducetree(p->right,w);
        
    }
    return p;
}
struct tnode* findParentOfLastNode(struct tnode *tre,struct tnode *lstn){//마지막 노드의 부모를 찿는 함수지만 알고리즘 적으로 시간낭비다
    struct tnode* tmp = NULL;
    if(lstn==NULL){
        return NULL;
    }
    if(tre!=NULL&&tre!=lstn){
        tmp = findParentOfLastNode(tre->left,lstn);
        if(tmp==NULL){
            if(tre->left==lstn||tre->right==lstn){//바로 밑 자식노드에 리프노드가 존재하면
                tmp = tre;
                return tmp;
            }
        }
        if(tmp==NULL){
            tmp = findParentOfLastNode(tre->right,lstn);
        }
    }
    return tmp;
    
}
struct tnode *findLastNode(struct tnode *p,int isBeforeReduceCount){//2번째 인자는 빈도를 줄인시점부터 함수를 호출했는지 이후에 호출해줬는지 명시해주는 bool값
    struct tnode *tmp = NULL;
    if(p!=NULL){
        tmp = findLastNode(p->left,isBeforeReduceCount);
        if(tmp==NULL){
            if(isBeforeReduceCount==1){
                if(p->count>1&&p->left==NULL&&p->right==NULL){
                    tmp = p;
                    return tmp;
                }
            }
            else{
                if(p->count>0&&p->left==NULL&&p->right==NULL){
                    tmp = p;
                    return tmp;
                }
            }
        }
        if(tmp==NULL){
            tmp = findLastNode(p->right,isBeforeReduceCount);
        }
    }
    return tmp;
}
struct tnode *findLastNodeOrOneChildNode(struct tnode *p,int isBeforeReduceCount){//2번째 인자는 빈도를 줄인시점부터 함수를 호출했는지 이후에 호출해줬는지 명시해주는 bool값
    struct tnode *tmp = NULL;
    if(p!=NULL){
        tmp = findLastNode(p->left,isBeforeReduceCount);
        if(tmp==NULL){
            if(isBeforeReduceCount==1){
                if(p->count>1&&((p->left==NULL&&p->right==NULL)||(p->left!=NULL&&p->right==NULL)||(p->left==NULL&&p->right!=NULL))){
                    tmp = p;
                    return tmp;
                }
            }
            else{
                if(p->count>0&&((p->left==NULL&&p->right==NULL)||(p->left!=NULL&&p->right==NULL)||(p->left==NULL&&p->right!=NULL))){
                    tmp = p;
                    return tmp;
                }
            }
        }
        if(tmp==NULL){
            tmp = findLastNode(p->right,isBeforeReduceCount);
        }
    }
    return tmp;
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

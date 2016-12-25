#include <stdio.h>
#include <string.h>
#include <ctype.h>
#define BUFSIZE 1000

/* Q3-3-1
 * 필터링할 단어들을 정의한다.
 * - 단순히 char *의 배열로 해도 무관하다.
 * - 빠른 탐색을 위해 알파벳 순서로 정렬한다.
 * - 비교를 위해 소문자로 입력한다.
 */
struct filter{
  char *word;
} filterword[] = {
  "a","aboard","about","above","across","after","against","all","along","although",
  "am","amid","among","an","and","another","anti","any","anybody","anyone",
  "anything","are","aren't","around","as","at","be","because","been","before",
  "behind","being","below","beneath","beside","besides","between","beyond","both","but",
  "by","can","can't","cannot","concerning","considering","could","couldn't","despite","did",
  "didn't","do","does","doesn't","don't","don’t","down","during","each","either","even","everybody","everyone","everything","except","excepting",
  "excluding","few","following","for","from","had","hadn't","has","hasn't","have",
  "haven't","he","her","hers","herself","him","himself","his","i","if",
  "in","inside","into","is","isn't","it","its","itself","lest","like",
  "many","may","mayn't","memine","might","mightn't","minus","more","most","much",
  "must","mustn't","my","myself","near","neither","nobody","none","noone","nor",
  "not","nothing","of","off","on","once","one","only","onto","opposite",
  "or","other","others","our","ours","ourselves","outside","over","past","per",
  "plus","regarding","round","save","several","shall","shan't","she","should","shouldn't",
  "since","so","some","somebody","someone","something","than","that","the","their",
  "theirs","them","themselves","these","they","this","those","though","through","till",
  "to","toward","towards","under","underneath","unless","unlike","until","up","upon","us","versus","via","was","wasn't","we","were",
  "weren't","what","whatever","when","whenever","where","wherever","which","whichever","while",
  "who","whoever","whom","whomever","whose","will","with","within","without","won't",
  "would","wouldn't","yet","you","your","yours","yourself","yourselves",
};

#define FKEYS (sizeof filterword / sizeof(struct filter))

char buf[BUFSIZE];
int bufp = 0;

int filtersearch(char *word, struct filter tab[], int n);
int getch();
void ungetch(int c);

int getword(char *word, int lim){
  /* Q3-3
   * 필터링 되는 경우 함수를 다시 호출해야 하기 때문에 lim 값을 보존하는 변수를 만든다.
   */
  int c, limorigin=lim;
  char *w = word;

  while(isspace(c = getch()));

  if(c != EOF) *w++ = c;

  if(!isalpha(c)){
    *w = '\0';
    return c;
  }
  for(;--lim > 0; w++){
    /* Q3-1
     * 이 부분에서 숫자나 영문자가 아니면 단어를 구분하는 행위를 한다.
     * 여기서 [']인  경우에는 단어를 구분하지 않고 반복문을 진행하도록 수행한다.
     * !isalnum(*w = getch()) 에서 받아온 w가 
     * *w != '\'' 에서 [']인 경우가 아니면서 숫자 및 알파벳이 아닌 경우에만 반복문을 빠져나가도록 한다.
     *
     * if(!isalnum(*w = getch())) -> if(!isalnum(*w = getch()) && *w != '\'')
     */
    if(!isalnum(*w = getch()) && *w != '\''){
      ungetch(*w);
      break;
    }
  }

  /* Q3-2
   * 소유격인 경우 해당 부분을 없애는 작업을 수행한다.
   * 1. 마지막으로 입력한 글자(w-1)가 [']이고 그 전 글자(w-2)가 [s]인 경우에는
   *    [...s']에 해당하는 복수형 소유격이므로 [...s]의 형태로 바꿔주기 위해 포인터를 1 감산한다.
   * 2. 마지막으로 입력한 글자(w-1)가 [s]이고 그 전 글자(w-2)가 [']인 경우에는
   *    [...'s]에 해당하는 단수형 소유격이므로 [...]의 형태로 바꿔주기 위해 포인터를 2 감산한다.
   */
  if(*(w-2) == 's' && *(w-1) == '\'') w = w-1;
  else if(*(w-2) == '\'' && *(w-1) == 's') w = w-2;

  *w = '\0';
  /* Q3-3
   * 얻은 단어가 필터링에 해당하는지 확인하여
   * 필터링해야 할 단어인 경우 getword 함수를 다시 호출한다.
   * 조건: filtersearch(word, filterword, FKEYS) >= 0
   *
   * Q3-4
   * 단어가 한글자로 되어있다면 필터링한다.
   * 조건: strlen(word) == 1
   */
  if(strlen(word) == 1 | filtersearch(word, filterword, FKEYS) >= 0) getword(word, limorigin);
  return word[0];
}

/* Q3-3-2
 * 필터링해야할 단어인지 확인한다.
 * - 탐색 알고리즘은 binary search로 갯수가 많은 필터링 단어를 효율적으로 탐색한다.
 * - 필터링하는 단어인 경우 위치번호를 반환한다.
 */
int filtersearch(char *word, struct filter tab[], int n){
  int cond;
  int low, high, mid;

  // 아래 두 줄의 코드는 탐색을 위해 단어를 소문자로 변경하는 코드이다.
  char *lwrword = strdup(word);
  for(char *lwrptr = lwrword; *lwrptr != '\0'; lwrptr++) *lwrptr=tolower(*lwrptr);

  low = 0;
  high = n - 1;
  while (low <= high) {
    mid = (low+high) / 2;
    if ((cond = strcmp(lwrword, tab[mid].word)) < 0)
      high = mid - 1;
    else if (cond > 0)
      low = mid + 1;
    else
      return mid;
  }
  return -1;
}

int getch(void){
  return (bufp > 0)?buf[--bufp]:getchar();
}
void ungetch(int c){
  if(bufp > BUFSIZE)
    printf("ungetch: too many characters\n");
  else
    buf[bufp++] = c;
  return;
}
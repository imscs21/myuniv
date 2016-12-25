#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define MAX_STUDENT 100
#define BUF 100

struct student {
	char *name;
	char *id;
	char grade;
};

struct student *read_student();
void add_student(struct student array[], struct student *std);
void print_student(struct student students[]);
float class_average(struct student students[]);

char *get_word();

int meetEOF = 0;

int main(void) {
	struct student students[MAX_STUDENT] = {{0}};
	struct student *std;

	while ((std = read_student()) != NULL) {
		add_student(students,std);
	}
	print_student(students);
    printf("print work\n");
	printf("\nClass AVG.:\t%f\n", class_average(students));
    printf("success print averge\n");
    
    return 0;
}

struct student *read_student() {
	struct student *std;
	char *name = get_word();
	char *id = get_word();
	char *grade = get_word();

	if(name == NULL || id == NULL || grade == NULL) return NULL;
    std =(struct student *)malloc(sizeof(*std));
        std->name=name;
        std->id=id;
        std->grade=*grade;
    
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	return std;
}

void add_student(struct student array[], struct student *std) {
    
	int inserted = 0;
	struct student tmp, swap;
	int index;
    index =inserted= 0;
    while(array[index].name!=NULL){
        printf("add work\n");
        if(std->grade!=array[inserted].grade){
            inserted++;
        }
        index++;
    }
    array[index++]=*std;
    
    for(int i =0;i<index;i++){
        for(int j =0;j<index;j++){
            if(array[i].grade<array[j].grade|| (array[i].grade==array[j].grade&&strcmp(array[i].name,array[j].name)<0)){
                swap = array[i];
                array[i]=array[j];
                array[j]=swap;
            }
        }
    }
    
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
}

void print_student(struct student students[]) {
	printf("%10s\t%10s\tGrade\n","Name","Student ID");
	for (int index=0; 
		 students[index].grade != 0 && index < MAX_STUDENT; 
		 ++index) {
		printf("%10s\t%10s\t%c\n", 
			   students[index].name, 
			   students[index].id, 
			   students[index].grade);
	}
}

float class_average(struct student students[]) {
	float avg;
	int sum = 0, count = 0;
    for(int i =0;students[i].name!=NULL;i++){
        int t;
        switch(students[i].grade){
            case 'A':
            case 'a':{
                t=4;
                break;
            }
            case 'B':
            case 'b':{
                t=3;
                break;
            }
            case 'C':
            case 'c':{
                t=2;
                break;
            }
            case 'D':
            case 'd':{
                t=1;
                break;
            }
            case 'F':
            case 'f':
            default:t=0;break;
        }
        sum+=t;
        count++;
    }
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/
	/* fill your code here*/

	return (count == 0) ? 0.0 : sum/count;;
}

char *get_word() {
	char *word = (char *) malloc(sizeof(char)*BUF);
	char c;
	int index;

	if (meetEOF) return NULL;

	while (isspace(c = getchar())) ;

	for (index=0; index < BUF; ++index) {
		if (c == EOF) {
			meetEOF = 1;
			break;
      // free(word);
      // return NULL;
		}
		if (isalnum(c))
			word[index] = c;
		else
			break;
		c = getchar();
	}
	word[index] = '\0';
	return word;
}

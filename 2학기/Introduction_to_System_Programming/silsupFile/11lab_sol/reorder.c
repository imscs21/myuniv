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
	printf("\nClass AVG.:\t%f\n", class_average(students));
}

struct student *read_student() {
	struct student *std;
	char *name = get_word();
	char *id = get_word();
	char *grade = get_word();

	if(name == NULL || id == NULL || grade == NULL) return NULL;
	// student 구조체의 크기만큼 memory allocation을 한다.
	std = (struct student *)(malloc(sizeof(struct student)));
	std->name = name;
	std->id = id;
	std->grade = *grade;
	return std;
}

void add_student(struct student students[], struct student *std) {
	int inserted = 0;
	struct student tmp, swap;
	int index;

	for (index = 0;
		students[index].id != 0 && index < MAX_STUDENT ;
		index++) {
		// students[index].grade  VS (*std).grade
		// 1.	students[index]보다 (*std).grade가 작은가 ?
		// 		+ 성적이 같다면, 이름의 내림차 순으로.
		if(students[index].grade > (*std).grade
			|| (students[index].grade == (*std).grade
			&& strcmp(students[index].name, (*std).name) > 0
				)
			) {
		// 1.T	students[index]에 (*std)를 넣고,
		//		원래 students[index]에 있는 struct를 std에 넣는다.
			tmp = students[index];
			students[index] = *std;
			*std = tmp;
		}
		// 1.F 	다음으로 넘어간다.
	}
	// 2.	for가 끝날때까지 들어갈 자리가 없었다면(insertion이 없다면)
	//  	마지막자리(index)에 *std를 넣는다.
	students[index] = *std;
}

void print_student(struct student students[]) {
	printf("%10s\t%10s\tGrade\n","Name","Student ID");
	for (int index=0; 
		 students[index].id != 0 && index < MAX_STUDENT; 
		 ++index) {
		printf("%10s\t%10s\t%c\n", 
			   students[index].name, 
			   students[index].id, 
			   students[index].grade);
	}
}

float class_average(struct student students[]) {
	float sum = 0;
	int count = 0;

	for (; 
	 students[count].id != 0 && count < MAX_STUDENT; 
	 ++count) {
	 	//  학점 A,B,C,D,F 를 4,3,2,1,0 으로
	 	switch (students[count].grade) {
	 		case 'A' :
	 			sum += 4; break;
	 		case 'B' :
	 			sum += 3; break;
	 		case 'C' :
	 			sum += 2; break;
	 		case 'D' :
	 			sum += 1; break;
	 	}
	}
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
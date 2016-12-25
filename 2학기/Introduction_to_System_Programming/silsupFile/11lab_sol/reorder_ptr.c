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
void add_student(struct student *students[], struct student *std);
void print_student(struct student *students[]);
float class_average(struct student *students[]);

char *get_word();


int main(void) {
	struct student *students[MAX_STUDENT];
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
	std = (struct student *)malloc(sizeof(struct student));
	std->name = name;
	std->id = id;
	std->grade = *grade;
	return std;
}

void add_student(struct student *students[], struct student *std) {
	int inserted = 0;
	struct student *tmp, *swap = NULL, **index;
	

	index = students;
	while ( *index != NULL ){
		if (swap != NULL) {
			tmp = *index;
			*index = swap;
			swap = tmp;
		}
		else if ( (**index).grade > (*std).grade
			|| ((**index).grade == (*std).grade 
			&& strcmp((**index).name, (*std).name) > 0)) {
			swap = *index;
			*index = std;
		}
		index++;
	}
	*index = swap != NULL ? swap : std;

}

void print_student(struct student *students[]) {
	struct student **index;
	index = students;

	printf("%10s\t%10s\tGrade\n","Name","Student ID");
	while ( *index != NULL ){
		printf("%10s\t%10s\t%c\n", 
			   (**index).name, 
			   (**index).id, 
			   (**index).grade);
		index++;
	}
}

float class_average(struct student *students[]) {
	float avg;
	int sum = 0,count = 0;
	struct student **index;
	index = students;

	while ( *index != NULL ){
		switch ((**index).grade) {
			case 'A':
			    sum += 4;
			    count++;
			    break;
			case 'B':
			    sum += 3;
			    count++;
			    break;
			case 'C':
			    sum += 2;
			    count++;
			    break;
			case 'D':
			    sum += 1;
			    count++;
			    break;
			case 'F':
			    sum += 0;
			    count++;
			    break;
			default:
			    break;
		}
		index++;
	}
	if (count == 0) avg = 0.0;
	else avg = sum / count;

	return (count == 0) ? 0.0 : sum/count;;
}

char *get_word() {
	char *word = (char *) malloc(sizeof(char)*BUF);
	char c;
	int index;


	while (isspace(c = getchar())) ;

	for (index=0; index < BUF; ++index) {
		if (c == EOF) {
			free(word);
			return NULL;
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
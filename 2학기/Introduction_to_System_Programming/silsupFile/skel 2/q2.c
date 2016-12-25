#include <stdio.h>

static char daytab[2][13] = {
  {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31},
  {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}
};

/* day_of_year: set day of year from manth & day */
int day_of_year(int year, int month, int day) {
  int i, leap;

  leap = (year%4 == 0 && year%100 != 0) || year%400 == 0;
  for (i = 1; i < month; i++)
    day += daytab[leap][i];
  return day;
}

/* month_day: set month, day from day of year */
void month_day(int year, int yearday, int *pmonth, int *pday) {
  int i, leap;
  char ** dt = daytab;
  dt+=(leap = (year%4 == 0 && year%100 != 0) || year%400 == 0);

  for (char* dt2=dt; yearday > *dt2; dt2++){
    yearday -= *(dt2);//daytab[leap][i];
  }
  *pmonth = i;
  *pday = yearday;
}

/* month_name: return name of n-th month */
char *month_name(int n) {
  static char *name[] = {
    "Illegal month",
    "January", "February", "March",
    "April", "May", "June",
    "July", "August", "September",
    "October", "November", "December"
  };

  return (n < 1 || n > 12) ? name[0] : name[n];
}

int main(void){
  int y, yd, m, d, *pm = &m, *pd = &d;
  printf("Day of Year\n");
  printf("%d.%d.%d:%d\n", 0,5,5,day_of_year(0,5,5));
  printf("%d.%d.%d:%d\n", 2015,12,31,day_of_year(2015,12,31));
  printf("%d.%d.%d:%d\n", 2016,11,17,day_of_year(2016,11,17));
  printf("%d.%d.%d:%d\n", 2016,12,31,day_of_year(2016,12,31));
  printf("+++++++++++\n");
  printf("Month Day\n");
  y = 0; yd = 126;month_day(y,yd,pm,pd);
  printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
  y = 2015; yd = 365;month_day(y,yd,pm,pd);
  printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
  y = 2016; yd = 322;month_day(y,yd,pm,pd);
  printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);
  y = 2016; yd = 366;month_day(y,yd,pm,pd);
  printf("%d of %d year:%d month %d day\n", y, yd, *pm, *pd);

  return 1;
}
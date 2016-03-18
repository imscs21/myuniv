import math;

hasFailSubject = False;
failSubjectCount=int(0);
failSubjectScore=float(0);
isExcludingFailScoreAndCount=False;

def ValueCheck(val):
    if(val<0 and val>100):
        print("유효성어긋");
        exit();
def score_average():
    print("Enter your scores. I will calculate your average score");
    count = int(0);
    global hasFailSubject;
    hasFailSubject = False;
    global isExcludingFailScoreAndCount;
    global failSubjectCount;
    global failSubjectScore;
    failSubjectCount=int(0);
    failSubjectScore=float(0);
    total = float(0);
    loopControl = True;
    average = float(0);
    in_msgs = ["score: ","score again: "];
    isParsingError = False;
    
    while loopControl:
        tempScoreStr = "";
        tempScore=0;
        
        try:
            tempScoreStr = input(in_msgs[isParsingError]);
            tempScore = float(tempScoreStr);
            isParsingError = False;
            if(tempScore<0 or tempScore > 100):
                isParsingError=True;
                continue;
                print("not continue");
            if(tempScore>0 and tempScore < 60):
                #print("added",isExcludingFailScoreAndCount,failSubjectCount,failSubjectScore);
                hasFailSubject=True;
                failSubjectCount+=1;
                failSubjectScore+=tempScore;
        except:
            isParsingError = True;
            continue;
            print("not continue");
    #ValueCheck(tempScore);
        if ( tempScore == 0):
            loopControl = False;
            break;
        else:
            total += float(tempScore);
        count+=1;
    #end while
    if (isExcludingFailScoreAndCount):
        total-=failSubjectScore;
        count-=failSubjectCount;
    if(count >0):
        
        average = total/float(count);
        average = round(average,1);
        print("Your average score of {0} subject(s) is {1}".format(count,average));
    #print("total: {0} , count: {1}".format(total,count));
    elif (count ==0):
        print("There is no score.");
        
        del tempScoreStr;
        del tempScore;
        del loopControl
    #end elif

def print_failsubject_count__if_exists():
    if(hasFailSubject):
        print("You failed in {0} subject(s).".format(failSubjectCount));
def score_average2():
    global isExcludingFailScoreAndCount;
    isExcludingFailScoreAndCount=True;
    score_average();
    print_failsubject_count__if_exists();
    isExcludingFailScoreAndCount=False;
#end define functions

score_average2();

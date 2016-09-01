def callagain:

def call():
#입력
    print("섭씨-화씨 온도변환기");
    print("섭씨온도를 알고 있으면 C를");
    print("화씨 온도를 알고 있으면 F를 입력해 주세요");
    unit = input("F/C: ");
    while (not (unit == "C" or unit == "c" or unit == "F" or unit == "f")):
        unit = input("F/C: ");
    isCallAgainable = False;
    if(unit == "C" or unit == "c"):
        print("섭씨를 화씨로 변환해드립니다");
        temp = input("섭씨온도를 정수로 입력해주세요");
        while not (temp.isdigit() or temp[0] == '-' and temp[1:].isdigit()):
            temp = input("섭씨온도를 정수로 입력해주세요");
        
        temp = int(temp);
        print("섭씨",temp,"도는 화씨로",round((temp*(9/5.0)+32),0),"입니다");
        isCallAgainable = not isCallAgainable;
        break;
        
     elif(unit == "F" or unit == "f"):
        print("화씨를 섭씨로 변환해드립니다");
        temp = input("화씨온도를 정수로 입력해주세요");
        while not (temp.isdigit() or temp[0] == '-' and temp[1:].isdigit()):
            temp = input("화씨온도를 정수로 입력해주세요"); 
        temp = int(temp);
        print(  "화씨",temp,"도는 섭씨로",((5*temp-160)/9.0),"입니다");
        
        break;
        #unit = input("F/C: ");
    if(isCallAgainable):
        callagain();
    else:
        print("안녕히가세요");
def callagain():
    respons = input("더하실래요?(예/아니오) ");
    isNeedToCallAgain = False;
    while not(respons == "예" or respons =="아니오"):
        if(respons == "예"):
            isNeedToCallAgain = True;
            break;
        elif(respons =="아니오"):
            break;
        respons = input("더하실래요?(예/아니오) ");
        
    if(isNeedToCallAgain):
        call();
call();
#계산및 출력


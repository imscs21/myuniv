#입력
print("섭씨-화씨 온도변환기");
print("섭씨온도를 알고 있으면 C를");
print("화씨 온도를 알고 있으면 F를 입력해 주세요");
unit = input("F/C: ");
while (not (unit == "C" or unit == "c" or unit == "F" or unit == "f")):
if(unit == "C" or unit == "c"):
    print("섭씨를 화씨로 변환해드립니다");
    temp = input("섭씨온도를 정수로 입력해주세요");
    while not temp.isdigit():
        temp = input("섭씨온도를 정수로 입력해주세요");
        
    temp = int(temp);
    print("섭씨",temp,"도는 화씨로",round((temp*(9/5.0)+32),0),"입니다");
    
elif(unit == "F" or unit == "f"):
    print("화씨를 섭씨로 변환해드립니다");
    temp = input("화씨온도를 정수로 입력해주세요");
    while not temp.isdigit():
        temp = input("화씨온도를 정수로 입력해주세요"); 
    temp = int(temp);
    print(  "화씨",temp,"",((5*temp-160)/9.0);
    
print("안녕히가세요");
#계산및 출력


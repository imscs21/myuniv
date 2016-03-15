# 대출 상환금 계산 서비스 
# 대출금 상환금액을 계산해주는 프로그램 
# 
# 입력: 원금(principal) - 백만이상 정수만 허용  
#       상환기간(years) - 1이상정수만 허용 
#       연이자율(interest rate) - 0.0에서 100.00 사이의 부동소수점수 만 허용 
# 출력: 연상환금액, 월상환금액, 상환금액의 총계 
# 
# 작성자: 황세현 
# 작성날짜: 2016년 3월 13일 (version 1.0) 
#헤더 로드
import math
import sys
print("대출 상환금 계산 서비스에 오신걸 환영합니다.") ;


# 입력과 입력확인 
p = int(input("대출원금이 얼마인가요? 백만원 이상만 계산해드립니다. "));
y = int(input("상환기간은 몇년인가요? "));
tempR = input("이자율은 몇%인가요? ");
percentageStr = "%";
if( tempR.endswith(percentageStr)): psIndex = tempR.index(percentageStr);tempR = tempR[:-1];
elif ( ("." not in tempR)): tempR = tempR[:2];

del percentageStr;

unit=["일원","십원","백원","천원","만원","십만원","백만원","천만원","억원","십억원","백억원"];
defaultNumbers=["일","이","삼","사","오","육","칠","팔","구","십","십일"];


r = float(tempR);
del tempR;
if ( r >=1): r /=100;
#if ( r<1): r *=100;  

 
def CheckVals1(): 
    if (p < int(pow(10,6)) ) :
        print("백만원 이상만 계산해드린다 하지 않았나요?");
        logData = "입력하신 값은 "+ defaultNumbers[int(str(p)[:1])-1]+unit[int(math.log10(p))]+"대 입니다";
        print(logData);
        del logData;
        sys.exit();
    elif (y<1):
        print("입력한 상환기간이 1년 미만이여서 조건에 불허해 계산할 수 없습니다");
        sys.exit();
    elif (r<0.0 and r>100.00):
        print("입력한 이자율이 0과 100사이가 아니여서 계산불가능 합니다");
        print(r);
        sys.exit();

def CheckVals2(): 
   logData = "백만원 이상만 계산해드린다 하지 않았나요?"+"\n"+"입력하신 값은 "+ defaultNumbers[int(str(p)[:1])-1]+unit[int(math.log10(p))]+"대 입니다";
   assert( p >= int(pow(10,6))),logData ;
   assert(y>=1),"입력한 상환기간이 1년 미만이여서 조건에 불허해 계산할 수 없습니다";
   assert(r>=0.0 and r<=100.00),"입력한 이자율이 0과 100사이가 아니여서 계산불가능 합니다";
       
CheckVals2();
# 상환금 계산 
def returnVal():
    valueResult = (((1+r)**y)*p*r)/(pow(1+r,y)-1);
    #valueResult /= ((1+r)**y)-1;
    return valueResult;
result = int(returnVal()); #math.floor(returnVal()); #연상환금액
def PrintResult(dy,dm,dt):
    print("대출 상환금 내역을 알려드리겠습니다");
    print("1년에 한번씩 상환하신다면 매년",int(dy),"원 씩 지불하셔야 합니다." );
    print("1달에 한번씩 상환하신다면 매월",int(dm),"원씩 지불하셔야 합니다");
    print("상환완료시까지 총 상환 금액은",dt,"원 입니다");
# 출력 
def valuelog():
    print(p,y,r,result);
#valuelog();
result *= y;
PrintResult(result/y,result/(y*12),result);
del p;
del y;
del r;
del result;

print("저희 서비스를 이용해주셔서 감사합니다.");
print("또 들려주세요.");


#!/bin/sh

if [ -z $1 ] 
then 
    echo "테스트를 실행할 파일을 입력해주세요.";
fi

echo "테스트 케이스를 선택해 주세요";
echo "\t1-1. grade0()"
echo "\t1-2. grade1()"
echo "\t2. median(a,b,c)"
echo "\t3-1. format_ok(f,m,b)";
echo "\t3-2. last_digit_ok(s)";
echo " 선택해주세요 : ";
read testcase;

if [ -f "./out.txt" ]
then rm out.txt;
fi


if [ -f "./ans.txt" ]
then rm ans.txt;
fi

input="";
answer="";
case $testcase in
    "1-1")
        input="101\n팔팔\n-.1\neight\nabc\n88\n"
        answer="백분위 점수: 백분위 점수: 백분위 점수: 백분위 점수: 백분위 점수: 백분위 점수: 학점: B\n1-가 프로그램 안녕";;
    "1-2")
        input="92\n예\n응\ny\n87\ny\n54\ny\n68\nn\n"
        answer="백분위 점수: 학점: A\n더할래?(y/n) 더할래?(y/n) 더할래?(y/n) 백분위 점수: 학점: B\n더할래?(y/n) 백분위 점수: 학점: F\n더할래?(y/n) 백분위 점수: 학점: D\n더할래?(y/n) 1-나 프로그램 안녕";;
    "2")
        echo "print('#','median(3,5,1)==3',median(3,5,1)==3)\nprint('#','median(3,3,3)==3',median(3,3,3)==3)\nprint('#','median(3,5,3)==3',median(3,5,3)==3);exit()" | python3 -i $1 | grep '#' > out.txt
        answer="# median(3,5,1)==3 True\n# median(3,3,3)==3 True\n# median(3,5,3)==3 True";;
    "3-1")
        echo "print('#','991111-1234567',format_ok('991111','-','1234567'))\nprint('#','901101+1234567',format_ok('901101','+','1234567'))\nprint('#','901101-123456',format_ok('901101','-','123456'));exit()" | python3 -i $1 > out.txt
        answer="# 991111-1234567 True\n# 901101+1234567 False\n# 901101-123456 False";;
    "3-2")
        echo "print('#','991111-1234567',last_digit_ok('9911111234567'))\nprint('#','121121-2234112',last_digit_ok('1211212234112'))\nprint('#','901101-1234564',last_digit_ok('9011011234564'));exit()" | python3 -i $1 > out.txt
        answer="# 991111-1234567 False\n# 121121-2234112 True\n# 901101-1234564 True";;
    *)
        echo "잘못 선택하셨습니다"
        break;;
esac

if [ -e "out.txt" ]
then echo "";
else
    echo "$input" | python3 $1 > out.txt;
fi
echo "$answer" > ans.txt;
df=`diff --ignore-case --ignore-all-space out.txt ans.txt`""
if [ -z "$df" ]
then echo "정답입니다 !";
else echo "다음과 같은 부분이 정답과 다릅니다.";
    echo "$df";
fi



if [ -f "./out.txt" ]
then rm out.txt;
fi


if [ -f "./ans.txt" ]
then rm ans.txt;
fi
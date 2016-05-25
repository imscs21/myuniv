print("시작파일은 blackjack.py입니다")
qust = "blackjack.py를 실행하시겠습니까?(y/n) "
ans = input(qust)
while(not(ans == "y" or ans == "n")):
    ans = input(qust)
if(ans=="y"):
    from subprocess import call
    call(["python3", "blackjack.py"])
import time

def counttime(count):
    remaincount = count
    while(remaincount>0):
        print(remaincount,"초 남았습니다")
        time.sleep(1)
        remaincount -= 1
counttime(10)
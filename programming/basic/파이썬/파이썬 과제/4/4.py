def remove_sign(val):
    return val.replace("-","");

def isfloat(s) : 
    (m,_,n) = s.partition(".") 
    return (m.isdigit() and (n.isdigit() or n == "")) or m == "" and n.isdigit() 


def get_fixed_signed(message) : 
    s = input(message);
    temps = s;
    s= remove_sign(s);
    while not (isfloat(s)):
        print(s[:]);
        print(isfloat(s));
        s = input(message);
       
        temps = s;
        s= remove_sign(s);
        
        if(isfloat(s)):
            break;
        
    return float(s);
    

def stop():
    cont = input('계속하시겠습니까? (y/n) ');     
    while not (cont == 'y' or cont == 'n'):         
        cont = input('계속하시겠습니까? (y/n) ');      
    return cont == 'n';
def safe_sqrt(): 
    import math;
    print("제곱근을 구해드립니다.");
    print("0이상의 수를 입력하세요.")
    while True: 
       
       # if(value.isnumeric()): continue;
        
        value = input("수를 입력하세요\n"); #get_fixed_signed("수를 입력하세요\n");
        if(not isfloat(value)):
            continue;
        isfloatvalue = isfloat(value);
        value = float(value);
        valuedasi = round(math.sqrt(value),4);
        loopControl0 = True;
        if(value == int(value)):
            value = int(value);
        print("{0} 의 제곱근은 {1} 입니다".format(value,valuedasi));
        
        iscontinue = stop();
        if(not iscontinue):
            continue;
        else:
            break;
    print("안녕히 가세요.");
safe_sqrt();
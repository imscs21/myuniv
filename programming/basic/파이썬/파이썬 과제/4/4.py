def remove_sign(val){
    return val.replace(val);
}
def get_fixed_signed(message) : 
    s = input(message);
    s= remove_sign(s);
    while not s.isdigit() and  
    s = input(message):
         
    return float(s);
def isfloat(s) : 
    (m,_,n) = s.partition(".");
    return m.isdigit() and (n.isdigit() or n == "") or  m == "" and n.isdigit();
     
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
        value= input();
        if(value.isnumeric()):
            continue;
        value = get_fixed_signed(value);
        valuedasi = math.sqrt(value);
        loopControl0 = True;
        print("{0} 의 제곱근은 {1} 입니다".format(value,valuedasi));
        loopControl1 = True;
        while loopControl1:
            vcheck = input("계속하시겠습니까?(y/n)");
            if(vcheck=="n"):
                loopControl1=False;
                loopControl0=False;
            elif(vcheck=="y"):
                loopControl0 = True;
                break;
            else:
                continue;
        if(loopControl0):
            continue;
        else:
            break;
    print("안녕히 가세요.");
safe_sqrt();
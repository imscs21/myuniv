class BankAccount:
    __name=""
    __balance=int(0)
    __no_of_accounts = int(0)
    no_of_accounts = int(0)
    def show_balance(self):
        print(self.__name+"`s balance is ",self.__balance ,"won")
    def deposit(amount):
        errmsg = "Deposit failed"
        succmsg = str(amount)+" won has been successfully deposited."
        if(type(amount) is str):
            if(amount.isdigit()):
                if(amount >= 0):
                    __balance += amount
                    print(succmsg)
                else:
                    print(errmsg)
            else:
                print(errmsg)
        else:
            if(amount >=0):
                __balance += amount
                print(succmsg)
            else:
                print(errmsg)
        del errmsg,succmsg
    
    def withdraw(amount):
        errmsg = "Withdraw failed"
        succmsg = str(amount)+" won has been successfully withdrawn."
        if(type(amount) is str):
            if(amount.isdigit()):
                if(amount >= 0 and amount <= balance):
                    __balance -= amount
                    print(succmsg)
                else:
                    print(errmsg)
            else:
                print(errmsg)
            
        else:
            if(amount >=0):
                __balance -= amount
                print(succmsg)
            else:
                print(errmsg)
        del errmsg,succmsg    
    def __init__(self,n,b=int(0)):
        self.__name = n
        errmsg = "balance value is invalid."
        if(type(b) is int):
            self.__balance = max(int(b),0)
        elif(type(b) is str):
            if(b.isdigit()):
                self.__balance =max( int(b),0)
               
        print("A bank account for",self.__name, "is open.")
        print("Your current balance is",self.__balance,"won")
        BankAccount.__no_of_accounts += 1
        BankAccount.no_of_accounts += 1
    def __str__(self):
        return self.__name+"'s BankAccount object"
    @staticmethod
    def count_accounts():
        return BankAccount.__no_of_accounts




ba1 = BankAccount("Yebbuni",100000)
print(ba1)
print(ba1.count_accounts())
ba2 = BankAccount("Monnani")
print(ba2)
print(ba2.count_accounts())
ba3 = BankAccount("Bbanjiri",-1000000)        
print(ba3 )
print(ba3.count_accounts())
        
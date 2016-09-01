class BankAccount:
    name=""
    balance=int(0)
    __no_of_accounts = int(0)
    no_of_accounts = int(0)
    def show_balance(self):
        print(self.name+"`s balance is ",self.balance ,"won")
    def deposit(amount):
        errmsg = "Deposit failed"
        succmsg = str(amount)+" won has been successfully deposited."
        if(type(amount) is str):
            if(amount.isdigit()):
                if(amount >= 0):
                    balance += amount
                    print(succmsg)
                else:
                    print(errmsg)
            else:
                print(errmsg)
        else:
            if(amount >=0):
                balance += amount
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
                    balance -= amount
                    print(succmsg)
                else:
                    print(errmsg)
            else:
                print(errmsg)
            
        else:
            if(amount >=0):
                balance -= amount
                print(succmsg)
            else:
                print(errmsg)
        del errmsg,succmsg    
    def __init__(self,n,b=int(0)):
        self.name = n
        errmsg = "balance value is invalid."
        if(type(b) is int):
            self.balance = max(int(b),0)
        elif(type(b) is str):
            if(b.isdigit()):
                self.balance =max( int(b),0)
               
        print("A bank account for",self.name, "is open.")
        print("Your current balance is",self.balance,"won")
        BankAccount.__no_of_accounts += 1
        BankAccount.no_of_accounts += 1
    def __str__(self):
        return self.name+"'s BankAccount object"
    @staticmethod
    def count_accounts():
        return BankAccount.__no_of_accounts

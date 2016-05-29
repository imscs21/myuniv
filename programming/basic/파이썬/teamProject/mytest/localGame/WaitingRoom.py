from tkinter import *
import tkinter.messagebox
import json
from StringData import *
    
class WaitingRoom(Frame):
    def  __init__(self,master,resp):
        super().__init__(master)
        self.__tk = master
        self.pack(pady=20)
        self.__totalPlayerCount = 0
        self.create_wdigets()
        self.__resp = resp
    def resizeWindowSize(self):
        width = 0
        height = 0
        width+= self.__lb1.winfo_reqwidth()
        height+= self.__lb1.winfo_reqheight()
        
        width+= self.__btn1.winfo_reqwidth()
        
        width+= self.__btn2.winfo_width()
        height+= self.__btn2.winfo_height()
        
        width+= self.__btn3.winfo_reqwidth()
        height+= self.__btn3.winfo_reqheight()
        
        width+= self.__lb1.winfo_width()
        height+= self.__lb1.winfo_height()
        
        width+= self.label_totalPlayerCount.winfo_reqwidth()
        height+= self.listbox_playerlist.winfo_reqheight()
        height+= self.entry_inputnewplayerName.winfo_reqheight()
        width+= int(width*0.5)
        height += int(height*0.3)
        print((width,height));
        self.__tk.geometry(str(width)+"x"+str(height))
        self.__tk.update()
        
    def destroy(self):
        size = self.listbox_playerlist.size()
        if(size>1):
            for i in range(size):
                self.__resp.append(self.listbox_playerlist.get(i))
            super().destroy()
        else:
            self.showDialogHadMinPlayer()
    def showDialogHadMinPlayer(self):
        tkinter.messagebox.showinfo("인원수 부족","도둑잡기는 최소 2명 이상 플레이 가능합니다")
    
    def quit(self):
        size = self.listbox_playerlist.size()
        if(size>1):
            for i in range(size):
                self.__resp.append(self.listbox_playerlist.get(i))
            super().quit()
        else:
            self.showDialogHadMinPlayer()
    
    def create_wdigets(self):
        self.__lb1 = Label(self,text=StringData.getLableTitlePlayerCountHeader())
        self.__lb1.grid(row=0,column=0)
        self.label_totalPlayerCount= Label(self,justify=LEFT,text=str(self.__totalPlayerCount)+"명")
        self.label_totalPlayerCount.grid(row=0,column=1)
        self.__btn1 = Button(self,text=StringData.getBtnTxtPlayerDel(),command=self.delPlayer)
        self.__btn1.grid(row=0,column=3)
        self.listbox_playerlist = Listbox(self,selectmode="SINGLE",height=8,width=35)
        self.listbox_playerlist.grid(row=1,column=0,columnspan=4)
        self.entry_inputnewplayerName = Entry(self,width=20,justify=LEFT)
        self.entry_inputnewplayerName.grid(row=2,column=0,columnspan=2)
        self.__btn2 = Button(self,text=StringData.getBtnTxtPlayerAdd(),command=self.addPlayer)
        self.__btn2.grid(row=2,column=3)
        self.__btn3 = Button(self,text=StringData.getBtnTxtDoPlay(),command=self.quit)
        self.__btn3.grid(row=3,column=4)
        self.resizeWindowSize()
        
    def delPlayer(self):
        idx = self.listbox_playerlist.curselection()
        if(idx != ()):
            self.listbox_playerlist.delete(idx)
            self.label_totalPlayerCount['text'] = str(self.listbox_playerlist.size())+"명"
            
    def addPlayer(self):
        pname = self.entry_inputnewplayerName.get()
        if(pname == '' or pname == []):
            tkinter.messagebox.showinfo("에러","이름을 입력해주세요")
        else:
            size = self.listbox_playerlist.size()
            hasSamePlayer = False
            for i in range(size):
                if(pname == self.listbox_playerlist.get(i)):
                    hasSamePlayer = True
                    break
            if(hasSamePlayer):
                tkinter.messagebox.showinfo("이미 등록됨","입력하신 사용자는 이미 등록되어 있는 사용자입니다.")
            elif(size>7):
                tkinter.messagebox.showinfo("인원수 꽉참","최대 8명까지 플레이 하실 수 있습니다.")
            else:
                self.listbox_playerlist.insert(self.listbox_playerlist.size(),pname)
                self.label_totalPlayerCount['text'] = str(self.listbox_playerlist.size())+"명"
            
        self.entry_inputnewplayerName.delete(0,END)
class InputView:
    @staticmethod
    def showWaitingRoomWindow():
        response = []
        root = Tk()
        root.title("Waiting Room")
        root.geometry("500x350")
        WaitingRoom(root,response)
        root.mainloop()
        return response
print(InputView.showWaitingRoomWindow())

    
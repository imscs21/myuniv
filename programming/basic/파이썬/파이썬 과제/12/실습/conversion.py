from tkinter import *
from StringData import *
class App(Frame):
    def __init__(self, master):
        self.__round_num = 1
        super().__init__(master)
        
        self.pack(padx=40, pady=20)
        
        self.create_widgets()
        
    def create_widgets(self):
        
        #self.entrys = [ [0 ]*2 ]*3
        rowOffset = 0
        entryFirIdx = 0
        Label(self, text=SData.getCTitle()).grid(row=rowOffset, column=0)
        Label(self, text=SData.getFTitle()).grid(row=rowOffset, column=1)
        self.entrys0 = ( Entry(self, width=10, justify=CENTER) )
        rowOffset += 1
        self.entrys0.grid(row=rowOffset, column=0)
        self.entrys1=( Entry(self, width=10, justify=CENTER) )
        self.entrys1.grid(row=rowOffset, column=1)
        Button(self, text=SData.getClearBtnTxt(), command=lambda: self.clear(0)).grid(row=rowOffset, column=3)
        rowOffset += 1
        Button(self, text=SData.getConvertBtnTxt(), command=self.c2f).grid(row=rowOffset, column=0)
        Button(self, text=SData.getConvertBtnTxt(), command=self.f2c).grid(row=rowOffset, column=1)
        rowOffset += 1
        entryFirIdx += 1
        
        

        Label(self, text=SData.getCmTitle()).grid(row=rowOffset, column=0)
        Label(self, text=SData.getFtTitle()).grid(row=rowOffset, column=1)
        self.entrys2 = ( Entry(self, width=10, justify=CENTER) )
        rowOffset += 1
        self.entrys2.grid(row=rowOffset, column=0)
        self.entrys3 = ( Entry(self, width=10, justify=CENTER) )
        self.entrys3.grid(row=rowOffset, column=1)
        Button(self, text=SData.getClearBtnTxt(), command=lambda: self.clear(1)).grid(row=rowOffset, column=3)
        rowOffset += 1
        Button(self, text=SData.getConvertBtnTxt(), command=self.cm2ft).grid(row=rowOffset, column=0)
        Button(self, text=SData.getConvertBtnTxt(), command=self.ft2cm).grid(row=rowOffset, column=1)
        rowOffset += 1
        entryFirIdx += 1
        
        
        Label(self, text=SData.getKgTitle()).grid(row=rowOffset, column=0)
        Label(self, text=SData.getFoundTitle()).grid(row=rowOffset, column=1)
        self.entrys4=( Entry(self, width=10, justify=CENTER) )
        rowOffset += 1
        self.entrys4.grid(row=rowOffset, column=0)
        self.entrys5 = ( Entry(self, width=10, justify=CENTER) )
        self.entrys5.grid(row=rowOffset, column=1)
        Button(self, text=SData.getClearBtnTxt(), command=lambda: self.clear(2)).grid(row=rowOffset, column=3)
        rowOffset += 1
        Button(self, text=SData.getConvertBtnTxt(), command=self.kg2fnd).grid(row=rowOffset, column=0)
        Button(self, text=SData.getConvertBtnTxt(), command=self.fnd2kg).grid(row=rowOffset, column=1)
        rowOffset += 1
        entryFirIdx += 1
        
        Button(self, text=SData.getExitBtnTxt(), command=self.quit).grid(row=rowOffset, column=3, columnspan=2)
        Label(self,text="test").grid()
        Label(self,text="test2").grid()
        #print(self.entrys)
        #print(len(self.entrys[0]))
    def c2f(self):
        entry = self.entrys0.get()
        if entry != '' and Reader.isint(entry):
            t = round(9.0 / 5.0 * int(entry) + 32)
            self.entrys1.delete(0, END)
            self.entrys1.insert(0, str(t))
            #self.entry1.grid(row=1,column=1)

    def f2c(self):
        entry = self.entrys1.get()
        if entry != '' and Reader.isint(entry):
            t = round((5 * int(entry) - 160) / 9.0)
            self.entrys0.delete(0, END)
            self.entrys0.insert(0, str(t))
            #self.entry0.grid(row=1,column=0)
            
            
    def cm2ft(self):
        entry = self.entrys2.get()
        if entry != '' and Reader.isint(entry):
            t = round(( int(entry) *0.03281),self.__round_num)
            self.entrys3.delete(0, END)
            self.entrys3.insert(0, str(t))
        
    def ft2cm(self):
        entry = self.entrys3.get()
        if entry != '' and Reader.isint(entry):
            t = round(int(entry)*30.48,self.__round_num)
            self.entrys2.delete(0, END)
            self.entrys2.insert(0, str(t))
            
    def kg2fnd(self):
        entry = self.entrys4.get()
        if entry != '' and Reader.isint(entry):
            t = round(( int(entry) *2.2046),self.__round_num)
            self.entrys5.delete(0, END)
            self.entrys5.insert(0, str(t))
    def fnd2kg(self):
        entry = self.entrys5.get()
        if entry != '' and Reader.isint(entry):
            t = round(( int(entry) *0.4536),self.__round_num)
            self.entrys4.delete(0, END)
            self.entrys4.insert(0, str(t))
    def clear(self,dataIdx=0):
        if(dataIdx == 0):
            self.entrys0.delete(0,END)
            self.entrys1.delete(0,END)
        elif(dataIdx == 1):
            self.entrys2.delete(0,END)
            self.entrys3.delete(0,END)
        elif(dataIdx ==2):
            self.entrys4.delete(0,END)
            self.entrys5.delete(0,END)
        
        
class Reader:
    @staticmethod
    def isint(s):
        return s.isdigit() or \
               s[0] == '-' and s[1:].isdigit() or \
               s[0] == '+' and s[1:].isdigit()
        
# main        
root = Tk()
root.title("변환기")
width =int( 280/5*7)
height =int( 180/5*9)

root.geometry(str(width)+"x"+str(height))
App(root)
root.mainloop()

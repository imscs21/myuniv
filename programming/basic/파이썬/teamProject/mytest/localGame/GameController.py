from tkinter import *
from WaitingRoom import *
class MainMenu(Frame,controller):
    def __init__(self,master):
        super().__init__(master)
        master.pack()
        self.__mController = controller
        
    def getController():
        return self.__mController    
    def create_widgets(self):
        pass
        
    

class Controller:
    def __init__(self,playerNames):
        
        self.__players = players
        
    def instancePlayersWithNames(self,names):
        self.__players = [0]*len(names)
        for i in range(0,len(names)):
            self.__players[i] = Player(Name)
    def play(self):
        window = Tk()
        MainMenu(window,self)
        window.mainLoop()
        
        
        
def main():
    playerList = []
    playerNameList = []
    playerNameList = InputView.getPlayerNameList()
    while(playerNameList == [] or not ( 2<=len(playerNameList)<=8)):
        playerNameList = InputView.getPlayerNameList(playerNameList)
    print(playerList)
    
    
main()
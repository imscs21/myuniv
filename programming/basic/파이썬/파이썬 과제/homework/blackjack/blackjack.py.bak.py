# Blackjack Game Contoller
from bjcard import Deck
from bjhand import *
from bjview import Reader

class BlackjackController:
    """defines Blackjack game controller class"""
    def __init__(self, names):
        """creates player/dealer's empty hand and a deck of cards
        argument: name -- player' name in string (default: 'Dealer')
        """
        self.__players = [""]*len(names)
        self.__PTOs = [False]*len(names)
        for i in range(0,len(names)):
            self.__players[i] = PlayerHand(names[i])
        self.__dealer = Hand()
        self.__deck = Deck()
        
    def play(self):
        """plays a round of blackjack game"""
        print("== new game ==")
        #player = self.__player
        #dealer = self.__dealer
        deck = self.__deck
        
        for i in range(0,len(self.__players)):
            self.__players[i].get(deck.next())
        self.__dealer.get(deck.next())
        #1바퀴 나누기
        for i in range(0,len(self.__players)):
            self.__players[i].get(deck.next())
        #player.get(deck.next())
        self.__dealer.get(deck.next(open=False))
        #2바퀴 나누기
        dealer = self.__dealer#공통 딜러 설정
        for i in range(0,len(self.__players)): # 플레이어당 플레이
        
            print("Dealer :", dealer)#딜러 상황
            print(self.__players[i].name, ":", self.__players[i])#플레이어 상황
            if self.__players[i].total == 21:
                print("Blackjack!", self.__players[i].name, "wins.")
                self.__players[i].earn_chips(2)
            else:
                while self.__players[i].total < 21 and \
                    Reader.ox(self.__players[i].name + ": Hit?(o/x) "):
                    self.__players[i].get(deck.next())
                    print(self.__players[i].name, ":", self.__players[i])
                if self.__players[i].total > 21:
                    print(self.__players[i].name, "busts!")
                    self.__players[i].lose_chips(1)
                else:
                    self.__PTOs[i] = True 
        if(sum(self.__PTOs) > 0):
            while dealer.total <= 16:
                    dealer.get(deck.next())
        
        for i in range(0,len(self.__players)):
            if(self.__PTOs[i]):
                self.__PTOs[i] = False
                if dealer.total > 21:
                    print("Dealer busts!")
                    self.__players[i].earn_chips(1)
                elif dealer.total == self.__players[i].total:
                    print("We draw.")
                elif dealer.total > self.__players[i].total:
                    print(self.__players[i].name, "loses.")
                    self.__players[i].lose_chips(1)
                else:
                    print(self.__players[i].name, "wins.")
                    self.__players[i].earn_chips(1)
        self.__dealer.open()
        print("Dealer :", self.__dealer)
        for i in range(0,len(self.__players)):
            self.__players[i].clear()
        dealer.clear()

def main():
    # main procedure
    print("Welcome to SMaSH Casino!")
    count =  input("Player Count:")
    while(not (count.isdigit() and count != "" and 0<int(count)<=3)):
        count = input("Player Count:")
    count = int(count)
    names = [Reader.register() for _ in range(count)]
    #name = Reader.register()
    game = BlackjackController(names)
    loopControl = True
    while loopControl:
        game.play()
        for i in range(0,count):
            if not Reader.ox("Play more, " + names[i] + "? (o/x) "):
                loopControl = False
                break
    for i in range(0,count):
        print("Bye, " + names[i] + "!")

# launch blackjack game
main()
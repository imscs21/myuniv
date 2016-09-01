# Blackjack Game Contoller
from bjcard import Deck
from bjhand import *
from bjview import Reader

class BlackjackController:
    """defines Blackjack game controller class"""
    def __init__(self, name):
        """creates player/dealer's empty hand and a deck of cards
        argument: name -- player' name in string (default: 'Dealer')
        """
        self.__player = PlayerHand(name)
        self.__dealer = Hand()
        self.__deck = Deck()
        
    def play(self):
        """plays a round of blackjack game"""
        print("== new game ==")
        player = self.__player
        dealer = self.__dealer
        deck = self.__deck
        player.get(deck.next())
        dealer.get(deck.next())
        player.get(deck.next())
        dealer.get(deck.next(open=False))
        print("Dealer :", dealer)
        print(player.name, ":", player)
        if player.total == 21:
            print("Blackjack!", player.name, "wins.")
            player.earn_chips(2)
        else:
            while player.total < 21 and \
                  Reader.ox(player.name + ": Hit?(o/x) "):
                player.get(deck.next())
                print(player.name, ":", player)
            if player.total > 21:
                print(player.name, "busts!")
                player.lose_chips(1)
            else:
                while dealer.total <= 16:
                    dealer.get(deck.next())
                if dealer.total > 21:
                    print("Dealer busts!")
                    player.earn_chips(1)
                elif dealer.total == player.total:
                    print("We draw.")
                elif dealer.total > player.total:
                    print(player.name, "loses.")
                    player.lose_chips(1)
                else:
                    print(player.name, "wins.")
                    player.earn_chips(1)
            dealer.open()
            print("Dealer :", dealer)
        player.clear()
        dealer.clear()

def main():
    # main procedure
    print("Welcome to SMaSH Casino!")
    pcountQust = "Player Count: "
    pcount = input(pcountQust)
    while(not (pcount.isdigit() and pcount != "" and 0<int(pcount)<=3)):
        pcount = input(pcountQust)
    pcount = int(pcount)
    names = [Reader.register() for _ in range(pcount)]
    games = [BlackjackController(name ) for name in names]
    
    while True:
        for i in range(len(games)):
            games[i].play()
        if not Reader.ox("Play more"  + "? (o/x) "):
            break
    for name in names:
        print("Bye, " + name + "!")

# launch blackjack game
main()

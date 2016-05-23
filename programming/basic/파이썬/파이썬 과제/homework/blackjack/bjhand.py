class Hand:
    """defines Hand class"""
    def __init__(self, name="Dealer"):
        """creates player/dealer's empty hand
        argument: name -- player's name in string (default: 'Dealer')
        """
        self.__name = name
        self.__hand = []
        
    def __str__(self):
        """returns its string representation"""
        if len(self.__hand) == 0:
            show = "empty"
        else:
            show = ""
            for card in self.__hand:
                show += str(card) + " "
        return show

    @property
    def name(self):
        """its name : either player's name or 'Dealer'"""
        return self.__name

    @property
    def total(self):
        """the total value of its hand"""
        point = 0
        number_of_ace = 0
        for card in self.__hand:
            if card.rank == 'A':
                point += 11
                number_of_ace += 1
            else:
                point += card.value
        while point > 21 and number_of_ace > 0:
            point -= 10
            number_of_ace -= 1
        return point  

    def get(self, card):
        """gets a card from deck and puts the card into its hand"""
        self.__hand.append(card)

    def clear(self):
        """empties its hand"""
        self.__hand = []

    def open(self):
        """turns all of its hand's cards' faces up"""
        for card in self.__hand:
            if not card.face_up:
                card.flip()

class PlayerHand(Hand):
    """defines PlayerHand class: subclass of Hand"""
    def __init__(self, name):
        """creates player's empty hand 
        with the capability of counting chips it owns
        argument: name -- player' name in string
        """
        super().__init__(name)
        self.__chips = 0
        
    def earn_chips(self, n):
        """increases the number of chips by n"""
        self.__chips += n
        print("Your("+self.name+") have", self.__chips, "chips.")
        
    def lose_chips(self, n):
        """decreases the number of chips by n"""
        self.__chips -= n
        print("Your("+self.name+") have", self.__chips, "chips.")




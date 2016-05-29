import json
from Deck import *
from Card import *
class Player:
    __hand=None
    __name=""
    def __init__(self):
        self.__hand = Deck.getEmptyDeck();

    def setName(self,Name):
        self.__name = Name
        return self
    def getName(self):
        return self.__name
    def getHand(self):
        return self.__hand

    def toJson(self):
        
        handj = []
        for c in self.__hand:
            handj.add(c.toJson());
        result = {"hand":handj,"name":name}
        result = json.dumps(result)
        return result
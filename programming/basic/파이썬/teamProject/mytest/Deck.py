import random
import json
from Card import *
class Deck(list):
    __jt = False
    #__CardCarrier = []
    def get(self,index):
        if(0<=index<len(self)):
            return self.__CardCarrier[index]
        else:
            return None
    def append(self,x):
        if(type(x) == Card or type(x) == JokerCard):
            super().append(x)
    def insert(self,i,x):
        if(type(x) == Card or type(x) == JokerCard):
            super().insert(i,x)
    
    
    @staticmethod
    def getSortedDeck():
        return Deck()
    @staticmethod
    def getEmptyDeck():
        result = Deck()
        result.clear()
        return result
   
	
    def getCloneDeck(self):
        return self[0:len(self)]

    def shuffle(self):
        random.shuffle(self)
        return self

    def shuffleWithClone(self):
        result = Deck.getCloneDeck()
        random.shuffle(result)
        #Collections.shuffle(result)
        return result
    @staticmethod
    def MakeJson(deck):
        ja = []
        for c in deck:
            ja.append(c.toJson())
        result = {"deck":ja}
        result = json.dumps(result)
        return result

    def toJson(self):
        return Deck.MakeJson(self)
	

    def __init__(self,Jt=False):
        super().__init__(self)
        for i in range(0,len(Card.Categories())-1):
            for j in range(0,len(Card.Levels())-1):
                self.append(Card(i,j))
		
        self.__jt = Jt
        for i in range(self.__jt+1):
            self.append(JokerCard())

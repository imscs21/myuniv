class SlidingBoard:
    __empty = (0,0)
    @property
    def board(self):
        """its board : either player's name or 'Dealer'"""
        return self.__board

    def __init__(self,size=2):
        #board = [[]*size]*size
        self.__board = SlidingBoard.create_board(SlidingBoard.create_init_board(size))
        self.__empty = self.find_position(0)  #(0,0)
        
    #end init func
    
   
        
    @staticmethod
    def create_board(numbers):
        size = int(len(numbers)**0.5)
        totalsize=size**2
        result = [numbers[i*size:(i+1)*size] for i in range(0,len(numbers)//size)]
        return result
        
     
    @staticmethod
    def create_init_board(size):
        totalsize=size**2
        import random
        temp = []
        temp = [i for i in range(1,totalsize)]
        random.shuffle(temp)
        temp = [0]+temp
    
        #result = [temp[i*size:(i+1)*size] for i in range(0,len(temp)//size)]
        #del temp,totalsize
        return temp#result
    @staticmethod
    def create_goal_board(size):
        totalsize=size**2
        
        import random
        temp = [i for i in range(1,totalsize)]+[0]
    
        #result = [temp[i-size:i] for i in range(size,totalsize+size,size)]
        #del temp,totalsize
        
        return temp #result
    
    def print_board(self):
        for row in self.__board:
            for item in row:
                if item == 0:
                    print("  ", end=" ")
                else:
                    print(str(item).rjust(2), end=" ")
            print() 
            
    def move(self,pos):
        (i, j) = pos
        if self.__empty == (i-1, j) or self.__empty == (i+1, j) or \
           self.__empty == (i, j-1) or self.__empty == (i, j+1):
            self.__board[self.__empty[0]][self.__empty[1]] = self.__board[i][j]
            self.__board[i][j] = 0
            self.__empty = pos
            #return (pos, self.__board)
        else:
            print("Can't move! Try again.")
            
            #return (self.__empty, self.__board)
    def find_position(self,num):
        for i in range(len(self.__board)):
            for j in range(len(self.__board[i])):
                if num == self.__board[i][j]:
                    return (i, j)
                    
    
from SlidingBoard1 import *
from SlidingView import *

class SlidingPuzzleController:
    __slider = None
    __goal = None
    __size = 0
    
    def __init__(self,size):
        self.__size = size
        self.__slider = SlidingBoard(self.__size)
        self.__goal = SlidingBoard.create_board( SlidingBoard.create_goal_board(self.__size))
        

    def play(self):
        while True:
            
            self.__slider.print_board()
            if self.__slider.board == self.__goal:
                print("Congratulations!")
                break
            num = Reader.get_number(self.__size)
            if num == 0:
                break
            pos = self.__slider.find_position(num)
            self.__slider.move(pos)
            #(empty, board) = __slider.move(pos, empty, board)
        print("Please come again.")
        
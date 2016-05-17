# Sliding Puzzle
import random
import math

def get_number(size):
    num = input("Type the number you want to move (Type 0 to quit): ")
    while not (num.isdigit() and 0 <= int(num) <= size * size - 1):
        num = input("Type the number you want to move (Type 0 to quit): ")
    return int(num)

def create_board(numbers):
    size = int(math.sqrt(len(numbers)))
    board = []
    for i in range(size):
        k = i * size
        board.append(numbers[k : k+size])
    return board

def create_init_board(size):
    numbers = list(range(size * size))
    random.shuffle(numbers)
    return create_board(numbers)

def create_goal_board(size):
    numbers = list(range(size * size))
    numbers = numbers[1:]
    numbers.append(0)
    return create_board(numbers)

def print_board(board):
    for row in board:
        for item in row:
            if item == 0:
                print("  ", end=" ")
            else:
                print(str(item).rjust(2), end=" ")
        print()
        
def find_position(num, board):
    for i in range(len(board)):
        for j in range(len(board)):
            if num == board[i][j]:
                return (i, j)

def move(pos, empty, board):
    (i, j) = pos
    if empty == (i-1, j) or empty == (i+1, j) or \
       empty == (i, j-1) or empty == (i, j+1):
        board[empty[0]][empty[1]] = board[i][j]
        board[i][j] = 0
        return (pos, board)
    else:
        print("Can't move! Try again.")
        return (empty, board)

def sliding_puzzle(size):
	board = create_init_board(size)
	goal = create_goal_board(size)
	empty = find_position(0, board)
	while True:
		print_board(board)
		if board == goal: 
			print("Congratulations!")
			break
		num = get_number(size)
		if num == 0: 
			break
		pos = find_position(num, board)
		(empty, board) = move(pos, empty, board)
	print("Please come again.")

def main():
    import sys
    size = sys.argv[1]
    if size.isdigit() and int(size) > 1:
        sliding_puzzle(int(size))
    else:
        print("Not a proper system argument.")

main()


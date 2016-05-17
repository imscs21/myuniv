errmsg = "Not a proper system argument"
from SPC import *


if(__name__ == "__main__"):
    import sys
    if(len(sys.argv) > 1 and sys.argv[1].isdigit()):
        size = int( sys.argv[1])
        if(size>1):
            #sliding_puzzle(size)
            spc = SlidingPuzzleController(size)
            spc.play()
        else:
            print(errmsg)
    else:
        print(errmsg)
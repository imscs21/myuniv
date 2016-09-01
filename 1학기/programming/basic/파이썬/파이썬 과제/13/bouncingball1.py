from tkinter import *

class Box(object):
    def __init__(self,size):
        self.box_size = size
        
    def in_horizontal_contact(self,x):
        return x <= 0 or x >= self.box_size
        
    def in_vertical_contact(self,y):
        return y <= 0 or y >= self.box_size
        
    def size_of(self):
        return self.box_size
class Sqare(Box):
    def __init__(self,size,ps):
        super().__init__(size)
        self.parentSize = ps
    def in_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2 <=x<= self.parentSize//2 + self.box_size//2) and (self.parentSize//2 - self.box_size//2 <=y<= self.parentSize//2+self.box_size//2)
    
    def in_left_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2  <=x<= self.parentSize//2 ) and( self.parentSize//2 - self.box_size//2+2 <=y<= self.parentSize//2+self.box_size//2 -2 )
    def in_right_contact(self,x,y):
        return (self.parentSize//2 <=x<= self.parentSize//2+self.box_size//2 )\
         and( self.parentSize//2 - self.box_size//2+2 <=y<= self.parentSize//2+self.box_size//2 -2 )
    def in_top_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2 <=y<= self.parentSize//2 ) \
        and( self.parentSize//2 - self.box_size//2+2 <=x<= self.parentSize//2+self.box_size//2 -2 )
    def in_bottom_contact(self,x,y):
        return (self.parentSize//2 <=y<= self.parentSize//2+self.box_size//2 ) \
        and( self.parentSize//2 - self.box_size//2+2 <=x<= self.parentSize//2+self.box_size//2 -2 )
    
    """
    def in_horizontal_contact(self,x):
        return   #not super().in_horizontal_contact(x)
    def in_vertical_contact(self,y):
        return #not super().in_vertical_contact(y) #y <= (self.parentSize//2) - self.box_size or y >= (self.parentSize//2+self.box_size)
    """
class MovingBall(object):
    def __init__(self,x,y,xv,yv,color,size,box,sqare):
        self.x = x
        self.y = y
        self.xv = xv
        self.yv = yv
        self.color = color
        self.size = size
        self.box = box
        self.sqare = sqare
        
    def x_position(self):
        return self.x
        
    def y_position(self):
        return self.y
        
    def color_of(self):
        return self.color
        
    def size_of(self):
        return self.size
        
    def move(self,time_unit):
        self.x = self.x + self.xv * time_unit
        if(self.sqare.in_contact(self.x,self.y)):
            isChanged = False
            if self.sqare.in_left_contact(self.x,self.y) or self.sqare.in_right_contact(self.x,self.y)  :
                print("delta xv")
                self.xv = - self.xv
                #self.y = self.y + self.yv * time_unit
            elif self.sqare.in_top_contact(self.x,self.y) or self.sqare.in_bottom_contact(self.x,self.y) :
                
                print("delta yv")
                self.yv = - self.yv
            self.y = self.y + self.yv * time_unit        
            print("====") 
        else:
            if self.box.in_horizontal_contact(self.x):
                self.xv = - self.xv
            self.y = self.y + self.yv * time_unit
            if self.box.in_vertical_contact(self.y):
                self.yv = - self.yv         
            
class AnimationWriter(object):
    def __init__(self,root,ball,box,sqare):
        size = box.size_of()
        self.size = size
        self.canvas = Canvas(root, width=size, height=size)
        self.canvas.grid()
        self.ball = ball
        self.sqare = sqare
            
    def animate(self):
        self.canvas.delete(ALL)
        self.ball.move(1)
        x = self.ball.x_position()
        y = self.ball.y_position()
        d = self.ball.size_of() * 2
        c = self.ball.color_of()
        self.canvas.create_rectangle(self.size//2 -self.sqare.size_of()//2, self.size//2 -self.sqare.size_of()//2,self.size//2 +self.sqare.size_of()//2, self.size//2 +self.sqare.size_of()//2,outline='blue',fill='blue')
        
        self.canvas.create_oval(x, y, x+d , y+d, outline=c, fill=c)
        self.canvas.after(10, self.animate)
        
class BounceController(object):
    def __init__(self):
        box_size = 400
        ball_size = 10
        ball_color = 'red'
        x_velocity, y_velocity = 5, 2
        root = Tk()
        root.title("Bouncing Ball")
        root.geometry(str(box_size+10)+"x"+str(box_size+10))
        box = Box(box_size)
        sqare = Sqare(box_size//3,box_size)
        ball = MovingBall(box_size//3, box_size//5, x_velocity, y_velocity, ball_color, ball_size, box,sqare)
        #ball = MovingBall(box_size//3, box_size//5, x_velocity, y_velocity, ball_color, ball_size, box,sqare)
        
        AnimationWriter(root, ball, box,sqare).animate()
        root.mainloop()
    
BounceController()



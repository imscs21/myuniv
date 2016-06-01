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
    def __init__(self,size,ps,color='blue'):
        super().__init__(size)
        self.parentSize = ps
        self.color = color
        self.__fixedArea = 0
    def color_of(self):
        return self.color
    def in_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2 <=x<= self.parentSize//2 + self.box_size//2) and (self.parentSize//2 - self.box_size//2 <=y<= self.parentSize//2+self.box_size//2)
    def drawShape(self,cv,bsize):
        cv.create_rectangle(bsize//2 -self.size_of()//2, bsize//2 -self.size_of()//2,bsize//2 +self.size_of()//2, bsize//2 +self.size_of()//2,outline=self.color_of(),fill=self.color_of())
        
    def in_left_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2  <=x<= self.parentSize//2 ) and( self.parentSize//2 - self.box_size//2+self.__fixedArea <=y<= self.parentSize//2+self.box_size//2 -self.__fixedArea )
    def in_right_contact(self,x,y):
        return (self.parentSize//2 <=x<= self.parentSize//2+self.box_size//2 )\
         and( self.parentSize//2 - self.box_size//2+self.__fixedArea <=y<= self.parentSize//2+self.box_size//2 -self.__fixedArea )
    def in_top_contact(self,x,y):
        return (self.parentSize//2 - self.box_size//2 <=y<= self.parentSize//2 ) \
        and( self.parentSize//2 - self.box_size//2+self.__fixedArea <=x<= self.parentSize//2+self.box_size//2 -self.__fixedArea )
    def in_bottom_contact(self,x,y):
        return (self.parentSize//2 <=y<= self.parentSize//2+self.box_size//2 ) \
        and( self.parentSize//2 - self.box_size//2+self.__fixedArea <=x<= self.parentSize//2+self.box_size//2 -self.__fixedArea )
    
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
        self.__isCollide = False
        self.__isColliding = False
    def x_position(self):
        return self.x
        
    def y_position(self):
        return self.y
        
    def color_of(self):
        return self.color
    def drawShape(self,cv):
        self.move(1)
        x = self.x_position()
        y = self.y_position()
        d = self.size_of() * 2
        c = self.color_of()
        cv.create_oval(x, y, x+d , y+d, outline=c, fill=c)
        
    def size_of(self):
        return self.size
    def isCollide(self):
        return self.__isCollide
    def setCollision(self,v):
        self.__isCollide = v
    def setIsColliding(self,v):
        self.__isColliding = v
    def isColliding(self):
        return self.__isColliding
    def move(self,time_unit):
        priviousX = int(self.x)
        priviousY = int(self.y)
        if(self.__isCollide):
            self.setCollision(False)
            self.xv = -self.xv
            self.yv = - self.yv
        self.x = self.x + self.xv * time_unit
        if(self.sqare.in_contact(self.x,self.y)):
            isChanged = False
            if self.sqare.in_left_contact(self.x,self.y) or self.sqare.in_right_contact(self.x,self.y)  :
                if( (self.box.size_of()//2 - self.sqare.size_of()//2 <=priviousX <= self.box.size_of()//2 + self.sqare.size_of()//2 and  self.box.size_of()//2+self.sqare.size_of()//2<=priviousY <=self.box.size_of() ) \
                or (self.box.size_of()//2 - self.sqare.size_of()//2 <=priviousX <= self.box.size_of()//2 + self.sqare.size_of()//2 and  0<=priviousY <=self.box.size_of()//2-self.sqare.size_of()//2 )):
                    print("delta yv2")
                    self.yv = - self.yv
                else:
                    print("delta xv")
                
                    self.xv = - self.xv
                #self.y = self.y + self.yv * time_unit
            elif self.sqare.in_top_contact(self.x,self.y) or self.sqare.in_bottom_contact(self.x,self.y) :
                if( (self.box.size_of()//2 - self.sqare.size_of()//2 <=priviousY <= self.box.size_of()//2 + self.sqare.size_of()//2 and  self.box.size_of()//2+self.sqare.size_of()//2<=priviousX <=self.box.size_of() ) \
                or (self.box.size_of()//2 - self.sqare.size_of()//2 <=priviousY <= self.box.size_of()//2 + self.sqare.size_of()//2 and  0<=priviousX <=self.box.size_of()//2-self.sqare.size_of()//2 )):
                    print("delta xv2")
                    self.xv = - self.xv
                else:
                    print("delta yv")
                    self.yv = - self.yv
            self.y = self.y + self.yv * time_unit   
            print("pos: ",(self.x,self.y))     
            print("====") 
        else:
            if self.box.in_horizontal_contact(self.x):
                self.xv = - self.xv
            self.y = self.y + self.yv * time_unit
            if self.box.in_vertical_contact(self.y):
                self.yv = - self.yv         
            
class AnimationWriter(object):
    def __init__(self,root,ball,ball2,box,sqare):
        size = box.size_of()
        self.size = size
        self.canvas = Canvas(root, width=size, height=size)
        self.canvas.grid()
        self.ball = ball
        self.ball2 = ball2
        self.sqare = sqare
            
    def animate(self):
        self.canvas.delete(ALL)
        self.sqare.drawShape(self.canvas,self.size)
        #self.canvas.create_rectangle(self.size//2 -self.sqare.size_of()//2, self.size//2 -self.sqare.size_of()//2,self.size//2 +self.sqare.size_of()//2, self.size//2 +self.sqare.size_of()//2,outline='blue',fill='blue')
        self.ball.drawShape(self.canvas)
        self.ball2.drawShape(self.canvas)
        x = self.ball.x_position()
        y = self.ball.y_position()
        x2 = self.ball2.x_position()
        y2 = self.ball2.y_position()
        d2 = self.ball2.size_of() * 2
        
        if(x2-d2<=x <=x2+d2 and y2-d2 <= y <= y2+d2):
            if(not( self.ball.isColliding() and self.ball2.isColliding())):
                self.ball.setIsColliding(True)
                self.ball2.setIsColliding(True)
                self.ball.setCollision(True)
                self.ball2.setCollision(True)
        else:
            self.ball.setIsColliding(False)
            self.ball2.setIsColliding(False)
        
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
        import random
        #random.randrange(0,1)
        ball = MovingBall(box_size//4, box_size//5, x_velocity, y_velocity, ball_color, ball_size, box,sqare)
        ball2 = MovingBall(box_size//5, box_size//4, x_velocity, y_velocity, 'green', ball_size, box,sqare)
        
        AnimationWriter(root, ball,ball2, box,sqare).animate()
        root.mainloop()
    
BounceController()



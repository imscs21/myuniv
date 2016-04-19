def find_last(filename,key):
    file = open(filename,"r")
    ofile = open("result.txt","w+")
    
    fsm = file.read()
    pos  = fsm.rfind(key)
    if(pos == -1):
        ofile.write("not found")
    else:
        ofile.write(str(pos))
    ofile.write("\n")
    ofile.close()
    file.close()
    
    
def find_all(filename,key):
    file = open(filename,"r")
    ofile = open("result.txt","w+")
    fsm = file.read()
    pos = fsm.find(key)
    last_index = int(0)
    while(pos != -1):
        ofile.write(str(pos+last_index))
        last_index += pos
        ofile.write("\n")
        fsm = fsm[(pos+len(key)-1):]
        pos = fsm.find(key)
    if(last_index == 0 and pos == -1):
        ofile.write("not found")
        ofile.write("\n")
    file.close()
    ofile.close()
        

def find_all_count(filename,key):
    file = open(filename,"r")
    ofile = open("result.txt","w+")
    fsm = file.read()
    count = int(0)
    pos = fsm.find(key)
    
    while(pos != -1):
        count += 1
        fsm = fsm[(pos+len(key)-1):]
        print(pos)
        pos = fsm.find(key)
        
    ofile.write(str(count))
    ofile.write("\n")
    file.close()
    ofile.close()
            
def one_sentence_per_line(filename) :      
    infile = open(filename,"r")      
    outfile = open("result.txt","w")      
    text = infile.read()      
    count = 0 
    
    while(text != '' or len(text)>0):
        (compare,sep1, text) = text.partition(".")
       
        while(compare != '' or len(compare)>0):
            (compare2,sep2,compare) = (compare).partition("?")
            count += 1
        
         
    
    
    outfile.write("문장이 총 " + str(count) + "개\n")      
    outfile.close() 
    infile.close() 

def find_all_sentence(filename,key) : 
    infile = open(filename,"r") 
    outfile = open("result.txt","w") 
    text = infile.read() 
    sentencecount = int(0)
    wordcount = int(0)
    while(text != '' or len(text)>0):
        (compare,sep1, text) = text.partition(".")
       
        while(compare != '' or len(compare)>0):
            (compare2,sep2,compare) = (compare).partition("?")
            pos = compare2.find(key)
            if(pos != -1):
                onesenten = compare2
                sentencecount +=1
                while (pos != -1):
                    wordcount += 1
                    onesenten = onesenten[pos+len(key)-1:]
                    pos = onesenten.find(key)
                    print(pos,sentencecount,wordcount)
                
                
    print(key,"가","문장",sentencecount,"에서",wordcount,"번 등장")
    outfile.write("'"+key+"'이(가) "+str(sentencecount)+"개 문장에서 "+str(wordcount)+"번 등장")
    outfile.close()      
    infile.close()      
    print("done")
find_all_sentence("article.txt","컴퓨터")
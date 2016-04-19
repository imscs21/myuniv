def find_last(filename,key):
    file = open(filename,"r")
    ofile = open("result_1.txt","w+")
    
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
    ofile = open("result_2.txt","w+")
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
    ofile = open("result_3.txt","w+")
    fsm = file.read()
    count = int(0)
    pos = fsm.find(key)
    
    while(pos != -1):
        count += 1
        fsm = fsm[(pos+len(key)-1):]
        pos = fsm.find(key)
    
    if(count == 0 ):
        ofile.write("not found\n")
    ofile.write(str(count))
    ofile.write("\n")
    file.close()
    ofile.close()
            
def one_sentence_per_line(filename) :      
    infile = open(filename,"r")      
    outfile = open("result_4.txt","w")      
    text = infile.read()      
    count = 0 
    while(text != '' or len(text)>0):
        (compare,sep1, text) = text.partition(".")
       
        while(compare != '' or len(compare)>0):
            (compare2,sep2,compare) = (compare+sep1).partition("?")
            outfile.write(compare2+sep2)
            count += 1
    outfile.write("\n문장이 총 " + str(count) + "개\n")      
    outfile.close() 
    infile.close() 

def find_all_sentence(filename,key) : 
    infile = open(filename,"r") 
    outfile = open("result_5.txt","w") 
    text = infile.read() 
    sentencecount = int(0)
    wordcount = int(0)
    while(text != '' or len(text)>0):
        (compare,sep1, text) = text.partition(".")
        while(compare != '' or len(compare)>0):
            (compare2,sep2,compare) = (compare+sep1).partition("?")
            pos = compare2.find(key)
            if(pos != -1):
                onesenten = compare2+sep2
                sentencecount +=1
                outfile.write("'"+key+"'이(가) "+str(sentencecount)+"번 등장\n")
                outfile.write(compare2+"\n")
                while (pos != -1):
                    wordcount += 1
                    onesenten = onesenten[pos+len(key)-1:]
                    pos = onesenten.find(key)
    outfile.write("'"+key+"'이(가) "+str(sentencecount)+"개 문장에서 "+str(wordcount)+"번 등장")
    outfile.close()      
    infile.close()      
    print("done")

find_last("article.txt","컴퓨터")
find_all("article.txt","컴퓨터")
find_all_count("article.txt","컴퓨터")
one_sentence_per_line("article.txt")
find_all_sentence("article.txt","컴퓨터")
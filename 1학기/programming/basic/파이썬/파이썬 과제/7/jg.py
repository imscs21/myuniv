def one_sentence_per_line(filename) :
	infile = open(filename, "r")
	outfile = open("result4준기.txt", "w+")
	text = infile.read()
	count = 0
	pos = text.find(".")
	pos2 = text.find("?")
	if pos == -1 and pos2 == -1 :
		outfile.write(text + "\n" + " No Sentence \n")

	while not(pos == -1 and pos2 == -1) : 
		print(pos,pos2, len(text),count)
		if pos < pos2  :
			i=pos
			(m,_,n) = text.partition(".")
			outfile.write(m + ".\n " +n)
			count+=1 
			pos = text.find(".",i+3)
			

		elif pos > pos2 :
			i=pos2
			(m,_,n) = text.partition("?")
			outfile.write(m + "?\n " + n)
			count+=1
			pos2 = text.find("?",i+3)
			

	print(i)
	outfile.write("\nTotal Sentence is " + str(count) + "\n")
	outfile.close()
	infile.close()

one_sentence_per_line("article.txt")
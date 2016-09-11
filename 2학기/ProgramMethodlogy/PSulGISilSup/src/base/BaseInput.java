package base;
import java.util.*;
import java.io.*;
public class BaseInput {
	protected Scanner sc=null;
	private void print(String str){
		System.out.print(str);
	}
	public Scanner getScanner(){
		return sc;
	}
public BaseInput(Scanner s){
	sc =s;
}
public BaseInput(InputStream ism){
	sc = new Scanner(ism);
}
public BaseInput(){
	sc=new Scanner(System.in);
}
public void close(){
	sc.close();
	
}
public byte readByte(){
	return sc.nextByte();
	
}
public byte readByte(String question){
	print(question);
	return readByte();
}
public String readLine(){
	return sc.nextLine();
}
public String readLine(String question){
	print(question);
	return readLine();
}
public String readString(String question){
	print(question);
	return readString();
}

public String readString(){
	return sc.next();
}
public int readInt(){
	return sc.nextInt();
}
public int readInt(String question){
	print(question);
	return readInt();
}
public double readDouble(){
	return sc.nextDouble();
}
public double readDouble(String question){
	print(question);
	return readDouble();
}
public float readFloat(){
	return sc.nextFloat();
}
public float readFloat(String question){
	print(question);
	return readFloat();
}
public long readLong(){
	return sc.nextLong();
}
public long readLong(String question){
	print(question);
	return readLong();
}
public Scanner reset(){
	return sc.reset();
}
public String readLineWithNewLine(String question){
	System.out.println(question);
	return readLine();
}
}

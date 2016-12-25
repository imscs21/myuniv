import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class BookObjectOutputTest{

	public static void main(String[] args) {
		FileOutputStream fout = null;
		ObjectOutputStream oos = null;

		ArrayList list = new ArrayList();
		Book b1 = new Book("a0001", "�ڹٿϼ�", "ȫ�浿", 10000);
		Book b2 = new Book("a0002", "��Ʈ����", "������", 20000);
		Book b3 = new Book("a0003", "���� EJB", "�輺��", 25000);
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		try{
			fout = new FileOutputStream("booklist.dat");
			oos = new ObjectOutputStream(fout);
			
			oos.writeObject(list);
			oos.reset();
			oos.writeObject(list);
			oos.reset();
			
			System.out.println("����Ǿ����ϴ�.");
			
		}catch(Exception ex){
		}finally{
			try{
				oos.close();
				fout.close();
			}catch(IOException ioe){}
		} // finally
	} // main end
} // class end

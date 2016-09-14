import java.util.*;
import java.io.*;
import java.net.*;
public class Test2 extends base.BaseMain {

	public void run(){
	
}
	static class INFO{
		public String url;
		public final File path = new File("/Users/hsh/Music");
	}
public static void main(String...strings ){
	final INFO inf = new INFO();
	while(!(inf.url=getInput().readLine("input url? ")).equals("program://finish")){
	try{
		URL url = new URL(inf.url);
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		printline("connecting...");
		conn.setConnectTimeout(30*1000);
		conn.connect();
		printline("connected!");
		File f = new File(inf.path,url.getFile());
		f.getParentFile().mkdirs();
		InputStream ism = conn.getInputStream();
		OutputStream osm = new FileOutputStream(f);
		printline("file downloading...");
		int a=conn.getContentLength();
		float prog=0,savedProg=-1;
		for(int i =0;i<a;i++){
			osm.write(ism.read());
			prog =Math.round( ((i+0.0f)/(a+0.0f)*1000))/10.0f;
			if(savedProg<0||savedProg<prog){
		savedProg = prog;
				printline(prog+"% downloaded");
			}
		}
		printline(f.getName()+" file saved!");
		printline("=========");
		printline("");
		ism.close();
		osm.close();
		conn.disconnect();
		
	}catch(Exception e){
		
		e.printStackTrace(System.out);
	}
	}
	printline("program exit");
}
}

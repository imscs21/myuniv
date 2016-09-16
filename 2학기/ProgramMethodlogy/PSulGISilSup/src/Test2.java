import java.util.*;
import java.io.*;
import java.net.*;
public class Test2 extends base.BaseMain {

	public void run(){
	
}
	static class INFO{
		public String url;
		public  File path = new File(getInput().readLine("folder?"));
		public boolean resetPath(){
			try{
				path  = new File(getInput().readLine("folder?"));
				return true;
			}catch(Exception e){}
			return false;
		}
	}
public static void main(String...strings ){
	final INFO inf = new INFO();
	while(!(inf.url=getInput().readLine("input url? ")).contains("program://finish")){
	if(inf.url.toString().contains("program://resetpath")){
		while(!inf.resetPath());
	}
		try{
		URL url = new URL(inf.url);
		HttpURLConnection conn= (HttpURLConnection)url.openConnection();
		conn.setRequestProperty("Accept-Encoding", "gzip");
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

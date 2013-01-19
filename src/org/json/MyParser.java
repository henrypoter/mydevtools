package org.json;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

public class MyParser {
	public static void parse(InputStream is){
		try{
			ByteArrayOutputStream baos=new ByteArrayOutputStream();
			byte[] bts=new byte[4096];
			int len;
			while((len=is.read(bts))!=-1){
				baos.write(bts,0,len);
			}
			baos.flush();
			String source=new String(baos.toByteArray(),"UTF-8");
			System.out.println("response:"+source);
			JSONObject json=new JSONObject(source);
			System.out.println("JSON:"+json.toString(2));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}

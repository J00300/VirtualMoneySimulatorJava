package pr;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

import javax.crypto.spec.SecretKeySpec;
 

public class TextField2
{
	 
	private static final String algorithm = "AES";
    private static final String transformation = algorithm + "/ECB/PKCS5Padding";
	 
	 public TextField2()    
	    {
	        
	        // Info_a �� AES ��ȣȭ. Info_b ����.
	        try
			{
	        	String test = "123456789abcdefg"; 
	    	    // 128��Ʈ�� Ű
	            //	   SecretKeySpec key = new SecretKeySpec(toBytes("696d697373796f7568616e6765656e61", 16), algorithm);
	        	SecretKeySpec key = new SecretKeySpec(test.getBytes(), algorithm);   	 
	        	JavaEnCrypto coder = new JavaEnCrypto(key);
	        	coder.decrypt(new File("C:/VirtualMoneySimulator/Info_a.txt"), new File("C:/VirtualMoneySimulator/Info_b.txt"));
		    } 
		        catch(Exception e)
			{
			    e.getStackTrace();
			}   
	    	
	        
	    
	    }

}

package pr;

import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class FileMaker {
	
	public FileMaker(){	}
	private static final String algorithm = "AES";
    private static final String transformation = algorithm + "/ECB/PKCS5Padding";
	
	public void MakeEncDec()									// ���� ������ ������ ���� ����. ����Ʈ�� ����. ������ �ص� �Ǵ� ��ȣȭ
	{
		String path = "C:\\VirtualMoneySimulator"; //���� ���
		String pathInfo1 = "C:\\VirtualMoneySimulator\\Info_a.txt";
		String pathInfo2 = "C:\\VirtualMoneySimulator\\Info_b.txt";
		File Folder = new File(path);
		File Info_a = new File(pathInfo1);
		File Info_b = new File(pathInfo2);
		
		if (!Info_a.exists() & !Info_b.exists())			// �ش� ���丮�� ������� ���丮�� ����. �� �� ��ȣȭ
		{
			try
			{
			    Folder.mkdir(); //���� �����մϴ�.
			    
			    // true ������ ������ ���� ���뿡 �̾ �ۼ�
	            FileWriter fw = new FileWriter(Info_b, true);
	             
	            // ���Ͼȿ� ���ڿ� ����
	            fw.write("default\n");		// ����Ʈ ���̵�
	            fw.write("****default\n");		//����Ʈ ��й�ȣ
	            // ù ���� ������ �߰�
	            
	            
	            
	            fw.write( "0#0#0\n");				//  �ѱݾ� 0, ���� ������ 0, ���ھ� 0
	            fw.write("0#0#0#0#0#0#0#0\n");		// ���� �ü� 0 * 8 
	            fw.write("0#0#0#0#0#0#0#0");		//���� ���� �� 0 * 8
	            
	            
	            fw.flush();
	            // ��ü �ݱ�
	            fw.close();
			    
		    } 
		        catch(Exception e)
			{
			    e.getStackTrace();
			}        
		}
		
		else						// �ص� �Ǵ� ��ȣȭ
		{
			try
			{	
        		// AES ��ȣȭ �۾� �� �ٽ� ����
	            String test = "123456789abcdefg";
	            SecretKeySpec key = new SecretKeySpec(test.getBytes(), algorithm);
	            JavaEnCrypto coder = new JavaEnCrypto(key);
	            
	            if (Info_a.exists())		//��ȣȭ�� ������ �ص�
				{
					coder.decrypt(new File("C:\\VirtualMoneySimulator\\Info_a.txt"), new File("C:\\VirtualMoneySimulator\\Info_b.txt"));
					Info_a.delete();
				}
				else if (Info_b.exists())						//�ص��� ���� Info_b�� ������ ��ȣȭ
				{
					coder.encrypt(new File("C:\\VirtualMoneySimulator\\Info_b.txt"), new File("C:\\VirtualMoneySimulator\\Info_a.txt"));
					Info_b.delete();
				}

			    
		    } 
		        catch(Exception e)
			{
			    e.getStackTrace();
			}        
		}
		
		// Information ������ �ִ��� üũ ��, ��ȣȭ
	}
}

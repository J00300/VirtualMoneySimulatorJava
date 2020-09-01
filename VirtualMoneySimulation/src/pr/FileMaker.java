package pr;

import java.io.*;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;


public class FileMaker {
	
	public FileMaker(){	}
	private static final String algorithm = "AES";
    private static final String transformation = algorithm + "/ECB/PKCS5Padding";
	
	public void MakeEncDec()									// 파일 폴더가 없으면 새로 생성. 디폴트값 저장. 있으면 해독 또는 암호화
	{
		String path = "C:\\VirtualMoneySimulator"; //폴더 경로
		String pathInfo1 = "C:\\VirtualMoneySimulator\\Info_a.txt";
		String pathInfo2 = "C:\\VirtualMoneySimulator\\Info_b.txt";
		File Folder = new File(path);
		File Info_a = new File(pathInfo1);
		File Info_b = new File(pathInfo2);
		
		if (!Info_a.exists() & !Info_b.exists())			// 해당 디렉토리가 없을경우 디렉토리를 생성. 그 후 암호화
		{
			try
			{
			    Folder.mkdir(); //폴더 생성합니다.
			    
			    // true 지정시 파일의 기존 내용에 이어서 작성
	            FileWriter fw = new FileWriter(Info_b, true);
	             
	            // 파일안에 문자열 쓰기
	            fw.write("default\n");		// 디폴트 아이디
	            fw.write("****default\n");		//디폴트 비밀번호
	            // 첫 저장 데이터 추가
	            
	            
	            
	            fw.write( "0#0#0\n");				//  총금액 0, 현재 보유액 0, 투자액 0
	            fw.write("0#0#0#0#0#0#0#0\n");		// 이전 시세 0 * 8 
	            fw.write("0#0#0#0#0#0#0#0");		//이전 보유 수 0 * 8
	            
	            
	            fw.flush();
	            // 객체 닫기
	            fw.close();
			    
		    } 
		        catch(Exception e)
			{
			    e.getStackTrace();
			}        
		}
		
		else						// 해독 또는 암호화
		{
			try
			{	
        		// AES 암호화 작업 후 다시 저장
	            String test = "123456789abcdefg";
	            SecretKeySpec key = new SecretKeySpec(test.getBytes(), algorithm);
	            JavaEnCrypto coder = new JavaEnCrypto(key);
	            
	            if (Info_a.exists())		//암호화된 문서는 해독
				{
					coder.decrypt(new File("C:\\VirtualMoneySimulator\\Info_a.txt"), new File("C:\\VirtualMoneySimulator\\Info_b.txt"));
					Info_a.delete();
				}
				else if (Info_b.exists())						//해독된 문서 Info_b가 있으면 암호화
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
		
		// Information 파일이 있는지 체크 후, 복호화
	}
}

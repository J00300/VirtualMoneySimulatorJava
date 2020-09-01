package pr;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableCellRenderer;
import javax.swing.JOptionPane;


public class SaveData 
{
	String[] storage = new String[2];
	 int tempnum = 0;
	 
	public int SaveData(int[] ilbl1, JTable table, int LineNumber)			// 입력되는 값 : 해독된 아이디의 LineNumber
	{ 
		for (int i = 0; i<8; i++)
		{
			table.setValueAt(table.getValueAt(i, 8), i, 6);
			table.setValueAt(table.getValueAt(i, 7), i, 5);
		}
		
		
		
		
		FileMaker FileM = new FileMaker();		// 로그인 버튼을 누르면 FileMaker 클래스의 DirMaker가 작동. Info.txt 디폴트
		FileM.MakeEncDec();						// 폴더가 없으면 폴더 생성 후 default default인 텍스트 파일 생성. Info_b 생성
		
		
		
		
		
		// Info_b의 LineNumber부터 1번째, 2번째 줄을 보관. ID와 PW
		//***************************************************************************
		
		
		try												// 첫줄 아이디, 둘째줄 비밀번호, 셋째줄 화폐 보유량 및 이전 가치
		{
			
			//파일 객체 생성
            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            
            String line = "";
            //String[] storage = new String[2];
            
            int tempnum = 0;
            while((line = bufReader.readLine()) != null)
            {
            	tempnum += 1;					// 
            	if (LineNumber == tempnum )		// 입력 LineNumber로 아이디 위치를 찾는다.
            	{
            		storage[0] = line;						// 아이디 저장
            		line = bufReader.readLine();
            		storage[1] = line;						// 비밀번호 저장
            		break;
            	}
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
            filereader.close();
		}
		catch(IOException e1)
		{
            System.out.println(e1);
        }	
            
            
            
         // Info_b의 LineNumber부터 5줄을 제거
    		//***************************************************************
		String filename="C:\\VirtualMoneySimulator\\Info_b.txt";
		//Enter starting line here
		int startline = LineNumber;
		//Enter number of lines here.
		int numlines = 5;
		delete(filename,startline,numlines);
    		
    		
    						// Info_b에서 제거한 라인을 최신화해 write
    		//***************************************************************
    		
    		FileWriter fw = null;
            BufferedWriter bw = null;
            
        try 
        {
	        fw = new FileWriter( "C:/VirtualMoneySimulator/Info_b.txt", true);
			bw = new BufferedWriter( fw );
			
			
			
			
			bw.write(storage[0]);
			bw.newLine();
			bw.write(storage[1]);
			bw.newLine();
			bw.write(ilbl1[0] + "#" + ilbl1[3] + "#" + ilbl1[2]);//  총 입금액 , 현 투자금액, 아직 투자하지 않은 입금액
			bw.newLine();
	        bw.write(table.getValueAt(0, 7) + "#" + table.getValueAt(1,7) + "#" + table.getValueAt(2, 7) + "#" + table.getValueAt(3 ,7) + "#" + table.getValueAt(4, 7) + "#" + table.getValueAt(5, 7) + "#" + table.getValueAt(6, 7) + "#" + table.getValueAt(7,7));		// 이전 시세 0 * 8 
	        bw.newLine();
	        bw.write(table.getValueAt(0,8) + "#" + table.getValueAt(1,8) + "#" + table.getValueAt(2,8) + "#" + table.getValueAt(3,8) + "#" + table.getValueAt(4,8) + "#" + table.getValueAt(5,8) + "#" + table.getValueAt(6,8) + "#" + table.getValueAt(7,8));		//이전전 보유 수 0 * 8
	        

			bw.flush(); //버퍼의 내용을 파일에 쓰기
	        fw.close();
        }
        catch(IOException e1)
		{
            System.out.println(e1);
        }	
            
        					// LineNumber 최신화
        //********************************************************    
        try
        {
        	
        	File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null)
            {
            	tempnum += 1;					// 
            	if (line.contentEquals(storage[0]) )		// 입력된 아이디의 위치 라인인 LineNumber를 write후의 버전으로 업데이트.
            	{
            		LineNumber = tempnum;
            		break;
            	}
            }
            //.readLine()은 끝에 개행문자를 읽지 않는다.            
            bufReader.close();
            filereader.close();
        }
        catch(IOException e1)
		{
            System.out.println(e1);
        }	

        LineNumber = tempnum;
        
        
        FileM.MakeEncDec(); 		//		Info_b를 Info_a로 암호화.
		
		for (int i = 0; i<8; i++)
		{
			table.setValueAt(table.getValueAt(i, 7), i, 5);
			table.setValueAt(table.getValueAt(i, 8), i, 6);	
		}

		return LineNumber;
	}
	
	
	
	
	// *********************************************************************************************
	void delete(String filename, int startline, int numlines)			// 라인 제거 함수
	{
		try
		{
			BufferedReader br=new BufferedReader(new FileReader(filename));
 
			//String buffer to store contents of the file
			StringBuffer sb=new StringBuffer("");
 
			//Keep track of the line number
			int linenumber=1;
			String line;
 
			while((line=br.readLine())!=null)
			{
				//Store each valid line in the string buffer
				if(linenumber<startline||linenumber>=startline+numlines)
					sb.append(line+"\n");
				linenumber++;
			}
			if(startline+numlines>linenumber)
				System.out.println("End of file reached.");
			br.close();
 
			FileWriter fw=new FileWriter(new File(filename));
			//Write entire string buffer into the file
			fw.write(sb.toString());
			fw.close();
		}
		catch (Exception e)
		{
			System.out.println("Something went horribly wrong: "+e.getMessage());
		}
	}
}

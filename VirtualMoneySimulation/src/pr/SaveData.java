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
	 
	public int SaveData(int[] ilbl1, JTable table, int LineNumber)			// �ԷµǴ� �� : �ص��� ���̵��� LineNumber
	{ 
		for (int i = 0; i<8; i++)
		{
			table.setValueAt(table.getValueAt(i, 8), i, 6);
			table.setValueAt(table.getValueAt(i, 7), i, 5);
		}
		
		
		
		
		FileMaker FileM = new FileMaker();		// �α��� ��ư�� ������ FileMaker Ŭ������ DirMaker�� �۵�. Info.txt ����Ʈ
		FileM.MakeEncDec();						// ������ ������ ���� ���� �� default default�� �ؽ�Ʈ ���� ����. Info_b ����
		
		
		
		
		
		// Info_b�� LineNumber���� 1��°, 2��° ���� ����. ID�� PW
		//***************************************************************************
		
		
		try												// ù�� ���̵�, ��°�� ��й�ȣ, ��°�� ȭ�� ������ �� ���� ��ġ
		{
			
			//���� ��ü ����
            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            
            String line = "";
            //String[] storage = new String[2];
            
            int tempnum = 0;
            while((line = bufReader.readLine()) != null)
            {
            	tempnum += 1;					// 
            	if (LineNumber == tempnum )		// �Է� LineNumber�� ���̵� ��ġ�� ã�´�.
            	{
            		storage[0] = line;						// ���̵� ����
            		line = bufReader.readLine();
            		storage[1] = line;						// ��й�ȣ ����
            		break;
            	}
            }
            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
            bufReader.close();
            filereader.close();
		}
		catch(IOException e1)
		{
            System.out.println(e1);
        }	
            
            
            
         // Info_b�� LineNumber���� 5���� ����
    		//***************************************************************
		String filename="C:\\VirtualMoneySimulator\\Info_b.txt";
		//Enter starting line here
		int startline = LineNumber;
		//Enter number of lines here.
		int numlines = 5;
		delete(filename,startline,numlines);
    		
    		
    						// Info_b���� ������ ������ �ֽ�ȭ�� write
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
			bw.write(ilbl1[0] + "#" + ilbl1[3] + "#" + ilbl1[2]);//  �� �Աݾ� , �� ���ڱݾ�, ���� �������� ���� �Աݾ�
			bw.newLine();
	        bw.write(table.getValueAt(0, 7) + "#" + table.getValueAt(1,7) + "#" + table.getValueAt(2, 7) + "#" + table.getValueAt(3 ,7) + "#" + table.getValueAt(4, 7) + "#" + table.getValueAt(5, 7) + "#" + table.getValueAt(6, 7) + "#" + table.getValueAt(7,7));		// ���� �ü� 0 * 8 
	        bw.newLine();
	        bw.write(table.getValueAt(0,8) + "#" + table.getValueAt(1,8) + "#" + table.getValueAt(2,8) + "#" + table.getValueAt(3,8) + "#" + table.getValueAt(4,8) + "#" + table.getValueAt(5,8) + "#" + table.getValueAt(6,8) + "#" + table.getValueAt(7,8));		//������ ���� �� 0 * 8
	        

			bw.flush(); //������ ������ ���Ͽ� ����
	        fw.close();
        }
        catch(IOException e1)
		{
            System.out.println(e1);
        }	
            
        					// LineNumber �ֽ�ȭ
        //********************************************************    
        try
        {
        	
        	File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
            //�Է� ��Ʈ�� ����
            FileReader filereader = new FileReader(file);
            //�Է� ���� ����
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            while((line = bufReader.readLine()) != null)
            {
            	tempnum += 1;					// 
            	if (line.contentEquals(storage[0]) )		// �Էµ� ���̵��� ��ġ ������ LineNumber�� write���� �������� ������Ʈ.
            	{
            		LineNumber = tempnum;
            		break;
            	}
            }
            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
            bufReader.close();
            filereader.close();
        }
        catch(IOException e1)
		{
            System.out.println(e1);
        }	

        LineNumber = tempnum;
        
        
        FileM.MakeEncDec(); 		//		Info_b�� Info_a�� ��ȣȭ.
		
		for (int i = 0; i<8; i++)
		{
			table.setValueAt(table.getValueAt(i, 7), i, 5);
			table.setValueAt(table.getValueAt(i, 8), i, 6);	
		}

		return LineNumber;
	}
	
	
	
	
	// *********************************************************************************************
	void delete(String filename, int startline, int numlines)			// ���� ���� �Լ�
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

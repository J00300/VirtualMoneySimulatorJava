package pr;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
 

// 0219 ȸ������ �� �� ������ �߰� ���. ���ư��� ��ư Ȱ��ȭ �ʿ�.

public class TextField1 extends JFrame
{
	// ��ư ���� ����
    JButton btn1, btn2, btn3;
    boolean IDPW;
    boolean UnusableID;
    
    public TextField1(String str)    
    {
        super(str);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel Panels = new JPanel(); 
        setSize(280,280);
        Dimension frameSize = getSize();	// ������ ũ��
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// ����� ȭ�� ũ��
        // ������ ��ġ �߾� ����
        setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
        setResizable(false);
        
        // ���̺� ����
        JLabel lbl1 = new JLabel(" ID :           ");      
        JLabel lbl2 = new JLabel(" ��й�ȣ:");
        JLabel lbl3	= new JLabel(" ID�� ��й�ȣ�� �Է��Ͻÿ�");
        JLabel lbl0 = new JLabel("                                              ");		// ��ĭ
        JLabel lbl4	= new JLabel(" ��Ʈ ������ ó���� �ð��� �ɸ��ϴ�.");
        JLabel lbl5	= new JLabel("ũ�� ����̹��� �������� �����ֽʽÿ�.");
        JLabel lbl01 = new JLabel("                                              ");		// ��ĭ
        JLabel lbl02 = new JLabel("                                              ");		// ��ĭ
        JLabel lbl03 = new JLabel("������ - �����");		// ��ĭ
        // 20�ڸ� �ؽ�Ʈ �ʵ� ����      
        JTextField txt1 = new JTextField(18);
        JPasswordField txt2 = new JPasswordField(18);
        // ��й�ȣ * �� 
        txt2.setEchoChar('*');
        Panels.add(lbl1);
        Panels.add(txt1);
        Panels.add(lbl2);  
        Panels.add(txt2);
       

        btn1 = new JButton(" Login "); // ���̵� ��й�ȣ Ʋ���� PanelNum[2], ������ [1]
        btn2 = new JButton(" ȸ������ "); // PanelNum[3]
        btn3 = new JButton(" ���� ");
        // �гο� 3���� ��ư ����
        Panels.add(btn1); Panels.add(btn2); Panels.add(btn3);
        Panels.add(lbl3);
        Panels.add(lbl0);										//��ĭ
        Panels.add(lbl4);
        Panels.add(lbl5);
        Panels.add(lbl01);										//��ĭ
        Panels.add(lbl02);										//��ĭ
        Panels.add(lbl03);										

        

        // IDPW�� ID�� Password ��Ī �� ����. �߰� �ٶ�
        IDPW = false; // are ID and Password are correct? 
        
        // �α��� ��ư ���� �� boolean IDPW �� üũ.
        btn1.addActionListener(new ActionListener()
        { 
        	
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		
        		FileMaker FileM = new FileMaker();		// �α��� ��ư�� ������ FileMaker Ŭ������ DirMaker�� �۵�. Info.txt ����Ʈ
        		FileM.MakeEncDec();						// ������ ������ ���� ���� �� default default�� �ؽ�Ʈ ���� ����. Info_b ����
        		
        		
        		// ID�� Password�� info�� ���� �Ͱ� ������ Ȯ�� �۾�
        		int LineNumber = 0;	// �ٹٲ� Ƚ�� 
        		
        		
    			try
    			{
    	            //���� ��ü ����
    	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
    	            //�Է� ��Ʈ�� ����
    	            FileReader filereader = new FileReader(file);
    	            //�Է� ���� ����
    	            BufferedReader bufReader = new BufferedReader(filereader);
    	            String line = "";
    	            while((line = bufReader.readLine()) != null)
    	            {
    	            	LineNumber = LineNumber + 1;			// LineNumber ��° �ٿ� ID�� ����
    	            	if (line.equals(txt1.getText()) )		// �Է� ���̵� ã�´�. ��й�ȣ�� �޸��忡 ***�� ����
    	            	{
    	            		// getPassword()�� ***�� �Էµ� ��й�ȣ�� �ص��ϳ� �� ���°� char �̹Ƿ� string���� �ٲ��� �ʿ䰡 �ִ�.
    	        			String pw2 = "";
    	        			char[] secret_pw2 = txt2.getPassword(); //secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ���� 
    	        			for(char cha : secret_pw2)
    	        			{ 
    	        				Character.toString(cha); // cha �� ����� �� string���� ��ȯ //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿����� 
    	        				pw2 += (pw2.equals("")) ? ""+cha+"" : ""+cha+""; 
    	        			}
    	        			String nxtline = bufReader.readLine();
    	        			pw2 = "****" + pw2;
    	        			
    	            		if (pw2.equals(nxtline))
    	            		{
    	            			IDPW = true;
    	            			break;
    	            		}
    	            		
    	            		else
    	            		{
    	            			IDPW = false;
    	            		}
    	            	}
    	            	
    	            }
    	            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
    	            bufReader.close();

    	        }
    			catch (FileNotFoundException e1)
    			{
    	            // TODO: handle exception
    	        }
    			catch(IOException e1)
    			{
    	            System.out.println(e1);
    	        }
        		
    			FileM.MakeEncDec(); 		//		Info_b�� Info_a�� ��ȣȭ.
        		
        		
        		if (IDPW == true)	// IDPW == true. �޸���� ��ȣȭ �ʿ�.
        		{
        			// ��� ������Ʈ �����
        			setVisible(false);
        			new Simulator(LineNumber);

        			
        		    
        			
        			//lbl3.setText("�α���.");
        			
        			
        			
        		}
        		
        		else	// ID�� PW�� ���� ���� ��
        		{
        			lbl3.setText("ID�� ��й�ȣ�� �߸� �Է��ϼ̽��ϴ�.");
        		}
        		
       		}
       	});

        btn2.addActionListener(new ActionListener()			//ȸ������ ��ư �̺�Ʈ
        { 
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		// ���� �г� ����
        		JFrame Frame2 = new JFrame("����ȭ�� �ùķ�����");
    			JPanel Panel2 = new JPanel();
    			Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			setResizable(true);
    			Frame2.setSize(280,280);
    			Dimension frameSize = Frame2.getSize();	// ������ ũ��
    		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// ����� ȭ�� ũ��
    		    // ������ ��ġ �߾� ����
    		    Frame2.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
    		    Frame2.setResizable(false);
    		    
    		    JButton btn21, btn22;
    		    
    		    JLabel lbl21 = new JLabel(" ID :            ");      
    	        JLabel lbl22 = new JLabel(" ��й�ȣ:");
    	        JLabel lbl23 = new JLabel(" 2�� Ȯ��: ");
    	        JLabel lbl24	= new JLabel(" ��� �� ID�� ��й�ȣ�� �Է��Ͻÿ�");
    	        // 20�ڸ� �ؽ�Ʈ �ʵ� ����      
    	        JTextField txt21 = new JTextField(18);
    	        JPasswordField txt22 = new JPasswordField(18);
    	        JPasswordField txt23 = new JPasswordField(18);
    	        // ��й�ȣ * �� 
    	        txt2.setEchoChar('*');
    	        Panel2.add(lbl21);
    	        Panel2.add(txt21);
    	        Panel2.add(lbl22);  
    	        Panel2.add(txt22);
    	        Panel2.add(lbl23);
    	        Panel2.add(txt23);
    	       

    	        btn21 = new JButton(" ȸ������ "); // ���̵� ��й�ȣ Ʋ���� PanelNum[2], ������ [1]
    	        btn22 = new JButton(" ���� "); // PanelNum[3]
    	        // �гο� 3���� ��ư ����
    	        Panel2.add(btn21); Panel2.add(btn22);
    	        Panel2.add(lbl24);
    		    
    		    
    		    
    		    Frame2.add(Panel2);
    		    
    		    setVisible(false);
    		    Frame2.setVisible(true);
    		    
    		    	    
    		    // ȸ�������ϱ� ��ư
    		    btn21.addActionListener(new ActionListener()
    	        { 
    	        	
    	        	public void actionPerformed(ActionEvent e) 
    	        	{
    	        		FileMaker FileM = new FileMaker();		// MakeEncDec �޼ҵ�� ������ ������ Info_a�� Info_b�� �ص�
    	        		FileM.MakeEncDec();						// ������ ������ ���� ���� �� default default�� �ؽ�Ʈ ���� Info_b ����. 
    	        		
    	        		// ID�� Password�� info�� ���� �Ͱ� ������ Ȯ�� �۾�
    	        		int LineNumber = 0;	// �ٹٲ� Ƚ�� 
    	        		
    	        		
    	    			try												// ù�� ���̵�, ��°�� ��й�ȣ, ��°�� ȭ�� ������ �� ���� ��ġ
    	    			{
    	    	            //���� ��ü ����
    	    	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
    	    	            //�Է� ��Ʈ�� ����
    	    	            FileReader filereader = new FileReader(file);
    	    	            //�Է� ���� ����
    	    	            BufferedReader bufReader = new BufferedReader(filereader);
    	    	            String line = "";
    	    	            
    	    	            LineNumber = 0;
    	    	            while((line = bufReader.readLine()) != null)
    	    	            {
    	    	            	LineNumber = LineNumber + 1;			// LineNumber ��° �ٿ� ID�� ����

    	    	            	if (line.equals(txt21.getText()) )		// �Է� ���̵� ã�´�.
    	    	            	{
    	    	            		UnusableID = true;
    	    	            		break;
    	    	            	}
    	    	            	else
    	    	            	{
    	    	            		UnusableID = false;
    	    	            	}
    	    	            }
    	    	            //.readLine()�� ���� ���๮�ڸ� ���� �ʴ´�.            
    	    	            bufReader.close();

    	    	        }
    	    			catch (FileNotFoundException e1)
    	    			{
    	    	            
    	    	        }
    	    			catch(IOException e1)
    	    			{
    	    	            System.out.println(e1);
    	    	        }
    	    			
    	    			
    	    			if (UnusableID == true)	// �̹� ���ǰ��ִ� ���̵�
    	        		{
    	        			lbl24.setText("�̹� ���ǰ��ִ� ID�Դϴ�.");
    	        		}
    	        		
    	        		else	// ��� �� �� �ִ� ID�� ��
    	        		{
    	        			// getPassword()�� ***�� �Էµ� ��й�ȣ�� �ص��ϳ� �� ���°� char �̹Ƿ� string���� �ٲ��� �ʿ䰡 �ִ�.
    	        			String pw22 = "";
    	        			char[] secret_pw22 = txt22.getPassword(); //secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ���� 
    	        			for(char cha : secret_pw22)
    	        			{ 
    	        				Character.toString(cha); // cha �� ����� �� string���� ��ȯ //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿����� 
    	        				pw22 += (pw22.equals("")) ? ""+cha+"" : ""+cha+""; 
    	        			}
	    	    			
    	        			String pw23 = "";
    	        			char[] secret_pw23 = txt23.getPassword(); //secret_pw �迭�� ����� ��ȣ�� �ڸ��� ��ŭ for�� �����鼭 cha �� �� ���ھ� ���� 
		        			for(char cha : secret_pw23)
		        			{ 
		        				Character.toString(cha); // cha �� ����� �� string���� ��ȯ //pw �� �����ϱ�, pw �� ���� ��������� ����, ���� ������ �̾ �����ϴ� ���׿����� 
		        				pw23 += (pw23.equals("")) ? ""+cha+"" : ""+cha+"";
		        			}

    	        			
    	        			if (pw22.equals(pw23))	// �� �Է� ��й�ȣ�� ��ġ��. ��й�ȣ ���� �� **** �߰�.
    	        			{
    	        				// �ؽ�Ʈ ���Ͽ� �߰� �� ��ȣȭ.
    	        				FileWriter fw = null ;
    	        				BufferedWriter bw = null;

    	        				try
    	        				{
    	        						lbl24.setText("��ġ");		// ���ư��� ��ư ���� ���
    	        					
    	        						//���� ����
    	        						fw = new FileWriter( "C:/VirtualMoneySimulator/Info_b.txt", true );
    	        						bw = new BufferedWriter( fw );
    	        						bw.newLine();
    	        						bw.write(txt21.getText()); //���ۿ� ������ �Է�
    	        						bw.newLine(); //���ۿ� ���� ����
    	        						bw.write("****" + pw23);
    	        						bw.newLine();
    	        						bw.write( "0#0#0");//  �ѱݾ� 0, ���� ������ 0, ���ھ� 0
    	        						bw.newLine();
    	        			            bw.write("0#0#0#0#0#0#0#0");		// ���� �ü� 0 * 8 
    	        			            bw.newLine();
    	        			            bw.write("0#0#0#0#0#0#0#0");		//���� ���� �� 0 * 8
    	        						
    	        						bw.flush(); //������ ������ ���Ͽ� ����

    	        				}
    	        				catch ( IOException e1 ) 
    	        				{
    	        					System.out.println(e1);
    	        				}
    	        				finally
    	        				{
    	        					try { fw.close(); } catch ( IOException e1 ) {}
    	        					try { bw.close(); } catch ( IOException e1 ) {}
    	        				}
    	        				
    	        				FileM.MakeEncDec();						// Info_b�� �ٽ� Info_a�� �����.
    	        								// ȸ������ �Ϸ� ������
    	        				
    	        				JFrame Frame3 = new JFrame("����ȭ�� �ùķ�����");
    	            			JPanel Panel3 = new JPanel();
    	            			Frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	            			setResizable(true);
    	            			Frame3.setSize(280,280);
    	            			Dimension frameSize = Frame2.getSize();	// ������ ũ��
    	            		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// ����� ȭ�� ũ��
    	            		    // ������ ��ġ �߾� ����
    	            		    Frame3.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
    	            		    Frame3.setResizable(false);
    	            		    
    	            		    JButton btn31, btn32;
    	            		    
    	            		    JLabel lbl31 = new JLabel(" ȸ�������� �Ϸ�Ǿ����ϴ�. ");
    	            	        btn31 = new JButton(" ���ư��� "); 
    	            	        btn32 = new JButton(" ���� "); 
    	            	       
    	            	        Panel3.add(btn31); Panel3.add(btn32);
    	            	        Panel3.add(lbl31);
    	            		    
    	            	        btn31.addActionListener(new ActionListener()
    	            	        { 
    	            	        	public void actionPerformed(ActionEvent e) 
    	            	        	{ 
    	            	        		Frame3.setVisible(false);
    	            	        		setVisible(true);
    	            	        	}
    	            	        });
    	            	        
    	            	        btn32.addActionListener(new ActionListener()	// ���� ��ư
    	            	        { 
    	            	        	public void actionPerformed(ActionEvent e) 
    	            	        	{ 
    	            	        		System.exit(0); // â �ݱ�
    	            	        	}
    	            	        });
    	            		    
    	            		    
    	            		    Frame3.add(Panel3);
    	            		    
    	            		    Frame2.setVisible(false);
    	            		    Frame3.setVisible(true);
    	            		    
    	        				
    	        				
    	        			}
    	        			
    	        			else								// �� �Է� ��й�ȣ�� ��ġ���� ����
    	        			{
    	        				lbl24.setText("Ȯ�ε� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
    	        			}
    	        			
    	        		}
    	    			
    	    			
    	        	}
    	        	
    	        });
    	        		
        		
        		// ���� ��ư.
    		    btn22.addActionListener(new ActionListener()
    		    { 
    		    	public void actionPerformed(ActionEvent e) 
    		    	{ 
    		    		System.exit(0); // â �ݱ�
    		    	}
    		    });
        		
       		}
       	});
       
     
        
        
        // ���� ��ư.
        btn3.addActionListener(new ActionListener()
        { 
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		System.exit(0); // â �ݱ�
       		}
       	});
        
        add(Panels);

        

        
        // x ������ �ݱ�
        addWindowListener(new WindowAdapter() 
        {
        	public void windowClosing(WindowEvent e) 
        	{
        		System.exit(0);
        	}
        }); // x ������ �ݱ�
        setVisible(true);  

    }

}

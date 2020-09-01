package pr;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableCellRenderer;




//	02/24 : �� �� ��ư ��ġ. ��Ʈ ��ư ���� �����.

public class Simulator extends JFrame		// �ùķ����� â
{	
	JTable table;
	JScrollPane scroll; // ���̺� ���� �� ���� �־�����~ scroll
	String[] [] data = new String[9][8]; // 
	int[] ilbl1 = new int[4];
	String[] beforeUpdate = new String[8];
	String[] afterUpdate = new String[8];
	boolean moneyUpdate;
	String[] title = {"��ȣȭ���","�ǽð� �ü�","������(���ϴ��)","�ŷ��ݾ�(24H)", "�ð� �Ѿ�", "���� ���� ����", "���� ��ġ", "���� ���� ����", "���� �ݾ� ����"}; //�÷��� ���� ������ ǥ���� 1���� �迭
	int maxsizex = 1280;
	int maxsizey = 720;
	private final static String addr = "https://www.bithumb.com/";
	String chartweb = null;
	BufferedImage img = null;
	int TempNum = 0;
	
	public Simulator(int LineNum)			// �ԷµǴ� �� : ���̵� Linenumber
	{ 
		
		 super("����ȭ�� �ùķ�����");			// ������ �̸�
		 
		 JPanel Panels = new JPanel();
	  
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 pack();
		 setSize(maxsizex, maxsizey);
		 Panels.setSize(maxsizex, maxsizey);
		 Dimension frameSize = getSize();	// ������ ũ��
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// ����� ȭ�� ũ��
	     // ������ ��ġ �߾� ����
	     setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
	     setResizable(false);
		 setVisible(true);
		 
		 
		 JButton btn_update = new JButton("<html>����<br />������Ʈ</html>"); 	// ���� ��� ��ư
		 JButton btn_save = new JButton(" ���� ");
		 JButton btn_exit = new JButton(" ���� "); 
		  
		
	     Panels.add(btn_update);
	     Panels.add(btn_save);
	     Panels.add(btn_exit);
	     Panels.setLayout(null);	
	     btn_update.setBounds(930, 30, 90, 70);
		 btn_save.setBounds(1050, 30, 90, 70);
		 btn_exit.setBounds(1160, 30, 90, 70);
	     
	     
		 
		 JButton btn1 = new JButton("��Ʈ����");	// ���� �߾� ��ư 2�� 3��. ���� �� ��Ʈ�� ������.
		 JButton btn2 = new JButton("����");
		 JButton btn3 = new JButton("�̴�����");
		 JButton btn4 = new JButton("�̿���");
		 JButton btn5 = new JButton("<html>��Ʈ����<br />��������</html>");
		 JButton btn6 = new JButton("��Ʈ���� ĳ��");
		 JButton btn7 = new JButton("����Ʈ����");
		 JButton btn8 = new JButton("ü�θ�ũ");
		 Panels.add(btn1);
	     Panels.add(btn2);
	     Panels.add(btn3);
	     Panels.add(btn4);
	     Panels.add(btn5);
	     Panels.add(btn6);
	     Panels.add(btn7);
	     Panels.add(btn8);
	     
	     btn1.setBounds(960, 120, 120, 60);				// ���� �߾� 2�� 4��
	     btn2.setBounds(1110, 120, 120, 60);
	     btn3.setBounds(960, 190, 120, 60);
	     btn4.setBounds(1110, 190, 120, 60);
	     btn5.setBounds(960, 260, 120, 60);
	     btn6.setBounds(1110, 260, 120, 60);
	     btn7.setBounds(960, 330, 120, 60);
	     btn8.setBounds(1110, 330, 120, 60);
	     
	     //JButton btn1 = new JButton("���ڱ� ����");	// �߰� ����
		 //JButton btn2 = new JButton("��ȣȭ�� ���� & �Ǹ�");
	     
	     ilbl1[0] = 0;		// �� �Աݾ�. �ؽ�Ʈ ���Ͽ� ****#0#0 ���� �����.
	     ilbl1[1] = 0;		// �� ������.  �� �����ݾװ� �� ���ڱݾ��� �ջ�.
	     ilbl1[2] = 0;					// ���� �������� ���� �Աݾ�.  0#0#**** ���� �����.
	     ilbl1[3] = 0;					// �� ���ڱݾ�. �ؽ�Ʈ���Ͽ� 0#****#0 ���� �����.
	     
	     
         TempNum = LineNum;			// LineNum�� ������ �����Ƿ� TempNum�� ������� ���
         
         
         GetData a = new GetData();
         data = a.GetData(data, addr, TempNum);
         ilbl1 = a.GetData(data, ilbl1, TempNum);

         table = new JTable(data, title) // table=new JTable(������-2�����迭, �÷��迭)
		 {
			 @Override
			 public boolean isCellEditable(int row, int column)			// ǥ �� ���� ����
		  	 {
				 if (column >= 8)										// ���� ���� �ݾ׸� ���� ����
				 {
					 return true;
				 }
				 else
				 {
					 return false;
				 }
 		   	 }
			 @Override public Component prepareRenderer(TableCellRenderer renderer, int row, int column) 
			 { 
				 JComponent component = (JComponent) super.prepareRenderer(renderer, row, column); 		// ǥ ���� ����
				 
				 if (row % 2 == 0)
				 {
					 component.setBackground(Color.PINK);  
				 }
				 else
				 {
					 component.setBackground(Color.YELLOW);  
				 }
				 if (column == 8)
				 {
					 component.setBackground(Color.WHITE);
					 component.setForeground(Color.BLUE);
				 }
				 else
				 {
					 component.setForeground(Color.BLACK);
				 }
				 return component;
			 }

 		 };
 		 
 		 
 		 
 		 
 		 
 		 
 		 
 		 JLabel lbl1 = new JLabel("�� �Աݾ� : " + ilbl1[0]);     // �� ���� �ݾ�, �� �ڻ�, ���� ���� �ݾ�
         JLabel lbl2 = new JLabel("�� �����ݾ� : " + ilbl1[1]);	// 2 �κп��� �ؽ�Ʈ���� ���� ������ �ٿ��� ��.
         JLabel lbl3 = new JLabel("�� �����ݾ� : " + ilbl1[2]);
         JLabel lbl4 = new JLabel("�� ���ڱݾ� : " + ilbl1[3]);

         Panels.add(lbl1);
         Panels.add(lbl2);
         Panels.add(lbl3);
         Panels.add(lbl4);
        
         lbl1.setBounds(930, 415, 160, 13);				// ���� ǥ�� ��Ʈ ��ư ����
	     lbl2.setBounds(930, 430, 160, 13);
	     lbl3.setBounds(930, 445, 160, 13);
	     lbl4.setBounds(930, 460, 160, 13);
      

        JButton btn_deposit = new JButton("�߰� �Ա�"); 			//�߰� �ݾ� 						//���߰�
        Panels.add(btn_deposit); 
        btn_deposit.setBounds(1160, 410, 90, 50);				// ���� �߾� 2�� 4��
		 
        JLabel lbl5 = new JLabel(" �Աݾ� : ");      
        JTextField txt1 = new JTextField(18);
        txt1.setText("0");
        
        Panels.add(lbl5);
        Panels.add(txt1);
        lbl5.setBounds(1120, 470, 90, 30);
        txt1.setBounds(1180, 470, 90, 30);
        
        int Deposit = 0;				// �߰� �Աݾ� �Է�
        
        for (int i = 0; i< 8; i++)
        {
        	beforeUpdate[i] = table.getValueAt(i, 8).toString();
        }
        
 		 
		 
		 table.setBounds(20, 510, 1240, 170);
		 table.getTableHeader().setReorderingAllowed(false);	// ��� �� �̵� �Ұ�
		 table.getTableHeader().setResizingAllowed(false);		// ũ�� ���� �Ұ�
		 
		 scroll = new JScrollPane(table);
		 scroll.setBounds(20, 510, 1240, 170);
		 
		 Panels.add(scroll);
		 
		 
 		ImageIcon originIcon = new ImageIcon("BTC.png");  
 		Image originImg = originIcon.getImage(); 

 		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

 		ImageIcon Icon = new ImageIcon(changedImg);

 		JLabel charts = new JLabel();
	 	charts.setIcon(Icon);
	 	charts.setBounds(5, 5, 910, 500);
	 	Panels.add(charts);
     
		 
		 add(Panels);
		 
		 // �ֽ�ȭ ��ư
		
		 
		
		 
		btn_update.addActionListener(new ActionListener()		// ���� ��� �ü� �� ���ھ� �ֽ�ȭ ��ư
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 	 
	        	for (int i = 0; i< 8; i++)
	            {
	            	afterUpdate[i] = table.getValueAt(i, 8).toString();
	            }
	        	
	        	moneyUpdate = true; 							//�� �Է°��� ���̺� �ԷµǾ��ִ� ���� �ٸ� ���
	        	
	        	for(int i = 0; i<8; i++)
	        	{
	        		if (beforeUpdate[i].contentEquals(afterUpdate[i]) == false)			//�� �Է°��� ���̺� �ԷµǾ��ִ� ���� �ٸ� ��� moneyUpdate = true
	        		{
	        			moneyUpdate = true;
	        			break;
	        		}
	        		moneyUpdate = false;													// �� �Է°��� ���̺� �ԷµǾ��� ���� ���� ��� false
	        	}
	        	
	     		
     			refresh(Panels, scroll, table, data, ilbl1, TempNum, moneyUpdate);
	        	Update up = new Update(table, data, addr, ilbl1, TempNum, moneyUpdate);    	 		
    	 		lbl1.setText("�� �Աݾ� : " + ilbl1[0]);     // �� ���� �ݾ�, �� �ڻ�, ���� ���� �ݾ�
    	        lbl2.setText("�� �����ݾ� : " + ilbl1[1]);	// 2 �κп��� �ؽ�Ʈ���� ���� ������ �ٿ��� ��.
    	        lbl3.setText("�� �����ݾ� : " + ilbl1[2]);
    	        lbl4.setText("�� ���ڱݾ� : " + ilbl1[3]);
    	 		 
    	 		System.out.println(";;;;;;;;;;;;;;");  
    	 		
    	 		for (int i = 0; i< 8; i++)
    	        {
    	        	beforeUpdate[i] = table.getValueAt(i, 8).toString();
    	        }
	     		
	        }
	    }); 
		 
		 btn_save.addActionListener(new ActionListener()		// ���� ��� ���� ��ư
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	
	        			// ������Ʈ ��ư ���� �߰�
	        	//**************************************
	        	for (int i = 0; i< 8; i++)
	            {
	            	afterUpdate[i] = table.getValueAt(i, 8).toString();
	            }
	        	
	        	moneyUpdate = true; 							//�� �Է°��� ���̺� �ԷµǾ��ִ� ���� �ٸ� ���
	        	
	        	for(int i = 0; i<8; i++)
	        	{
	        		if (beforeUpdate[i].contentEquals(afterUpdate[i]) == false)			//�� �Է°��� ���̺� �ԷµǾ��ִ� ���� �ٸ� ��� moneyUpdate = true
	        		{
	        			moneyUpdate = true;
	        			break;
	        		}
	        		moneyUpdate = false;													// �� �Է°��� ���̺� �ԷµǾ��� ���� ���� ��� false
	        	}
	        	
	     		
     			refresh(Panels, scroll, table, data, ilbl1, TempNum, moneyUpdate);
	        	Update up = new Update(table, data, addr, ilbl1, TempNum, moneyUpdate);
	        	
 	        	
    	 		lbl1.setText("�� �Աݾ� : " + ilbl1[0]);     // �� ���� �ݾ�, �� �ڻ�, ���� ���� �ݾ�
    	        lbl2.setText("�� �����ݾ� : " + ilbl1[1]);	// 2 �κп��� �ؽ�Ʈ���� ���� ������ �ٿ��� ��.
    	        lbl3.setText("�� �����ݾ� : " + ilbl1[2]);
    	        lbl4.setText("�� ���ڱݾ� : " + ilbl1[3]);
    	 		 
    	 		
    	 		for (int i = 0; i< 8; i++)
    	        {
    	        	beforeUpdate[i] = table.getValueAt(i, 8).toString();
    	        }
	        	
	        	//*************************************
	        	SaveData n = new SaveData();
    	 		int num = n.SaveData(ilbl1, table, TempNum);
	        	
	        	TempNum = num;
	        	

	       	}
	    });  
		
		
		
		btn_deposit.addActionListener(new ActionListener()		// ���� �Ա� ��ư
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	
	        	try
	        	{
	        		if (ilbl1[0] > 1000000000)
		        	{
		        		txt1.setText("10�� �̻� �Ұ�");
		        	}
		        	else
		        	{
		        		ilbl1[0] += Integer.parseInt(txt1.getText());		// �� �Աݾ�. �ؽ�Ʈ ���Ͽ� ****#0#0 ���� �����.
			        	ilbl1[1] += Integer.parseInt(txt1.getText());		// �� ������.  �� �����ݾװ� �� ���ڱݾ��� �ջ�.
			        	ilbl1[2] += Integer.parseInt(txt1.getText());		// ���� �������� ���� �Աݾ�.  0#0#**** ���� �����.
			        														// ilbl1[3] �� ���ڱݾ�. �ؽ�Ʈ���Ͽ� 0#****#0 ���� �����.
			        	txt1.setText("0");
			        	lbl1.setText("�� �Աݾ� : " + ilbl1[0]);     // �� ���� �ݾ�, �� �ڻ�, ���� ���� �ݾ�
			            lbl2.setText("�� �ڻ� : " + ilbl1[1]);	// 2 �κп��� �ؽ�Ʈ���� ���� ������ �ٿ��� ��.
			            lbl3.setText("�� �����ݾ� : " + ilbl1[2]);
			            lbl4.setText("�� ���ڱݾ� : " + ilbl1[3]);
		        	}
	        	}
	        	
	        	catch (NumberFormatException e2)
	        	{
	        		txt1.setText("10�� �̻� �Ұ�");
	        	}
	        	
	        	
	        	
	       	}
	    });
		
		//*************************

		
		btn1.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	
	        	ImageIcon originIcon = new ImageIcon("BTC.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		
		btn2.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("XRP.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		btn3.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("ETH.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		btn4.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("EOS.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		btn5.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("BSV.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		btn6.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("BCH.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
		btn7.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("LTC.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });

		btn8.addActionListener(new ActionListener()		// ��Ʈ���� ��Ʈ �����ֱ� ��ưasasasasaasasa****
	    { 
	        public void actionPerformed(ActionEvent e) 
	        {
	        	ImageIcon originIcon = new ImageIcon("LINK.png");  
	     		Image originImg = originIcon.getImage(); 

	     		Image changedImg= originImg.getScaledInstance(910, 500, Image.SCALE_SMOOTH );

	     		ImageIcon Icon = new ImageIcon(changedImg);
	        	charts.setIcon(Icon);
        		Panels.repaint();
	       	}
	    });
		
 
		 
		 
		btn_exit.addActionListener(new ActionListener()		// ���� �����ư
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	System.exit(0); // â �ݱ�
	       	}
	    });
		
		
		
	}
	
	
	//				Table�� ������ �����Ϳ� ������� �޼ҵ�. update ������ ���ȴ�.
	//*********************************************************
	void refresh(JPanel Panels, JScrollPane scroll, JTable table, String[] [] data, int ilbl1[], int LineNum, boolean moneyUpdate)
	{
		// table�� �Է��� ���� �ݾ׶��� ������ ǥ data�� �Է�
		String[] title = {"��ȣȭ���","�ǽð� �ü�","������(���ϴ��)","�ŷ��ݾ�(24H)", "�ð� �Ѿ�", "���� ���� ����", "���� ��ġ", "���� ���� ����", "���� �ݾ� ����"}; //�÷��� ���� ������ ǥ���� 1���� �迭
		String addr = "https://www.bithumb.com/";
		int[] t = new int[8];
		float[] f = new float[8];
		
		
		CheckNumber Checker = new CheckNumber();
		boolean b0 = Checker.CheckNumber(table.getValueAt(0, 8).toString());
		boolean b1 = Checker.CheckNumber(table.getValueAt(1, 8).toString());
		boolean b2 = Checker.CheckNumber(table.getValueAt(2, 8).toString());
		boolean b3 = Checker.CheckNumber(table.getValueAt(3, 8).toString());
		boolean b4 = Checker.CheckNumber(table.getValueAt(4, 8).toString());
		boolean b5 = Checker.CheckNumber(table.getValueAt(5, 8).toString());
		boolean b6 = Checker.CheckNumber(table.getValueAt(6, 8).toString());
		boolean b7 = Checker.CheckNumber(table.getValueAt(7, 8).toString());
		
		if (b0&&b1&&b2&&b3&&b4&&b5&&b6&&b7 == true)
		{
			if (moneyUpdate == true)							// ����� ���ڱݾ��� �������� ȭ�� ������ ����
			{
				t[0] = Integer.parseInt(table.getValueAt(0, 8).toString());	// table�� ���� �ݾ׶��� ���� ������ ��ȯ
				t[1] = Integer.parseInt(table.getValueAt(1, 8).toString());
				t[2] = Integer.parseInt(table.getValueAt(2, 8).toString());
				t[3] = Integer.parseInt(table.getValueAt(3, 8).toString());
				t[4] = Integer.parseInt(table.getValueAt(4, 8).toString());
				t[5] = Integer.parseInt(table.getValueAt(5, 8).toString());
				t[6] = Integer.parseInt(table.getValueAt(6, 8).toString());
				t[7] = Integer.parseInt(table.getValueAt(7, 8).toString());
				
				int temp = 0;
				for (int j = 0; j<8; j++)
				{
					temp += t[j];			 //�� ȭ�� ���� ���ھ��� ��
				}
				
				// �� �������� �� ���ھ��� �պ��� ���� ���. ilbl1[1] �� �� ���ھ�
				if (temp > ilbl1[1])
				{
					// �ڱ��� �����մϴ� ���.
					table.setValueAt("�߰� �Ա��� �ʿ��մϴ�.", 0, 8);
				}
				
				else		// �� �������� �� ���ھ׺��� Ŭ ���
				{
					for (int i = 0; i < 8; i++)	// �� ȭ�� ���� �ݾ׿��� ���� ȭ�� ������ ������ ȭ�� ���� ���� ���
					{
						f[i] = Float.parseFloat(table.getValueAt(i, 8).toString()) / (Float.parseFloat(table.getValueAt(i, 1).toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("��", "")));
						table.setValueAt(String.format("%.6f", f[i]), i, 7);
					}
					
					
					for (int i = 0; i<8; i++)
					{
						data[i][7] = table.getValueAt(i, 7).toString();
					}
				}
			}
			
			
			else											// ȭ�� ������ �״�� �ΰ� ���ڱݾ��� ���ü����� ���߾� ����	
			{	
				int temp = 0;
				for (int j = 0; j<8; j++)
				{
					temp += t[j];			 //�� ȭ�� ���� ���ھ��� ��
				}
				
				// �� �������� �� ���ھ��� �պ��� ���� ���. ilbl1[1] �� �� ���ھ�
				if (temp > ilbl1[1])
				{
					// �ڱ��� �����մϴ� ���.
					table.setValueAt("�߰� �Ա��� �ʿ��մϴ�.", 0, 8);
				}
				
				else		// �� �������� �� ���ھ׺��� Ŭ ���
				{
					
					for (int i = 0; i<8; i++)
					{
						data[i][7] = table.getValueAt(i, 7).toString();
					}
				}
			}
			
		}
		else
		{
			table.setValueAt("���ڸ� �Է��� �ֽʽÿ�", 0, 8);
		}
		
		
		
	}
	
	
}

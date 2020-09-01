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




//	02/24 : 라벨 및 버튼 배치. 차트 버튼 변경 고려중.

public class Simulator extends JFrame		// 시뮬레이터 창
{	
	JTable table;
	JScrollPane scroll; // 테이블 위에 열 라벨을 넣어주자~ scroll
	String[] [] data = new String[9][8]; // 
	int[] ilbl1 = new int[4];
	String[] beforeUpdate = new String[8];
	String[] afterUpdate = new String[8];
	boolean moneyUpdate;
	String[] title = {"암호화폐명","실시간 시세","변동률(전일대비)","거래금액(24H)", "시가 총액", "이전 보유 수량", "이전 가치", "현재 보유 수량", "투자 금액 변경"}; //컬럼의 제목 정보를 표현할 1차원 배열
	int maxsizex = 1280;
	int maxsizey = 720;
	private final static String addr = "https://www.bithumb.com/";
	String chartweb = null;
	BufferedImage img = null;
	int TempNum = 0;
	
	public Simulator(int LineNum)			// 입력되는 값 : 아이디 Linenumber
	{ 
		
		 super("가상화폐 시뮬레이터");			// 프레임 이름
		 
		 JPanel Panels = new JPanel();
	  
		 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 pack();
		 setSize(maxsizex, maxsizey);
		 Panels.setSize(maxsizex, maxsizey);
		 Dimension frameSize = getSize();	// 프레임 크기
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// 모니터 화면 크기
	     // 프레임 위치 중앙 설정
	     setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
	     setResizable(false);
		 setVisible(true);
		 
		 
		 JButton btn_update = new JButton("<html>정보<br />업데이트</html>"); 	// 우측 상단 버튼
		 JButton btn_save = new JButton(" 저장 ");
		 JButton btn_exit = new JButton(" 종료 "); 
		  
		
	     Panels.add(btn_update);
	     Panels.add(btn_save);
	     Panels.add(btn_exit);
	     Panels.setLayout(null);	
	     btn_update.setBounds(930, 30, 90, 70);
		 btn_save.setBounds(1050, 30, 90, 70);
		 btn_exit.setBounds(1160, 30, 90, 70);
	     
	     
		 
		 JButton btn1 = new JButton("비트코인");	// 우측 중앙 버튼 2행 3열. 종목 별 차트로 보여줌.
		 JButton btn2 = new JButton("리플");
		 JButton btn3 = new JButton("이더리움");
		 JButton btn4 = new JButton("이오스");
		 JButton btn5 = new JButton("<html>비트코인<br />에스브이</html>");
		 JButton btn6 = new JButton("비트코인 캐시");
		 JButton btn7 = new JButton("라이트코인");
		 JButton btn8 = new JButton("체인링크");
		 Panels.add(btn1);
	     Panels.add(btn2);
	     Panels.add(btn3);
	     Panels.add(btn4);
	     Panels.add(btn5);
	     Panels.add(btn6);
	     Panels.add(btn7);
	     Panels.add(btn8);
	     
	     btn1.setBounds(960, 120, 120, 60);				// 우측 중앙 2행 4열
	     btn2.setBounds(1110, 120, 120, 60);
	     btn3.setBounds(960, 190, 120, 60);
	     btn4.setBounds(1110, 190, 120, 60);
	     btn5.setBounds(960, 260, 120, 60);
	     btn6.setBounds(1110, 260, 120, 60);
	     btn7.setBounds(960, 330, 120, 60);
	     btn8.setBounds(1110, 330, 120, 60);
	     
	     //JButton btn1 = new JButton("투자금 투입");	// 추가 투자
		 //JButton btn2 = new JButton("암호화폐 구입 & 판매");
	     
	     ilbl1[0] = 0;		// 총 입금액. 텍스트 파일에 ****#0#0 으로 저장됨.
	     ilbl1[1] = 0;		// 총 보유액.  현 보유금액과 현 투자금액의 합산.
	     ilbl1[2] = 0;					// 아직 투자하지 않은 입금액.  0#0#**** 으로 저장됨.
	     ilbl1[3] = 0;					// 총 투자금액. 텍스트파일에 0#****#0 으로 저장됨.
	     
	     
         TempNum = LineNum;			// LineNum이 변하지 않으므로 TempNum을 대용으로 사용
         
         
         GetData a = new GetData();
         data = a.GetData(data, addr, TempNum);
         ilbl1 = a.GetData(data, ilbl1, TempNum);

         table = new JTable(data, title) // table=new JTable(데이터-2차원배열, 컬럼배열)
		 {
			 @Override
			 public boolean isCellEditable(int row, int column)			// 표 셀 수정 방지
		  	 {
				 if (column >= 8)										// 현재 투자 금액만 수정 가능
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
				 JComponent component = (JComponent) super.prepareRenderer(renderer, row, column); 		// 표 배경색 설정
				 
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
 		 
 		 
 		 
 		 
 		 
 		 
 		 
 		 JLabel lbl1 = new JLabel("총 입금액 : " + ilbl1[0]);     // 총 투입 금액, 총 자산, 현재 여유 금액
         JLabel lbl2 = new JLabel("총 보유금액 : " + ilbl1[1]);	// 2 부분에는 텍스트에서 읽은 가격을 붙여야 함.
         JLabel lbl3 = new JLabel("현 여유금액 : " + ilbl1[2]);
         JLabel lbl4 = new JLabel("현 투자금액 : " + ilbl1[3]);

         Panels.add(lbl1);
         Panels.add(lbl2);
         Panels.add(lbl3);
         Panels.add(lbl4);
        
         lbl1.setBounds(930, 415, 160, 13);				// 우측 표와 차트 버튼 사이
	     lbl2.setBounds(930, 430, 160, 13);
	     lbl3.setBounds(930, 445, 160, 13);
	     lbl4.setBounds(930, 460, 160, 13);
      

        JButton btn_deposit = new JButton("추가 입금"); 			//추가 금액 						//미추가
        Panels.add(btn_deposit); 
        btn_deposit.setBounds(1160, 410, 90, 50);				// 우측 중앙 2행 4열
		 
        JLabel lbl5 = new JLabel(" 입금액 : ");      
        JTextField txt1 = new JTextField(18);
        txt1.setText("0");
        
        Panels.add(lbl5);
        Panels.add(txt1);
        lbl5.setBounds(1120, 470, 90, 30);
        txt1.setBounds(1180, 470, 90, 30);
        
        int Deposit = 0;				// 추가 입금액 입력
        
        for (int i = 0; i< 8; i++)
        {
        	beforeUpdate[i] = table.getValueAt(i, 8).toString();
        }
        
 		 
		 
		 table.setBounds(20, 510, 1240, 170);
		 table.getTableHeader().setReorderingAllowed(false);	// 행렬 값 이동 불가
		 table.getTableHeader().setResizingAllowed(false);		// 크기 수정 불가
		 
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
		 
		 // 최신화 버튼
		
		 
		
		 
		btn_update.addActionListener(new ActionListener()		// 우측 상단 시세 및 투자액 최신화 버튼
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 	 
	        	for (int i = 0; i< 8; i++)
	            {
	            	afterUpdate[i] = table.getValueAt(i, 8).toString();
	            }
	        	
	        	moneyUpdate = true; 							//새 입력값이 테이블에 입력되어있던 값과 다를 경우
	        	
	        	for(int i = 0; i<8; i++)
	        	{
	        		if (beforeUpdate[i].contentEquals(afterUpdate[i]) == false)			//새 입력값이 테이블에 입력되어있던 값과 다를 경우 moneyUpdate = true
	        		{
	        			moneyUpdate = true;
	        			break;
	        		}
	        		moneyUpdate = false;													// 새 입력값이 테이블에 입력되었던 값과 같을 경우 false
	        	}
	        	
	     		
     			refresh(Panels, scroll, table, data, ilbl1, TempNum, moneyUpdate);
	        	Update up = new Update(table, data, addr, ilbl1, TempNum, moneyUpdate);    	 		
    	 		lbl1.setText("총 입금액 : " + ilbl1[0]);     // 총 투입 금액, 총 자산, 현재 여유 금액
    	        lbl2.setText("총 보유금액 : " + ilbl1[1]);	// 2 부분에는 텍스트에서 읽은 가격을 붙여야 함.
    	        lbl3.setText("현 여유금액 : " + ilbl1[2]);
    	        lbl4.setText("현 투자금액 : " + ilbl1[3]);
    	 		 
    	 		System.out.println(";;;;;;;;;;;;;;");  
    	 		
    	 		for (int i = 0; i< 8; i++)
    	        {
    	        	beforeUpdate[i] = table.getValueAt(i, 8).toString();
    	        }
	     		
	        }
	    }); 
		 
		 btn_save.addActionListener(new ActionListener()		// 우측 상단 저장 버튼
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	
	        			// 업데이트 버튼 내용 추가
	        	//**************************************
	        	for (int i = 0; i< 8; i++)
	            {
	            	afterUpdate[i] = table.getValueAt(i, 8).toString();
	            }
	        	
	        	moneyUpdate = true; 							//새 입력값이 테이블에 입력되어있던 값과 다를 경우
	        	
	        	for(int i = 0; i<8; i++)
	        	{
	        		if (beforeUpdate[i].contentEquals(afterUpdate[i]) == false)			//새 입력값이 테이블에 입력되어있던 값과 다를 경우 moneyUpdate = true
	        		{
	        			moneyUpdate = true;
	        			break;
	        		}
	        		moneyUpdate = false;													// 새 입력값이 테이블에 입력되었던 값과 같을 경우 false
	        	}
	        	
	     		
     			refresh(Panels, scroll, table, data, ilbl1, TempNum, moneyUpdate);
	        	Update up = new Update(table, data, addr, ilbl1, TempNum, moneyUpdate);
	        	
 	        	
    	 		lbl1.setText("총 입금액 : " + ilbl1[0]);     // 총 투입 금액, 총 자산, 현재 여유 금액
    	        lbl2.setText("총 보유금액 : " + ilbl1[1]);	// 2 부분에는 텍스트에서 읽은 가격을 붙여야 함.
    	        lbl3.setText("현 여유금액 : " + ilbl1[2]);
    	        lbl4.setText("현 투자금액 : " + ilbl1[3]);
    	 		 
    	 		
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
		
		
		
		btn_deposit.addActionListener(new ActionListener()		// 우측 입금 버튼
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	
	        	try
	        	{
	        		if (ilbl1[0] > 1000000000)
		        	{
		        		txt1.setText("10억 이상 불가");
		        	}
		        	else
		        	{
		        		ilbl1[0] += Integer.parseInt(txt1.getText());		// 총 입금액. 텍스트 파일에 ****#0#0 으로 저장됨.
			        	ilbl1[1] += Integer.parseInt(txt1.getText());		// 총 보유액.  현 보유금액과 현 투자금액의 합산.
			        	ilbl1[2] += Integer.parseInt(txt1.getText());		// 아직 투자하지 않은 입금액.  0#0#**** 으로 저장됨.
			        														// ilbl1[3] 총 투자금액. 텍스트파일에 0#****#0 으로 저장됨.
			        	txt1.setText("0");
			        	lbl1.setText("총 입금액 : " + ilbl1[0]);     // 총 투입 금액, 총 자산, 현재 여유 금액
			            lbl2.setText("총 자산 : " + ilbl1[1]);	// 2 부분에는 텍스트에서 읽은 가격을 붙여야 함.
			            lbl3.setText("현 보유금액 : " + ilbl1[2]);
			            lbl4.setText("현 투자금액 : " + ilbl1[3]);
		        	}
	        	}
	        	
	        	catch (NumberFormatException e2)
	        	{
	        		txt1.setText("10억 이상 불가");
	        	}
	        	
	        	
	        	
	       	}
	    });
		
		//*************************

		
		btn1.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		
		btn2.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		btn3.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		btn4.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		btn5.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		btn6.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
		btn7.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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

		btn8.addActionListener(new ActionListener()		// 비트코인 차트 보여주기 버튼asasasasaasasa****
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
		
 
		 
		 
		btn_exit.addActionListener(new ActionListener()		// 우상단 종료버튼
	    { 
	        public void actionPerformed(ActionEvent e) 
	        { 
	        	System.exit(0); // 창 닫기
	       	}
	    });
		
		
		
	}
	
	
	//				Table의 내용을 데이터에 덧씌우는 메소드. update 이전에 사용된다.
	//*********************************************************
	void refresh(JPanel Panels, JScrollPane scroll, JTable table, String[] [] data, int ilbl1[], int LineNum, boolean moneyUpdate)
	{
		// table에 입력한 투자 금액란의 내용을 표 data에 입력
		String[] title = {"암호화폐명","실시간 시세","변동률(전일대비)","거래금액(24H)", "시가 총액", "이전 보유 수량", "이전 가치", "현재 보유 수량", "투자 금액 변경"}; //컬럼의 제목 정보를 표현할 1차원 배열
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
			if (moneyUpdate == true)							// 변경된 투자금액을 기준으로 화폐 개수를 수정
			{
				t[0] = Integer.parseInt(table.getValueAt(0, 8).toString());	// table의 투자 금액란의 값을 형으로 변환
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
					temp += t[j];			 //각 화폐에 대한 투자액의 합
				}
				
				// 총 보유액이 각 투자액의 합보다 작을 경우. ilbl1[1] 이 총 투자액
				if (temp > ilbl1[1])
				{
					// 자금이 부족합니다 출력.
					table.setValueAt("추가 입금이 필요합니다.", 0, 8);
				}
				
				else		// 총 보유액이 총 투자액보다 클 경우
				{
					for (int i = 0; i < 8; i++)	// 각 화폐 투자 금액에서 현재 화폐 가격을 나누어 화폐 보유 수를 계산
					{
						f[i] = Float.parseFloat(table.getValueAt(i, 8).toString()) / (Float.parseFloat(table.getValueAt(i, 1).toString().replaceAll(",", "").replaceAll(" ", "").replaceAll("원", "")));
						table.setValueAt(String.format("%.6f", f[i]), i, 7);
					}
					
					
					for (int i = 0; i<8; i++)
					{
						data[i][7] = table.getValueAt(i, 7).toString();
					}
				}
			}
			
			
			else											// 화폐 개수는 그대로 두고 투자금액을 현시세가에 맞추어 변경	
			{	
				int temp = 0;
				for (int j = 0; j<8; j++)
				{
					temp += t[j];			 //각 화폐에 대한 투자액의 합
				}
				
				// 총 보유액이 각 투자액의 합보다 작을 경우. ilbl1[1] 이 총 투자액
				if (temp > ilbl1[1])
				{
					// 자금이 부족합니다 출력.
					table.setValueAt("추가 입금이 필요합니다.", 0, 8);
				}
				
				else		// 총 보유액이 총 투자액보다 클 경우
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
			table.setValueAt("숫자만 입력해 주십시오", 0, 8);
		}
		
		
		
	}
	
	
}

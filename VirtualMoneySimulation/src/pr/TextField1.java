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
 

// 0219 회원가입 후 새 프래임 추가 요망. 돌아가기 버튼 활성화 필요.

public class TextField1 extends JFrame
{
	// 버튼 변수 선언
    JButton btn1, btn2, btn3;
    boolean IDPW;
    boolean UnusableID;
    
    public TextField1(String str)    
    {
        super(str);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel Panels = new JPanel(); 
        setSize(280,280);
        Dimension frameSize = getSize();	// 프레임 크기
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// 모니터 화면 크기
        // 프레임 위치 중앙 설정
        setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
        setResizable(false);
        
        // 레이블 생성
        JLabel lbl1 = new JLabel(" ID :           ");      
        JLabel lbl2 = new JLabel(" 비밀번호:");
        JLabel lbl3	= new JLabel(" ID와 비밀번호를 입력하시오");
        JLabel lbl0 = new JLabel("                                              ");		// 빈칸
        JLabel lbl4	= new JLabel(" 차트 데이터 처리에 시간이 걸립니다.");
        JLabel lbl5	= new JLabel("크롬 드라이버를 종료하지 말아주십시오.");
        JLabel lbl01 = new JLabel("                                              ");		// 빈칸
        JLabel lbl02 = new JLabel("                                              ");		// 빈칸
        JLabel lbl03 = new JLabel("제작자 - 김규현");		// 빈칸
        // 20자리 텍스트 필드 생성      
        JTextField txt1 = new JTextField(18);
        JPasswordField txt2 = new JPasswordField(18);
        // 비밀번호 * 로 
        txt2.setEchoChar('*');
        Panels.add(lbl1);
        Panels.add(txt1);
        Panels.add(lbl2);  
        Panels.add(txt2);
       

        btn1 = new JButton(" Login "); // 아이디 비밀번호 틀리면 PanelNum[2], 맞으면 [1]
        btn2 = new JButton(" 회원가입 "); // PanelNum[3]
        btn3 = new JButton(" 종료 ");
        // 패널에 3가지 버튼 생성
        Panels.add(btn1); Panels.add(btn2); Panels.add(btn3);
        Panels.add(lbl3);
        Panels.add(lbl0);										//빈칸
        Panels.add(lbl4);
        Panels.add(lbl5);
        Panels.add(lbl01);										//빈칸
        Panels.add(lbl02);										//빈칸
        Panels.add(lbl03);										

        

        // IDPW는 ID와 Password 매칭 후 결정. 추가 바람
        IDPW = false; // are ID and Password are correct? 
        
        // 로그인 버튼 누를 시 boolean IDPW 값 체크.
        btn1.addActionListener(new ActionListener()
        { 
        	
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		
        		FileMaker FileM = new FileMaker();		// 로그인 버튼을 누르면 FileMaker 클래스의 DirMaker가 작동. Info.txt 디폴트
        		FileM.MakeEncDec();						// 폴더가 없으면 폴더 생성 후 default default인 텍스트 파일 생성. Info_b 생성
        		
        		
        		// ID와 Password가 info에 적힌 것과 같은지 확인 작업
        		int LineNumber = 0;	// 줄바꿈 횟수 
        		
        		
    			try
    			{
    	            //파일 객체 생성
    	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
    	            //입력 스트림 생성
    	            FileReader filereader = new FileReader(file);
    	            //입력 버퍼 생성
    	            BufferedReader bufReader = new BufferedReader(filereader);
    	            String line = "";
    	            while((line = bufReader.readLine()) != null)
    	            {
    	            	LineNumber = LineNumber + 1;			// LineNumber 번째 줄에 ID가 있음
    	            	if (line.equals(txt1.getText()) )		// 입력 아이디를 찾는다. 비밀번호는 메모장에 ***이 붙음
    	            	{
    	            		// getPassword()는 ***로 입력된 비밀번호를 해독하나 그 형태가 char 이므로 string으로 바꿔줄 필요가 있다.
    	        			String pw2 = "";
    	        			char[] secret_pw2 = txt2.getPassword(); //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장 
    	        			for(char cha : secret_pw2)
    	        			{ 
    	        				Character.toString(cha); // cha 에 저장된 값 string으로 변환 //pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자 
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
    	            //.readLine()은 끝에 개행문자를 읽지 않는다.            
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
        		
    			FileM.MakeEncDec(); 		//		Info_b를 Info_a로 암호화.
        		
        		
        		if (IDPW == true)	// IDPW == true. 메모장과 암호화 필요.
        		{
        			// 모든 컴포넌트 지우기
        			setVisible(false);
        			new Simulator(LineNumber);

        			
        		    
        			
        			//lbl3.setText("로그인.");
        			
        			
        			
        		}
        		
        		else	// ID나 PW가 맞지 않을 때
        		{
        			lbl3.setText("ID나 비밀번호를 잘못 입력하셨습니다.");
        		}
        		
       		}
       	});

        btn2.addActionListener(new ActionListener()			//회원가입 버튼 이벤트
        { 
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		// 원래 패널 제거
        		JFrame Frame2 = new JFrame("가상화폐 시뮬레이터");
    			JPanel Panel2 = new JPanel();
    			Frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			setResizable(true);
    			Frame2.setSize(280,280);
    			Dimension frameSize = Frame2.getSize();	// 프레임 크기
    		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// 모니터 화면 크기
    		    // 프레임 위치 중앙 설정
    		    Frame2.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
    		    Frame2.setResizable(false);
    		    
    		    JButton btn21, btn22;
    		    
    		    JLabel lbl21 = new JLabel(" ID :            ");      
    	        JLabel lbl22 = new JLabel(" 비밀번호:");
    	        JLabel lbl23 = new JLabel(" 2차 확인: ");
    	        JLabel lbl24	= new JLabel(" 사용 할 ID와 비밀번호를 입력하시오");
    	        // 20자리 텍스트 필드 생성      
    	        JTextField txt21 = new JTextField(18);
    	        JPasswordField txt22 = new JPasswordField(18);
    	        JPasswordField txt23 = new JPasswordField(18);
    	        // 비밀번호 * 로 
    	        txt2.setEchoChar('*');
    	        Panel2.add(lbl21);
    	        Panel2.add(txt21);
    	        Panel2.add(lbl22);  
    	        Panel2.add(txt22);
    	        Panel2.add(lbl23);
    	        Panel2.add(txt23);
    	       

    	        btn21 = new JButton(" 회원가입 "); // 아이디 비밀번호 틀리면 PanelNum[2], 맞으면 [1]
    	        btn22 = new JButton(" 종료 "); // PanelNum[3]
    	        // 패널에 3가지 버튼 생성
    	        Panel2.add(btn21); Panel2.add(btn22);
    	        Panel2.add(lbl24);
    		    
    		    
    		    
    		    Frame2.add(Panel2);
    		    
    		    setVisible(false);
    		    Frame2.setVisible(true);
    		    
    		    	    
    		    // 회원가입하기 버튼
    		    btn21.addActionListener(new ActionListener()
    	        { 
    	        	
    	        	public void actionPerformed(ActionEvent e) 
    	        	{
    	        		FileMaker FileM = new FileMaker();		// MakeEncDec 메소드는 폴더가 있으면 Info_a를 Info_b로 해독
    	        		FileM.MakeEncDec();						// 폴더가 없으면 폴더 생성 후 default default인 텍스트 파일 Info_b 생성. 
    	        		
    	        		// ID와 Password가 info에 적힌 것과 같은지 확인 작업
    	        		int LineNumber = 0;	// 줄바꿈 횟수 
    	        		
    	        		
    	    			try												// 첫줄 아이디, 둘째줄 비밀번호, 셋째줄 화폐 보유량 및 이전 가치
    	    			{
    	    	            //파일 객체 생성
    	    	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
    	    	            //입력 스트림 생성
    	    	            FileReader filereader = new FileReader(file);
    	    	            //입력 버퍼 생성
    	    	            BufferedReader bufReader = new BufferedReader(filereader);
    	    	            String line = "";
    	    	            
    	    	            LineNumber = 0;
    	    	            while((line = bufReader.readLine()) != null)
    	    	            {
    	    	            	LineNumber = LineNumber + 1;			// LineNumber 번째 줄에 ID가 있음

    	    	            	if (line.equals(txt21.getText()) )		// 입력 아이디를 찾는다.
    	    	            	{
    	    	            		UnusableID = true;
    	    	            		break;
    	    	            	}
    	    	            	else
    	    	            	{
    	    	            		UnusableID = false;
    	    	            	}
    	    	            }
    	    	            //.readLine()은 끝에 개행문자를 읽지 않는다.            
    	    	            bufReader.close();

    	    	        }
    	    			catch (FileNotFoundException e1)
    	    			{
    	    	            
    	    	        }
    	    			catch(IOException e1)
    	    			{
    	    	            System.out.println(e1);
    	    	        }
    	    			
    	    			
    	    			if (UnusableID == true)	// 이미 사용되고있는 아이디
    	        		{
    	        			lbl24.setText("이미 사용되고있는 ID입니다.");
    	        		}
    	        		
    	        		else	// 사용 할 수 있는 ID일 때
    	        		{
    	        			// getPassword()는 ***로 입력된 비밀번호를 해독하나 그 형태가 char 이므로 string으로 바꿔줄 필요가 있다.
    	        			String pw22 = "";
    	        			char[] secret_pw22 = txt22.getPassword(); //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장 
    	        			for(char cha : secret_pw22)
    	        			{ 
    	        				Character.toString(cha); // cha 에 저장된 값 string으로 변환 //pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자 
    	        				pw22 += (pw22.equals("")) ? ""+cha+"" : ""+cha+""; 
    	        			}
	    	    			
    	        			String pw23 = "";
    	        			char[] secret_pw23 = txt23.getPassword(); //secret_pw 배열에 저장된 암호의 자릿수 만큼 for문 돌리면서 cha 에 한 글자씩 저장 
		        			for(char cha : secret_pw23)
		        			{ 
		        				Character.toString(cha); // cha 에 저장된 값 string으로 변환 //pw 에 저장하기, pw 에 값이 비어있으면 저장, 값이 있으면 이어서 저장하는 삼항연산자 
		        				pw23 += (pw23.equals("")) ? ""+cha+"" : ""+cha+"";
		        			}

    	        			
    	        			if (pw22.equals(pw23))	// 두 입력 비밀번호가 일치함. 비밀번호 저장 시 **** 추가.
    	        			{
    	        				// 텍스트 파일에 추가 및 암호화.
    	        				FileWriter fw = null ;
    	        				BufferedWriter bw = null;

    	        				try
    	        				{
    	        						lbl24.setText("일치");		// 돌아가기 버튼 수정 요망
    	        					
    	        						//파일 쓰기
    	        						fw = new FileWriter( "C:/VirtualMoneySimulator/Info_b.txt", true );
    	        						bw = new BufferedWriter( fw );
    	        						bw.newLine();
    	        						bw.write(txt21.getText()); //버퍼에 데이터 입력
    	        						bw.newLine(); //버퍼에 개행 삽입
    	        						bw.write("****" + pw23);
    	        						bw.newLine();
    	        						bw.write( "0#0#0");//  총금액 0, 현재 보유액 0, 투자액 0
    	        						bw.newLine();
    	        			            bw.write("0#0#0#0#0#0#0#0");		// 이전 시세 0 * 8 
    	        			            bw.newLine();
    	        			            bw.write("0#0#0#0#0#0#0#0");		//이전 보유 수 0 * 8
    	        						
    	        						bw.flush(); //버퍼의 내용을 파일에 쓰기

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
    	        				
    	        				FileM.MakeEncDec();						// Info_b를 다시 Info_a로 만든다.
    	        								// 회원가입 완료 프레임
    	        				
    	        				JFrame Frame3 = new JFrame("가상화폐 시뮬레이터");
    	            			JPanel Panel3 = new JPanel();
    	            			Frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	            			setResizable(true);
    	            			Frame3.setSize(280,280);
    	            			Dimension frameSize = Frame2.getSize();	// 프레임 크기
    	            		    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();	// 모니터 화면 크기
    	            		    // 프레임 위치 중앙 설정
    	            		    Frame3.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2);
    	            		    Frame3.setResizable(false);
    	            		    
    	            		    JButton btn31, btn32;
    	            		    
    	            		    JLabel lbl31 = new JLabel(" 회원가입이 완료되었습니다. ");
    	            	        btn31 = new JButton(" 돌아가기 "); 
    	            	        btn32 = new JButton(" 종료 "); 
    	            	       
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
    	            	        
    	            	        btn32.addActionListener(new ActionListener()	// 종료 버튼
    	            	        { 
    	            	        	public void actionPerformed(ActionEvent e) 
    	            	        	{ 
    	            	        		System.exit(0); // 창 닫기
    	            	        	}
    	            	        });
    	            		    
    	            		    
    	            		    Frame3.add(Panel3);
    	            		    
    	            		    Frame2.setVisible(false);
    	            		    Frame3.setVisible(true);
    	            		    
    	        				
    	        				
    	        			}
    	        			
    	        			else								// 두 입력 비밀번호가 일치하지 않음
    	        			{
    	        				lbl24.setText("확인된 비밀번호가 일치하지 않습니다.");
    	        			}
    	        			
    	        		}
    	    			
    	    			
    	        	}
    	        	
    	        });
    	        		
        		
        		// 종료 버튼.
    		    btn22.addActionListener(new ActionListener()
    		    { 
    		    	public void actionPerformed(ActionEvent e) 
    		    	{ 
    		    		System.exit(0); // 창 닫기
    		    	}
    		    });
        		
       		}
       	});
       
     
        
        
        // 종료 버튼.
        btn3.addActionListener(new ActionListener()
        { 
        	public void actionPerformed(ActionEvent e) 
        	{ 
        		System.exit(0); // 창 닫기
       		}
       	});
        
        add(Panels);

        

        
        // x 눌러서 닫기
        addWindowListener(new WindowAdapter() 
        {
        	public void windowClosing(WindowEvent e) 
        	{
        		System.exit(0);
        	}
        }); // x 눌러서 닫기
        setVisible(true);  

    }

}

package pr;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel; 
import javax.swing.table.TableCellRenderer;
import javax.swing.JOptionPane;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class Update 
{
	private final static String addr = "https://www.bithumb.com/";
	
	public Update() {};
	
	public Update(JTable table, String[][] Info, String addr, int[] ilbl1, int LineNumber, boolean moneyUpdate)
	{
		
		try 
		 {
			Document doc = Jsoup.connect(addr).get();				// html ���� 
			Elements content01 = doc.select("#assetRealBTC_KRW");	// �ǽð� �ü�
			Elements content02 = doc.select("#assetRealPriceBTC_KRW");	// ���� ��� ������
			Elements content03 = doc.select("#assetRealRateBTC_KRW");	// ���� ��� ������ %
			Elements content04 = doc.select("#assetRealBTC_KRW2KRW");	// �ŷ��� (24H)
			Elements content05 = doc.select(".sort_total.assetTotalBTC_KRW");	// �ð��Ѿ�
			String text00 = "��Ʈ����";
			String text01 = content01.text();
			String text02 = content02.text() + " (" + content03.text() + ")";
			String text03 = (content04.text()).substring(2, (content04.text()).length());
			String text04 = content05.text();
				
			Elements content11 = doc.select("#assetRealXRP_KRW");	// �ǽð� �ü�
			Elements content12 = doc.select("#assetRealPriceXRP_KRW");	// ���� ��� ������
			Elements content13 = doc.select("#assetRealRateXRP_KRW");	// ���� ��� ������ %
			Elements content14 = doc.select("#assetRealXRP_KRW2KRW");	// �ŷ��� (24H)
			Elements content15 = doc.select(".sort_total.assetTotalXRP_KRW");	// �ð��Ѿ�
			String text10 = "����";
			String text11 = content11.text();
			String text12 = content12.text() + " (" + content13.text() + ")";
			String text13 = (content14.text()).substring(2, (content14.text()).length());
			String text14 = content15.text();
			
			Elements content21 = doc.select("#assetRealETH_KRW");	// �ǽð� �ü�
			Elements content22 = doc.select("#assetRealPriceETH_KRW");	// ���� ��� ������
			Elements content23 = doc.select("#assetRealRateETH_KRW");	// ���� ��� ������ %
			Elements content24 = doc.select("#assetRealETH_KRW2KRW");	// �ŷ��� (24H)
			Elements content25 = doc.select(".sort_total.assetTotalETH_KRW");	// �ð��Ѿ�
			String text20 = "�̴�����";
			String text21 = content21.text();
			String text22 = content22.text() + " (" + content23.text() + ")";
			String text23 = (content24.text()).substring(2, (content24.text()).length());
			String text24 = content25.text();
			
			Elements content31 = doc.select("#assetRealEOS_KRW");	// �ǽð� �ü�
			Elements content32 = doc.select("#assetRealPriceEOS_KRW");	// ���� ��� ������
			Elements content33 = doc.select("#assetRealRateEOS_KRW");	// ���� ��� ������ %
			Elements content34 = doc.select("#assetRealEOS_KRW2KRW");	// �ŷ��� (24H)
			Elements content35 = doc.select(".sort_total.assetTotalEOS_KRW");	// �ð��Ѿ�
			String text30 = "�̿���";
			String text31 = content31.text();
			String text32 = content32.text() + " (" + content33.text() + ")";
			String text33 = (content34.text()).substring(2, (content34.text()).length());
			String text34 = content35.text();
			
			Elements content41 = doc.select("#assetRealBSV_KRW");	// �ǽð� �ü�
			Elements content42 = doc.select("#assetRealPriceBSV_KRW");	// ���� ��� ������
			Elements content43 = doc.select("#assetRealRateBSV_KRW");	// ���� ��� ������ %
			Elements content44 = doc.select("#assetRealBSV_KRW2KRW");	// �ŷ��� (24H)
			Elements content45 = doc.select(".sort_total.assetTotalBSV_KRW");	// �ð��Ѿ�
			String text40 = "��Ʈ���� ��������";
			String text41 = content41.text();
			String text42 = content42.text() + " (" + content43.text() + ")";
			String text43 = (content44.text()).substring(2, (content44.text()).length());
			String text44 = content45.text();
			
			Elements content51 = doc.select("#assetRealBCH_KRW");	// �ǽð� �ü�
			Elements content52 = doc.select("#assetRealPriceBCH_KRW");	// ���� ��� ������
			Elements content53 = doc.select("#assetRealRateBCH_KRW");	// ���� ��� ������ %
			Elements content54 = doc.select("#assetRealBCH_KRW2KRW");	// �ŷ��� (24H)
			Elements content55 = doc.select(".sort_total.assetTotalBCH_KRW");	// �ð��Ѿ�
			String text50 = "��Ʈ���� ĳ��";
			String text51 = content51.text();
			String text52 = content52.text() + " (" + content53.text() + ")";
			String text53 = (content14.text()).substring(2, (content54.text()).length());
			String text54 = content55.text();
			
			Elements content61 = doc.select("#assetRealLTC_KRW");	// �ǽð� �ü�
			Elements content62 = doc.select("#assetRealPriceLTC_KRW");	// ���� ��� ������
			Elements content63 = doc.select("#assetRealRateLTC_KRW");	// ���� ��� ������ %
			Elements content64 = doc.select("#assetRealLTC_KRW2KRW");	// �ŷ��� (24H)
			Elements content65 = doc.select(".sort_total.assetTotalLTC_KRW");	// �ð��Ѿ�
			String text60 = "����Ʈ����";
			String text61 = content61.text();
			String text62 = content62.text() + " (" + content63.text() + ")";
			String text63 = (content64.text()).substring(2, (content64.text()).length());
			String text64 = content65.text();
			
			Elements content71 = doc.select("#assetRealLINK_KRW");	// �ǽð� �ü�
			Elements content72 = doc.select("#assetRealPriceLINK_KRW");	// ���� ��� ������
			Elements content73 = doc.select("#assetRealRateLINK_KRW");	// ���� ��� ������ %
			Elements content74 = doc.select("#assetRealLINK_KRW2KRW");	// �ŷ��� (24H)
			Elements content75 = doc.select(".sort_total.assetTotalLINK_KRW");	// �ð��Ѿ�
			String text70 = "ü�θ�ũ";
			String text71 = content71.text();
			String text72 = content72.text() + " (" + content73.text() + ")";
			String text73 = (content74.text()).substring(2, (content74.text()).length());
			String text74 = content75.text();
				
				//�ؽ�Ʈ ���� ���尪 ����
			
			String text08, text18, text28, text38, text48, text58, text68, text78;			//���� ���� ȭ�� ��ġ

			
							//�ؽ�Ʈ ���Ͽ� ����� �� ��������
			
			FileMaker FileM = new FileMaker();		// �α��� ��ư�� ������ FileMaker Ŭ������ DirMaker�� �۵�. Info.txt ����Ʈ
			FileM.MakeEncDec();						// ������ ������ ���� ���� �� default default�� �ؽ�Ʈ ���� ����. Info_b ����
			
   		
				// LineNumber�� ���� ���� �ٿ� ���� �ü�, ������ ���� ����Ǿ����� ��� ù �� ���ڴ� "#$&" 
   			//�ص��� Info_b���� #$&�� �����ϴ� ���� �����͸� �����´�.
   		try
			{
	            //���� ��ü ����
	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
	            //�Է� ��Ʈ�� ����
	            FileReader filereader = new FileReader(file);
	            //�Է� ���� ����
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            int Templine = 0;
	            
	            while((line = bufReader.readLine()) != null)	// �� ���� ���� ������		
	            {
	            	Templine = Templine + 1;
	            	if ((LineNumber+2) == Templine)		//���̵� 1��° �ٿ� ������ �����ʹ� 3��° �ٿ� �ִ�.
	            	{
	            		// �� ������ line�� �� ���� �ݾ�, �� ������, �� �������� �ǹ��ϹǷ� �� �����ٺ��� �����͸� ã�´�.
	            		line = bufReader.readLine();			// ���� ���� ȭ�� �� 			����: 0#0#0#0#0#0#0#0
	            		String arr00[] = line.split("#");		// #���� ������				����: arr00[0] == 0, arr00[1] == 0...
	            		
	            		line = bufReader.readLine();			// ���� ���� ȭ�� ��ġ
	            		String arr01[] = line.split("#"); 		// #���� ������

	            		
	            		if (moneyUpdate == true)
	            		{
	            			Info = new String[][]{{text00, text01, text02, text03, text04, arr00[0], arr01[0], Info[0][7], table.getValueAt(0, 8).toString()},
		        				{text10, text11, text12, text13, text14, arr00[1], arr01[1], Info[1][7], table.getValueAt(1, 8).toString()},
		        				{text20, text21, text22, text23, text24, arr00[2], arr01[2], Info[2][7], table.getValueAt(2, 8).toString()},
		        				{text30, text31, text32, text33, text34, arr00[3], arr01[3], Info[3][7], table.getValueAt(3, 8).toString()},
		        				{text40, text41, text42, text43, text44, arr00[4], arr01[4], Info[4][7], table.getValueAt(4, 8).toString()},
		        				{text50, text51, text52, text53, text54, arr00[5], arr01[5], Info[5][7], table.getValueAt(5, 8).toString()},
		        				{text60, text61, text62, text63, text64, arr00[6], arr01[6], Info[6][7], table.getValueAt(6, 8).toString()},
		        				{text70, text71, text72, text73, text74, arr00[7], arr01[7], Info[7][7], table.getValueAt(7, 8).toString()}			
		        			};
		        			
		        			//ilbl1[0] = 0;		// �� �Աݾ�. �ؽ�Ʈ ���Ͽ� ****#0#0 ���� �����.
		            	    //ilbl1[1] = 0;		// �� ������.  �� �����ݾװ� �� ���ڱݾ��� �ջ�.
		            	    //ilbl1[2] = 0;					// ���� �������� ���� �Աݾ�.  0#0#**** ���� �����.
		            	    //ilbl1[3] = 0;					// �� ���ڱݾ�. �ؽ�Ʈ���Ͽ� 0#****#0 ���� �����.
		            		int temp = 0;
		            		
		            		for (int i = 0; i < 8; i++)
		            		{
		            			temp += Math.round(Float.parseFloat(Info[i][8]));			//float int ��ȯ
		            		}
		            		
		            		ilbl1[3] = temp;
		            		ilbl1[2] = ilbl1[1] - ilbl1[3];
	            		}
	            		else			// ����ڰ� ���ڱݾ��� �������� �ʾ��� ��� ��ü������ �� ȭ�� �ü��� �°� �����Ѵ�.
	            		{
	            			DecimalFormat decimalFormat = new DecimalFormat("0");
	            			Info = new String[][]{{text00, text01, text02, text03, text04, arr00[0], arr01[0], Info[0][7], decimalFormat.format(Math.round(Float.parseFloat(Info[0][7]) * Float.parseFloat(text01.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text10, text11, text12, text13, text14, arr00[1], arr01[1], Info[1][7], decimalFormat.format(Math.round(Float.parseFloat(Info[1][7]) * Float.parseFloat(text11.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text20, text21, text22, text23, text24, arr00[2], arr01[2], Info[2][7], decimalFormat.format(Math.round(Float.parseFloat(Info[2][7]) * Float.parseFloat(text21.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text30, text31, text32, text33, text34, arr00[3], arr01[3], Info[3][7], decimalFormat.format(Math.round(Float.parseFloat(Info[3][7]) * Float.parseFloat(text31.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text40, text41, text42, text43, text44, arr00[4], arr01[4], Info[4][7], decimalFormat.format(Math.round(Float.parseFloat(Info[4][7]) * Float.parseFloat(text41.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text50, text51, text52, text53, text54, arr00[5], arr01[5], Info[5][7], decimalFormat.format(Math.round(Float.parseFloat(Info[5][7]) * Float.parseFloat(text51.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text60, text61, text62, text63, text64, arr00[6], arr01[6], Info[6][7], decimalFormat.format(Math.round(Float.parseFloat(Info[6][7]) * Float.parseFloat(text61.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")},
		        				{text70, text71, text72, text73, text74, arr00[7], arr01[7], Info[7][7], decimalFormat.format(Math.round(Float.parseFloat(Info[7][7]) * Float.parseFloat(text71.replace(" ", "").replace("��", "").replace(",","")))).replace(".0", "")}			//�ٲٱ�
		        			};	
		        			
		        			int temp = 0;
		            		
		            		for (int i = 0; i < 8; i++)
		            		{
		            			temp += Math.round(Float.parseFloat(Info[i][8]));			//float int ��ȯ
		            		}
		            		
		            		ilbl1[3] = temp;
		            		ilbl1[1] = ilbl1[2] + ilbl1[3];
		        			
	            		}
	  
	            		for (int i = 0; i<8; i++)
	            		{
	            			for (int j = 0; j<9; j++)
	            			{
	            				table.setValueAt(Info[i][j], i, j);
	            			}
	            		}
	   
	            		break;
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
			
			
	     } 
		 catch (IOException e3) 
		 {
	         e3.printStackTrace();
	     }
	}
}

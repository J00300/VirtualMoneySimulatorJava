package pr;

import java.io.*;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class GetData 
{
	String addr = "https://www.bithumb.com/";
	public String[][] GetData(String[][] data, String addr, int LineNumber) 
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
			
			Elements cont1 = doc.select(".pane-legend-item-value pane-legend-line pane-legend-item-value__main");

				
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
	            		// �� ������ line�� �� ���� �ݾ�, �� ������, �� �������� �ǹ�
	
	            		
	            		line = bufReader.readLine();			// ���� ���� ȭ�� �� 			����: 0#0#0#0#0#0#0#0
	            		String arr00[] = line.split("#");		// #���� ������				����: arr00[0] == 0, arr00[1] == 0...
	            		
	            		line = bufReader.readLine();			// ���� ���� ȭ�� ��ġ
	            		String arr01[] = line.split("#"); 		// #���� ������
	            		
	            		float floata0 = Float.parseFloat(arr00[0]);
	            		float floata1 = Float.parseFloat(arr00[1]);					// text01 ��� arr00[0] ���� ��� float �ڷ������� ��ȯ
	            		float floata2 = Float.parseFloat(arr00[2]);
	            		float floata3 = Float.parseFloat(arr00[3]);					// floata �� ȭ�� ���� ��
	            		float floata4 = Float.parseFloat(arr00[4]);					// �Ҽ��� 3�ڸ�, �� 0.000���� ǥ�� �����ϰ� �Ѵ�.
	            		float floata5 = Float.parseFloat(arr00[5]);
	            		float floata6 = Float.parseFloat(arr00[6]);
	            		float floata7 = Float.parseFloat(arr00[7]);
	            		
	            		
	            		String r0, r1, r2, r3, r4, r5, r6, r7;			// �ǽð� ȭ��ġ �ؽ�Ʈ
	            		
	            		r0 = text01.replaceAll(",", "");
	            		r0 = r0.replaceAll(" ", "");
	            		r0 = r0.replaceAll("��", "");
	            		r1 = text11.replaceAll(",", "");				// �ǽð� ȭ�� ��ġ ���ڿ��� ",", " ", "��" �� �����Ͽ� float �� ��ȯ�� �����ϰ� �����.
	            		r1 = r1.replaceAll(" ", "");
	            		r1 = r1.replaceAll("��", "");
	            		r2 = text21.replaceAll(",", "");
	            		r2 = r2.replaceAll(" ", "");
	            		r2 = r2.replaceAll("��", "");
	            		r3 = text31.replaceAll(",", "");
	            		r3 = r3.replaceAll(" ", "");
	            		r3 = r3.replaceAll("��", "");
	            		r4 = text41.replaceAll(",", "");
	            		r4 = r4.replaceAll(" ", "");
	            		r4 = r4.replaceAll("��", "");
	            		r5 = text51.replaceAll(",", "");
	            		r5 = r5.replaceAll(" ", "");
	            		r5 = r5.replaceAll("��", "");
	            		r6 = text61.replaceAll(",", "");
	            		r6 = r6.replaceAll(" ", "");
	            		r6 = r6.replaceAll("��", "");
	            		r7 = text71.replaceAll(",", "");
	            		r7 = r7.replaceAll(" ", "");
	            		r7 = r7.replaceAll("��", "");
	            		
	            		
	            		float floatb0 = Float.parseFloat(r0);
	            		float floatb1 = Float.parseFloat(r1);					// floatb �� ���� ȭ�� �ð�
	            		float floatb2 = Float.parseFloat(r2);
	            		float floatb3 = Float.parseFloat(r3);
	            		float floatb4 = Float.parseFloat(r4);
	            		float floatb5 = Float.parseFloat(r5);
	            		float floatb6 = Float.parseFloat(r6);
	            		float floatb7 = Float.parseFloat(r7);
	            		
	            		
	            		
	            		text08 = (Float.toString(Math.round(floata0*floatb0))).replace(".0", "");			// ȭ�� ���� * ���� �ð�
	            		text18 = (Float.toString(Math.round(floata1*floatb1))).replace(".0", "");			// �Ҽ� ������
	            		text28 = (Float.toString(Math.round(floata2*floatb2))).replace(".0", "");			// ��°���� text�� �Ҽ� ù°�ڸ��� ��Ÿ����.
	            		text38 = (Float.toString(Math.round(floata3*floatb3))).replace(".0", "");
	            		text48 = (Float.toString(Math.round(floata4*floatb4))).replace(".0", "");
	            		text58 = (Float.toString(Math.round(floata5*floatb5))).replace(".0", "");
	            		text68 = (Float.toString(Math.round(floata6*floatb6))).replace(".0", "");
	            		text78 = (Float.toString(Math.round(floata7*floatb7))).replace(".0", "");
	            		
	            		
	            		
	            		
	            		
	                    

	            		data = new String[][]{{text00, text01, text02, text03, text04, arr00[0], arr01[0], arr00[0], text08},
	        				{text10, text11, text12, text13, text14, arr00[1], arr01[1], arr00[1], text18},
	        				{text20, text21, text22, text23, text24, arr00[2], arr01[2], arr00[2], text28},
	        				{text30, text31, text32, text33, text34, arr00[3], arr01[3], arr00[3], text38},
	        				{text40, text41, text42, text43, text44, arr00[4], arr01[4], arr00[4], text48},
	        				{text50, text51, text52, text53, text54, arr00[5], arr01[5], arr00[5], text58},
	        				{text60, text61, text62, text63, text64, arr00[6], arr01[6], arr00[6], text68},
	        				{text70, text71, text72, text73, text74, arr00[7], arr01[7], arr00[7], text78}
	        			};			
	        			
	        			
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
	
		 return data;
		
	};
	
	public int[] GetData(String[][] data, int[] ilbl1, int LineNumber)			//����
	{
		 
			
							//�ؽ�Ʈ ���Ͽ� ����� �� ��������
			
		FileMaker FileM = new FileMaker();		// �α��� ��ư�� ������ FileMaker Ŭ������ DirMaker�� �۵�. Info.txt ����Ʈ
		FileM.MakeEncDec();						// ������ ������ ���� ���� �� default default�� �ؽ�Ʈ ���� ����. Info_b ����
		
		
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
            		// �� ������ line�� �� ���� �ݾ�, �� ������, �� �������� �ǹ�

            		String Strilbl1[] = line.split("#");							//����: 0#0#0
            		ilbl1[0] = Integer.parseInt(Strilbl1[0]);
            		ilbl1[3] = Integer.parseInt(Strilbl1[1]);
            		ilbl1[2] = Integer.parseInt(Strilbl1[2]);
            		ilbl1[1] = ilbl1[2] + ilbl1[3];
            		
            		//ilbl1[0] = 0;		// �� �Աݾ�. �ؽ�Ʈ ���Ͽ� ****#0#0 ���� �����.
            	    //ilbl1[1] = 0;		// �� ������.  �� �����ݾװ� �� ���ڱݾ��� �ջ�.
            	    //ilbl1[2] = 0;					// ���� �������� ���� �Աݾ�.  0#0#**** ���� �����.
            	    //ilbl1[3] = 0;					// �� ���ڱݾ�. �ؽ�Ʈ���Ͽ� 0#****#0 ���� �����.
            		
            		
            		
            		
            		line = bufReader.readLine();			// ���� ���� ȭ�� �� 			����: 0#0#0#0#0#0#0#0
            		String arr00[] = line.split("#");		// #���� ������				����: arr00[0] == 0, arr00[1] == 0...
            		
            		line = bufReader.readLine();			// ���� ���� ȭ�� ��ġ
            		String arr01[] = line.split("#"); 		// #���� ������
            		
            					
        			
        			int temp = 0;
        			for (int i = 0; i<8; i++)
        			{
        				temp += Integer.parseInt(data[i][8]);
        			}
        			
        			ilbl1[3] = temp;
        			ilbl1[1] = ilbl1[3] + ilbl1[2];
					
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
		return ilbl1;
			
	     


	}
}

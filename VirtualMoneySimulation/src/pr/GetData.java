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
			Document doc = Jsoup.connect(addr).get();				// html 빗썸 
			Elements content01 = doc.select("#assetRealBTC_KRW");	// 실시간 시세
			Elements content02 = doc.select("#assetRealPriceBTC_KRW");	// 전일 대비 변동액
			Elements content03 = doc.select("#assetRealRateBTC_KRW");	// 전일 대비 변동률 %
			Elements content04 = doc.select("#assetRealBTC_KRW2KRW");	// 거래량 (24H)
			Elements content05 = doc.select(".sort_total.assetTotalBTC_KRW");	// 시가총액
			String text00 = "비트코인";
			String text01 = content01.text();
			String text02 = content02.text() + " (" + content03.text() + ")";
			String text03 = (content04.text()).substring(2, (content04.text()).length());
			String text04 = content05.text();
			
			Elements cont1 = doc.select(".pane-legend-item-value pane-legend-line pane-legend-item-value__main");

				
			Elements content11 = doc.select("#assetRealXRP_KRW");	// 실시간 시세
			Elements content12 = doc.select("#assetRealPriceXRP_KRW");	// 전일 대비 변동액
			Elements content13 = doc.select("#assetRealRateXRP_KRW");	// 전일 대비 변동률 %
			Elements content14 = doc.select("#assetRealXRP_KRW2KRW");	// 거래량 (24H)
			Elements content15 = doc.select(".sort_total.assetTotalXRP_KRW");	// 시가총액
			String text10 = "리플";
			String text11 = content11.text();
			String text12 = content12.text() + " (" + content13.text() + ")";
			String text13 = (content14.text()).substring(2, (content14.text()).length());
			String text14 = content15.text();
			
			Elements content21 = doc.select("#assetRealETH_KRW");	// 실시간 시세
			Elements content22 = doc.select("#assetRealPriceETH_KRW");	// 전일 대비 변동액
			Elements content23 = doc.select("#assetRealRateETH_KRW");	// 전일 대비 변동률 %
			Elements content24 = doc.select("#assetRealETH_KRW2KRW");	// 거래량 (24H)
			Elements content25 = doc.select(".sort_total.assetTotalETH_KRW");	// 시가총액
			String text20 = "이더리움";
			String text21 = content21.text();
			String text22 = content22.text() + " (" + content23.text() + ")";
			String text23 = (content24.text()).substring(2, (content24.text()).length());
			String text24 = content25.text();
			
			Elements content31 = doc.select("#assetRealEOS_KRW");	// 실시간 시세
			Elements content32 = doc.select("#assetRealPriceEOS_KRW");	// 전일 대비 변동액
			Elements content33 = doc.select("#assetRealRateEOS_KRW");	// 전일 대비 변동률 %
			Elements content34 = doc.select("#assetRealEOS_KRW2KRW");	// 거래량 (24H)
			Elements content35 = doc.select(".sort_total.assetTotalEOS_KRW");	// 시가총액
			String text30 = "이오스";
			String text31 = content31.text();
			String text32 = content32.text() + " (" + content33.text() + ")";
			String text33 = (content34.text()).substring(2, (content34.text()).length());
			String text34 = content35.text();
			
			Elements content41 = doc.select("#assetRealBSV_KRW");	// 실시간 시세
			Elements content42 = doc.select("#assetRealPriceBSV_KRW");	// 전일 대비 변동액
			Elements content43 = doc.select("#assetRealRateBSV_KRW");	// 전일 대비 변동률 %
			Elements content44 = doc.select("#assetRealBSV_KRW2KRW");	// 거래량 (24H)
			Elements content45 = doc.select(".sort_total.assetTotalBSV_KRW");	// 시가총액
			String text40 = "비트코인 에스브이";
			String text41 = content41.text();
			String text42 = content42.text() + " (" + content43.text() + ")";
			String text43 = (content44.text()).substring(2, (content44.text()).length());
			String text44 = content45.text();
			
			Elements content51 = doc.select("#assetRealBCH_KRW");	// 실시간 시세
			Elements content52 = doc.select("#assetRealPriceBCH_KRW");	// 전일 대비 변동액
			Elements content53 = doc.select("#assetRealRateBCH_KRW");	// 전일 대비 변동률 %
			Elements content54 = doc.select("#assetRealBCH_KRW2KRW");	// 거래량 (24H)
			Elements content55 = doc.select(".sort_total.assetTotalBCH_KRW");	// 시가총액
			String text50 = "비트코인 캐시";
			String text51 = content51.text();
			String text52 = content52.text() + " (" + content53.text() + ")";
			String text53 = (content14.text()).substring(2, (content54.text()).length());
			String text54 = content55.text();
			
			Elements content61 = doc.select("#assetRealLTC_KRW");	// 실시간 시세
			Elements content62 = doc.select("#assetRealPriceLTC_KRW");	// 전일 대비 변동액
			Elements content63 = doc.select("#assetRealRateLTC_KRW");	// 전일 대비 변동률 %
			Elements content64 = doc.select("#assetRealLTC_KRW2KRW");	// 거래량 (24H)
			Elements content65 = doc.select(".sort_total.assetTotalLTC_KRW");	// 시가총액
			String text60 = "라이트코인";
			String text61 = content61.text();
			String text62 = content62.text() + " (" + content63.text() + ")";
			String text63 = (content64.text()).substring(2, (content64.text()).length());
			String text64 = content65.text();
			
			Elements content71 = doc.select("#assetRealLINK_KRW");	// 실시간 시세
			Elements content72 = doc.select("#assetRealPriceLINK_KRW");	// 전일 대비 변동액
			Elements content73 = doc.select("#assetRealRateLINK_KRW");	// 전일 대비 변동률 %
			Elements content74 = doc.select("#assetRealLINK_KRW2KRW");	// 거래량 (24H)
			Elements content75 = doc.select(".sort_total.assetTotalLINK_KRW");	// 시가총액
			String text70 = "체인링크";
			String text71 = content71.text();
			String text72 = content72.text() + " (" + content73.text() + ")";
			String text73 = (content74.text()).substring(2, (content74.text()).length());
			String text74 = content75.text();

			
			
				//텍스트 파일 저장값 선언
			
			String text08, text18, text28, text38, text48, text58, text68, text78;			//현재 보유 화폐 가치

			
							//텍스트 파일에 저장된 값 가져오기
			
			FileMaker FileM = new FileMaker();		// 로그인 버튼을 누르면 FileMaker 클래스의 DirMaker가 작동. Info.txt 디폴트
			FileM.MakeEncDec();						// 폴더가 없으면 폴더 생성 후 default default인 텍스트 파일 생성. Info_b 생성
			
   		
				// LineNumber의 다음 다음 줄에 이전 시세, 보유액 등이 저장되어있을 경우 첫 세 문자는 "#$&" 
   			//해독된 Info_b에서 #$&로 시작하는 줄의 데이터를 가져온다.
   		try
			{
	            //파일 객체 생성
	            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
	            //입력 스트림 생성
	            FileReader filereader = new FileReader(file);
	            //입력 버퍼 생성
	            BufferedReader bufReader = new BufferedReader(filereader);
	            String line = "";
	            int Templine = 0;
	            while((line = bufReader.readLine()) != null)	// 빈 줄이 생길 때까지		
	            {
	            	Templine = Templine + 1;
	            	if ((LineNumber+2) == Templine)		//아이디가 1번째 줄에 있으면 데이터는 3번째 줄에 있다.
	            	{
	            		// 이 상태의 line은 총 투자 금액, 총 보유액, 현 보유액을 의미
	
	            		
	            		line = bufReader.readLine();			// 이전 보유 화폐 수 			예시: 0#0#0#0#0#0#0#0
	            		String arr00[] = line.split("#");		// #으로 나누기				예시: arr00[0] == 0, arr00[1] == 0...
	            		
	            		line = bufReader.readLine();			// 이전 보유 화폐 가치
	            		String arr01[] = line.split("#"); 		// #으로 나누기
	            		
	            		float floata0 = Float.parseFloat(arr00[0]);
	            		float floata1 = Float.parseFloat(arr00[1]);					// text01 등과 arr00[0] 등을 모두 float 자료형으로 변환
	            		float floata2 = Float.parseFloat(arr00[2]);
	            		float floata3 = Float.parseFloat(arr00[3]);					// floata 는 화폐 보유 량
	            		float floata4 = Float.parseFloat(arr00[4]);					// 소숫점 3자리, 즉 0.000까지 표현 가능하게 한다.
	            		float floata5 = Float.parseFloat(arr00[5]);
	            		float floata6 = Float.parseFloat(arr00[6]);
	            		float floata7 = Float.parseFloat(arr00[7]);
	            		
	            		
	            		String r0, r1, r2, r3, r4, r5, r6, r7;			// 실시간 화폐가치 텍스트
	            		
	            		r0 = text01.replaceAll(",", "");
	            		r0 = r0.replaceAll(" ", "");
	            		r0 = r0.replaceAll("원", "");
	            		r1 = text11.replaceAll(",", "");				// 실시간 화폐 가치 문자열의 ",", " ", "원" 을 제거하여 float 형 변환이 가능하게 만든다.
	            		r1 = r1.replaceAll(" ", "");
	            		r1 = r1.replaceAll("원", "");
	            		r2 = text21.replaceAll(",", "");
	            		r2 = r2.replaceAll(" ", "");
	            		r2 = r2.replaceAll("원", "");
	            		r3 = text31.replaceAll(",", "");
	            		r3 = r3.replaceAll(" ", "");
	            		r3 = r3.replaceAll("원", "");
	            		r4 = text41.replaceAll(",", "");
	            		r4 = r4.replaceAll(" ", "");
	            		r4 = r4.replaceAll("원", "");
	            		r5 = text51.replaceAll(",", "");
	            		r5 = r5.replaceAll(" ", "");
	            		r5 = r5.replaceAll("원", "");
	            		r6 = text61.replaceAll(",", "");
	            		r6 = r6.replaceAll(" ", "");
	            		r6 = r6.replaceAll("원", "");
	            		r7 = text71.replaceAll(",", "");
	            		r7 = r7.replaceAll(" ", "");
	            		r7 = r7.replaceAll("원", "");
	            		
	            		
	            		float floatb0 = Float.parseFloat(r0);
	            		float floatb1 = Float.parseFloat(r1);					// floatb 는 현재 화폐 시가
	            		float floatb2 = Float.parseFloat(r2);
	            		float floatb3 = Float.parseFloat(r3);
	            		float floatb4 = Float.parseFloat(r4);
	            		float floatb5 = Float.parseFloat(r5);
	            		float floatb6 = Float.parseFloat(r6);
	            		float floatb7 = Float.parseFloat(r7);
	            		
	            		
	            		
	            		text08 = (Float.toString(Math.round(floata0*floatb0))).replace(".0", "");			// 화폐 수량 * 현재 시가
	            		text18 = (Float.toString(Math.round(floata1*floatb1))).replace(".0", "");			// 소수 버리기
	            		text28 = (Float.toString(Math.round(floata2*floatb2))).replace(".0", "");			// 어째선지 text는 소수 첫째자리가 나타난다.
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
			
	     } 
		 catch (IOException e3) 
		 {
	         e3.printStackTrace();
	     }
	
		 return data;
		
	};
	
	public int[] GetData(String[][] data, int[] ilbl1, int LineNumber)			//문제
	{
		 
			
							//텍스트 파일에 저장된 값 가져오기
			
		FileMaker FileM = new FileMaker();		// 로그인 버튼을 누르면 FileMaker 클래스의 DirMaker가 작동. Info.txt 디폴트
		FileM.MakeEncDec();						// 폴더가 없으면 폴더 생성 후 default default인 텍스트 파일 생성. Info_b 생성
		
		
		try
		{
            //파일 객체 생성
            File file = new File("C:/VirtualMoneySimulator/Info_b.txt");
            //입력 스트림 생성
            FileReader filereader = new FileReader(file);
            //입력 버퍼 생성
            BufferedReader bufReader = new BufferedReader(filereader);
            String line = "";
            int Templine = 0;
            while((line = bufReader.readLine()) != null)	// 빈 줄이 생길 때까지		
            {
            	Templine = Templine + 1;
            	if ((LineNumber+2) == Templine)		//아이디가 1번째 줄에 있으면 데이터는 3번째 줄에 있다.
            	{
            		// 이 상태의 line은 총 투자 금액, 총 보유액, 현 보유액을 의미

            		String Strilbl1[] = line.split("#");							//예시: 0#0#0
            		ilbl1[0] = Integer.parseInt(Strilbl1[0]);
            		ilbl1[3] = Integer.parseInt(Strilbl1[1]);
            		ilbl1[2] = Integer.parseInt(Strilbl1[2]);
            		ilbl1[1] = ilbl1[2] + ilbl1[3];
            		
            		//ilbl1[0] = 0;		// 총 입금액. 텍스트 파일에 ****#0#0 으로 저장됨.
            	    //ilbl1[1] = 0;		// 총 보유액.  현 보유금액과 현 투자금액의 합산.
            	    //ilbl1[2] = 0;					// 아직 투자하지 않은 입금액.  0#0#**** 으로 저장됨.
            	    //ilbl1[3] = 0;					// 현 투자금액. 텍스트파일에 0#****#0 으로 저장됨.
            		
            		
            		
            		
            		line = bufReader.readLine();			// 이전 보유 화폐 수 			예시: 0#0#0#0#0#0#0#0
            		String arr00[] = line.split("#");		// #으로 나누기				예시: arr00[0] == 0, arr00[1] == 0...
            		
            		line = bufReader.readLine();			// 이전 보유 화폐 가치
            		String arr01[] = line.split("#"); 		// #으로 나누기
            		
            					
        			
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
		return ilbl1;
			
	     


	}
}

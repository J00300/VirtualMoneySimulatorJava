package pr;



public class Main {

	public static void main(String[] args) {
		 // 텍스트 필드 생성자 
        new TextField1("가상화폐 시뮬레이터");
		
		Seleniumprocess test = new Seleniumprocess();
		
		
 		test.oper("https://www.bithumb.com/trade/status/BTC_KRW", "BTC.png");
 		test.oper("https://www.bithumb.com/trade/status/XRP_KRW", "XRP.png");
 		test.oper("https://www.bithumb.com/trade/status/ETH_KRW", "ETH.png");
 		test.oper("https://www.bithumb.com/trade/status/EOS_KRW", "EOS.png");
 		test.oper("https://www.bithumb.com/trade/status/BSV_KRW", "BSV.png");
 		test.oper("https://www.bithumb.com/trade/status/BCH_KRW", "BCH.png");
 		test.oper("https://www.bithumb.com/trade/status/LTC_KRW", "LTC.png");
 		test.oper("https://www.bithumb.com/trade/status/LINK_KRW", "LINK.png");
 		

	}

}

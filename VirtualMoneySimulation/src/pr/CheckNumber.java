package pr;

public class CheckNumber 
{
	public CheckNumber() {};
	
	public boolean CheckNumber(String str)
	{
		char check;
		
		if(str.equals(""))
		{
			//문자열이 공백인지 확인
			return false;
		}
		
		for(int i = 0; i<str.length(); i++){
			check = str.charAt(i);
			if( check < 48 || check > 58)
			{
				//해당 char값이 숫자가 아닐 경우
				return false;
			}
			
		}		
		return true;
	}
}

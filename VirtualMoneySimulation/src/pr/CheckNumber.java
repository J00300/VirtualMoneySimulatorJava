package pr;

public class CheckNumber 
{
	public CheckNumber() {};
	
	public boolean CheckNumber(String str)
	{
		char check;
		
		if(str.equals(""))
		{
			//���ڿ��� �������� Ȯ��
			return false;
		}
		
		for(int i = 0; i<str.length(); i++){
			check = str.charAt(i);
			if( check < 48 || check > 58)
			{
				//�ش� char���� ���ڰ� �ƴ� ���
				return false;
			}
			
		}		
		return true;
	}
}

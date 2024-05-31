package assignment;

public class Vinay {

	public static void main(String[] args) {
		
		String s="Vinayay Parity";
//		String s1="Vinay Parit";
//		String s=new String ("Vinay Parit");
		
		
		for(int i=0;i<s.length();i++)
		{
			int count=0;
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(i)==s.charAt(j))
				{
					if(i>j)
					{
						break;
					}
					else
					{
						count++;
					}
				}
			}
			if(count>=1)
			{
				System.out.print(s.charAt(i));
			}
		}
	}
}

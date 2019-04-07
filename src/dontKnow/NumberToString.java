package dontKnow;


/*
 * 
 * This program is to print the possible strings from given number.
 * 
 * Conditions:
 * 	If number consists of continuous Zeros, program gives runtime exception.
 * 	
 * 	Still we can optimize this program by using character array instead of string and
 * 	pass start and end indexes as function parameters. Substring operations are costly.
 * 
 * 	NOTE: This program prints all permutations, i.e. repeated values as well. We can use HashMap or Set to overcome this.
 * 
 */

public class NumberToString {

	public String alphabets;
	
	public NumberToString()
	{
		alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	
	public void printString(String number)
	{
		printStringHelper(number, "");
	}

	private void printStringHelper(String number, String prefix) {
		
		if(number.equals(""))
		{
			System.out.println(prefix);
		}
		else
		{
			Integer i =Integer.parseInt(number.charAt(number.length()-1)+"");
			Integer ii = -1;
			if(number.length() >= 2)
			{
				ii = Integer.parseInt(""+number.charAt(number.length()-2)+number.charAt(number.length()-1));
			}
			
			// Handling some cases
			// Instead of this, trim all leading zeros
			if(number.equals("0"))
			{
				printStringHelper("",prefix);
			}
			
			
			if(i != 0 )
			{
				printStringHelper(number.substring(0,number.length()-1),alphabets.charAt(i-1) +prefix);
			}
			
			if(ii == 0)
			{
				System.out.println("Not posible..");
				throw new RuntimeException("Not possible to create a string");
			}
			
			else if(( i == 0 && ii != -1) || 
					(ii != -1 && ii <= 26 )
					)
			{
				printStringHelper(number.substring(0,number.length()-2),alphabets.charAt(ii-1) +prefix);
			}
					
			
			
		}
		
		
	}

	public static void main(String args[])
	{
		NumberToString ns = new NumberToString();
		
//		ns.printString("123");
//		ns.printString("314");
//		ns.printString("12321");
//		ns.printString("100"); // throws runtime exception
//		ns.printString("1232");
//		ns.printString("123210");
		ns.printString("027");
		
	}
	
	
}

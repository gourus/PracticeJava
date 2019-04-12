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
			Integer ii = -1;

			// Converting last character of string to number 
			Integer i =Integer.parseInt(
					String.valueOf(number.charAt(number.length()-1) )
					);
			
			// Converting last two characters of string to number
			if(number.length() >= 2)
			{
				ii = Integer.parseInt(	
						String.valueOf(number.charAt(number.length()-2))
						.concat(String.valueOf(number.charAt(number.length()-1)))
						);
			}
			
			// Handling some cases
			// Instead of this, trim all zeros at starting
			if(number.equals("0"))
			{
				printStringHelper("",prefix);
			}
						
			// If we take only one digit
			if(i != 0 )
			{
				printStringHelper(
						number.substring(0,number.length()-1), 
						alphabets.charAt(i-1) + prefix 
						);
			}
			
			// This if is to handing some base case like, not to allow 2 consecutive zeros in number
			if(ii == 0)
			{
				System.out.println("Not posible..");
				throw new RuntimeException("Not possible to create a string");
			}
			
			// Take 2 digits if possible to form a new string
			else if(( i == 0 && ii != -1) || 
					(ii != -1 && ii <= 26 )
					)
			{
				printStringHelper(
						number.substring(0,number.length()-2),
						alphabets.charAt(ii-1) + prefix
						);
			}		
			
		}
		
		
	}

	public static void main(String args[])
	{
		NumberToString ns = new NumberToString();
		
		ns.printString("123");
//		ns.printString("123123123123");
//		ns.printString("314");
//		ns.printString("12321");
//		ns.printString("100"); // throws runtime exception
//		ns.printString("1232");
//		ns.printString("123210");
//		ns.printString("027");
		
	}
	
	
}

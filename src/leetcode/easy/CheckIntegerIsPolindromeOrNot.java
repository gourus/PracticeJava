package leetcode.easy;

public class CheckIntegerIsPolindromeOrNot {

	static public boolean isPalindrome(int x) {
		
		
		//Base cases : to remove Negative number and a number 0 as last digit
		if (x < 0 || (x % 10 == 0 && x!= 0) ) {
            return false;
        }
        
        int revNumber = 0;
        
        while (x > revNumber) {
            revNumber = revNumber * 10 + x % 10;
            x = x/10;
        }
        
        return (x == revNumber || x == revNumber/10);
        		
	}

	public static void main(String[] args) {
		
		System.out.println(isPalindrome(1000000001));

	}

}

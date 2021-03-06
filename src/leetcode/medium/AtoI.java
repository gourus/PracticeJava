package leetcode.medium;

/**
 * Implement atoi which converts a string to an integer.
 * 
 * The function first discards as many whitespace characters as necessary until
 * the first non-whitespace character is found. Then, starting from this
 * character, takes an optional initial plus or minus sign followed by as many
 * numerical digits as possible, and interprets them as a numerical value.
 * 
 * The string can contain additional characters after those that form the
 * integral number, which are ignored and have no effect on the behavior of this
 * function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid
 * integral number, or if no such sequence exists because either str is empty or
 * it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned.
 * 
 * Note:
 * 
 * Only the space character ' ' is considered as whitespace character. Assume we
 * are dealing with an environment which could only store integers within the
 * 32-bit signed integer range: [−231, 231 − 1]. If the numerical value is out
 * of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is
 * returned. 
 * 
 * Example 1:
 * Input: "42" 
 * Output: 42 
 * 
 * Example 2:
 * Input: " -42" 
 * Output: -42 
 * Explanation: The first non-whitespace character is
 * '-', which is the minus sign. Then take as many numerical digits as possible,
 * which gets 42. 
 * 
 * Example 3:
 * Input: "4193 with words" 
 * Output: 4193 
 * Explanation: Conversion stops at digit
 * '3' as the next character is not a numerical digit. Example 4:
 * 
 * Input: "words and 987" 
 * Output: 0 
 * Explanation: The first non-whitespace
 * character is 'w', which is not a numerical digit or a +/- sign. Therefore no
 * valid conversion could be performed. Example 5:
 * 
 * Input: "-91283472332" 
 * Output: -2147483648 
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 * 
 * @author sgouru
 *
 */

public class AtoI {

	public static int myAtoi(String str) {

		// Base condition
		if (str == null || str.isEmpty() || str.trim().isEmpty()) {
			return 0;
		}

		String inp = str.trim();
		boolean neg = false;
		int i = 0;

		if (inp.length() == 1 && !Character.isDigit(inp.charAt(0))) {
			return 0;
		}
		
		if (inp.charAt(0) == '+') {
			if (!Character.isDigit(inp.charAt(1))) {
				return 0;
			}
			i = 1;
		}else if (inp.charAt(0) == '-') {
			if (!Character.isDigit(inp.charAt(1))) {
				return 0;
			}
			neg = true;
			i = 1;
		}
		
		int res = 0;
		int prev = 0;

		for (; i < inp.length(); i++) {
			
			prev = res;

			if(Character.isDigit(inp.charAt(i))) {
				res = res * 10 + (inp.charAt(i) - '0');
			} else {
				if(neg == false) {
					return res;
				} else {
					return -res;	
				}
			}
			
			//Checking for out of integer values
			if(prev != res/10) {
				if (neg == false) {
					return Integer.MAX_VALUE;
				} else {
					return Integer.MIN_VALUE;
				}
			}
		}

		if(neg == false) {
			return res;
		} else {
			return -res;	
		}

	}
	
	public static void main(String[] args) {
		System.out.println(myAtoi("  -0012a42"));
		System.out.println(myAtoi("+1"));
		System.out.println(myAtoi("   "));
		System.out.println(myAtoi(null));
		System.out.println(myAtoi("42"));
		System.out.println(myAtoi("-42"));
		System.out.println(myAtoi("4193 with words"));
		System.out.println(myAtoi("words and 987"));
		System.out.println(myAtoi("-91283472332"));
		System.out.println(myAtoi("2147483646"));
		System.out.println(myAtoi("2147483648"));
		System.out.println(myAtoi("-6147483648"));
	}

}

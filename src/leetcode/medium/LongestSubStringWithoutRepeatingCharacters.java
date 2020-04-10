package leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Question From Leetcode
 * 
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3.
 * 
 * Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1.
 * 
 * Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author sgouru
 *
 */

public class LongestSubStringWithoutRepeatingCharacters {

	static int findLengthOfLongestSubStrWithOutRepeatingChar(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}

		Set<Character> set = new HashSet<Character>();

		int low = 0;
		int hi = 0;

		int maxSubStrLength = 1;

		while (hi < s.length()) {

			if (set.isEmpty() || !set.contains(s.charAt(hi))) {
				set.add(s.charAt(hi));
				maxSubStrLength = Math.max(set.size(), maxSubStrLength);
				hi++;
			} else {
				set.remove(s.charAt(low));
				low++;
			}
		}

		return maxSubStrLength;
	}

	static public int lengthOfLongestSubstring(String str) {
		
		// From Geeks for geeks : which is optimized

		if (str == null || str.length() == 0) {
			return 0;
		}

		int n = str.length();
		int cur_len = 1; // length of current substring
		int max_len = 1; // result
		int prev_index; // previous index
		int i;
		int visited[] = new int[256];

		/*
		 * Initialize the visited array as -1, -1 is used to indicate that character has
		 * not been visited yet.
		 */
		for (i = 0; i < 256; i++) {
			visited[i] = -1;
		}

		/*
		 * Mark first character as visited by storing the index of first character in
		 * visited array.
		 */
		visited[str.charAt(0)] = 0;

		/*
		 * Start from the second character. First character is already processed
		 * (cur_len and max_len are initialized as 1, and visited[str[0]] is set
		 */
		for (i = 1; i < n; i++) {
			prev_index = visited[str.charAt(i)];

			/*
			 * If the current character is not present in the already processed substring or
			 * it is not part of the current NRCS, then do cur_len++
			 */
			if (prev_index == -1 || i - cur_len > prev_index)
				cur_len++;

			/*
			 * If the current character is present in currently considered NRCS, then update
			 * NRCS to start from the next character of the previous instance.
			 */
			else {
				/*
				 * Also, when we are changing the NRCS, we should also check whether length of
				 * the previous NRCS was greater than max_len or not.
				 */
				if (cur_len > max_len)
					max_len = cur_len;

				cur_len = i - prev_index;
			}

			// update the index of current character
			visited[str.charAt(i)] = i;
		}

		// Compare the length of last NRCS with max_len and
		// update max_len if needed
		if (cur_len > max_len)
			max_len = cur_len;

		return max_len;

	}

	public static void main(String[] args) {

		System.out.println(findLengthOfLongestSubStrWithOutRepeatingChar("abcabcabca"));
		lengthOfLongestSubstring("abcaauohhg");

	}

}

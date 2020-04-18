package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Example:
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * @author sgouru
 *
 */

public class LetterCombinationsOfPhoneNumber {

	static public List<String> letterCombinations(String digits) {

		List<String> resList = new ArrayList<String>();
		Map<Integer, String> map = new HashMap<Integer, String>();

		map.put(1, "1");
		map.put(2, "abc");
		map.put(3, "def");
		map.put(4, "ghi");
		map.put(5, "jkl");
		map.put(6, "mno");
		map.put(7, "pqrs");
		map.put(8, "tuv");
		map.put(9, "wxyz");
		map.put(0, "0");

		letterCombinationsHelper(digits, 0, digits.length(), "", resList, map);
		
		Stream.of(resList).forEach(System.out::println);
		
		return resList;
	}

	private static void letterCombinationsHelper(String digits, int index, int length, String current,
			List<String> resList, Map<Integer, String> map) {

		if (index == length) {
			resList.add(current);
			return;
		}

		String value = map.getOrDefault(Integer.parseInt(digits.charAt(index) + ""), "");

		for (int i = 0; i < value.length(); i++) {
			letterCombinationsHelper(digits, index+1, length, current + value.charAt(i), resList, map);
		}

	}
	
	public static void main(String[] args) {
		letterCombinations("2345");
	}

}

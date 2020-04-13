package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * 
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"], 
 * Output: [ ["ate","eat","tea"], ["nat","tan"], ["bat"] ] Note:
 * 
 * All inputs will be in lowercase. 
 * The order of your output does not matter.
 * 
 * @author sgouru
 *
 */

public class GroupAnagrams {

	static public List<List<String>> groupAnagrams(String[] strs) {

		if (strs.length == 0) {
			return new ArrayList<List<String>>();
		}

		Map<String, List<String>> map = new HashMap<String, List<String>>();

		for (String s : strs) {

			char[] a = s.toCharArray();

			Arrays.sort(a);

			String st = String.valueOf(a);

			if (!map.containsKey(st)) {
				map.put(st, new ArrayList<String>());
			}

			map.get(st).add(s);

		}

		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		
		String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		
		List<List<String>> op = groupAnagrams(strs);
		
		for(List<String> l : op ) {
			Stream.of(l.toString()).forEach(System.out::println);
		}
		
		
	}

}

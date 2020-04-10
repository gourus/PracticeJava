package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Question from Leetcode
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author sgouru
 *
 */
public class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> res = new HashSet<List<Integer>>();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		Map<Integer, Integer> mapIndex = new HashMap<Integer, Integer>();
		
		Arrays.sort(nums);

		int ind = 0;
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0)+1);
			mapIndex.put(i,ind++);
		}

		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			int val = map.getOrDefault(key, 0);
			map.replace(key, val-1);
			for (int j = i + 1; j < nums.length; j++) {
				int key_j = nums[j];
				int val_j = map.getOrDefault(key_j, 0);
				map.replace(key_j, val_j-1);

				int twoSum = nums[i] + nums[j];
				
				if(map.containsKey(0 - twoSum) && mapIndex.get(0 - twoSum) > j)
				{
					if(map.get(0-twoSum) > 0)
					{
						res.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], 0 - twoSum)));
					}
				}
				
				map.replace(key_j, val_j);
			
			}
			map.replace(key, val);
		} 
		
		return res.stream().collect(Collectors.toList());

	}
	
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> res = threeSum(nums);
		
		for (List<Integer> list : res) {
			Stream.of(list.toString()).forEach(System.out::println);
		}
	}

}

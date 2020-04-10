package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Question from Leetcode
 * 
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example: Given nums = [2, 7, 11, 15], target = 9, Because nums[0] + nums[1] =
 * 2 + 7 = 9, return [0, 1].
 * 
 * @author sgouru
 *
 */

public class TwoSum {

	static int[] twoSum(int[] nums, int target) {

		int[] arr = new int[2];
		Map<Integer, Integer> hashMap = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				arr[0] = hashMap.get(target - nums[i]);
				arr[1] = i;
				return arr;

			}
			hashMap.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {

		int[] nums = { 2, 7, 11, 15 };

		int[] a = twoSum(nums, 9);

		if (a == null) {
			System.out.println(a);
		} else {

			for (int i : a) {
				System.out.println(i);
			}
		}
	}

}

package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3] 
 * Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 * 
 * @author sgouru
 *
 */

public class Permutaions {
	
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        permuteHelper(nums, 0, nums.length, res);
        
        return removeDuplicates(res);
                
    }

	private List<List<Integer>> removeDuplicates(List<List<Integer>> res) {
		
        Set<List<Integer>> resSet = new HashSet<List<Integer>>();
        resSet.addAll(res);
		return resSet.stream().collect(Collectors.toList());
	}

	private void permuteHelper(int[] nums, int presentIndex, int length, List<List<Integer>> res) {
		
		if(presentIndex == length) {
			res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
			
		}
		
		for(int i = presentIndex; i< length; i++) {
			
			swap(nums, i, presentIndex);
			
			permuteHelper(nums, presentIndex+1, length, res);
			
			swap(nums, presentIndex, i);
		}
		
	}

	private void swap(int[] nums, int i, int presentIndex) {
		int temp = nums[i];
		nums[i] = nums[presentIndex];
		nums[presentIndex] = temp;
	}
	
	public static void main(String[] args) {
		
		Permutaions p = new Permutaions();
		
		List<List<Integer>> res = p.permute(new int[]{1,2,3});
		
		for(List<Integer> list : res) {
			Stream.of(list).forEach(System.out::print);
			System.out.println();
		}
		
		System.out.println("============");
		
		res.clear();
		
		res = p.permute(new int[]{1,1,3});
		
		for(List<Integer> list : res) {
			Stream.of(list).forEach(System.out::print);
			System.out.println();
		}

		
	}


}

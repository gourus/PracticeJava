package leetcode.easy;

public class RemoveDuplicates {

    public static int removeDuplicates(int[] nums) {

        // Starting condition
        if(nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        
        int current = 0;
        for (int i=1; i<nums.length; i++) {
            if (nums[current] != nums[i]) {
                if(current != i-1) {
                    nums[current+1] = nums[i];
                }
                current++;
            }
        }
        
        return current+1;
        
    }
    
    public static void main(String[] args) {
    	
    	int [] nums = {0,0,1,1,1,2,2,3,3,4};
    	
    	int res = removeDuplicates(nums);
    	
    	for(int i=0; i< res; i++) {
    		System.out.println(nums[i]);
    	}
		
	}
	
}

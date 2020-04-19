package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Stream;

/**
 * 
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ 	"((()))", 
 * 		"(()())", 
 * 		"(())()", 
 * 		"()(())", 
 * 		"()()()" 
 * ]
 * 
 * @author sgouru
 *
 */

public class GenerateParentheses {
	
	
	public List<String> generateParenthesis(int n) {
		
		List<String> res = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n; i++) {
			sb.append('(');
			sb.append(')');
		}
		
		res = permute(sb.toString().toCharArray());
		
		return res;
        
    }
	
    public List<String> permute(char[] nums) {
        
        List<String> res = new ArrayList<String>();
        
        permuteHelper(nums, 0, nums.length, res);
        
        return removeDuplicates(res);
                
    }

	private List<String> removeDuplicates(List<String> res) {
		
        Set<String> resSet = new HashSet<String>();
        resSet.addAll(res);
		return new ArrayList<String>(resSet);
	}

	private void permuteHelper(char[] nums, int presentIndex, int length, List<String> res) {
		
		if(presentIndex == length) {
			
			if(isValid(String.copyValueOf(nums))) {
			res.add(String.copyValueOf(nums));
			}			
		}
		
		for(int i = presentIndex; i< length; i++) {
			
			swap(nums, i, presentIndex);
			
			permuteHelper(nums, presentIndex+1, length, res);
			
			swap(nums, presentIndex, i);
		}
		
	}

	private void swap(char[] nums, int i, int presentIndex) {
		char temp = nums[i];
		nums[i] = nums[presentIndex];
		nums[presentIndex] = temp;
	}
	
    public boolean isValid(String s) {
        
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        
        Stack<Character> stack = new Stack<Character>();
        
        for (Character c : s.toCharArray()) {
            if(c == '(') {
                stack.push(c);
            } else {                
                        if (!stack.isEmpty()) {
                            Character ch = stack.pop();
                            if(ch != '(') {
                                return false;
                            }
                        } else {
                            return false;
                        }
            }
        }
        
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;   
        }
        
    }
    
    
    public List<String> generateParanthesesBackTracing(int n) {
    	
    	List<String> res = new ArrayList<String>();
    	
    	generateParaHelper(new char[2*n],0, n, n, n, res);
    	
    	return res;
    	
    }
    
    
    /**
     * 
     * 
     * This method follows backTracing. Which is better than brute force.
     * 
     * Back trace follows the tree structure like this.
     * 
     * If the number of parantheses are 3. i.e. we need to generate the permutations of
     * valid parantheses of 3 pairs.
     * 
     * 
     * This back tracing follow DFS and uses these conditions.
     * 
     * If the parantheses is are called valid, when :
     * 	i. Number of left parantheses should be greater than right in present string
     *  ii. Should not add right parantheses untill left parantheses added. 
     * 
     * 
     * 						( 3, 3 )
     * 						   /	
     * 						  /
     * 					  (2, 3)
     * 						/	\
     * 					   /   	 \
     * 					  /	      \
     * 				(1,3)		   (2, 2)
     * 				/\					/
     * 			   /  \				   /
     * 			  /    \			  /
     * 		 (0, 3)    (1, 2)	(1, 2)
     * 		  \			/	\	/	\
     * 		   \		
     * 		 (0, 2)
     * 			\
     * 			 \
     * 			(0, 1)
     * 			  \
     * 			   \
     * 			  (0, 0) ==> Go untill left and right reaches to 0
     * 			
     * @param cs
     * @param ind
     * @param left
     * @param right
     * @param n
     * @param res
     */
    
    
    
    private void generateParaHelper(char[] cs, int ind, int left, int right, int n, List<String> res) {
    	
    	if(ind == 2*n) {
    		res.add(new String(cs));
    		return;
    	}
    	
    	if( left >= right) {
    		cs[ind] = '(';
    		generateParaHelper(cs, ind+1, left-1, right, n, res);
    	} else if (left < right) {

    		if(left != 0) {
        		cs[ind] = '(';
    			generateParaHelper(cs, ind+1, left-1, right, n, res);
    		}
    		cs[ind] = ')';
    		generateParaHelper(cs, ind+1, left, right-1, n, res);
    	}
    	
    	cs[ind] = '\0';
    		
	}

	public static void main(String[] args) {
    	
    	GenerateParentheses gp = new GenerateParentheses();
    	
    	
    	// Using brute force
    	// generate all permutations and only add valid parantheses
    	List<String> res = gp.generateParenthesis(3);
    	
    	for(String s : res) {
    		System.out.println(s);
    	}
    	
    	res.clear();
    	
    	
    	// Using back tracing
    	res = gp.generateParanthesesBackTracing(3);
    	
    	//Stream.of(res).forEach(System.out::println);
    	
    	System.out.println("==========");
    	
    	for(String s : res) {
    		System.out.println(s);
    	}
		
	}



}

package leetcode.hard;

/**
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3] nums2 = [2]
 * 
 * The median is 2.0 
 * 
 * Example 2:
 * 
 * nums1 = [1, 2] nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * @author sgouru
 */

//By Using merge sort technique, we can find the median in O(m+n) time.
//We need to solve this in O(log(m+n)) time. So we can use binary search technique.

//NOTE: This will work only when the length of the arrays are not equal.


public class MedianOfTwoSortedArrays {
	
	public static double findMedian(int [] num1, int [] num2) {
		
		int n = num1.length;
		int m = num2.length;
		
		if (n < m) {
			return findMedianHelper(num1, n, num2, m);
		} else {
			return findMedianHelper(num2, m, num1, n);
		}

	}

	private static double findMedianHelper(int[] a, int n, int[] b, int m) {
		
		int min_ind = 0;
		int max_ind = n;
		
		int i, j;
		
		while (min_ind <= max_ind) {
			i = (min_ind + max_ind) / 2;
			j = (n + m + 1) / 2 - i;
			
			if(i < n && j > 0 && (b[j-1] > a[i]) ) {
				min_ind = i+1;
			} else if (i>0 && j<m && a[i-1] > b[j] ) {
				min_ind = i-1;	
			} else {
				if (i == 0 ) {
					return b[j-1];
				} else if (j==0) {
					return a[i-1];
				} else {
					return Math.max(a[i-1], b[j-1]);
				}
			}
		}
		
		return 0;
	}

}

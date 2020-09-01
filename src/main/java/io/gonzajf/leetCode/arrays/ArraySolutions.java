package io.gonzajf.leetCode.arrays;

import java.util.Arrays;

public class ArraySolutions {

	/**
	 * Given an array nums of integers, return how many of them contain an even
	 * number of digits.
	 */
	public static int findNumbers(int[] nums) {

		int count = 0;
		int n = 1;
		for (int nr : nums) {

			int r = nr / 10;
			while (r != 0) {
				n++;
				r = r / 10;
			}
			if (n % 2 == 0) {
				count++;
			}
			n = 1;
		}
		return count;
	}

	/**
	 * Given an array of integers A sorted in non-decreasing order, 
	 * return an array of the squares of each number, also in sorted non-decreasing order. 
	 */
	public static int[] sortedSquares(int[] A) {

		for (int i = 0; i < A.length; i++) {
			A[i] = A[i]*A[i];
		}
		Arrays.sort(A);
		return A;
	}

	/**
	 * Given a fixed length array arr of integers, duplicate each occurrence of zero, 
	 * shifting the remaining elements to the right. 
	 * Note that elements beyond the length of the original array are not written.
	 * Do the above modifications to the input array in place, 
	 * do not return anything from your function
	 */
    public static void duplicateZeros(int[] arr) {
        
    	for (int i = 0; i < arr.length-1; i++) {
			if(arr[i] == 0) {
				for (int j = arr.length-1; j > i; j--) {
					arr[j] = arr[j-1];
				}
				arr[i+1] = 0;
				i++;
			}
		}
    }
    
    /**
     * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
     * 
     * Note:
     * The number of elements initialized in nums1 and nums2 are m and n respectively.
     * You may assume that nums1 has enough space (size that is equal to m + n) 
     * to hold additional elements from nums2.
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

    	int first = m-1;
    	int second = n-1;
    	
    	for (int i = nums1.length - 1; i >= 0; i--) {
			
    		if(second < 0) {
    			break;
    		}
    		if (first >= 0 && nums1[first] > nums2[second]) {
    			nums1[i] = nums1[first];
    			first--;
    		} else {
    			nums1[i] = nums2[second];
    			second--;
    		}
		}
    }
    
    public static int removeElement(int[] nums, int val) {
        
    	int p = 0;

    	for (int i = 0; i < nums.length; i++) {
			
    		if(nums[i] != val) {
    			nums[p] = nums[i];
    			p++;
    		}
		}
    	return p;
    }
    
    public static int removeDuplicates(int[] nums) {
    	
    	int p = 1;
    	int i = 0;
    	
    	while(p < nums.length) {
    		
    		if(nums[i] == nums[p]) {
    			p++;
    		} 
    		else {
    			nums[i+1] = nums[p];
    			p++;
    			i++;
    		}
    	}
        return i+1;
    }
}
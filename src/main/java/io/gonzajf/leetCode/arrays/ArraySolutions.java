package io.gonzajf.leetCode.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
	 * Given an array of integers A sorted in non-decreasing order, return an array
	 * of the squares of each number, also in sorted non-decreasing order.
	 */
	public static int[] sortedSquares(int[] A) {

		for (int i = 0; i < A.length; i++) {
			A[i] = A[i] * A[i];
		}
		Arrays.sort(A);
		return A;
	}

	/**
	 * Given a fixed length array arr of integers, duplicate each occurrence of
	 * zero, shifting the remaining elements to the right. Note that elements beyond
	 * the length of the original array are not written. Do the above modifications
	 * to the input array in place, do not return anything from your function
	 */
	public static void duplicateZeros(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0) {
				for (int j = arr.length - 1; j > i; j--) {
					arr[j] = arr[j - 1];
				}
				arr[i + 1] = 0;
				i++;
			}
		}
	}

	/**
	 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
	 * one sorted array.
	 * 
	 * Note: The number of elements initialized in nums1 and nums2 are m and n
	 * respectively. You may assume that nums1 has enough space (size that is equal
	 * to m + n) to hold additional elements from nums2.
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {

		int first = m - 1;
		int second = n - 1;

		for (int i = nums1.length - 1; i >= 0; i--) {

			if (second < 0) {
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

			if (nums[i] != val) {
				nums[p] = nums[i];
				p++;
			}
		}
		return p;
	}

	public static int removeDuplicates(int[] nums) {

		int p = 1;
		int i = 0;

		while (p < nums.length) {

			if (nums[i] == nums[p]) {
				p++;
			} else {
				nums[i + 1] = nums[p];
				p++;
				i++;
			}
		}
		return i + 1;
	}

	/**
	 * Given an array arr of integers, check if there exists two integers N and M
	 * such that N is the double of M ( i.e. N = 2 * M).
	 * 
	 * More formally check if there exists two indices i and j such that : i != j 0
	 * <= i, j < arr.length arr[i] == 2 * arr[j]
	 */
	public static boolean checkIfExist(int[] arr) {

		Map<Integer, Integer> map = new HashMap<>();

		for (int n : arr) {

			if (!map.containsKey(n * 2) && !(map.containsKey(n / 2) && n % 2 == 0)) {

				map.put(n, 1);
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * Given an array A of integers, return true if and only if it is a valid
	 * mountain array. Recall that A is a mountain array if and only if: A.length >=
	 * 3 There exists some i with 0 < i < A.length - 1 such that: A[0] < A[1] < ...
	 * A[i-1] < A[i] A[i] > A[i+1] > ... > A[A.length - 1]
	 */
	public static boolean validMountainArray(int[] A) {

		int i = 0;

		while (i < A.length && i + 1 < A.length && A[i] < A[i + 1]) {
			i++;
		}

		if (i == 0 || i + 1 >= A.length) {
			return false;
		}

		while (i < A.length && i + 1 < A.length) {
			if (A[i] <= A[i++ + 1]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Given an array arr, replace every element in that array with the greatest
	 * element among the elements to its right, and replace the last element with
	 * -1. After doing so, return the array.
	 */
	public static int[] replaceElements(int[] arr) {

		int max = arr[arr.length - 1];
		arr[arr.length - 1] = -1;

		for (int i = arr.length - 1; i > 0; i--) {
			int prev = arr[i - 1];
			arr[i - 1] = max;
			if (prev > max) {
				max = prev;
			}
		}
		return arr;
	}

	/**
	 * Given an array nums, write a function to move all 0's to the end of it while
	 * maintaining the relative order of the non-zero elements.
	 */
	public static void moveZeroes(int[] nums) {

		int zeroPointer = -1;
		for (int i = 0; i < nums.length; i++) {

			if (zeroPointer == -1 && nums[i] == 0) {
				zeroPointer = i;
			}
			if (zeroPointer != -1 && nums[i] != 0) {
				nums[zeroPointer] = nums[i];
				nums[i] = 0;
				zeroPointer++;
			}
		}
	}

	/**
	 * Given an array A of non-negative integers, return an array consisting of all
	 * the even elements of A, followed by all the odd elements of A. You may return
	 * any answer array that satisfies this condition.
	 */
	public static int[] sortArrayByParity(int[] A) {

		int oddPointer = -1;
		for (int i = 0; i < A.length; i++) {

			if (oddPointer == -1 && A[i] % 2 != 0) {
				oddPointer = i;
			}
			if (oddPointer != -1 && A[i] % 2 == 0) {
				int temp = A[oddPointer];
				A[oddPointer] = A[i];
				A[i] = temp;
				oddPointer++;
			}
		}
		return A;
	}

	/**
	 * Students are asked to stand in non-decreasing order of heights for an annual
	 * photo. Return the minimum number of students that must move in order for all
	 * students to be standing in non-decreasing order of height. Notice that when a
	 * group of students is selected they can reorder in any possible way between
	 * themselves and the non selected students remain on their seats.
	 */
	public static int heightChecker(int[] heights) {

		int swaps = 0;
		int[] copy = heights.clone();
		Arrays.sort(copy);

		for (int i = 0; i < heights.length; i++) {
			if(heights[i] != copy[i]) {
				swaps++;
			}
		}
		return swaps;
	}
}
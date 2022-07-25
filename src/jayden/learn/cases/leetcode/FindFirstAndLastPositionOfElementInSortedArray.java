package jayden.learn.cases.leetcode;

import java.util.Arrays;

/*
Find First and Last Position of Element in Sorted Array

Given an array of integers nums sorted in non-decreasing order,
 find the starting and ending position of a given target value.
If target is not found in the array, return [-1, -1].
You must write an algorithm with O(log n) runtime complexity.


Example 1

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]


Example 2

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]


Example 3

Input: nums = [], target = 0
Output: [-1,-1]
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    public static void main(String[] args) {
        {
            int[] nums = {5, 7, 7, 8, 8, 10};
            FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
            if ("[3, 4]".equals(Arrays.toString(solution.searchRange(nums, 8)))) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            int[] nums = {5, 7, 7, 8, 8, 10};
            FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
            if ("[-1, -1]".equals(Arrays.toString(solution.searchRange(nums, 6)))) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
        {
            int[] nums = {};
            FindFirstAndLastPositionOfElementInSortedArray solution = new FindFirstAndLastPositionOfElementInSortedArray();
            if ("[-1, -1]".equals(Arrays.toString(solution.searchRange(nums, 0)))) {
                System.out.println("Testcase 3: passed");
            } else {
                System.err.println("Testcase 3: failed");
            }
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int i = 0;
        while (i < nums.length) {
            int left = i + 1, right = i + 2;
            if (nums[i] == target) {
                if (res[0] == -1) {
                    res[0] = i;
                }
                res[1] = i;
            }
            if (left < nums.length && nums[left] == target) {
                if (res[0] == -1) {
                    res[0] = left;
                }
                res[1] = left;
            }
            if (right < nums.length && nums[right] == target) {
                if (res[0] == -1) {
                    res[0] = right;
                }
                res[1] = right;
            }
            i += 2;
        }
        return res;
    }
}

package jayden.learn.cases.leetcode;

import java.util.Arrays;
import java.util.List;

/*
You are given an integer array nums and you have to return a new counts array.
The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].


Example 1

Input: nums = [5,2,6,1]
Output: [2,1,1,0]
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.


Example 2

Input: nums = [-1]
Output: [0]


Example 3

Input: nums = [-1,-1]
Output: [0,0]
*/
public class CountOfSmallerNumbersAfterSelf {

    public static void main(String[] args) {
        {
            int[] nums = {5, 2, 6, 1};
            CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
            if ("[2, 1, 1, 0]".equals(solution.countSmaller(nums).toString())) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            int[] nums = {-1};
            CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
            if ("[0]".equals(solution.countSmaller(nums).toString())) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
        {
            int[] nums = {-1, -1};
            CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf();
            if ("[0, 0]".equals(solution.countSmaller(nums).toString())) {
                System.out.println("Testcase 3: passed");
            } else {
                System.err.println("Testcase 3: failed");
            }
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int[] indices = new int[nums.length];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = i;
        }
        Integer[] table = new Integer[nums.length];
        Arrays.fill(table, 0);
        mergeSort(table, nums, indices);
        return Arrays.asList(table);
    }

    private int[] mergeSort(Integer[] table, int[] nums, int[] indices) {
        int pivot = indices.length / 2;
        int[] leftIndices = Arrays.copyOfRange(indices, 0, pivot);
        int[] rightIndices = Arrays.copyOfRange(indices, pivot, indices.length);
        if (leftIndices.length > 1) {
            leftIndices = mergeSort(table, nums, leftIndices);
        }
        if (rightIndices.length > 1) {
            rightIndices = mergeSort(table, nums, rightIndices);
        }
        return merge(table, nums, leftIndices, rightIndices);
    }

    private int[] merge(Integer[] table, int[] nums, int[] leftIndices, int[] rightIndices) {
        int[] indices = new int[leftIndices.length + rightIndices.length];
        int left = 0, right = 0, ind = 0, count = 0;
        while (left < leftIndices.length && right < rightIndices.length) {
            if (nums[leftIndices[left]] <= nums[rightIndices[right]]) {
                int index = leftIndices[left++];
                indices[ind++] = index;
                table[index] += count;
            } else {
                indices[ind++] = rightIndices[right++];
                count++;
            }
        }
        while (left < leftIndices.length) {
            int index = leftIndices[left++];
            indices[ind++] = index;
            table[index] += count;
        }
        while (right < rightIndices.length) {
            indices[ind++] = rightIndices[right++];
        }
        return indices;
    }
}

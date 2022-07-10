package jayden.learn.cases.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/*
You are given a 0-indexed integer array nums and an integer k.
You are initially standing at index 0.
In one move, you can jump at most k steps forward without going outside the boundaries of the array.
That is, you can jump from index i to any index in the range [i + 1, min(n - 1, i + k)] inclusive.

You want to reach the last index of the array (index n - 1).
Your score is the sum of all nums[j] for each index j you visited in the array.
Return the maximum score you can get.


Example 1
Input: nums = [1,-1,-2,4,-7,3], k = 2
Output: 7
Explanation: You can choose your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is 7.


Example 2
Input: nums = [10,-5,-2,4,0,3], k = 3
Output: 17
Explanation: You can choose your jumps forming the subsequence [10,4,3] (underlined above). The sum is 17.

Example 3
Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
Output: 0
*/
public class JumpGame6 {

    public static void main(String[] args) {
        {
            int[] nums = {1, -1, -2, 4, -7, 3};
            int k = 2;
            JumpGame6 solution = new JumpGame6();
            System.out.println("Testcase 1: " + (7 == solution.maxResult(nums, k) ? "passed" : "failed"));
        }
        {
            int[] nums = {10,-5,-2,4,0,3};
            int k = 3;
            JumpGame6 solution = new JumpGame6();
            System.out.println("Testcase 2: " + (17 == solution.maxResult(nums, k) ? "passed" : "failed"));
        }
        {
            int[] nums = {1,-5,-20,4,-1,3,-6,-3};
            int k = 2;
            JumpGame6 solution = new JumpGame6();
            System.out.println("Testcase 3: " + (0 == solution.maxResult(nums, k) ? "passed" : "failed"));
        }
    }

    public int maxResult(int[] nums, int k) {
        Queue<Pair> queue = new PriorityQueue<>(k + 1);
        queue.add(new Pair(nums[nums.length - 1], nums.length - 1));
        for (int i = nums.length - 2; i >= 0; i--) {
            while (queue.peek().value > i + k) {
                queue.poll();
            }
            int sum = queue.peek().key + nums[i];
            if (i == 0) {
                return sum;
            }
            queue.add(new Pair(sum, i));
        }
        return -1;
    }

    class Pair implements Comparable<Pair> {

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.key, this.key);
        }
    }
}

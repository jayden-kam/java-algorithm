package jayden.learn.cases.leetcode;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        {
            int[] cost = {10,15,20};
            MinCostClimbingStairs solution = new MinCostClimbingStairs();
            if (15 == solution.minCostClimbingStairs(cost)) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
            MinCostClimbingStairs solution = new MinCostClimbingStairs();
            if (6 == solution.minCostClimbingStairs(cost)) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
    }

    public int minCostClimbingStairs(int[] cost) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            cost[i] = cost[i] + (i > 1 ? Math.min(cost[i - 2], cost[i - 1]) : 0);
            if (i >= cost.length - 2) {
                min = Math.min(cost[i], min);
            }
        }
        return min;
    }
}

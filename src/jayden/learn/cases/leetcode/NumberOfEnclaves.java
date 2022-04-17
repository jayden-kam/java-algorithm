package jayden.learn.cases.leetcode;

/*
You are given an m x n binary matrix grid, where 0 represents a sea cell and 1 represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell
    or walking off the boundary of the grid.

Return the number of land cells in grid for which we cannot walk off the boundary of the grid in any number of moves.

Example 1:
Input: grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
Explanation: There are three 1s that are enclosed by 0s, and one 1 that is not enclosed because its on the boundary.

Example 2:
Input: grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
Explanation: All 1s are either on the boundary or can reach the boundary.
 */
public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (isLandOnBoundary(i, j, grid)) {
                    reverseLandToSea(i, j, grid);
                }
            }
        }
        int count = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isLandOnBoundary(int i, int j, int[][] grid) {
        return grid[i][j] == 1 && (
                i == 0 || i == grid.length - 1 || j == 0 || j == grid[i].length - 1
        );
    }

    public static void reverseLandToSea(int i, int j, int[][] grid) {
        if (i >= 0 && i <= grid.length - 1 && j >= 0 && j <= grid[i].length - 1) {
            if (grid[i][j] == 1) {
                grid[i][j] = 0;
                reverseLandToSea(i - 1, j, grid); // upward
                reverseLandToSea(i + 1, j, grid); // downward
                reverseLandToSea(i, j - 1, grid); // left
                reverseLandToSea(i, j + 1, grid); // right
            }
        }
    }

    public static void main(String[] args) {
        testcaseOne();
        testcaseTwo();
    }

    public static void testcaseOne() {
        int[][] grid = {{0, 0, 0, 0}, {1, 0, 1, 0}, {0, 1, 1, 0}, {0, 0, 0, 0}};
        System.out.println("Testcase 1: " + (3 == numEnclaves(grid) ? "Passed" : "Failed"));
    }

    public static void testcaseTwo() {
        int[][] grid = {{0, 1, 1, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println("Testcase 2: " + (0 == numEnclaves(grid) ? "Passed" : "Failed"));
    }
}

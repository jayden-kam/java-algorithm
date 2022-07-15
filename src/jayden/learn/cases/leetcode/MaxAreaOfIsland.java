package jayden.learn.cases.leetcode;

/*
You are given an m x n binary matrix grid.
An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.
Return the maximum area of an island in grid. If there is no island, return 0.


Example 1

Input: grid = [
    [0,0,1,0,0,0,0,1,0,0,0,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,1,1,0,1,0,0,0,0,0,0,0,0],
    [0,1,0,0,1,1,0,0,1,0,1,0,0],
    [0,1,0,0,1,1,0,0,1,1,1,0,0],
    [0,0,0,0,0,0,0,0,0,0,1,0,0],
    [0,0,0,0,0,0,0,1,1,1,0,0,0],
    [0,0,0,0,0,0,0,1,1,0,0,0,0]
]
Output: 6
Explanation: The answer is not 11, because the island must be connected 4-directionally.


Example 2

Input: grid = [
    [0,0,0,0,0,0,0,0]
]
Output: 0
*/
public class MaxAreaOfIsland {

    public static void main(String[] args) {
        {
            int[][] grid = {
                    {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                    {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                    {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
            };
            MaxAreaOfIsland solution = new MaxAreaOfIsland();
            if (6 == solution.maxAreaOfIsland(grid)) {
                System.out.println("Testcase 1: passed");
            } else {
                System.err.println("Testcase 1: failed");
            }
        }
        {
            int[][] grid = {
                    {0, 0, 0, 0, 0, 0, 0, 0}
            };
            MaxAreaOfIsland solution = new MaxAreaOfIsland();
            if (0 == solution.maxAreaOfIsland(grid)) {
                System.out.println("Testcase 2: passed");
            } else {
                System.err.println("Testcase 2: failed");
            }
        }
    }

    public int maxAreaOfIsland(int[][] grid) {
        int result = 0;
        int[][] view = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (view[i][j] == 0) {
                    view[i][j] = 1;
                    if (grid[i][j] == 1) {
                        int res = 1;
                        if (j < grid[i].length - 1)
                            res += lookRight(view, grid, i, j);
                        if (i > 0)
                            res += lookUp(view, grid, i, j);
                        if (i < grid.length - 1)
                            res += lookDown(view, grid, i, j);
                        result = Math.max(res, result);
                    }
                }
            }
        }
        return result;
    }

    private int lookUp(int[][] view, int[][] grid, int i, int j) {
        int res = 0;
        i -= 1;
        if (view[i][j] == 0) {
            view[i][j] = 1;
            if (grid[i][j] == 1) {
                res = 1;
                if (i > 0)
                    res += lookUp(view, grid, i, j);
                if (j > 0)
                    res += lookLeft(view, grid, i, j);
                if (j < grid[i].length - 1)
                    res += lookRight(view, grid, i, j);
            }
        }
        return res;
    }

    private int lookDown(int[][] view, int[][] grid, int i, int j) {
        int res = 0;
        i += 1;
        if (view[i][j] == 0) {
            view[i][j] = 1;
            if (grid[i][j] == 1) {
                res = 1;
                if (i < grid.length - 1)
                    res += lookDown(view, grid, i, j);
                if (j > 0)
                    res += lookLeft(view, grid, i, j);
                if (j < grid[i].length - 1)
                    res += lookRight(view, grid, i, j);
            }
        }
        return res;
    }

    private int lookLeft(int[][] view, int[][] grid, int i, int j) {
        int res = 0;
        j -= 1;
        if (view[i][j] == 0) {
            view[i][j] = 1;
            if (grid[i][j] == 1) {
                res = 1;
                if (j > 0)
                    res += lookLeft(view, grid, i, j);
                if (i > 0)
                    res += lookUp(view, grid, i, j);
                if (i < grid.length - 1)
                    res += lookDown(view, grid, i, j);
            }
        }
        return res;
    }

    private int lookRight(int[][] view, int[][] grid, int i, int j) {
        int res = 0;
        j += 1;
        if (view[i][j] == 0) {
            view[i][j] = 1;
            if (grid[i][j] == 1) {
                res = 1;
                if (j < grid[i].length - 1)
                    res += lookRight(view, grid, i, j);
                if (i > 0)
                    res += lookUp(view, grid, i, j);
                if (i < grid.length - 1)
                    res += lookDown(view, grid, i, j);
            }
        }
        return res;
    }
}

package jayden.learn.cases.leetcode;

/*
Search a 2D Matrix II

Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix.
This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.


Example 1

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
Output: true


Example 2

Input: matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
Output: false
 */
public class SearchA2DMatrixII {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        SearchA2DMatrixII solution = new SearchA2DMatrixII();
        if (solution.searchMatrix(matrix, 5)) {
            System.out.println("Testcase 1: passed");
        } else {
            System.err.println("Testcase 1: failed");
        }
        if (solution.searchMatrix(matrix, 20)) {
            System.err.println("Testcase 2: failed");
        } else {
            System.out.println("Testcase 2: passed");
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0, j = matrix[0].length - 1;
        do {
            if (target == matrix[i][j]) {
                return true;
            } else if (target > matrix[i][j]) {
                i++;
            } else {
                j--;
            }
        } while (i < matrix.length && j >= 0);
        return false;
    }
}

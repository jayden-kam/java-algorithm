package jayden.learn.cases.leetcode;

/*
Given strings s1, s2, and s3, find whether s3 is formed by an interleaving of s1 and s2.

An interleaving of two strings s and t is a configuration where they are divided into non-empty substrings such that:
s = s1 + s2 + ... + sn
t = t1 + t2 + ... + tm
|n - m| <= 1

The interleaving is s1 + t1 + s2 + t2 + s3 + t3 + ... or t1 + s1 + t2 + s2 + t3 + s3 + ...
Note: a + b is the concatenation of strings a and b.

Example 1:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true

Example 2:
Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false

Example 3:
Input: s1 = "", s2 = "", s3 = ""
Output: true
*/
public class InterleavingString {

    public static void main(String[] args) {
        InterleavingString solution = new InterleavingString();
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println("Test Case 1: " + (solution.isInterleave(s1, s2, s3) ? "passed" : "failed"));

        solution = new InterleavingString();
        s1 = "";
        s2 = "";
        s3 = "";
        System.out.println("Test Case 2: " + (solution.isInterleave(s1, s2, s3) ? "passed" : "failed"));

        solution = new InterleavingString();
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbbbaccc";
        System.out.println("Test Case 3: " + (solution.isInterleave(s1, s2, s3) ? "failed" : "passed"));

        solution = new InterleavingString();
        s1 = "a";
        s2 = "b";
        s3 = "a";
        System.out.println("Test Case 4: " + (solution.isInterleave(s1, s2, s3) ? "failed" : "passed"));

        solution = new InterleavingString();
        s1 = "aabcc";
        s2 = "dbbca";
        s3 = "aadbcbbcac";
        System.out.println("Test Case 4: " + (solution.isInterleave(s1, s2, s3) ? "passed" : "failed"));
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int lengthS1 = s1.length(), lengthS2 = s2.length(), lengthS3 = s3.length();
        if (lengthS1 + lengthS2 != lengthS3) {
            return false;
        } else if (lengthS1 == 0) {
            return s2.equals(s3);
        } else if (lengthS2 == 0) {
            return s1.equals(s3);
        }
        boolean[][] matrix = new boolean[lengthS1 + 1][lengthS2 + 1];
        matrix[0][0] = true;
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j < matrix[0].length; j++) {
            matrix[0][j] = matrix[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) ||
                        (matrix[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
            }
        }
        return matrix[lengthS1][lengthS2];
    }
}

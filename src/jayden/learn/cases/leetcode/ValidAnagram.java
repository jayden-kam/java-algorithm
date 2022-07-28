package jayden.learn.cases.leetcode;

/*
Valid Anagram

Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 typically using all the original letters exactly once.


Example 1

Input: s = "anagram", t = "nagaram"
Output: true


Example 2

Input: s = "rat", t = "car"
Output: false
 */
public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        ValidAnagram solution = new ValidAnagram();
        System.out.println(solution.isAnagram(s, t));
    }

    public boolean isAnagram(String s, String t) {
        int[] sTable = new int[26], tTable = new int[26];
        for (char c : s.toCharArray()) {
            sTable[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tTable[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (sTable[i] != tTable[i]) {
                return false;
            }
        }
        return true;
    }
}

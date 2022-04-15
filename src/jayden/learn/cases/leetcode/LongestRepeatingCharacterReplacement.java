package jayden.learn.cases.leetcode;

/*
You are given a string s and an integer k.
You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/
public class LongestRepeatingCharacterReplacement {

    /*
    Many people know the problem can be reiterated as :
    "longest substring where (length - max occurrence) <= k"
    The key point is we are focusing on "longest".
    So assume we initially found a valid substring, what do we do next?

    1. Still valid even appended by one more char——then we are happy, just expand the window
    2. It became invalid. But at this time, do we have to shrink the window?
        ——No, we shift the whole window rightwards by one unit. So that the length is unchanged.
        The reason for that is , any index smaller than original "start",
        will never have the chance to lead a longer valid substring than current length of our window.
    3. Do we need to update max in time?
        ——No. Once again, we focus on "longest". The length of valid substring is determined by what?
        Max Occurrence + k
        We only need to update max occurrence when it becomes larger,
        because only that can we generate a longer valid substring.
        If we can't surpass the historic max occurrence,
        then we can not generate a longer valid substring from current "start",
        I mean the new windows's left bound. To some extend, this becomes a game to find max occurrence.
    */
    public static int characterReplacement(String s, int k) {
        s = s.toUpperCase();
        int maxWindow = 0, window = 0, most = 0, start = 0;
        int[] charArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            most = Math.max(most, ++charArray[s.charAt(i) - 'A']);
            window = i + 1 - start;
            if (window - most > k) {
                --charArray[s.charAt(start++) - 'A'];
            } else {
                maxWindow = Math.max(maxWindow, window);
            }
        }
        return maxWindow;
    }

    public static void main(String[] args) {
        testCaseOne();
        testCaseTwo();
    }

    public static void testCaseOne() {
        String s = "AABABBA";
        int k = 1;
        System.out.println("Test case 1: " + (4 == characterReplacement(s, k) ? "Passed" : "Failed"));
    }

    public static void testCaseTwo() {
        String s = "ABBB";
        int k = 2;
        System.out.println("Test case 2: " + (4 == characterReplacement(s, k) ? "Passed" : "Failed"));
    }
}

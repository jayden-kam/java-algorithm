package jayden.learn.cases.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
Given a list of strings words and a string pattern, return a list of words[i] that match pattern.
You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p
 so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters:
 every letter maps to another letter, and no two letters map to the same letter.
 */
public class FindAndReplacePattern {

    public static void main(String[] args) {
        String[] words = {
                "xyx"
        };
        String pattern = "abc";
        FindAndReplacePattern solution = new FindAndReplacePattern();
        System.out.println(solution.findAndReplacePattern(words, pattern));
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>(words.length);
        for (String word : words) {
            if (check(word, pattern)) {
                list.add(word);
            }
        }
        return list;
    }

    private boolean check(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            if (a.indexOf(a.charAt(i)) != b.indexOf(b.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

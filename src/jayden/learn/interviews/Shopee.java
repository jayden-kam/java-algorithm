package jayden.learn.interviews;

import java.util.Scanner;
import java.util.Stack;

public class Shopee {

    /* Excel Columns
    input should be either Upper Alpha string from 'A' to 'Z' (like "A", "AC", "ZZA") or pure numbers

    when input string "A", should return 1
    when input string "Z", should return 26
    when input string "AA", should return 27
    when input string "ZZ", should return 702
    when input string "AZZ", should return 1378
    when input string "XFD", should return 16384
        etc..

    when input number 1, should return "A"
    when input number 27, should return "AA"
    when input number 703, should return "AAA"
    when input number 2708874, should return "EXCEL"
    when input number 1110829947, should return "COLUMNS"
        etc..
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input:");
        String input = sc.nextLine();
        try {
            int number = Integer.parseInt(input);
            System.out.println(parseNumberToString(number));
            return;
        } catch (Exception e) {
            if (isStringValid(input)) {
                System.out.println(parseStringToNumber(input));
                return;
            }
        }
        System.out.println("Empty");// edge cases where just return empty string
    }

    private static boolean isStringValid(String input) {
        for (char c : input.toCharArray()) {
            if (!isCharValid(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isCharValid(char c) {
        return c > 64 && c < 91;
    }

    private static int getNumberFromChar(char c) {
        return c - 64;
    }

    private static char getCharFromNumber(int n) {
        return (char) (n + 64);
    }

    //main solution part 2
    private static String parseNumberToString(int number) {
        Stack<Character> stack = new Stack<>();
        int quotient, remainder;
        boolean needSub = false;
        do {
            quotient = number / 26;
            remainder = number % 26;
            if (needSub) {
                if (--remainder == 0 && quotient == 0) {
                    break;
                }
                needSub = false;
            }
            if (remainder == 0) {
                stack.push(getCharFromNumber(26));
                needSub = true;
            } else {
                stack.push(getCharFromNumber(remainder));
            }
            number = quotient;
        } while (quotient > 0);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    //main solution part 1
    private static int parseStringToNumber(String input) {
        int n = 0, m = input.length(), number = 0;
        while (m > 0) {
            number += getNumberFromChar(input.charAt(n++)) * Math.pow(26, --m);
        }
        return number;
    }
}

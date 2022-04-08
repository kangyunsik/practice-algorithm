package com.codingtest.algorithm.acmicpc.q15927;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        if (isPalindrome(input)) {
            if (isAllSame(input)) System.out.println("-1");
            else System.out.println(len - 1);
        } else {
            System.out.println(len);
        }
    }

    private static boolean isPalindrome(String input) {
        for (int i = 0, len = input.length(); i < len / 2; i++) {
            if (input.charAt(i) != input.charAt(len - 1 - i)) return false;
        }
        return true;
    }

    private static boolean isAllSame(String input) {
        char cur = input.charAt(0);
        for (int i = 1, len = input.length(); i < len; i++) {
            if(cur != input.charAt(i)) return false;
        }
        return true;
    }
}

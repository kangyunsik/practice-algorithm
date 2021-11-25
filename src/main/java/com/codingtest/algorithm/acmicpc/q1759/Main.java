package com.codingtest.algorithm.acmicpc.q1759;

import java.io.*;
import java.util.*;

public class Main {

    static char[] chars;
    static int l, c;
    static List<String> answer;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        answer = new ArrayList<>();
        sb = new StringBuilder();

        l = sc.nextInt();
        c = sc.nextInt();
        chars = new char[c];
        for (int i = 0; i < c; i++) {
            chars[i] = sc.next().charAt(0);
        }
        Arrays.sort(chars);
        find(0, 0, 0);
        for (String s : answer) {
            bw.write(s + "\n");
        }
        bw.flush();
    }

    private static void find(int current, int vowel, int count) {
        if (count == l && vowel > 0 && l - vowel > 1) {
            answer.add(sb.toString());
            return;
        }
        if (current == c) return;

        sb.append(chars[current]);
        find(current + 1, vowel + (isVowel(chars[current]) ? 1 : 0) , count + 1);
        sb.deleteCharAt(count);
        find(current + 1, vowel, count);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

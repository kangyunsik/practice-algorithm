package com.codingtest.algorithm.acmicpc.q17609;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            sb.append(func(input, 0, input.length() - 1, 0)).append("\n");
        }
        System.out.println(sb);
    }

    private static int func(String s, int l, int r, int d) {
        while (l < r && s.charAt(l) == s.charAt(r)) {
            l++;
            r--;
        }

        if (l < r) {
            if (d == 1) return 2;
            return Math.min(func(s, l + 1, r, d + 1), func(s, l, r - 1, d + 1));
        }
        return d;
    }
}
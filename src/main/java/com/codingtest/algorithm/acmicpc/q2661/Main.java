package com.codingtest.algorithm.acmicpc.q2661;

import java.io.*;
import java.util.*;

public class Main {
    static char[] ans;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = new char[n];
        find(0);
        System.out.println(ans);
    }

    static boolean find(int len) {
        if (len == n) return true;
        int cnt = 0;
        boolean[] can = new boolean[4];
        Arrays.fill(can, true);
        for (int j = len - 1; j >= 0; j -= 2) {
            String prev = new String(ans, j, cnt + 1);
            String post;
            for (int i = 1; i <= 3; i++) {
                post = new String(ans, j + cnt + 1, cnt) + i;
                if (prev.equals(post)) can[i] = false;
            }
            cnt++;
        }
        for (int i = 1; i <= 3; i++) {
            if (!can[i]) continue;
            ans[len] = (char) (i + '0');
            if (find(len + 1)) return true;
        }
        return false;
    }
}
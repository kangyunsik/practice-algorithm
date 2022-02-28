package com.codingtest.algorithm.acmicpc.q11585;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int[] pi;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        char[] input = new char[n];
        char[] pattern = new char[n];
        for (int i = 0; i < n; i++) {
            input[i] = st.nextToken().charAt(0);
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            pattern[i] = st.nextToken().charAt(0);
        }

        pi = new int[n];
        getPi(pattern);

        int ans = 0;
        for (int i = 0, j = 0; i < n * 2 - 1; i++) {
            while (j > 0 && input[i % n] != pattern[j]) j = pi[j - 1];
            if (input[i % n] != pattern[j]) continue;
            if (++j == pattern.length) {
                ans++;
                j = pi[j - 1];
            }
        }
        int gcd = gcd(ans, n);
        bw.write((ans / gcd) + "/" + (n / gcd));
        bw.flush();
    }

    private static void getPi(char[] pattern) {
        for (int i = 1, j = 0, len = pattern.length; i < len; i++) {
            while (j > 0 && pattern[i] != pattern[j]) j = pi[j - 1];
            if (pattern[i] == pattern[j]) pi[i] = ++j;
        }
    }

    private static int gcd(int ans, int n) {
        if (ans > n) return gcd(n, ans);
        if (n % ans == 0) return ans;
        return gcd(n, n % ans);
    }
}

package com.codingtest.algorithm.acmicpc.q1593;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        String b = br.readLine();
        int[] cnt = new int[128];
        int[] origin = new int[128];
        for (int i = 0; i < n; i++) {
            cnt[b.charAt(i)]++;
            origin[s.charAt(i)]++;
        }

        int ans = 0;
        if (isEqual(cnt, origin)) ans++;
        for (int i = n; i < m; i++) {
            cnt[b.charAt(i)]++;
            cnt[b.charAt(i - n)]--;
            if (isEqual(cnt, origin)) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean isEqual(int[] a, int[] b) {
        for (int i = 65; i < 123; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}

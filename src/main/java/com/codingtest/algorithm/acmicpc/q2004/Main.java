package com.codingtest.algorithm.acmicpc.q2004;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = n - m;
        int five_op = 1, five = 0;
        int two_op = 1, two = 0;
        int ans;

        while (five_op <= n/5) {
            five_op *= 5;
            five -= m / five_op;
            five -= k / five_op;
            five += n / five_op;
        }

        while (two_op <= n/2) {
            two_op *= 2;
            two -= m / two_op;
            two -= k / two_op;
            two += n / two_op;
        }

        ans = Math.min(two, five);
        if (ans < 0) {
            bw.write("0\n");
        } else {
            bw.write(ans + "\n");
        }
        bw.flush();
    }
}


package com.codingtest.algorithm.acmicpc.q10253;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        int ans;

        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            st = new StringTokenizer(br.readLine());
            ans = getAnswer(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            bw.write(ans + "\n");
            bw.flush();
        }
    }

    private static int getAnswer(int a, int b) {
        if (a == 1) {
            return b;
        }

        // [1,b]
        int s = 1, e = b;
        int x = -1;
        while (s < e) {
            x = s + (e - s) / 2;
            if (b <= (long) a * x) {
                e = x;
            } else {
                s = x;
                if(s == e-1){
                    break;
                }
            }
        }

        if(b <= (x+1) * a){
            x++;
        }
        int[] temp = subTract(a, b, 1, x);
        return getAnswer(temp[0], temp[1]);
    }

    private static int[] subTract(int a1, int b1, int a2, int b2) {
        int a = a1 * b2 - a2 * b1;
        int b = b1 * b2;
        return impact(a, b);
    }

    private static int[] impact(int a, int b) {
        int gcd = getGCD(a, b);
        return new int[]{a / gcd, b / gcd};
    }

    private static int getGCD(int a, int b) {
        if (a > b) return getGCD(b, a);
        if (b % a == 0) return a;
        return getGCD(b % a, a);
    }
}

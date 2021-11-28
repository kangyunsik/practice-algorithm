package com.codingtest.algorithm.acmicpc.q1253;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] value;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n;

        n = Integer.parseInt(br.readLine());
        value = new int[n];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(value);
        for (int i = 0; i < n; i++) {
            twoPointer(value[i], i);
        }

        bw.write(answer+"");
        bw.flush();
        br.close();
        bw.close();
    }

    private static void twoPointer(int v, int index) {
        int left = 0;
        int right = value.length - 1;
        while (left < right) {
            if(left == index) {
                left++;
                continue;
            }
            if(right == index) {
                right--;
                continue;
            }

            int lTemp = value[left];
            int rTemp = value[right];
            int sum = lTemp + rTemp;
            if (sum == v) {
                answer += 1;
                return;
            } else {
                if (sum < v) left++;
                else right--;
            }
        }
    }
}

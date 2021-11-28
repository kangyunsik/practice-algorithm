package com.codingtest.algorithm.acmicpc.q7453;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] value;
        int[] aSum, bSum;

        int n, sum;
        long answer = 0L;
        n = Integer.parseInt(br.readLine());
        value = new int[n][4];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 4; j++) {
                value[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        aSum = new int[n*n];
        bSum = new int[n*n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sum = value[i][0] + value[j][1];
                aSum[i*n+j] = sum;
                sum = value[i][2] + value[j][3];
                bSum[i*n+j] = sum;
            }
        }
        Arrays.sort(aSum);
        Arrays.sort(bSum);

        int left = 0;
        int right = n*n - 1;
        int l_cnt;
        int r_cnt;
        while (left < n*n && right >= 0) {
            int aTemp = aSum[left];
            int bTemp = bSum[right];
            l_cnt = 0;
            r_cnt = 0;
            sum = aTemp + bTemp;
            if (sum == 0) {
                while (left < n*n && aSum[left] == aTemp) {
                    l_cnt++;
                    left++;
                }
                while (right >= 0 && bSum[right] == bTemp) {
                    r_cnt++;
                    right--;
                }

                answer += (long) l_cnt * r_cnt;
            } else if (sum > 0) {
                right--;
            } else {
                left++;
            }
        }

        bw.write(answer +"");
        bw.flush();
    }

}
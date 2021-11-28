package com.codingtest.algorithm.acmicpc.q2473;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long min = Long.MAX_VALUE;
        int[] value = new int[n];
        int[] answer = new int[3];
        int[] dx = {0, 1, -1};
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        br.close();
        for (int i = 0; i < n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(value);

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = value[i] + value[j];
                int index = Arrays.binarySearch(value, -sum);
                if (index < 0) index = -index - 2;
                for (int k = 0; k < 3; k++) {
                    int assume = index + dx[k];
                    if (assume < n && assume >= 0 && assume != i && assume != j) {
                        long abs = Math.abs((long) sum + value[assume]);
                        if (min > abs) {
                            min = abs;
                            answer[0] = value[i];
                            answer[1] = value[j];
                            answer[2] = value[assume];
                        }
                    }
                }

            }
        }
        Arrays.sort(answer);
        for (int ans : answer) {
            bw.write(ans + " ");
        }
        bw.flush();
        bw.close();
    }
}

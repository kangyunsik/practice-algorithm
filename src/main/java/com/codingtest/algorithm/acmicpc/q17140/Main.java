package com.codingtest.algorithm.acmicpc.q17140;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int rSize = 3, cSize = 3, ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r = Integer.parseInt(st.nextToken()) - 1;
        int c = Integer.parseInt(st.nextToken()) - 1;
        int k = Integer.parseInt(st.nextToken());
        matrix = new int[100][100];
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (matrix[r][c] != k && ans <= 100) {
            if (rSize >= cSize) {
                operation(1);
            } else {
                operation(0);
            }
            ans++;
        }
        bw.write(Integer.toString(ans > 100 ? -1 : ans));
        bw.flush();
    }

    private static void operation(int R) {
        List<Integer> temp = new ArrayList<>();
        List<int[]> poses = new ArrayList<>();
        int[] time;
        int max = 0;
        for (int i = 0; i < (R == 1 ? rSize : cSize); i++) {
            temp.clear();
            poses.clear();
            time = new int[101];
            for (int j = 0; j < 100; j++) {
                if (R == 1) time[matrix[i][j]]++;
                else time[matrix[j][i]]++;
            }

            for (int j = 1; j <= 100; j++) {
                if (time[j] > 0) poses.add(new int[]{j, time[j]});
            }
            Collections.sort(poses, (i1, i2) -> i1[1] == i2[1] ? i1[0] - i2[0] : i1[1] - i2[1]);
            for (int[] pos : poses) {
                temp.add(pos[0]);
                temp.add(pos[1]);
            }

            for (int j = 0; j < temp.size() && j < 100; j++) {
                if (R == 1) matrix[i][j] = temp.get(j);
                else matrix[j][i] = temp.get(j);
            }

            for (int j = temp.size(); j < 100; j++) {
                if (R == 1) matrix[i][j] = 0;
                else matrix[j][i] = 0;
            }
            max = Math.max(max, Math.min(temp.size(), 100));
        }

        if (R == 1) cSize = max;
        else rSize = max;
    }
}

package com.codingtest.algorithm.acmicpc.q14890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n, l, answer = 0;
        int[][] map;
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            int[] r_pre = {map[i][0], map[0][i]};
            int[] r_cnt = {1, 1};

            lb:
            for (int line = 0; line < 2; line++) {

                for (int j = 1; j < n; j++) {
                    int m = (line == 0 ? map[i][j] : map[j][i]);

                    if (r_pre[line] == m) {
                        r_cnt[line]++;
                    } else {
                        if (m - r_pre[line] == 1 && l > r_cnt[line]) {
                            continue lb;
                        } else if (m - r_pre[line] == -1) {
                            if (n - j >= l) {
                                for (int k = 0; k < l; k++) {
                                    if ((line == 0 ? map[i][j+k] : map[j+k][i]) - r_pre[line] != -1) {
                                        continue lb;
                                    }
                                }
                                j += l - 1;
                                r_cnt[line] = 0;
                            } else {
                                continue lb;
                            }
                        } else if (Math.abs(m - r_pre[line]) != 1) {
                            continue lb;
                        } else {
                            r_cnt[line] = 1;
                        }
                    }
                    r_pre[line] = m;
                }

                answer++;
            }

        }

        System.out.println(answer);
    }
}

package com.codingtest.algorithm.acmicpc.q2468;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i <= 100; i++) {
            answer = Math.max(answer, bfs(arr, i));
        }

        bw.write(answer + "");
        bw.flush();
    }

    private static int bfs(int[][] arr, int h) {
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        boolean[][] visit = new boolean[arr.length][arr.length];
        int c = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > h && !visit[i][j]) {
                    c++;
                    xq.offer(i);
                    yq.offer(j);
                    visit[i][j] = true;
                    while (!xq.isEmpty()) {
                        int px = xq.poll();
                        int py = yq.poll();
                        for (int k = 0; k < 4; k++) {
                            if (px + dx[k] < arr.length && py + dy[k] < arr.length
                                    && px + dx[k] >= 0 && py + dy[k] >= 0 &&
                                    !visit[px + dx[k]][py + dy[k]] && arr[px + dx[k]][py + dy[k]] > h) {
                                xq.offer(px + dx[k]);
                                yq.offer(py + dy[k]);
                                visit[px+dx[k]][py+dy[k]] = true;
                            }
                        }
                    }
                }
            }
        }

        return c;
    }
}

package com.codingtest.algorithm.acmicpc.q2234;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class Main {
    static int[][] map;
    static final int[] dx = {0, -1, 0, 1};
    static final int[] dy = {-1, 0, 1, 0};
    static int n, m, ans = 0;
    static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][];
        check = new boolean[n][m];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            map[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    ans = Math.max(ans, bfs(i, j));
                    cnt++;
                }
            }
        }
        bw.write(cnt + "\n");
        bw.write(ans + "\n");

        ans = 0;
        for (int dist = 0; dist < 4; dist++) {
            int next = 1 << (dist);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        Arrays.fill(check[k], false);
                    }

                    if (map[i][j] >= next) {
                        map[i][j] -= next;
                        ans = Math.max(ans, bfs(i, j));
                        map[i][j] += next;
                    }
                }
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }

    private static int bfs(int x, int y) {
        int dep = 0;
        Queue<Integer> queueX = new LinkedList<>();
        Queue<Integer> queueY = new LinkedList<>();
        queueX.offer(x);
        queueY.offer(y);
        check[x][y] = true;
        while (!queueX.isEmpty()) {
            Integer pollX = queueX.poll();
            Integer pollY = queueY.poll();

            dep++;
            for (int i = 0; i < 4; i++) {
                int px = dx[i] + pollX;
                int py = dy[i] + pollY;
                if (inRange(px, py) && !check[px][py] && (map[pollX][pollY] & (1 << (i))) == 0) {
                    check[px][py] = true;
                    queueX.offer(px);
                    queueY.offer(py);
                }
            }
        }
        return dep;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }
}
package com.codingtest.algorithm.acmicpc.q16933;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][][] check;
    static int[][] map;
    static int n, m, k;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        check = new boolean[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = temp[j] - '0';
            }
        }

        bw.write(String.valueOf(bfs()));
        bw.flush();
    }

    private static int bfs() {
        int x, y, dep, cost, day;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1, 0});
        check[0][0][0] = true;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            x = poll[0];
            y = poll[1];
            dep = poll[2];
            cost = poll[3];
            day = poll[4];
            if (x == n - 1 && y == m - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int px = dx[i] + x;
                int py = dy[i] + y;
                if (px >= 0 && py >= 0 && px < n && py < m) {
                    if (map[px][py] == 0 && !check[px][py][dep]) {
                        check[px][py][dep]= true;
                        queue.offer(new int[]{px, py, dep, cost + 1, 1 - day});
                    } else if (map[px][py] == 1 && dep < k) {
                        if (!check[px][py][dep + 1]) {
                            if(day == 0) {
                                check[px][py][dep + 1] = true;
                                queue.offer(new int[]{px, py, dep + 1, cost + 1, 1 - day});
                            }else{
                                queue.offer(new int[]{x, y, dep, cost + 1, 1 - day});
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
}
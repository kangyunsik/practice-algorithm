package com.codingtest.algorithm.acmicpc.q3197;

import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] none;
    static int[][] board;
    static int[] parent;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static Set<Integer> water = new HashSet<>();
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int x1 = -1, y1 = -1, x2 = -1, y2 = -1;
        board = new int[n][m];
        none = new boolean[n][m];
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = input.charAt(j);
                if (c == 'L') {
                    x2 = x1;
                    y2 = y1;
                    x1 = i;
                    y1 = j;
                }

                if (c == 'X') {
                    board[i][j] = -1;
                } else {
                    none[i][j] = true;
                    water.add(encodePosition(i, j));
                }
            }
        }

        int ans = 0;
        init();
        while (!find(board[x1][y1], board[x2][y2])) {
            impact();
            ans++;
        }

        bw.write(ans + "\n");
        bw.flush();
    }

    private static void init() {
        int cnt = 1;
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean[][] already = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (already[i][j] || board[i][j] == -1) continue;
                qx.offer(i);
                qy.offer(j);
                while (!qx.isEmpty()) {
                    Integer X = qx.poll();
                    Integer Y = qy.poll();
                    board[X][Y] = cnt;
                    for (int k = 0; k < 4; k++) {
                        int px = X + dx[k];
                        int py = Y + dy[k];
                        if (inRange(px, py) && board[px][py] != -1 && !already[px][py]) {
                            already[px][py] = true;
                            qx.offer(px);
                            qy.offer(py);
                        }
                    }
                }
                cnt++;
            }
        }
        parent = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            parent[i] = i;
        }
    }

    private static void impact() {
        Set<Integer> temp = new HashSet<>();
        int[] poses;

        for (Integer pos : water) {
            poses = decodePosition(pos);
            for (int i = 0; i < 4; i++) {
                int px = poses[0] + dx[i];
                int py = poses[1] + dy[i];
                if (inRange(px, py)) {
                    if (board[px][py] > 0) {
                        union(board[px][py], board[poses[0]][poses[1]]);
                    }
                    if (!none[px][py]) {
                        temp.add(encodePosition(px, py));
                        none[px][py] = true;
                    }
                    board[px][py] = board[poses[0]][poses[1]];
                }
            }
        }

        for (Integer pos : temp) {
            poses = decodePosition(pos);
            for (int i = 0; i < 4; i++) {
                int px = poses[0] + dx[i];
                int py = poses[1] + dy[i];
                if (inRange(px, py)) {
                    if (board[px][py] > 0) {
                        union(board[px][py], board[poses[0]][poses[1]]);
                    }
                }
            }
        }
        water = new HashSet<>(temp);
    }

    private static void union(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        if (a > b) parent[a] = b;
        else parent[b] = a;
    }

    private static int getParent(int a) {
        if (parent[a] == a) return a;
        else return parent[a] = getParent(parent[a]);
    }

    private static boolean find(int a, int b) {
        a = getParent(a);
        b = getParent(b);
        return a == b;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static int encodePosition(int x, int y) {
        return x * 10000 + y;
    }

    private static int[] decodePosition(int pos) {
        return new int[]{pos / 10000, pos % 10000};
    }

}

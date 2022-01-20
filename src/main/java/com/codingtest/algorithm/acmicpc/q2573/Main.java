package com.codingtest.algorithm.acmicpc.q2573;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][] board;
    static int n, m;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int ans = 0;
        board = new int[n][];
        for (int i = 0; i < n; i++) {
            board[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int b;
        while ((b = bfs()) == 1) {
            ans++;
            impact();
        }

        bw.write((b == 0 ? b : ans) + "\n");
        bw.flush();
    }

    private static void impact() {
        List<Integer> nextX = new ArrayList<>();
        List<Integer> nextY = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] > 0){
                    for (int k = 0; k < 4; k++) {
                        int px = i + dx[k];
                        int py = j + dy[k];
                        if(inRange(px,py) && board[px][py] == 0){
                            nextX.add(i);
                            nextY.add(j);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < nextX.size(); i++) {
            int X = nextX.get(i);
            int Y = nextY.get(i);
            if(board[X][Y] > 0){
                board[X][Y]--;
            }
        }

    }

    private static int bfs() {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        boolean[][] already = new boolean[n][m];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (already[i][j] || board[i][j] == 0) continue;
                cnt++;
                qx.offer(i);
                qy.offer(j);
                while (!qx.isEmpty()) {
                    Integer X = qx.poll();
                    Integer Y = qy.poll();
                    for (int k = 0; k < 4; k++) {
                        int px = X + dx[k];
                        int py = Y + dy[k];
                        if (inRange(px, py) && !already[px][py] && board[px][py] > 0) {
                            already[px][py] = true;
                            qx.offer(px);
                            qy.offer(py);
                        }
                    }
                }

            }
        }
        return cnt;
    }

    private static boolean inRange(int px, int py) {
        return px >= 0 && py >= 0 && px < n && py < m;
    }
}

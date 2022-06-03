package com.codingtest.algorithm.acmicpc.q5427;

import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] board;
    static List<int[]> fire;
    static final char FIRE = '*';
    static final char SAN = '@';
    static final char WALL = '#';
    static final char EMPTY = '.';
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            board = new char[n][];
            fire = new ArrayList<>();
            int sr = -1, sc = -1;
            for (int i = 0; i < n; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == SAN) {
                        sr = i;
                        sc = j;
                    } else if (board[i][j] == FIRE) {
                        fire.add(new int[]{i, j});
                    }
                }
            }
            int ans = bfs(sr, sc);
            sb.append(ans == -1 ? "IMPOSSIBLE" : ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int sr, int sc) {
        int sanCnt = 1, dist = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int[] f : fire) {
            queue.offer(new int[]{f[0], f[1], FIRE});
        }
        queue.offer(new int[]{sr, sc, SAN});
        while (sanCnt > 0 && !queue.isEmpty()) {
            int size = queue.size();
            dist++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int kind = cur[2];
                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + dr[dir];
                    int nc = c + dc[dir];
                    if (kind == FIRE) {
                        if (isOutOfBound(nr, nc) || board[nr][nc] == WALL || board[nr][nc] == FIRE) continue;
                        if (board[nr][nc] == SAN) {
                            sanCnt--;
                        }
                        board[nr][nc] = FIRE;
                        queue.offer(new int[]{nr, nc, FIRE});
                    } else if (kind == SAN) {
                        if (isOutOfBound(nr, nc)) return dist;
                        if (board[nr][nc] == WALL) continue;
                        if (board[nr][nc] == EMPTY) {
                            sanCnt++;
                            board[nr][nc] = SAN;
                            queue.offer(new int[]{nr, nc, SAN});
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static boolean isOutOfBound(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
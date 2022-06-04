package com.codingtest.algorithm.acmicpc.q9328;

import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int r, c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int n, m;
    static char[][] board;
    static boolean[][] visit;
    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static List<Node> dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            board = new char[n + 2][m + 2];
            visit = new boolean[n + 2][m + 2];
            dest = new ArrayList<>();

            String temp;
            for (int i = 1; i <= n; i++) {
                temp = br.readLine();
                for (int j = 1; j <= m; j++) {
                    board[i][j] = temp.charAt(j - 1);
                    if (board[i][j] == '$') dest.add(new Node(i, j));
                }
            }

            String initKey = br.readLine();
            int initBit = 0;
            if (!initKey.equals("0")) {
                for (int i = 0; i < initKey.length(); i++) {
                    initBit |= 1 << initKey.charAt(i) - 'a';
                }
            }
            int ans = bfs(initBit);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    private static int bfs(int status) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node>[] waitQueue = new Queue[26];

        for (int i = 0; i < 26; i++) {
            waitQueue[i] = new LinkedList<>();
        }

        for (int i = 1; i <= n; i++) {
            queue.offer(new Node(i, 0));
            queue.offer(new Node(i, m + 1));
        }
        for (int i = 1; i <= m; i++) {
            queue.offer(new Node(0, i));
            queue.offer(new Node(n + 1, i));
        }

        int r, c, bit;
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            r = cur.r;
            c = cur.c;
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                if (isInvalid(nr, nc)) continue;
                if (Character.isUpperCase(board[nr][nc])) {
                    bit = board[nr][nc] - 'A';
                    if ((status & 1 << bit) == 0) {
                        waitQueue[bit].add(new Node(nr, nc));
                        continue;
                    }
                } else if (Character.isLowerCase(board[nr][nc])) {
                    bit = board[nr][nc] - 'a';
                    status |= 1 << bit;
                    while (!waitQueue[bit].isEmpty()) {
                        Node poll = waitQueue[bit].poll();
                        visit[poll.r][poll.c] = true;
                        queue.offer(poll);
                    }
                }
                visit[nr][nc] = true;
                queue.offer(new Node(nr, nc));
            }
        }
        return (int) dest.stream().filter(i -> visit[i.r][i.c]).count();
    }

    private static boolean isInvalid(int r, int c) {
        return isOutOfBound(r, c) || board[r][c] == '*' || visit[r][c];
    }

    private static boolean isOutOfBound(int r, int c) {
        return r < 1 || c < 1 || r > n || c > m;
    }
}
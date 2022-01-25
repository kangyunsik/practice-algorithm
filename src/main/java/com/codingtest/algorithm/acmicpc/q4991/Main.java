package com.codingtest.algorithm.acmicpc.q4991;

import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static int x, y, cnt, ans, n, m;
    static List<Integer> rx;
    static List<Integer> ry;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int[][] mem;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        while (n != 0 && m != 0) {
            rx = new ArrayList<>();
            ry = new ArrayList<>();
            board = new char[n][];
            ans = Integer.MAX_VALUE;
            cnt = 0;

            for (int i = 0; i < n; i++) {
                board[i] = br.readLine().toCharArray();
                for (int j = 0; j < m; j++) {
                    char c = board[i][j];
                    if (c == 'o') {
                        x = i;
                        y = j;
                    } else if (c == '*') {
                        rx.add(i);
                        ry.add(j);
                        cnt++;
                    }
                }
            }
            mem = new int[cnt+1][cnt+1];

            findSequence(new Stack<>(), new boolean[cnt]);
            if (ans == Integer.MAX_VALUE) {
                bw.write("-1\n");
            } else {
                bw.write(ans + "\n");
            }
            bw.flush();

            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
        }
    }

    private static void findSequence(Stack<Integer> route, boolean[] already) {
        if (route.size() == cnt) {
            ans = Math.min(ans, findDist(route));
            return;
        }

        for (int i = 1; i <= cnt; i++) {
            if (!already[i-1]) {
                already[i-1] = true;
                route.push(i);
                findSequence(route, already);
                route.pop();
                already[i-1] = false;
            }
        }
    }

    private static int findDist(Stack<Integer> route) {
        int fx = x;
        int fy = y;
        int result = 0;
        int cur = 0;
        lb :
        for (Integer next : route) {
            if(mem[cur][next] != 0){
                if(mem[cur][next] == Integer.MAX_VALUE){
                    return mem[cur][next];
                }
                result += mem[cur][next];
                fx = rx.get(next - 1);
                fy = ry.get(next - 1);
                cur = next;
                continue;
            }

            Queue<Pos> queue = new LinkedList<>();
            queue.offer(new Pos(fx, fy, 0));
            boolean[][] already = new boolean[n][m];
            already[fx][fy] = true;

            while (!queue.isEmpty()) {
                Pos poll = queue.poll();
                if (poll.x == rx.get(next-1) && poll.y == ry.get(next-1)) {
                    fx = poll.x;
                    fy = poll.y;
                    result += poll.cost;
                    mem[cur][next] = poll.cost;
                    mem[next][cur] = poll.cost;
                    cur = next;
                    continue lb;
                }

                for (int i = 0; i < 4; i++) {
                    int px = poll.x + dx[i];
                    int py = poll.y + dy[i];
                    if (inRange(px, py) && board[px][py] != 'x' && !already[px][py]) {
                        already[px][py] = true;
                        queue.offer(new Pos(px, py, poll.cost + 1));
                    }
                }
            }
            return mem[cur][next] = Integer.MAX_VALUE;
        }
        return result;
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static class Pos {
        int x;
        int y;
        int cost;

        public Pos(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}

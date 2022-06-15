package com.codingtest.algorithm.acmicpc.q20056;

import java.io.*;
import java.util.*;

public class Main {

    static class FireBall {
        int r, c, m, s, d;

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }

        public void move() {
            r += (dr[d] + N) * s;
            c += (dc[d] + N) * s;
            r %= N;
            c %= N;
        }

        public FireBall[] getSplit(int beforeSize) {
            FireBall[] ret = new FireBall[4];
            for (int i = 0; i < 4; i++) {
                ret[i] = new FireBall(r, c, m / 5, s / beforeSize, d + i * 2);
            }
            return ret;
        }
    }

    static int N;
    static Queue<FireBall>[][] board;
    static Queue<FireBall> balls;
    static final int[] dr = {-1, -1, 0, 1, 1, 1, 0, -1};
    static final int[] dc = {0, 1, 1, 1, 0, -1, -1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        balls = new LinkedList<>();
        int r, c, m, s, d;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            balls.offer(new FireBall(r, c, m, s, d));
        }

        simulate(K);
        int ans = getRemainValue();
        System.out.println(ans);
    }

    private static void simulate(int k) {
        board = new Queue[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = new LinkedList<>();
            }
        }

        while (k-- > 0) {
            moveBalls();
            setBallsAtBoard();
            merge();
        }
    }

    private static void moveBalls() {
        for (FireBall ball : balls) {
            ball.move();
        }
    }

    private static void setBallsAtBoard() {
        while (!balls.isEmpty()) {
            FireBall ball = balls.poll();
            board[ball.r][ball.c].offer(ball);
        }
    }

    private static void merge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = board[i][j].size();
                if (size == 0) continue;
                else if (size == 1) {
                    balls.offer(board[i][j].poll());
                    continue;
                }
                FireBall merged = getMergedBallValueAndClear(board[i][j]);
                if (merged.m < 5) continue;
                FireBall[] split = merged.getSplit(size);
                for (FireBall fireBall : split) {
                    balls.offer(fireBall);
                }
            }
        }
    }

    private static FireBall getMergedBallValueAndClear(Queue<FireBall> balls) {
        FireBall ret = new FireBall(balls.peek().r, balls.peek().c, 0, 0, 1);
        boolean isAllOdd = true, isAllEven = true;
        while (!balls.isEmpty()) {
            FireBall poll = balls.poll();
            ret.m += poll.m;
            ret.s += poll.s;
            if ((poll.d & 1) == 0) isAllOdd = false;
            if ((poll.d & 1) == 1) isAllEven = false;
        }
        if (isAllOdd || isAllEven) ret.d = 0;
        return ret;
    }

    private static int getRemainValue() {
        return balls.stream().mapToInt(f -> f.m).sum();
    }
}
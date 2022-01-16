package com.codingtest.algorithm.acmicpc.q14891;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Chain[] chains = new Chain[4];
        for (int i = 0; i < 4; i++) {
            chains[i] = new Chain(br.readLine());
        }
        for (int i = 0; i < 4; i++) {
            if (i - 1 >= 0) {
                chains[i].left = chains[i - 1];
            }
            if (i + 1 < 4) {
                chains[i].right = chains[i + 1];
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                chains[j].already = false;
            }

            chains[a].turnClock(b == 1);
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (chains[i].isScore())
                sum += (1 << i);
        }

        bw.write(sum + "\n");
        bw.flush();
    }

    static class Chain {
        String status;
        Chain left, right;
        boolean already;
        int cur;

        public Chain(String status) {
            this.status = status;
            this.cur = 0;
        }

        public void turnClock(boolean isClockWise) {
            this.already = true;
            if (left != null && !left.already && this.getLeftSide() != left.getRightSide()) {
                left.turnClock(!isClockWise);
            }

            if (right != null && !right.already && this.getRightSide() != right.getLeftSide()) {
                right.turnClock(!isClockWise);
            }

            cur = (cur + (isClockWise ? 7 : 1)) % 8;
        }

        public char getLeftSide() {
            return status.charAt((this.cur + 6) % 8);
        }

        public char getRightSide() {
            return status.charAt((this.cur + 2) % 8);
        }

        public boolean isScore() {
            return status.charAt(cur) == '1';
        }
    }
}

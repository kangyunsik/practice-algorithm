package com.codingtest.algorithm.acmicpc.q1941;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] board = new char[5][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < 5; i++) {
            board[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < 1 << 25; i++) {
            if (Integer.bitCount(i) != 7) continue;
            if (!isUnion(i)) continue;
            int cnt = 0;
            for (int j = 0; j < 25; j++) {
                int row = j / 5;
                int col = j % 5;
                if ((i & 1 << j) > 0 && board[row][col] == 'S') {
                    cnt++;
                }
            }
            if (cnt >= 4) {
                ans++;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    static int[] dr = {1, -1, 5, -5};

    private static boolean isUnion(int status) {
        for (int i = 0; i < 25; i++) {
            if ((status & 1 << i) > 0) {
                int cnt = 0;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                int visit = 1 << i;
                while (!queue.isEmpty()) {
                    int poll = queue.poll();
                    cnt++;
                    for (int j = 0; j < 4; j++) {
                        int nextR = poll + dr[j];
                        if (nextR >= 25 || nextR < 0) continue;
                        if (j == 0 && poll % 5 == 4) continue;
                        if (j == 1 && poll % 5 == 0) continue;
                        if ((visit & 1 << nextR) > 0) continue;
                        if((status & 1 << nextR) == 0) continue;
                        visit |= (1 << nextR);
                        queue.offer(nextR);
                    }

                }
                return cnt == 7;
            }
        }
        return false;
    }
}

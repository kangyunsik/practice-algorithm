package com.codingtest.algorithm.acmicpc.q7562;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Main {
    static final int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    static final int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        int ans, px, py;
        int[] begin, end;
        boolean[][] visit;

        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            ans = -1;
            l = Integer.parseInt(br.readLine());
            visit = new boolean[l][l];
            begin = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            end = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


            Queue<Point> queue = new LinkedList<>();
            queue.offer(new Point(begin[0], begin[1], 0));

            while (!queue.isEmpty()) {
                Point poll = queue.poll();
                if (poll.x == end[0] && poll.y == end[1]) {
                    ans = poll.score;
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    px = poll.x + dx[i];
                    py = poll.y + dy[i];
                    if (inRange(px, py) && !visit[px][py]) {
                        visit[px][py] = true;
                        queue.offer(new Point(px, py, poll.score + 1));
                    }
                }
            }

            bw.write(ans + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < l && y < l;
    }
}

class Point {
    int x;
    int y;
    int score;

    public Point(int x, int y, int score) {
        this.x = x;
        this.y = y;
        this.score = score;
    }
}
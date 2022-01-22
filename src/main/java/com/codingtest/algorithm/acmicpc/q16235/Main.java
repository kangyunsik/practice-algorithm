package com.codingtest.algorithm.acmicpc.q16235;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

public class Main {
    static int[][] plus;
    static int[][] board;
    static PriorityQueue<Tree> pq = new PriorityQueue<>(Comparator.comparingInt(t -> t.z));
    static List<Tree> dead = new ArrayList<>();
    static int n;
    static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static final int[] dy = {-1, 0, 1, -1, 0, 1, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m, k, x, y, z;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        plus = new int[n][];
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            plus[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(board[i], 5);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;
            z = Integer.parseInt(st.nextToken());
            pq.offer(new Tree(x, y, z));
        }

        while (k-- > 0) {
            spring();
            summer();
            fall();
            winter();
        }

        bw.write(pq.size() + "\n");
        bw.flush();
    }

    static class Tree {
        int x;
        int y;
        int z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static void spring() {
        List<Tree> temp = new ArrayList<>();
        while (!pq.isEmpty()) {
            Tree poll = pq.poll();
            if (board[poll.x][poll.y] >= poll.z) {
                board[poll.x][poll.y] -= poll.z;
                poll.z++;
                temp.add(poll);
            } else {
                dead.add(poll);
            }
        }
        for (Tree tree : temp) {
            pq.offer(tree);
        }
    }

    private static void summer() {
        for (Tree tree : dead) {
            board[tree.x][tree.y] += tree.z / 2;
        }
        dead.clear();
    }

    private static void fall() {
        List<Tree> baby = new ArrayList<>();
        for (Tree tree : pq) {
            if (tree.z % 5 == 0) {
                for (int i = 0; i < 8; i++) {
                    int px = tree.x + dx[i];
                    int py = tree.y + dy[i];
                    if (inRange(px, py)) {
                        baby.add(new Tree(px, py, 1));
                    }
                }
            }
        }

        for (Tree tree : baby) {
            pq.offer(tree);
        }
    }

    private static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] += plus[i][j];
            }
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}

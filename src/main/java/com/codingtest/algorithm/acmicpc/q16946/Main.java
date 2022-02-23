package com.codingtest.algorithm.acmicpc.q16946;

import java.io.*;
import java.util.*;

public class Main {
    static int[][] board;
    static Map<Integer, Integer> mapper = new HashMap<>();  // location[] -> counter
    static Map<Integer, Integer> counterMapper = new HashMap<>(); // counter -> areaSize
    static Set<Integer> already = new HashSet<>();
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int n, m, counter;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        String input;
        for (int i = 0; i < n; i++) {
            input = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0 && !already.contains(encode(i, j))){
                    bfs(i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) board[i][j] = getValue(i, j) + 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.append(String.valueOf(board[i][j] % 10));
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static int getValue(int x, int y) {
        int ret = 0;
        Set<Integer> counterLocalSet = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            int px = x + dx[i];
            int py = y + dy[i];
            if (isValidRange(px, py) && board[px][py] == 0) {
                counterLocalSet.add(mapper.get(encode(px, py)));
            }
        }
        for (Integer cnt : counterLocalSet) {
            ret += counterMapper.get(cnt);
        }
        return ret;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        Set<Integer> local = new HashSet<>();
        already.add(encode(x, y));
        local.add(encode(x, y));
        int cnt = 0;
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            cnt++;
            for (int i = 0; i < 4; i++) {
                int px = poll[0] + dx[i];
                int py = poll[1] + dy[i];
                int encode = encode(px, py);
                if (isValidRange(px, py) && board[px][py] == 0 && !already.contains(encode)) {
                    already.add(encode);
                    local.add(encode);
                    queue.offer(new int[]{px, py});
                }
            }
        }

        counterMapper.put(++counter, cnt);
        for (Integer code : local) {
            mapper.put(code, counter);
        }
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    private static int encode(int x, int y) {
        return x * 10000 + y;
    }
}

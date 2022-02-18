package com.codingtest.algorithm.acmicpc.q15683;

import java.io.*;
import java.util.*;

/***
 *  소요시간 : 240 ms
 *  메모리사용량 : 67,036 KB
 */
public class Main {
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, -1, 0, 1};
    static final int[] cctvCycleNum = {0, 4, 2, 4, 4, 1};
    static final int[][] cctvDirInfo = {{}, {0}, {0, 2}, {0, 1}, {0, 1, 2}, {0, 1, 2, 3}};

    static int[][] board;
    static List<Cctv> cctvList;
    static int n, m, ans, maxVisible;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        cctvList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int type = Integer.parseInt(st.nextToken());
                board[i][j] = type;
                if (type == 0) {
                    ans++;
                } else if (type < 6) {
                    cctvList.add(new Cctv(i, j, type));
                }
            }
        }

        // Stack == CCTV 각각의 방향에 대한 정보 == cctvCycleInfo 의 인덱스에 해당.
        findCases(0, new Stack<>());
        bw.write((ans - maxVisible) + "\n");
        bw.flush();
    }

    private static int calcVisibleArea(Stack<Integer> stack) {
        int[][] temp = new int[n][m];
        for (int i = 0; i < n; i++) {
            temp[i] = Arrays.copyOf(board[i], m);
        }

        int result = 0;
        for (int cctvIdx = 0; cctvIdx < cctvList.size(); cctvIdx++) {
            Cctv cctv = cctvList.get(cctvIdx);
            for (int j = 0; j < cctvDirInfo[cctv.kind].length; j++) {
                int next = (stack.get(cctvIdx) + cctvDirInfo[cctv.kind][j]) % 4;
                result += cctv.draw(dx[next], dy[next], temp);
            }
        }
        return result;
    }

    private static void findCases(int cctvIdx, Stack<Integer> stack) {
        if (cctvIdx == cctvList.size()) {
            maxVisible = Math.max(maxVisible, calcVisibleArea(stack));
            return;
        }

        for (int i = 0; i < cctvCycleNum[cctvList.get(cctvIdx).kind]; i++) {
            stack.push(i);
            findCases(cctvIdx + 1, stack);
            stack.pop();
        }
    }

    private static boolean inRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static class Cctv {
        int x;
        int y;
        int kind;

        public Cctv(int x, int y, int kind) {
            this.x = x;
            this.y = y;
            this.kind = kind;
        }

        public int draw(int dx, int dy, int[][] temp) {
            int result = 0;
            int px = x + dx;
            int py = y + dy;
            while (inRange(px, py) && temp[px][py] != 6) {
                if (temp[px][py] == 0) {
                    result++;
                    temp[px][py] = -1;
                }
                px += dx;
                py += dy;
            }
            return result;
        }
    }
}

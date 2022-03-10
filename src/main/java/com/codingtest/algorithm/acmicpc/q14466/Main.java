package com.codingtest.algorithm.acmicpc.q14466;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, k, r;
    static List<int[]>[][] none;
    static int[][] cows;
    static int[][][] parent;
    static final int[] dx = {0, 0, 1, -1};
    static final int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        none = new List[n][n];
        parent = new int[n][n][2];
        initParent();

        cows = new int[k][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                none[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            none[x1][y1].add(new int[]{x2, y2});
            none[x2][y2].add(new int[]{x1, y1});
        }

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            cows[i][0] = Integer.parseInt(st.nextToken()) - 1;
            cows[i][1] = Integer.parseInt(st.nextToken()) - 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int dir = 0; dir < 4; dir++) {
                    int nextX = i + dx[dir];
                    int nextY = j + dy[dir];
                    if (isValidRange(nextX, nextY) && !isContains(none[i][j], nextX, nextY)) {
                        union(new int[]{i, j}, new int[]{nextX, nextY});
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < k - 1; i++) {
            for (int j = i + 1; j < k; j++) {
                if (getParent(cows[i]) != getParent(cows[j])) {
                    ans++;
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean isContains(List<int[]> list, int x, int y) {
        for (int[] pos : list) {
            if(pos[0] == x && pos[1] == y) return true;
        }
        return false;
    }

    private static int[] getParent(int[] a) {
        int x = a[0];
        int y = a[1];
        if (parent[x][y][0] == x && parent[x][y][1] == y) return parent[x][y];
        else return parent[x][y] = getParent(parent[x][y]);
    }

    private static void initParent() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                parent[i][j] = new int[]{i, j};
            }
        }
    }

    private static void union(int[] a, int[] b) {
        a = getParent(a);
        b = getParent(b);
        parent[a[0]][a[1]] = b;
    }

    private static boolean isValidRange(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}

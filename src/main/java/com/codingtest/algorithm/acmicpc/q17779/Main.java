package com.codingtest.algorithm.acmicpc.q17779;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int sum = 0, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                sum += board[i][j];
            }
        }

        int ans = sum;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int d1 = 0; d1 < n && d1 <= y; d1++) {
                    for (int d2 = 0; x + d1 + d2 < n && y + d2 < n; d2++) {
                        ans = Math.min(ans, calcDiff(x, y, d1, d2));
                    }
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int calcDiff(int x, int y, int d1, int d2) {
        int area1 = calcArea1(x, y, d1, d2);
        int area2 = calcArea2(x, y, d1, d2);
        int area3 = calcArea3(x, y, d1, d2);
        int area4 = calcArea4(x, y, d1, d2);
        int area5 = sum - area1 - area2 - area3 - area4;
        int[] temp = {area1, area2, area3, area4, area5};
        Arrays.sort(temp);
        return temp[4] - temp[0];
    }

    private static int calcArea4(int x, int y, int d1, int d2) {
        int sum = 0;
        for (int i = x + d2 + 1; i <= x + d1 + d2; i++) {
            for (int j = y + 2 * d2 + x + 1 - i; j < n; j++) {
                sum += board[i][j];
            }
        }

        for (int i = x + d1 + d2 + 1; i < n; i++) {
            for (int j = y + d2 - d1; j < n; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    private static int calcArea3(int x, int y, int d1, int d2) {
        int sum = 0;
        for (int i = x + d1; i <= x + d1 + d2; i++) {
            for (int j = 0; j < y - 2 * d1 + i - x; j++) {
                sum += board[i][j];
            }
        }

        for (int i = x + d1 + d2 + 1; i < n; i++) {
            for (int j = 0; j < y + d2 - d1; j++) {
                sum += board[i][j];
            }
        }
        return sum;
    }

    private static int calcArea2(int x, int y, int d1, int d2) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = y + 1; j < n; j++) {
                sum += board[i][j];
            }
        }
        for (int i = x; i <= x + d2; i++) {
            for (int k = y - x + i + 1; k < n; k++) {
                sum += board[i][k];
            }
        }

        return sum;
    }

    private static int calcArea1(int x, int y, int d1, int d2) {
        int sum = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j <= y; j++) {
                sum += board[i][j];
            }
        }

        for (int i = x; i < x + d1; i++) {
            for (int k = 0; k < y - i + x; k++) {
                sum += board[i][k];
            }
        }
        return sum;
    }
}

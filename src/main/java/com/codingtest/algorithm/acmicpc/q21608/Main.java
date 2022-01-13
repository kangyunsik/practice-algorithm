package com.codingtest.algorithm.acmicpc.q21608;

import java.io.*;
import java.util.stream.Stream;

public class Main {
    static int n, x, y;
    static int[][] map, input;
    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        input = new int[n * n][];
        for (int i = 0; i < n * n; i++) {
            input[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            setStudent(input[i]);
        }
        bw.write(getSatis() + "\n");
        bw.flush();
    }

    private static int getSatis() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                for (int p = 0; p < n * n; p++) {
                    if (map[i][j] == input[p][0]) {
                        for (int k = 0; k < 4; k++) {
                            int px = i + dx[k];
                            int py = j + dy[k];
                            if (inRange(px) && inRange(py)) {
                                if (isContains(input[p], map[px][py])) {
                                    temp++;
                                }
                            }
                        }
                        break;
                    }

                }

                if(temp != 0){
                    int score = 1;
                    while (temp-- > 1) {
                        score *= 10;
                    }
                    ans += score;
                }

            }
        }
        return ans;
    }

    private static void setStudent(int[] arr) {
        x = -1;
        selectLocation(arr);
        if (x == -1) {
            selectRemain();
        }
        map[x][y] = arr[0];
    }

    private static void selectLocation(int[] arr) {
        int max_score = 0;
        int score;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                score = 0;

                for (int k = 0; k < 4; k++) {
                    int px = i + dx[k];
                    int py = j + dy[k];
                    if (inRange(px) && inRange(py)) {
                        if (isContains(arr, map[px][py])) {
                            score += 10;
                        } else if (map[px][py] == 0) {
                            score += 1;
                        }
                    }
                }

                if (max_score < score && map[i][j] == 0) {
                    x = i;
                    y = j;
                    max_score = score;
                }
            }
        }
    }

    private static boolean isContains(int[] arr, int i) {
        return i == arr[1] || i == arr[2] || i == arr[3] || i == arr[4];
    }

    private static boolean inRange(int x) {
        return x >= 0 && x < n;
    }

    private static void selectRemain() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    x = i;
                    y = j;
                    return;
                }
            }
        }
    }
}

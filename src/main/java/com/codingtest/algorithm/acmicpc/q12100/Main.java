package com.codingtest.algorithm.acmicpc.q12100;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    static final int[] dx = {1, -1, 0, 0};
    static final int[] dy = {0, 0, 1, -1};
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Board init = new Board(n);
        for (int i = 0; i < n; i++) {
            init.values[i] = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        findDFS(init, 0);


        bw.write(ans + "\n");
        bw.flush();
    }

    private static void findDFS(Board status, int depth) {
        if (depth == 5) {
            ans = Math.max(ans, status.getValue());
            return;
        }
        for (int i = 0; i < 4; i++) {
            findDFS(status.turn(dx[i], dy[i]), depth + 1);
        }

    }

    static class Board {
        int[][] values;
        int n;

        public Board(int size) {
            this.values = new int[size][size];
            this.n = size;
        }

        public Board turn(int dx, int dy) {
            Board temp = new Board(n);
            for (int i = 0; i < n; i++) {
                temp.values[i] = Arrays.copyOf(values[i], n);
            }
            temp.move(dx, dy);

            if (dx == 0) {
                if (dy == 1) {
                    for (int i = 0; i < n; i++) {
                        for (int j = n - 1; j > 0; j--) {
                            if (temp.values[i][j] == temp.values[i][j - 1]) {
                                temp.values[i][j] *= 2;
                                temp.values[i][j - 1] = 0;
                            }
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n - 1; j++) {
                            if (temp.values[i][j] == temp.values[i][j + 1]) {
                                temp.values[i][j] *= 2;
                                temp.values[i][j + 1] = 0;
                            }
                        }
                    }
                }

            } else if (dx == 1) {
                for (int i = 0; i < n; i++) {
                    for (int j = n - 1; j > 0; j--) {
                        if (temp.values[j][i] == temp.values[j - 1][i]) {
                            temp.values[j][i] *= 2;
                            temp.values[j - 1][i] = 0;
                        }
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n - 1; j++) {
                        if (temp.values[j][i] == temp.values[j + 1][i]) {
                            temp.values[j][i] *= 2;
                            temp.values[j + 1][i] = 0;
                        }
                    }
                }
            }

            temp.move(dx, dy);
            return temp;
        }

        public void move(int dx, int dy) {
            List<Integer> tmp = new ArrayList<>();
            if (dx == 0) {
                if (dy == 1) {
                    for (int i = 0; i < n; i++) {
                        tmp.clear();

                        for (int j = 0; j < n; j++) {
                            if (values[i][j] != 0) {
                                tmp.add(values[i][j]);
                            }
                        }
                        int listIdx = tmp.size() - 1;

                        for (int j = n - 1; listIdx >= 0; j--) {
                            values[i][j] = tmp.get(listIdx--);
                        }
                        for (int j = 0; j < n - tmp.size(); j++) {
                            values[i][j] = 0;
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        tmp.clear();

                        for (int j = 0; j < n; j++) {
                            if (values[i][j] != 0) {
                                tmp.add(values[i][j]);
                            }
                        }

                        for (int j = 0; j < tmp.size(); j++) {
                            values[i][j] = tmp.get(j);
                        }
                        for (int j = tmp.size(); j < n; j++) {
                            values[i][j] = 0;
                        }
                    }
                }
            } else if (dx == 1) {
                for (int i = 0; i < n; i++) {
                    tmp.clear();

                    for (int j = 0; j < n; j++) {
                        if (values[j][i] != 0) {
                            tmp.add(values[j][i]);
                        }
                    }

                    int listIdx = tmp.size() - 1;

                    for (int j = n - 1; listIdx >= 0; j--) {
                        values[j][i] = tmp.get(listIdx--);
                    }
                    for (int j = 0; j < n - tmp.size(); j++) {
                        values[j][i] = 0;
                    }
                }
            } else {
                for (int i = 0; i < n; i++) {
                    tmp.clear();

                    for (int j = 0; j < n; j++) {
                        if (values[j][i] != 0) {
                            tmp.add(values[j][i]);
                        }
                    }

                    for (int j = 0; j < tmp.size(); j++) {
                        values[j][i] = tmp.get(j);
                    }
                    for (int j = tmp.size(); j < n; j++) {
                        values[j][i] = 0;
                    }
                }
            }

        }

        public int getValue() {
            int max = 0;
            for (int[] value : values) {
                for (int i : value) {
                    max = Math.max(max, i);
                }
            }
            return max;
        }
    }
}

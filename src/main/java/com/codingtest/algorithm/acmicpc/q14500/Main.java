package com.codingtest.algorithm.acmicpc.q14500;

import java.io.*;
import java.util.*;

public class Main {
    int n, m;
    int[][] array;
    StringTokenizer st;
    int answer;
    Puzzle puzzle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Main main = new Main(n, m);
        for (int i = 0; i < n; i++) {
            main.set(i, br.readLine());
        }
        main.run();
        bw.write(main.getAnswer() + "\n");
        bw.flush();
    }

    public Main(int n, int m) {
        this.n = n;
        this.m = m;
        array = new int[n][m];
        answer = Integer.MIN_VALUE;
        puzzle = new Puzzle();
    }

    void set(int index, String input) {
        st = new StringTokenizer(input, " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            array[index][i] = Integer.parseInt(st.nextToken());
        }
    }

    void run() {
        for (int[][] state : puzzle.states) {
            int temp = getValue(array, state);
            answer = Math.max(answer, temp);
        }
    }

    int getValue(int[][] board, int[][] state) {
        int state_n = state.length;
        int state_m = state[0].length;
        int temp;
        int max = 0;

        for (int i = 0; i < n - state_n + 1; i++) {
            for (int j = 0; j < m - state_m + 1; j++) {
                temp = 0;
                for (int k = 0; k < state.length; k++) {
                    for (int l = 0; l < state[k].length; l++) {
                        temp += board[i + k][j + l] * state[k][l];
                    }
                }
                max = Math.max(max, temp);
            }
        }

        return max;
    }

    int getAnswer() {
        return this.answer;
    }

    class Puzzle {
        List<int[][]> states;
        Set<Integer> already;

        int[][][] init_state = {
                {
                        {1, 0},
                        {1, 1},
                        {0, 1}
                },
                {
                        {1, 0},
                        {1, 0},
                        {1, 1}
                },
                {
                        {1, 1},
                        {1, 1}
                },
                {
                        {1, 1, 1},
                        {0, 1, 0}
                },
                {
                        {1, 1, 1, 1}
                },
        };

        Puzzle() {
            this.states = new ArrayList<>();
            this.already = new HashSet<>();
            int[][] another;
            int code;
            for (int[][] ints : init_state) {
                states.add(ints);
                already.add(getBinaryCode(ints));
                for (int j = 0; j < 4; j++) {
                    another = getAnother(ints, false, j);
                    code = getBinaryCode(another);
                    if (!already.contains(code)) {
                        states.add(getAnother(ints, false, j));
                        already.add(code);
                    }

                    another = getAnother(ints, true, j);
                    code = getBinaryCode(another);
                    if (!already.contains(code)) {
                        states.add(getAnother(ints, true, j));
                        already.add(code);
                    }
                }
            }
        }

        int getBinaryCode(int[][] state) {
            int sum = 0;
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[i].length; j++) {
                    sum += state[i][j] * Math.pow(2, i * 4 + j);
                }
            }
            return sum;
        }

        int[][] getAnother(int[][] state, boolean symmetry, int rotate) {
            int[][] new_state;
            new_state = symmetry ? getSymmetry(state) : state;
            new_state = getRotate(new_state, rotate);
            return new_state;
        }

        int[][] getSymmetry(int[][] state) {
            int n = state.length;
            int m = state[0].length;
            int[][] new_state = new int[m][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    new_state[m - 1 - j][n - 1 - i] = state[i][j];
                }
            }
            return new_state;
        }

        int[][] getRotate(int[][] state, int rotate) {
            if (rotate == 0)
                return state;

            int n = state.length;
            int m = state[0].length;
            int[][] new_state = new int[m][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    new_state[j][n - 1 - i] = state[i][j];
                }
            }

            return getRotate(new_state, rotate - 1);
        }
    }
}

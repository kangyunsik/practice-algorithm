package com.codingtest.algorithm.programmers.q17679;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int solution(int m, int n, String[] board) {
        Board boardClass = new Board(m, n, board);
        while(boardClass.popBoard());
        return boardClass.answer;
    }

    class Board {
        int m;
        int n;
        char[][] matrix;
        int answer;

        public Board(int m, int n, String[] values) {
            this.m = m;
            this.n = n;
            answer = 0;
            matrix = new char[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = values[m-i-1].charAt(j);
                }
            }
        }

        private boolean popBoard() {
            boolean pop = false;
            Queue<Integer> tx = new LinkedList<>();
            Queue<Integer> ty = new LinkedList<>();
            int[] dx = {0, 0, 1, 1};
            int[] dy = {0, 1, 0, 1};

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char temp = matrix[i][j];
                    if (temp == matrix[i + 1][j] && temp == matrix[i][j + 1] && temp == matrix[i + 1][j + 1]) {
                        tx.offer(i);
                        ty.offer(j);
                    }
                }
            }

            while (!tx.isEmpty()) {
                Integer x = tx.poll();
                Integer y = ty.poll();
                for (int i = 0; i < 4; i++) {
                    if (matrix[x + dx[i]][y + dy[i]] != 0) {
                        matrix[x + dx[i]][y + dy[i]] = 0;
                        answer++;
                        pop = true;
                    }
                }
            }

            downWard();
            return pop;
        }

        private void downWard() {
            for (int i = 0; i < n; i++) {
                List<Character> list = new ArrayList<>();
                for (int j = 0; j < m; j++) {
                    if (matrix[j][i] != 0) {
                        list.add(matrix[j][i]);
                    }
                    matrix[j][i] = 0;
                }

                for (int j = 0; j < list.size(); j++) {
                    matrix[j][i] = list.get(j);
                }
            }
        }
    }
}
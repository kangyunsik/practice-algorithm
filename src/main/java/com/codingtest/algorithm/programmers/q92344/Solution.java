package com.codingtest.algorithm.programmers.q92344;

class Solution {
    static int[][] sub;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        sub = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            sub[i][0] = board[i][0];
            for (int j = 1; j < board[i].length; j++) {
                sub[i][j] = board[i][j] - board[i][j - 1];
            }
        }

        for (int[] order : skill) {
            for (int r = order[1]; r <= order[3]; r++) {
                sub[r][order[2]] += (2 * order[0] - 3) * order[5];
                if (order[4] != sub[r].length - 1) {
                    sub[r][order[4] + 1] += (-2 * order[0] + 3) * order[5];
                }
            }
        }

        for (int[] row : sub) {
            int cur = row[0];
            if (cur > 0) answer++;
            for (int j = 1; j < row.length; j++) {
                cur += row[j];
                if (cur > 0) answer++;
            }
        }

        return answer;
    }
}
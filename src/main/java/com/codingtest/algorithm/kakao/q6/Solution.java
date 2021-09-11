package com.codingtest.algorithm.kakao.q6;

public class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] new_board = new int[n+2][m+2];
        int[][] new_board2 = new int[n+2][m+2];

        for (int i = 1; i <= n; i++) {
            new_board2[i][0] = board[i-1][0];
            new_board[i][0] = board[i-1][0];
        }
        for (int j = 1; j <= m; j++) {
            new_board2[0][j] = board[0][j-1];
            new_board[0][j] = board[0][j-1];
        }

        for (int i = 1; i <= n; i++) {
            new_board2[i][1] = 0;
            new_board[i][1] = 0;
            for (int j = 2; j <= m; j++) {
                new_board2[i][j] = board[i-1][j-1] - board[i-1][j-2];
                new_board[i][j] = board[i-1][j-1] - board[i-1][j-2];
            }
        }

        for (int i = 0; i < skill.length; i++) {
            int type = skill[i][0];
            int r1 = skill[i][1] + 1;
            int c1 = skill[i][2] + 1;
            int r2 = skill[i][3] + 1;
            int c2 = skill[i][4] + 1;
            int degree = type == 1 ? -skill[i][5] : skill[i][5];
            for (int j=r1;j<=r2;j++){
                new_board[j][c1] += degree;
                new_board[j][c2+1] += -degree;
            }

        }

        int[][] heal = new int[n][m];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            heal[i][0] = new_board[i+1][0] + new_board[i+1][1];
            if(heal[i][0] > 0)
                answer ++;
            for (int j = 1; j < m; j++) {
                heal[i][j] = heal[i][j-1] + new_board[i+1][j+1];
                if(heal[i][j] > 0)
                    answer ++;
            }
        }

        return answer;
    }

    private void printTest(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }
    }
}

package com.codingtest.algorithm.programmers.q49994;

class Solution {
    static boolean[][][][] matrix = new boolean[11][11][11][11];
    static int c_x = 5;
    static int c_y = 5;

    static void clear(){
        Solution.c_x = 5;
        Solution.c_y = 5;
        Solution.matrix  =new boolean[11][11][11][11];
    }

    public int solution(String dirs) {


        for (int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            switch(c){
                case 'U':
                    if(check(c_x,c_y+1)){
                        matrix[c_x][c_y][c_x][++c_y] = true;
                    }
                    break;
                case 'D':
                    if(check(c_x,c_y-1)){
                        matrix[c_x][c_y][c_x][--c_y] = true;
                    }
                    break;
                case 'L':
                    if(check(c_x-1,c_y)){
                        matrix[c_x][c_y][--c_x][c_y] = true;
                    }
                    break;
                case 'R':
                    if(check(c_x+1,c_y)){
                        matrix[c_x][c_y][++c_x][c_y] = true;
                    }
                    break;
            }
        }

        int answer = 0;

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                for (int k = 0; k < 11; k++) {
                    for (int l = 0; l < 11; l++) {
                        if(matrix[i][j][k][l]){
                            answer += 1;
                            matrix[k][l][i][j] = false;
                        }
                    }
                }
            }
        }

        return answer;
    }

    private boolean check(int c_x, int c_y) {
        return c_x >= 0 && c_y >= 0 && c_x < 11 && c_y < 11;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution("LL"));
    }
}

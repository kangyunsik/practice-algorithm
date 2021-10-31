package com.codingtest.algorithm.programmers.q60061;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        Frame frame = new Frame(n );
        for (int[] ints : build_frame) {
            frame.run(ints[0], ints[1], ints[2], ints[3]);
        }
        return frame.getResult();
    }

    class Frame {
        int n;
        boolean[][] b;
        boolean[][] g;

        public Frame(int n) {
            this.n = n;
            g = new boolean[n+1][n+1];
            b = new boolean[n+1][n+1];
        }

        public void run(int x,int y,int c,int o) {
            if (c == 0) {   // 기둥
                if (o == 0) { // 삭제
                    g[x][y] = false;
                    if(!(isValid(x,y+1,0) && isValid(x-1,y+1,1) && isValid(x,y+1,1))) {
                        g[x][y] = true;
                    }
                } else { // 추가
                    g[x][y] = true;
                    if(!isValid(x,y,c)){
                        g[x][y] = false;
                    }
                }
            } else {  // 보
                if (o == 0) { // 삭제
                    b[x][y] = false;
                    if(!(isValid(x,y,0) && isValid(x+1,y,0) && isValid(x+1,y,1) && isValid(x-1,y,1))){
                        b[x][y] = true;
                    }
                } else { // 추가
                    b[x][y] = true;
                    if (!isValid(x,y,c)) {
                        b[x][y] = false;
                    }
                }
            }
        }

        private boolean isValid(int x,int y, int type){
            if(x < 0 || x > n || y < 0 || y > n || (type == 0 && !g[x][y]) || (type == 1 && !b[x][y])){
                return true;
            }

            if(type == 0)
                return y == 0 || b[x][y] || (x > 0 && b[x - 1][y]) || (y > 0 && g[x][y - 1]);
            else if(type == 1)
                return (x < n && y > 0 && g[x+1][y-1]) || (y > 0 && g[x][y - 1]) || (x > 0 && x < n && b[x - 1][y] && b[x + 1][y]);
            else
                return false;
        }

        public int[][] getResult() {
            List<int[]> resultList = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j <= n; j++) {
                    if (g[i][j]) {
                        int[] temp = {i, j, 0};
                        resultList.add(temp);
                    }
                    if (b[i][j]) {
                        int[] temp = {i, j, 1};
                        resultList.add(temp);
                    }
                }
            }
            return resultList.toArray(new int[resultList.size()][]);
        }
    }
}
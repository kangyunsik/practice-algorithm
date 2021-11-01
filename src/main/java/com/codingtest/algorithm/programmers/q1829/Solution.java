package com.codingtest.algorithm.programmers.q1829;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        boolean[][] check = new boolean[m][n];

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < picture[0].length; j++) {
                if (check[i][j])
                    continue;

                Queue<Integer> qx = new LinkedList<>();
                Queue<Integer> qy = new LinkedList<>();
                qx.offer(i);
                qy.offer(j);

                int c = 0;
                int value = picture[i][j];
                if (value == 0) {
                    continue;
                }
                while (!qx.isEmpty()) {
                    int x = qx.poll();
                    int y = qy.poll();

                    c++;
                    check[x][y] = true;

                    for (int k = 0; k < 4; k++) {
                        int px = dx[k] + x;
                        int py = dy[k] + y;

                        if (px >= 0 && px < m && py >= 0 && py < n && !check[px][py] && value == picture[px][py]) {
                            qx.offer(px);
                            qy.offer(py);
                            check[px][py] = true;
                        }
                    }
                }

                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, c);
                if (c > 0) {
                    numberOfArea++;
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}
package com.codingtest.algorithm.programmers.q77485;

import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] array = new int[rows][columns];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<rows * columns;i++)
            array[i/columns][i%columns] = i+1;

        for (int[] query : queries) {
            int ans = Integer.MAX_VALUE;
            int x1 = query[0] - 1;
            int y1 = query[1] - 1;
            int x2 = query[2] - 1;
            int y2 = query[3] - 1;

            int[] overflow = {array[x1 + 1][y1], array[x1][y2 - 1], array[x2 - 1][y2], array[x2][y1 + 1]};
            for (int i = x1 + 1; i < x2; i++) {
                array[i][y1] = array[i + 1][y1];
                ans = Math.min(ans, array[i + 1][y1]);
            }

            for (int i = y2 - 1; i > y1; i--) {
                array[x1][i] = array[x1][i - 1];
                ans = Math.min(ans, array[x1][i - 1]);
            }

            for (int i = x2 - 1; i > x1; i--) {
                array[i][y2] = array[i - 1][y2];
                ans = Math.min(ans, array[i - 1][y2]);
            }

            for (int i = y1 + 1; i < y2; i++) {
                array[x2][i] = array[x2][i + 1];
                ans = Math.min(ans, array[x2][i + 1]);
            }

            array[x1][y1] = overflow[0];
            array[x1][y2] = overflow[1];
            array[x2][y2] = overflow[2];
            array[x2][y1] = overflow[3];
            for (int i = 0; i < 4; i++) {
                ans = Math.min(ans, overflow[i]);
            }
            list.add(ans);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}

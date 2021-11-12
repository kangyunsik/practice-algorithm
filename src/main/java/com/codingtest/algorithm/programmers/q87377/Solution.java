package com.codingtest.algorithm.programmers.q87377;

import java.util.ArrayList;
import java.util.List;

class Solution {
    long max_x = Long.MIN_VALUE;
    long min_x = Long.MAX_VALUE;
    long max_y = Long.MIN_VALUE;
    long min_y = Long.MAX_VALUE;

    public String[] solution(int[][] line) {
        List<Long> ax = new ArrayList<>();
        List<Long> ay = new ArrayList<>();

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Long[] point = getPoint(line[i], line[j]);
                if (point != null) {
                    ax.add(point[0]);
                    ay.add(point[1]);
                    setBound(point[0], point[1]);
                }
            }
        }

        StringBuilder[] sbs = new StringBuilder[(int) (max_x - min_x) + 1];
        for (int i = 0; i < sbs.length; i++) {
            sbs[i] = new StringBuilder(".".repeat((int) (max_y - min_y) + 1));
        }

        for (int i = 0; i < ay.size(); i++) {
            sbs[(int) (ax.get(i) - min_x)].setCharAt((int) (ay.get(i) - min_y), '*');
        }

        String[] answer = new String[sbs.length];
        for (int i = 0; i < sbs.length; i++) {
            answer[i] = sbs[sbs.length - 1 - i].toString();
        }

        return answer;
    }

    private void setBound(long a, long b) {
        max_x = Math.max(a, max_x);
        min_x = Math.min(a, min_x);
        max_y = Math.max(b, max_y);
        min_y = Math.min(b, min_y);
        System.out.println("max_x = " + max_x);
        System.out.println("min_x = " + min_x);
        System.out.println("max_y = " + max_y);
        System.out.println("min_y = " + min_y);
    }


    private Long[] getPoint(int[] a, int[] b) {

        if ((long) a[0] * b[1] == (long) a[1] * b[0])
            return null;

        double x = (double) ((long) a[2] * b[0] - (long) a[0] * b[2])
                / ((long) a[0] * b[1] - (long) a[1] * b[0]);
        double y = (double) ((long) a[2] * b[1] - (long) a[1] * b[2])
                / ((long) a[1] * b[0] - (long) a[0] * b[1]);
        if (x == Math.round(x) && y == Math.round(y))
            return new Long[]{(long) x, (long) y};
        else
            return null;
    }
}
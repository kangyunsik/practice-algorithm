package com.codingtest.algorithm.programmers.q42840;

class Solution {
    public int[] solution(int[] answers) {
        int a, b, c;
        a = b = c = 0;
        int[] as = {1, 2, 3, 4, 5};
        int[] bs = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] cs = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == as[i % 5])
                a++;

            if (answers[i] == bs[i % 8])
                b++;

            if (answers[i] == cs[i % 10])
                c++;
        }

        if (a == b && b == c)
            return new int[]{1, 2, 3};
        else if (a == b && a > c)
            return new int[]{1, 2};
        else if (b == c && b > a)
            return new int[]{2, 3};
        else if (a == c && a > b)
            return new int[]{1, 3};
        else {
            int max = Math.max(a, Math.max(b, c));
            return new int[]{max == a ? 1 : max == b ? 2 : 3};
        }
    }
}
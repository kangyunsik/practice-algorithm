package com.codingtest.algorithm.programmers.q62048;

class Solution {
    public long solution(long w, long h) {
        long gcd = gcd(w, h);
        if (gcd != 1L)
            return w * h - (w * h / gcd - gcd * solution(w / gcd, h / gcd));

        long answer = 0;
        for (int i = 0; i < w; i++)
            answer += (Math.ceil(h * (i+1) / (double)w) - Math.floor(h * i / (double)w));

        return w * h - answer;
    }

    private long gcd(long a, long b) {
        return b > a ? gcd(b, a) :
                (a % b == 0 ? b : gcd(b, a % b));
    }
}
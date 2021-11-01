package com.codingtest.algorithm.programmers.q62048;

class Solution {
    public long solution(long w, long h) {
        return w * h - w - h + gcd(w, h);
    }

    private long gcd(long a, long b) {
        return b > a ? gcd(b, a) :
                (a % b == 0 ? b : gcd(b, a % b));
    }
}
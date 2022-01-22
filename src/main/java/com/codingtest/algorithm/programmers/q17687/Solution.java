package com.codingtest.algorithm.programmers.q17687;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder ans = new StringBuilder();
        int turn = 0, cnt = 0, cur = 0;
        while (cnt != t) {
            String value = Integer.toString(cur++, n).toUpperCase();
            for (int i = 0, len = value.length() ; i < len && cnt < t; i++) {
                if (turn++ % m == (p - 1)) {
                    ans.append(value.charAt(i));
                    cnt++;
                }
            }
        }
        return ans.toString();
    }
}
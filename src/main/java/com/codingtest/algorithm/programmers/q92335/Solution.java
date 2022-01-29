package com.codingtest.algorithm.programmers.q92335;

class Solution {
    public int solution(int n, int k) {
        String string = getNthString(n, k);
        int answer = 0;
        for (String s : string.split("0")) {
            if (!s.equals("") && isPrime(Long.parseLong(s))) {
                answer++;
            }
        }
        return answer;
    }

    private String getNthString(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while(n>0){
            sb.append(n%k);
            n/=k;
        }
        return sb.reverse().toString();
    }

    private boolean isPrime(long l) {
        if(l == 1L) return false;
        if(l == 2L) return true;
        for (int i = 2; (long) i * i <= l; i++) {
            if(l%i == 0)
                return false;
        }
        return true;
    }
}
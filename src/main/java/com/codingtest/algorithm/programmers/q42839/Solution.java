package com.codingtest.algorithm.programmers.q42839;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> ints = new HashSet<>();

    public int solution(String numbers) {
        getAnswer(numbers, "");
        return ints.size();
    }

    private boolean isPrime(int n){
        if(n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if(n%i == 0) return false;
        }
        return true;
    }

    private void getAnswer(String remain, String sum){
        if(remain.length() == 0){
            if(sum.length() > 0 ) {
                int val = Integer.parseInt(sum);
                if(!ints.contains(val) && isPrime(val)){
                    ints.add(val);
                }
            }
            return;
        }

        for (int i = 0; i < remain.length(); i++) {
            char c = remain.charAt(i);
            String subUnit = remain.substring(0, i) + remain.substring(i + 1);
            getAnswer(subUnit, c+sum);
            getAnswer(subUnit, sum + c);
        }

        getAnswer(remain.substring(1), sum);
    }


}
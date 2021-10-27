package com.codingtest.algorithm.programmers.q43165;

class Solution {
    int[] numbers;
    int target;
    int answer = 0;
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = numbers;
        dfs(0,0);
        return answer;
    }

    private void dfs(int value, int depth){
        if(depth == numbers.length){
            if(value == target)
                answer++;
            return;
        }

        dfs(value + numbers[depth], depth+1);
        dfs(value - numbers[depth], depth+1);
    }
}

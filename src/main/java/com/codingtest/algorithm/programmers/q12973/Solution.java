package com.codingtest.algorithm.programmers.q12973;

import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean deleted;
        for(char c : s.toCharArray()){
            deleted = false;
            while(!stack.isEmpty() && stack.peek() == c){
                stack.pop();
                deleted = true;
            }
            if(!deleted){
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
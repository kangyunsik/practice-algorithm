package com.codingtest.algorithm.programmers.q60058;

import java.util.Stack;

class Solution {
    public String solution(String p) {
        if (p.isEmpty()) {
            return p;
        }

        int count = 0;
        int index = 0;
        do {
            if (p.charAt(index) == '(') {
                count++;
            } else {
                count--;
            }
            index++;
        } while (index < p.length() && count != 0);
        String u = p.substring(0, index);
        String v = p.substring(index);
        StringBuilder sb = new StringBuilder();

        if (isBalance(u)) {
            sb.append(u).append(solution(v));
        } else {
            sb.append("(").append(solution(v)).append(")").append(removeEdgesAndReverse(u));
        }

        return sb.toString();
    }

    private String removeEdgesAndReverse(String u) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < u.length() - 1; i++) {
            if (u.charAt(i) == '(')
                sb.append(")");
            else
                sb.append("(");
        }
        return sb.toString();
    }

    private boolean isBalance(String u) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < u.length(); i++) {
            char c = u.charAt(i);
            if(c == '(')
                stack.push(c);
            else if(stack.isEmpty())
                return false;
            else
                stack.pop();
        }
        return stack.isEmpty();
    }
}
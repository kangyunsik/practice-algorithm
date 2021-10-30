package com.codingtest.algorithm.programmers.q60057;

class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();

        for (int quantum = 1; quantum <= len; quantum++) {
            int count = 0;

            StringBuilder comp = new StringBuilder();
            String temp = s.substring(0,quantum);
            String temp1 = s.substring(0,quantum);

            for (int i = quantum; i < len; i+=quantum) {
                temp1 = s.substring(i,Math.min(len,i+quantum));
                if(temp.equals(temp1)){
                    count++;
                }else{
                    comp.append(count > 0 ? (count + 1) : "").append(temp);
                    temp = temp1;
                    count = 0;
                }
            }
            comp.append(count > 0 ? (count + 1) : "").append(temp1);
            answer = Math.min(answer , comp.toString().length());
        }
        return answer;
    }
}
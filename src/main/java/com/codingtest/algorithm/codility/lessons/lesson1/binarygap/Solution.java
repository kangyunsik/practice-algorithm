package com.codingtest.algorithm.codility.lessons.lesson1.binarygap;

class Solution {
    public int solution(int N) {
        Integer start = null;
        int result = 0;

        String string = Integer.toBinaryString(N);
        for (int i = 0; i < string.length(); i++) {
            if(string.charAt(i) == '1'){
                if(start != null){
                    result = Math.max(result, i - start - 1);
                }
                start = i;
            }
        }

        return result;
    }
}

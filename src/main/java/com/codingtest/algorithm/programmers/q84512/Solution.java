package com.codingtest.algorithm.programmers.q84512;

import java.util.TreeSet;

class Solution {
    int[] seq = new int[5];
    char[] mapper = {'A','E','I','O','U'};
    TreeSet<String> strings = new TreeSet<>();

    public int solution(String word) {
        findCases(0);
        int idx = 0;
        for (String string : strings) {
            if(word.equals(string)) return idx;
            idx++;
        }
        return -1;
    }

    private void findCases(int cur) {
        if(cur == 5){
            makeBySeq();
            return;
        }

        for (int i = 0; i <= 5; i++) {
            seq[cur] = i;
            findCases(cur + 1);
        }
    }

    private void makeBySeq(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if(seq[i] != 0){
                sb.append(mapper[seq[i] - 1]);
            }
        }
        strings.add(sb.toString());
    }

}

package com.codingtest.algorithm.programmers.q42746;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        List<String> list = new ArrayList<>();
        boolean head = false;
        for(int n : numbers)
            list.add(Integer.toString(n));
        Collections.sort(list, (o1, o2) -> -(o1+o2).compareTo(o2+o1));

        StringBuilder sb = new StringBuilder();
        for(String value : list){
            if(!value.equals("0") || head){
                sb.append(value);
                head = true;
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}
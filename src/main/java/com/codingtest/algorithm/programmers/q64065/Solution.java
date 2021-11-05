package com.codingtest.algorithm.programmers.q64065;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        List<Integer> answer = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        String[] strings = s.substring(1,s.length()-2).split("},");

        Arrays.sort(strings,Comparator.comparingInt(String::length));

        for(String string : strings){
            String[] ints = string.substring(1).split(",");
            for(String i : ints){
                int value = Integer.parseInt(i);
                if(!set.contains(value)){
                    answer.add(value);
                }
                set.add(value);
            }
        }

        return answer.stream().mapToInt(i->i).toArray();
    }
}

package com.codingtest.algorithm.programmers.q72411;

import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        int[] maxSize = new int[11];
        Queue<String>[] queues = new LinkedList[11];
        int len = orders.length;

        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                String[] dif = getDiff(orders[i],orders[j]);
                for (String d : dif) {
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
        }

        for(String key : map.keySet()){
            if(maxSize[key.length()] < map.get(key)){
                maxSize[key.length()] = map.get(key);
                queues[key.length()] = new LinkedList<>();
                queues[key.length()].add(key);
            }else if(maxSize[key.length()] == map.get(key)){
                queues[key.length()].add(key);
            }
        }

        for (int j : course)
            while (queues[j] != null && !queues[j].isEmpty())
                answer.add(queues[j].poll());

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    private String[] getDiff(String s1, String s2) {
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s1.toCharArray())
            set.add(c);
        for(char c : s2.toCharArray())
            if(set.contains(c))
                sb.append(c);

        Set<String> result = new HashSet<>();
        char[] temp = sb.toString().toCharArray();
        Arrays.sort(temp);
        getOther(result,new String(temp));
        return result.toArray(new String[0]);
    }

    private void getOther(Set<String> set, String s) {
        if(s.length() < 2){
            return;
        }

        set.add(s);
        for (int i = 0; i < s.length(); i++) {
            getOther(set,s.substring(0,i)+s.substring(i+1));
        }
    }
}
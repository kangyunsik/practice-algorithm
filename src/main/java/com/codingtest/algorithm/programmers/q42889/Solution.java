package com.codingtest.algorithm.programmers.q42889;

import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        Map<Integer , Integer> map = new HashMap<>();
        List<Node> list = new ArrayList<>();
        Arrays.sort(stages);
        int remain = stages.length;
        for (int stage : stages) {
            map.put(stage, map.getOrDefault(stage,0) + 1);
        }

        for (int i = 1; i <= N; i++) {
            Integer clear = map.getOrDefault(i, 0);
            if(remain == 0)
                list.add(new Node(0.0, i));
            else
                list.add(new Node((double)clear / remain, i));
            remain -= clear;
        }
        Collections.sort(list);

        return list.stream().mapToInt(o -> o.stage).toArray();
    }
}

class Node implements Comparable<Node>{
    double value;
    int stage;

    @Override
    public int compareTo(Node o) {
        if(Double.compare(this.value,o.value) == 0){
            return this.stage - o.stage;
        }else{
            return Double.compare(o.value,this.value);
        }
    }

    public Node(double value, int stage) {
        this.value = value;
        this.stage = stage;
    }
}
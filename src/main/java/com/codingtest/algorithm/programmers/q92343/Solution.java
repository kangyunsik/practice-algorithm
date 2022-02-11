package com.codingtest.algorithm.programmers.q92343;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 1, 0));
        while(!queue.isEmpty()){
            Node poll = queue.poll();
            if(poll.sheep <= poll.wolf) continue;
            answer = Math.max(answer, poll.sheep);
            for (int[] edge : edges) {
                for (int i = 0, j = 1; i < 2; i++, j--) {
                    if(((1 << edge[i]) & poll.status) > 0 && ((1 << edge[j]) & poll.status) == 0){
                        if(info[edge[j]] == 0)
                            queue.offer(new Node((1 << edge[j] | poll.status), poll.sheep + 1, poll.wolf));
                        else
                            queue.offer(new Node((1 << edge[j] | poll.status), poll.sheep, poll.wolf + 1));
                    }
                }
            }
        }
        return answer;
    }

    static class Node{
        int status;
        int sheep;
        int wolf;

        public Node(int status, int sheep, int wolf) {
            this.status = status;
            this.sheep = sheep;
            this.wolf = wolf;
        }
    }
}
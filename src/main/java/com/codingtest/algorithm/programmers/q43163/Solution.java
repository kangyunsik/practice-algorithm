package com.codingtest.algorithm.programmers.q43163;

import java.util.*;

class Solution {
    int[][] matrix;
    String[] words;

    public int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;
        int n = words.length;
        this.matrix = new int[n][n];
        this.words = words;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = onlyIfOneDiff(words[i], words[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (onlyIfOneDiff(begin, words[i]) == 1) {
                answer = Math.min(answer, find(i, target));
            }
        }

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private int find(int index, String target) {
        int[] dist = new int[matrix.length];

        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[index] = 1;

        PriorityQueue<Index> pq = new PriorityQueue<>(Comparator.comparingInt(o->o.cost));
        pq.offer(new Index(index, 1));
        while (!pq.isEmpty()) {
            Index poll = pq.poll();
            int mDest = poll.dest;
            int mCost = poll.cost;

            if (dist[mDest] >= mCost) {
                for (int i = 0; i < dist.length; i++) {
                    if (matrix[mDest][i] == 1) {
                        int temp = mCost + matrix[mDest][i];
                        if (dist[i] > temp) {
                            dist[i] = temp;
                            pq.offer(new Index(i, temp));
                        }
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if(words[i].equals(target) && dist[i] != Integer.MAX_VALUE){
                answer = Math.min(dist[i],answer);
            }
        }
        return answer;
    }

    class Index {
        int dest;
        int cost;

        public Index(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }

    private int onlyIfOneDiff(String word1, String word2) {
        int count = 0;
        for (int i = 0; i < word1.length(); i++) {
            if(word1.charAt(i) != word2.charAt(i)){
                count ++;
            }
        }
        return count == 1 ? 1 : 0;
    }
}

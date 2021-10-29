package com.codingtest.algorithm.programmers.q60062;

import java.util.*;

class Solution {
    List<int[]> permuted_dist;
    int[] weak_d;
    int dist_len;
    int answer = Integer.MAX_VALUE;

    public int solution(int n, int[] weak, int[] dist) {
        this.permuted_dist = new ArrayList<>();
        this.weak_d = Arrays.copyOf(weak, weak.length * 2);
        this.dist_len = dist.length;

        getPermuted(dist, 0);
        for (int i = weak.length; i < this.weak_d.length; i++) {
            this.weak_d[i] = weak[i - weak.length] + n;
        }

        for (int i = 0; i < weak.length; i++) {
            getMinFriend(i, i + weak.length - 1);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void getPermuted(int[] dist, int depth) {
        if (depth == dist.length) {
            permuted_dist.add(Arrays.copyOf(dist, dist.length));
        }

        for (int i = depth; i < dist.length; i++) {
            swap(dist, depth, i);
            getPermuted(dist, depth + 1);
            swap(dist, depth, i);
        }
    }

    private void swap(int[] dist, int depth, int i) {
        int temp = dist[depth];
        dist[depth] = dist[i];
        dist[i] = temp;
    }

    public void getMinFriend(int start, int end) {
        for (int[] array : permuted_dist) {
            int count = 0;
            int temp = weak_d[start];
            int i = start;

            while (i <= end) {
                if (weak_d[i] - temp > array[count]) {
                    count++;
                    if (count == dist_len) {
                        count = Integer.MAX_VALUE - 1;
                        break;
                    }
                    temp = weak_d[i];
                } else i++;
            }
            answer = Math.min(count + 1, answer);
        }
    }
}
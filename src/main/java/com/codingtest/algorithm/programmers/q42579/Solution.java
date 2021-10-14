package com.codingtest.algorithm.programmers.q42579;

import java.util.*;

class Solution {
    static Map<String, Integer> sumMap = new HashMap<>();
    static Map<String, Integer> cntMap = new HashMap<>();
    PriorityQueue<Music> queue = new PriorityQueue<>(Collections.reverseOrder());

    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            int value = sumMap.getOrDefault(genres[i], 0) + plays[i];
            sumMap.put(genres[i], value);

            cntMap.put(genres[i], 0);
        }

        for (int i = 0; i < genres.length; i++)
            queue.add(new Music(i, genres[i], plays[i]));

        while (!queue.isEmpty()) {
            Music music = queue.poll();
            if (cntMap.get(music.genres) != 2) {
                cntMap.put(music.genres, cntMap.get(music.genres) + 1);
                answer.add(music.id);
            }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    class Music implements Comparable<Music> {
        int id;
        String genres;
        int plays;

        @Override
        public int compareTo(Music o) {
            if (sumMap.get(o.genres).equals(sumMap.get(this.genres))) {
                return this.plays == o.plays ? o.id - this.id : this.plays - o.plays;
            } else {
                return sumMap.get(this.genres) - sumMap.get(o.genres);
            }
        }

        public Music(int id, String genres, int plays) {
            this.id = id;
            this.genres = genres;
            this.plays = plays;
        }
    }
}
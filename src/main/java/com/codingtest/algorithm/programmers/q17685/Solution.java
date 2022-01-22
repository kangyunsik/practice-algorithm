package com.codingtest.algorithm.programmers.q17685;

import java.util.Arrays;
import java.util.Comparator;

class Solution {

    public int solution(String[] words) {
        int answer = 0;
        Trie trie = new Trie(0);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        for (String word : words) {
            trie.offer(word);
        }
        for (String word : words) {
            answer += trie.find(word);
        }
        return answer;
    }

    static class Trie {
        boolean check;
        int depth;
        String cur;
        Trie[] sub;

        public Trie(int depth) {
            this.depth = depth;
            this.sub = new Trie[26];
        }

        public void offer(String word) {
            if (this.cur == null) {
                this.cur = word;
                return;
            }
            if (!check) subOffer(cur);
            check = true;
            subOffer(word);
        }

        private void subOffer(String word) {
            if (depth < word.length()) {
                int index = word.charAt(depth) - 'a';
                if (sub[index] == null) {
                    sub[index] = new Trie(this.depth + 1);
                }
                sub[index].offer(word);
            }
        }

        public int find(String word) {
            if (word.length() == depth) {
                return depth;
            }
            int index = word.charAt(this.depth) - 'a';
            if (sub[index] == null) {
                return this.depth;
            }
            return sub[index].find(word);
        }
    }
}
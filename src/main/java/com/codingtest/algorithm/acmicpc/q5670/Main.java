package com.codingtest.algorithm.acmicpc.q5670;

import java.io.*;

public class Main {

    static class Trie {

        Trie[] child;
        int depth, sum;

        public Trie() {
            child = new Trie[26];
        }

        public void push(String s) {
            if (depth == s.length()) {
                sum++;
                return;
            }
            int idx = s.charAt(depth) - 'a';
            if (child[idx] == null) {
                sum++;
                child[idx] = new Trie();
                child[idx].depth = this.depth + 1;
            }
            child[idx].push(s);
        }

        public int find(String s) {
            int ret = Math.min(1, sum - 1);
            if (depth == 0) ret = 1;
            if (s.length() - 1 == depth) return ret;
            return child[s.charAt(depth) - 'a'].find(s) + ret;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            Trie root = new Trie();
            String[] s = new String[n];
            for (int i = 0; i < n; i++) {
                s[i] = br.readLine();
                root.push(s[i]);
            }

            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += root.find(s[i]);
            }
            sb.append(String.format("%.2f", ans * 1.0 / n)).append("\n");
        }
        System.out.println(sb);
    }
}

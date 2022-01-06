package com.codingtest.algorithm.acmicpc.q14425;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n, m, ans = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Trie trie = new Trie();

        for (int i = 0; i < n; i++) {
            trie.offer(br.readLine(), 0);
        }
        for (int i = 0; i < m; i++) {
            if (trie.find(br.readLine(), 0)) {
                ans++;
            }
        }
        br.close();
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
    }
}

class Trie {
    int cnt;
    Trie[] sub;

    public Trie() {
        this.cnt = 0;
        this.sub = new Trie[26];
    }

    public void offer(String string, int loc) {
        if (loc == string.length()) {
            this.cnt++;
            return;
        }

        int index = string.charAt(loc) - 'a';
        if (sub[index] == null) {
            sub[index] = new Trie();
        }
        sub[index].offer(string, loc + 1);
    }

    public boolean find(String input, int loc) {
        if (input.length() == loc) {
            return this.cnt > 0;
        }

        int index = input.charAt(loc) - 'a';
        if (sub[index] != null) {
            return sub[index].find(input, loc + 1);
        } else {
            return false;
        }
    }

}

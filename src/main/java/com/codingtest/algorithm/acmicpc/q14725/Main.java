package com.codingtest.algorithm.acmicpc.q14725;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input;

        Trie trie = new Trie();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            trie.offer(input, 1);
        }
        trie.print(0);
    }
}

class Trie{
    Map<String, Trie> sub;

    public Trie(){
        sub = new TreeMap<>();
    }

    public void offer(String[] strings, int depth){
        if(strings.length == depth){
            return;
        }

        Trie temp = sub.getOrDefault(strings[depth], new Trie());
        temp.offer(strings, depth+1);
        sub.put(strings[depth], temp);
    }

    public void print(int depth){
        for (String key : sub.keySet()) {
            System.out.println("--".repeat(depth)+key);
            sub.get(key).print(depth + 1);
        }
    }
}

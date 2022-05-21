package com.codingtest.algorithm.acmicpc.q1017;

import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] edges, revEdges;
    static List<Integer> left, right, ans;
    static int leftSel, rightSel;
    static int[] aside;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        left = new ArrayList<>();
        right = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
            if (input[i] % 2 == 1) {
                left.add(i);
            } else {
                right.add(i);
            }
        }

        if (left.size() != right.size()) {
            System.out.println(-1);
            return;
        }
        aside = new int[left.size()];
        visit = new boolean[left.size()];
        Arrays.fill(aside, -1);
        setEdges(input);

        if (input[0] % 2 == 1) {
            leftSel = 0;
            for (Integer next : edges[0]) {
                int selCnt = 0;
                rightSel = next;
                for (int i = 0; i < left.size(); i++) {
                    if(dfs(i)){
                        selCnt++;
                        Arrays.fill(visit, false);
                    }
                }
                if (selCnt == left.size() - 1) {
                    ans.add(input[right.get(rightSel)]);
                }
                Arrays.fill(aside, -1);

            }
        } else {
            rightSel = 0;
            for (Integer next : revEdges[0]) {
                int selCnt = 0;
                leftSel = next;
                for (int i = 0; i < left.size(); i++) {
                    if(dfs(i)){
                        selCnt++;
                        Arrays.fill(visit, false);
                    }
                }
                if (selCnt == left.size() - 1) {
                    ans.add(input[left.get(leftSel)]);
                }
                Arrays.fill(aside, -1);
            }
        }
        if(ans.size() == 0){
            System.out.println(-1);
        }else{
            Collections.sort(ans);
            for (Integer an : ans) {
                System.out.print(an +" ");
            }
        }
    }

    private static void setEdges(int[] input) {
        edges = new List[left.size()];
        revEdges = new List[left.size()];
        for (int i = 0; i < left.size(); i++) {
            edges[i] = new ArrayList<>();
            revEdges[i] = new ArrayList<>();
        }

        for (int i = 0; i < left.size(); i++) {
            for (int j = 0; j < right.size(); j++) {
                if(isPrime(input[left.get(i)] + input[right.get(j)])){
                    edges[i].add(j);
                    revEdges[j].add(i);
                }
            }
        }
    }

    private static boolean isPrime(int v) {
        if(v == 2) return true;
        int sq = (int) Math.sqrt(v);
        for (int i = 2; i <= sq; i++) {
            if(v % i == 0) return false;
        }
        return true;
    }

    private static boolean dfs(int cur) {
        if(cur == leftSel) return false;
        visit[cur] = true;

        for (Integer to : edges[cur]) {
            int next = aside[to];
            if(to == rightSel) continue;
            if (next == -1 || (!visit[next] && dfs(next))){
                aside[to] = cur;
                return true;
            }
        }
        return false;
    }
}
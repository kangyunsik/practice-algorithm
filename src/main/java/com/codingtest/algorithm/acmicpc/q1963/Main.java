package com.codingtest.algorithm.acmicpc.q1963;

import java.io.*;
import java.util.*;

public class Main {
    static List<Integer> primes;
    static boolean[] isPrime;
    static Map<Integer, List<Integer>> edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        setPrimes();
        setEdges();
        int a, b, ans, T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            ans = bfs(a, b);
            if (ans == -1) sb.append("Impossible");
            else sb.append(ans);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void setEdges() {
        edges = new HashMap<>(2000);
        for (Integer prime : primes) {
            edges.put(prime, new ArrayList<>());
        }

        int first, second;
        for (int i = 0; i < primes.size(); i++) {
            first = primes.get(i);
            for (int j = i + 1; j < primes.size(); j++) {
                second = primes.get(j);
                if (isOnlyDiffOne(first, second)) {
                    edges.get(first).add(second);
                    edges.get(second).add(first);
                }
            }
        }
    }

    private static boolean isOnlyDiffOne(int a, int b) {
        int same = 0;
        while (a > 0 && b > 0) {
            if (a % 10 == b % 10) same++;
            a /= 10;
            b /= 10;
        }
        return same == 3;
    }

    private static int bfs(int begin, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(begin);
        boolean[] visit = new boolean[10000];
        visit[begin] = true;
        int size, depth = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == end) return depth;
                for (int next : edges.get(cur)) {
                    if (visit[next]) continue;
                    visit[next] = true;
                    queue.offer(next);
                }
            }
            depth++;
        }
        return -1;
    }

    private static void setPrimes() {
        isPrime = new boolean[10000];
        primes = new ArrayList<>();
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            if (!isPrime[i]) continue;
            for (int j = i * 2; j < 10000; j += i) {
                isPrime[j] = false;
            }
        }
        for (int i = 1000; i < 10000; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}

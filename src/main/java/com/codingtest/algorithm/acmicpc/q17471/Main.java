package com.codingtest.algorithm.acmicpc.q17471;

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer>[] edges;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        edges = new List[n];
        for (int i = 0; i < n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0, m; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; j++) {
                int next = Integer.parseInt(st.nextToken()) - 1;
                edges[i].add(next);
                edges[next].add(i);
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < (1 << n) - 1; i++) {
            if (!isValidTeam(i)) continue;
            int zeroTeam = 0;
            int oneTeam = 0;
            for (int j = 0; j < n; j++) {
                if (hasBitAt(i, j)) oneTeam += arr[j];
                else zeroTeam += arr[j];
            }
            ans = Math.min(ans, Math.abs(zeroTeam - oneTeam));
        }

        if (ans == Integer.MAX_VALUE) ans = -1;
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean isValidTeam(int flag) {
        int oneVisit = getVisit(flag, false);
        int zeroVisit = getVisit(flag, true);
        return oneVisit + zeroVisit == (1 << n) - 1;
    }

    private static int getVisit(int flag, boolean isZero) {
        int visit = 0;
        for (int i = 0; i < n; i++) {
            if (hasBitAt(flag, i) == !isZero) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visit |= 1 << i;
                while (!queue.isEmpty()) {
                    Integer cur = queue.poll();
                    for (Integer next : edges[cur]) {
                        if (hasBitAt(visit, next)) continue;
                        if (isZero == hasBitAt(flag, next)) continue;
                        visit |= 1 << next;
                        queue.offer(next);
                    }
                }
                break;
            }
        }
        return visit;
    }

    private static boolean hasBitAt(int flag, int i) {
        return (flag & 1 << i) > 0;
    }
}

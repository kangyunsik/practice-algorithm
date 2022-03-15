package com.codingtest.algorithm.acmicpc.q17135;

import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> initMobs = new ArrayList<>();
    static List<int[]> mobs;
    static int n, m, d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                if (st.nextToken().equals("1"))
                    initMobs.add(new int[]{i, j});
            }
        }

        int ans = 0;
        for (int i = 0; i < (1 << m); i++) {
            if (Integer.bitCount(i) != 3) continue;
            mobs = new ArrayList<>();
            for (int[] initMob : initMobs) {
                mobs.add(new int[]{initMob[0], initMob[1]});
            }
            int cnt = 0;
            do {
                cnt += shot(i);
            } while (move());
            ans = Math.max(ans, cnt);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static boolean move() {
        for (int i = mobs.size() - 1; i >= 0; i--) {
            if(++mobs.get(i)[0] == n) {
                mobs.remove(mobs.get(i));
            }
        }
        return mobs.size() != 0;
    }

    private static int shot(int flag) {
        Set<int[]> targets = new HashSet<>();
        for (int i = 0; i < m; i++) {
            if ((flag & 1 << i) > 0) {
                int maxDist = d;
                int left = Integer.MAX_VALUE;
                int[] target = null;
                for (int[] mob : mobs) {
                    int dist = getDist(mob, i);
                    if (dist < maxDist || (dist == maxDist && mob[1] < left)) {
                        maxDist = dist;
                        target = mob;
                        left = mob[1];
                    }
                }
                if (target != null) targets.add(target);
            }
        }
        int ret = targets.size();
        for (int[] target : targets) {
            mobs.remove(target);
        }
        return ret;
    }

    private static int getDist(int[] mob, int archer) {
        return n - mob[0] + Math.abs(archer - mob[1]);
    }
}

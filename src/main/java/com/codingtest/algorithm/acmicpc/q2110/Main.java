package com.codingtest.algorithm.acmicpc.q2110;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        List<Integer> location = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            location.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(location);
        int ans = 1, distLow = 1, distHigh = 1 << 30;
        while (distLow < distHigh) {
            int distMid = (distLow + distHigh) / 2;
            int installable = getInstallable(location, distMid);
            if (installable >= c) {
                distLow = distMid;
                ans = Math.max(ans, distMid);
                if (distLow == distHigh - 1) {
                    break;
                }
            } else {
                distHigh = distMid;
            }
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getInstallable(List<Integer> location, int term) {
        int cur = location.get(0);
        int cnt = 1;
        for (Integer value : location) {
            if (cur + term <= value) {
                cur = value;
                cnt++;
            }
        }
        return cnt;
    }
}

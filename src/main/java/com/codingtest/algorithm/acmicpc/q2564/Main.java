package com.codingtest.algorithm.acmicpc.q2564;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        int[] dir = new int[k];
        int[] pos = new int[k];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            dir[i] = Integer.parseInt(st.nextToken());
            pos[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int hDir = Integer.parseInt(st.nextToken());
        int hPos = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans += getDist(dir[i], pos[i], hDir, hPos);
        }
        bw.write(String.valueOf(ans));
        bw.flush();
    }

    private static int getDist(int dir, int pos, int hDir, int hPos) {
        if (dir < hDir) return getDist(hDir, hPos, dir, pos);

        if (hDir == dir) {
            return Math.abs(hPos - pos);
        } else if (hDir == 1 && dir == 2) {
            return Math.min(pos + hPos, 2 * n - pos - hPos) + m;
        } else if (hDir == 1 && dir == 3) {
            return pos + hPos;
        } else if (hDir == 1 && dir == 4) {
            return n - hPos + pos;
        } else if (hDir == 2 && dir == 3) {
            return m - pos + hPos;
        } else if (hDir == 2 && dir == 4) {
            return n - hPos + m - pos;
        } else {
            return Math.min(pos + hPos, 2 * m - pos - hPos) + n;
        }
    }
}

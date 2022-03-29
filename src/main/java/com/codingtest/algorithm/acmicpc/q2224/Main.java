package com.codingtest.algorithm.acmicpc.q2224;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] edges = new boolean[123][123];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0, a, b; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = st.nextToken().charAt(0);
            st.nextToken();
            b = st.nextToken().charAt(0);
            if(a == b) continue;
            edges[a][b] = true;
        }

        for (int mid = 65; mid <= 122; mid++) {
            for (int i = 65; i <= 122; i++) {
                for (int j = 65; j <= 122; j++) {
                    if(i == j) continue;
                    if (edges[i][mid] && edges[mid][j]) edges[i][j] = true;
                }
            }
        }

        int ans = 0;
        for (int i = 'A'; i <= 'z'; i++) {
            for (int j = 'A'; j <= 'z'; j++) {
                if (edges[i][j]) {
                    ans++;
                    sb.append((char) i).append(" => ").append((char) j).append("\n");
                }
            }
        }
        bw.write(String.valueOf(ans));
        bw.newLine();
        bw.write(sb.toString());
        bw.flush();
    }
}

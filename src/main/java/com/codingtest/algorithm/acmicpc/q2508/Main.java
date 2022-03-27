package com.codingtest.algorithm.acmicpc.q2508;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 0; test_case < T; test_case++) {
            br.readLine();
            st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] board = new char[n][];
            for (int i = 0; i < n; i++) {
                board[i] = br.readLine().toCharArray();
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(board[i][j] == 'o'){
                        if(i + 1 < n && i - 1 >= 0 && board[i+1][j] == '^' && board[i-1][j] == 'v'){
                            ans++;
                        }else if(j + 1 < m && j - 1 >= 0 && board[i][j+1] == '<' && board[i][j-1] == '>'){
                            ans++;
                        }
                    }
                }
            }
            bw.append(String.valueOf(ans)).append("\n");
        }
        bw.flush();
    }
}

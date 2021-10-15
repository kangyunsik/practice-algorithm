package com.codingtest.algorithm.acmicpc.q11403;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n;
    boolean[][] matrix;
    int[][] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        main.init(n);
        for (int i = 0; i < n; i++) {
            main.set(i,br.readLine());
        }
        main.run();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(main.getAnswer()[i][j]+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }

    public void init(int n){
        this.n = n;
        matrix = new boolean[n][n];
        answer = new int[n][n];
    }

    public void set(int index, String s){
        StringTokenizer st = new StringTokenizer(s, " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            matrix[index][i] = st.nextToken().equals("1");
        }
    }

    public void run(){
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            boolean[] check = new boolean[n];

            queue.add(i);
            while(!queue.isEmpty()){
                int k = queue.poll();
                for (int j = 0; j < n; j++) {
                    if(!check[j] && matrix[k][j]){
                        answer[i][j] = 1;
                        check[j] = true;
                        queue.add(j);
                    }
                }
            }
        }
    }

    public int[][] getAnswer() {
        return answer;
    }
}

package com.codingtest.algorithm.q7569;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n, m, h;
    int not_ripe, day;
    int[][][] matrix;
    boolean[][][] check;
    Queue<Index> init_queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,m,h;

        Main main = new Main();
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        
        main.init(n,m,h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < m; j++) {
                main.set(br.readLine(), j,i);
            }
        }
        main.run();
        System.out.println(main.getAnswer());
    }

    public void init(int n, int m, int h) {
        this.n = n;
        this.m = m;
        this.h = h;
        matrix = new int[n][m][h];
        check = new boolean[n][m][h];
        init_queue = new LinkedList<>();
    }

    public void set(String input, int n, int h) {
        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value == 0)
                not_ripe++;
            else if (value == 1) {
                init_queue.add(new Index(i, n, h));
                check[i][n][h] = true;
            }
            matrix[i][n][h] = value;
        }
    }

    public void run() {
        ripe(init_queue, not_ripe);
        if (not_ripe != 0)
            day = -1;
    }

    public void ripe(Queue<Index> indexes, int count) {
        Queue<Index> new_index = new LinkedList<>();

        while (!indexes.isEmpty()) {
            Index index = indexes.poll();

            int[] vector_x = {1, 0, 0, -1, 0, 0};
            int[] vector_y = {0, 1, 0, 0, -1, 0};
            int[] vector_z = {0, 0, 1, 0, 0, -1};

            for (int i = 0; i < 6; i++) {
                int vx = index.i + vector_x[i];
                int vy = index.j + vector_y[i];
                int vz = index.k + vector_z[i];

                if (vx >= 0 && vx < n
                        && vy >= 0 && vy < m
                        && vz >= 0 && vz < h &&
                        !check[vx][vy][vz] && matrix[vx][vy][vz] == 0) {
                    matrix[vx][vy][vz] = 1;
                    not_ripe--;
                    new_index.add(new Index(vx, vy, vz));
                    check[vx][vy][vz] = true;
                }

            }
        }
        //System.out.println("day++ count : " + count + " ripe : " + not_ripe);
        if (count != not_ripe) {
            day++;
            ripe(new_index, not_ripe);
        }

    }

    public int getAnswer() {
        return this.day;
    }

    class Index {
        int i, j, k;

        public Index(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public void printTest() {
        System.out.println("n : " + n + " m : " + m + " h : " + h);
        for (int h = 0; h < this.h; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j][h] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}

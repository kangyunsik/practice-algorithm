package com.codingtest.algorithm.q7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int n,m,h;
    int answer,not_ripe,day;
    int[][][] matrix;
    Queue<Index> init_queue;

    public static void main(String[] args) {


    }

    public void init(int n,int m, int h){
        this.n = n;
        this.m = m;
        this.h = h;
        matrix = new int[this.n][this.m][this.h];
        init_queue = new LinkedList<>();
        this.answer = 0;
        this.not_ripe = 0;
        this.day = 0;
    }

    public void set(String input, int n,int h){
        StringTokenizer st = new StringTokenizer(input," ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            int value = Integer.parseInt(st.nextToken());
            if(value == 0)
                not_ripe++;
            else if(value == 1) {
                init_queue.add(new Index(n, i, h));
            }
            System.out.println("value : " + value);
            matrix[i][n][h] = value;
        }
    }

    public void run(){
        ripe(init_queue,not_ripe);
        if(not_ripe != 0)
            day = -1;
    }

    public void ripe(Queue<Index> indexes,int count){
        Queue<Index> new_index = new LinkedList<>();

        while(!indexes.isEmpty()){
            Index index = indexes.poll();

            int[] vector_x = {1,0,0,-1,0,0};
            int[] vector_y = {0,1,0,0,-1,0};
            int[] vector_z = {0,0,1,0,0,-1};
            for (int i = 0; i < 6; i++) {
                int vx = index.i+vector_x[i];
                int vy = index.j+vector_y[i];
                int vz = index.k+vector_z[i];

                if(vx >= 0 && vx < n
                && vy >= 0 && vy < m
                && vz >= 0 && vz < h){
                    if(matrix[vx][vy][vz] == 0) {
                        System.out.println("not ripe");
                        matrix[vx][vy][vz] = 1;
                        not_ripe--;
                        new_index.add(new Index(vx, vy,vz));
                    }
                }
            }
        }
        day++;
        System.out.println("day++ count : " + count + " ripe : " + not_ripe );
        if(count!= not_ripe)
            ripe(new_index,not_ripe);

    }

    public int getAnswer(){
        return this.day;
    }

    class Index{
        int i,j,k;

        public Index(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }
    }

    public void printTest(){
        System.out.println("n : " + n + " m : " + m + " h : " + h);
        for (int h = 0; h < this.h; h++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    System.out.print(matrix[i][j][h]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}

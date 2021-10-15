package com.codingtest.algorithm.acmicpc.q10026;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    int n;
    char[][] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        main.init(n);
        for (int i = 0; i < n; i++) {
            main.set(i,br.readLine());
        }
        bw.write(main.getAnswer(false) +" " +main.getAnswer(true)+"\n");
        bw.flush();
    }

    public void init(int n){
        this.n = n;
        array = new char[n][n];
    }

    public void set(int index,String in){
        for (int i = 0; i < n; i++) {
            char c = in.charAt(i);
            array[index][i] = in.charAt(i);
        }
    }

    public int getAnswer(boolean isDisabled){
        boolean[][] check = new boolean[n][n];
        Queue<Integer[]> queue = new LinkedList<>();
        int[] vx = {1,0,-1,0};
        int[] vy = {0,1,0,-1};

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!check[i][j]) {
                    count++;
                    queue.add(new Integer[]{i,j});

                    while(!queue.isEmpty()){
                        Integer[] polled = queue.poll();
                        int px = polled[0];
                        int py = polled[1];

                        if(!check[px][py]) {
                            char target = array[px][py];
                            check[px][py] = true;
                            for (int k = 0; k < 4; k++) {
                                int dx = px + vx[k];
                                int dy = py + vy[k];
                                if (dx < n && dx >= 0 &&
                                        dy < n && dy >= 0 &&
                                        isSameByDisabled(isDisabled, target, array[dx][dy])) {
                                    queue.add(new Integer[]{dx, dy});
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public boolean isSameByDisabled(boolean isDisabled, char a, char b) {
        if(isDisabled){
            if(a == 'R')
                a = 'G';
            if(b == 'R')
                b = 'G';
            return a==b;
        }else{
            return a==b;
        }
    }


}

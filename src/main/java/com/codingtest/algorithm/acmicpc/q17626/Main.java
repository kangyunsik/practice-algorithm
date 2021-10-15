package com.codingtest.algorithm.acmicpc.q17626;

import java.io.*;

public class Main {
    int n;
    int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Main main = new Main();
        main.init(n);
        bw.write(Integer.toString(main.getAnswer()));
        bw.flush();
    }

    public int getAnswer(){
        return array[n];
    }

    public void init(int n){
        this.n = n;
        array = new int[n+1];

        for (int i = 1; i*i <=n ; i++) {
            array[i*i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            if(array[i] == 0){
                int temp = Integer.MAX_VALUE;
                for (int j = 1; j*j <= i/2; j++) {
                    int target = array[j*j] + array[i-j*j];
                    temp = Math.min(target,temp);
                }
                array[i] = temp;
            }
        }
    }
}

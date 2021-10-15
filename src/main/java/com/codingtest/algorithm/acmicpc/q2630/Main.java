package com.codingtest.algorithm.acmicpc.q2630;

import java.util.Scanner;

public class Main {
    public int n;
    public int[][] array;
    public int[] solution;

    public void init(int n, int[][] array) {
        this.n = n;
        this.array = array;
        this.solution = new int[2];
    }

    public void run() {
        recursive(0, 0, n);
    }

    public void recursive(int i, int j, int size) {
        if(size == 1){
            solution[array[i][j]]++;

        }else if(isSame(i,j,size)){
            solution[array[i][j]]++;

        }else{
            recursive(i,j,size/2);
            recursive(i+size/2,j,size/2);
            recursive(i,j+size/2,size/2);
            recursive(i+size/2,j+size/2,size/2);

        }
    }

    public boolean isSame(int i,int j, int size){
        int temp = array[i][j];
        for (int k = 0; k < size * size; k++)
            if(temp != array[i+k/size][j+k%size])
                return false;

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int n = sc.nextInt();
        int[][] array;

        array = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                array[i][j] = sc.nextInt();

        main.init(n, array);
        main.run();
        for (int i : main.solution)
            System.out.println(i);
    }
}

package com.codingtest.algorithm.acmicpc.q1780;

import java.util.Scanner;

public class Main {
    public int[][] array;
    public int n;
    public int[] answer;

    public void init(int n) {
        array = new int[n][n];
        this.n = n;
        this.answer = new int[3];
    }

    public void run(){
        recursive(0,0,n);
    }

    public void recursive(int i, int j, int size) {
        if (size == 1)
            answer[array[i][j] + 1]++;
        else if (isSame(i, j, size))
            answer[array[i][j] + 1]++;
        else
            for (int k = 0; k < 9; k++)
                recursive(i + size / 3 * (k % 3), j + k / 3 * size / 3, size / 3);
    }

    public boolean isSame(int i, int j, int size) {
        int target = array[i][j];
        for (int k = 0; k < size * size; k++)
            if (target != array[i + k / size][j + k % size])
                return false;
        return true;
    }

    public static void main(String[] args) {
        Main main = new Main();
        int n;

        Scanner sc = new Scanner(System.in);
        main.init(n = sc.nextInt());

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                main.array[i][j] = sc.nextInt();

        main.run();
        for (int i : main.answer)
            System.out.println(i);
    }
}

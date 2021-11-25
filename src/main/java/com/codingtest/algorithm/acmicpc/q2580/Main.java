package com.codingtest.algorithm.acmicpc.q2580;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int[][] matrix = new int[9][9];
    static List<Integer> requireX = new ArrayList<>();
    static List<Integer> requireY = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                matrix[i][j] = sc.nextInt();
                if(matrix[i][j] == 0) {
                    requireX.add(i);
                    requireY.add(j);
                }
            }
        }
        find(0);
    }

    private static void print(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void find(int current){
        if(current == requireX.size()) {
            print();
            flag = true;
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if(isValid(current, i) && !flag){
                matrix[requireX.get(current)][requireY.get(current)] = i;
                find(current+1);
                matrix[requireX.get(current)][requireY.get(current)] = 0;
            }
        }

    }

    private static boolean isValid(int loc_index, int value){
        int i = requireX.get(loc_index);
        int j = requireY.get(loc_index);
        for (int k = 0; k < 9; k++) {
            if(matrix[i][k] == value) return false;
            if(matrix[k][j] == value) return false;
        }

        for (int k = i - i%3; k < i - i%3 + 3; k++) {
            for (int l = j - j%3; l < j - j%3 + 3; l++) {
                if(matrix[k][l] == value) return false;
            }
        }
        return true;
    }
}

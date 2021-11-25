package com.codingtest.algorithm.acmicpc.q9963;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    static int[] queen_location;
    static int n;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        queen_location = new int[n];
        function(0);
        bw.write(answer+"");
        bw.flush();
    }

    private static void function(int current){
        if(current == n){
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if(isValid(current, i)){
                queen_location[current] = i;
                function(current + 1);
            }
        }
    }
    private static boolean isValid(int current, int index){
        for (int i = 0; i < current; i++) {
            if(queen_location[i] == index || (Math.abs(current-i) == Math.abs(index - queen_location[i]))){
                return false;
            }
        }
        return true;
    }
}

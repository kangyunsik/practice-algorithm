package com.codingtest.algorithm.acmicpc.q1935;

import java.io.*;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(br.readLine());
        }
        Stack<Double> numbers = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(Character.isAlphabetic(c)){
                numbers.push((double)values[c-'A']);
            }else{
                Double p1 = numbers.pop();
                Double p2 = numbers.pop();
                if(c == '+'){
                    numbers.push(p2 + p1);
                }else if(c == '-'){
                    numbers.push(p2 - p1);
                }else if(c == '*'){
                    numbers.push(p2 * p1);
                }else{
                    numbers.push(p2 / p1);
                }
            }
        }
        bw.write(String.format("%.2f",numbers.pop()));
        bw.flush();
    }
}

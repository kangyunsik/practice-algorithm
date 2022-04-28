package com.codingtest.algorithm.acmicpc.q9661;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine()) % 5;
        System.out.println(n % 5 == 0 || n % 5 == 2 ? "CY" : "SK");
    }
}
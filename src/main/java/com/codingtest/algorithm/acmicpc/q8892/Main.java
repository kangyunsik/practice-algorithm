package com.codingtest.algorithm.acmicpc.q8892;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test_case = Integer.parseInt(br.readLine());
        lb:
        for (int test = 0; test < test_case; test++) {
            int n = Integer.parseInt(br.readLine());
            String[] inputs = new String[n];
            for (int i = 0; i < n; i++) {
                inputs[i] = br.readLine();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i != j && isPalindrome(inputs[i]+inputs[j])){
                        bw.write(inputs[i]+inputs[j]+"\n");
                        bw.flush();
                        continue lb;
                    }
                }
            }
            bw.write("0\n");
            bw.flush();
        }
    }

    private static boolean isPalindrome(String string){
        for (int i = 0; i < string.length()/2; i++) {
            if(string.charAt(i) != string.charAt(string.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

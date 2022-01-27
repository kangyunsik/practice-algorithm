package com.codingtest.algorithm.acmicpc.q16472;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String string = br.readLine();

        int len = string.length(), ans = 0, cnt, num, prev = 0;
        int[] status = new int[26];

        for (int i = 0; i < len; i++) {
            int c = string.charAt(i) - 'a';
            status[c]++;
            cnt = 0;
            num = 0;
            for (int j = 0; j < 26; j++) {
                if(status[j] > 0){
                    num += status[j];
                    cnt++;
                }
            }
            if(n >= cnt){
                ans = Math.max(ans, num);
            }else{
                status[string.charAt(prev++) - 'a']--;
            }
        }
        bw.write(ans + "\n");
        bw.flush();
    }
}

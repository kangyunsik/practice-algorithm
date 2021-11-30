package com.codingtest.algorithm.acmicpc.q2042;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n, a, b;
        long m, k, temp, c;
        long[] value, sum;
        Map<Integer, Long> edited = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());

        value = new long[n];
        sum = new long[n];
        for (int i = 0; i < n; i++) {
            value[i] = Long.parseLong(br.readLine());
            if (i == 0) sum[i] = value[i];
            else sum[i] = sum[i - 1] + value[i];
        }

        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken()) - 1;
            c = Long.parseLong(st.nextToken()) - 1;
            if(a == 1){
                edited.put(b, c - value[b] + 1);
            }else{
                if(b == 0){
                    temp = sum[(int)c];
                }else{
                    temp = sum[(int)c] - sum[b - 1];
                }
                for (Integer index : edited.keySet()) {
                    if(b <= index && index <= c){
                        temp += edited.get(index);
                    }
                }
                bw.write(temp+"\n");
            }
        }
        bw.flush();
    }
}

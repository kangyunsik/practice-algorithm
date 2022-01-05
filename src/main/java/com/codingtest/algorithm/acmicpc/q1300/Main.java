package com.codingtest.algorithm.acmicpc.q1300;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,k;

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        br.close();

        bw.write(solve(n,k)+"\n");
        bw.flush();
        bw.close();
    }

    public static int solve(int n, int k){
        int s,e,mid,sum,ans = k;
        s = 1;
        e = k;

        while(s < e){
            mid = (s+e)/2;
            sum = 0;
            for (int i = 1; i <= n; i++) {
                sum += Math.min(mid/i, n);
            }

            if(sum >= k){
                ans = mid;
                e = mid;
            }else{
                s = mid;
                if(s == e-1){
                    break;
                }
            }
        }
        return ans;
    }
}

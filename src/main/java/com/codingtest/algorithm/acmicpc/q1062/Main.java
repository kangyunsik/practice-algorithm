package com.codingtest.algorithm.acmicpc.q1062;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static boolean[] check = new boolean[26];
    static String[] inputs;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        inputs = new String[n];
        for (int i = 0; i < n; i++) {
            String temp = br.readLine();
            temp = temp.substring(4, temp.length()-4);
            temp = temp.replaceAll("[acint]","");
            inputs[i] = temp;
        }
        if(m < 5){
            bw.write("0\n");
            bw.flush();
            return;
        }
        m-=5;
        check['a' - 'a'] = true;
        check['c' - 'a'] = true;
        check['i' - 'a'] = true;
        check['n' - 'a'] = true;
        check['t' - 'a'] = true;

        find(0, m);
        bw.write(ans+"\n");
        bw.flush();
    }

    static void find(int depth, int remain){
        if(remain == 0){
            updateAns();
            return;
        }else if(depth >= 26){
            return;
        }

        if(!check[depth]){
            check[depth] = true;
            find(depth+1, remain-1);
            check[depth] = false;
        }
        find(depth+1,remain);
    }

    static void updateAns() {
        int cnt = 0;
        for (String input : inputs) {
            if(isValid(input)){
                cnt++;
            }
        }
        ans = Math.max(cnt , ans);
    }

    static boolean isValid(String string){
        for (int i = 0; i < string.length(); i++) {
            if(!check[string.charAt(i) - 'a'])
                return false;
        }
        return true;
    }
}

package com.codingtest.algorithm.q17219;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    String[] answer;
    int count;
    Map<String,String> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,m;

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Main main = new Main();
        main.init(m);
        for (int i = 0; i < n; i++) {
            main.set(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            main.run(br.readLine());
        }

        for (String s : main.answer)
            bw.write(s+"\n");
        bw.flush();
    }

    public void init(int m){
        map = new HashMap<>();
        answer = new String[m];
        count = 0;
    }

    public void set(String string){
        StringTokenizer st = new StringTokenizer(string," ");
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        map.put(s1,s2);
    }


    public void run(String string){
        answer[count++] = map.get(string);
    }

    public String[] getAnswer(){
        return answer;
    }
}

package com.codingtest.algorithm.q7662;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    int n;
    List<Long> list;
    long value;

    public void init(int n){
        this.n = n;
        list = new ArrayList<>();
    }

    public void run(String s){
        char order = s.split(" ")[0].charAt(0);
        value = Long.parseLong(s.split(" ")[1]);

        switch(order){
            case 'I':
                insert(value);
                break;
            case 'D':
                delete(value);
                break;
        }
    }

    public void insert(long value){
        int size = list.size();

        if(size==0)
            list.add(value);
        else
            list.add(binarySearch(0,size-1),value);
    }

    public int binarySearch(int s, int e){
        int m;
        while(!(e-1 == s || e==s)){
            m = (s+e)/2;
            if(list.get(m) <= value){
                s = m;
            }else{
                e = m;
            }
        }

        if(list.get(e) < value)
            return e+1;
        else
            return e;


    }

    public void delete(long value){
        if(list.size() > 0 && value == 1){
            list.remove(list.size()-1);
        }else if(list.size() > 0 && value == -1){
            list.remove(0);
        }
    }

    public String getAnswer(){
        if(list.size() == 0)
            return "EMPTY";
        else
            return list.get(list.size()-1) + " " + list.get(0);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main;
        int t = Integer.parseInt(br.readLine());
        int n;

        for (int i = 0; i < t; i++) {
            n = Integer.parseInt(br.readLine());
            main = new Main();
            main.init(n);
            for (int j = 0; j < n; j++) {
                main.run(br.readLine());
            }
            bw.write(main.getAnswer()+"\n");
        }
        bw.flush();

    }
}

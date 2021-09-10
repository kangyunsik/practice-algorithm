package com.codingtest.algorithm.datastructure;

import java.util.ArrayList;
import java.util.List;

public class Eratosthenes {
    List<Integer> list;
    boolean[] check;
    int n;

    public Eratosthenes(int n) {
        list = new ArrayList<>();
        check = new boolean[n+1];
        this.n = n;
        check[0] = true;
        check[1] = true;
    }

    public void run(){
        for (int i = 2; i*i <= n; i++) {
            if(!check[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    check[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(!check[i])
                list.add(i);
        }
    }

}

package com.codingtest.algorithm.acmicpc.q2346;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            temp.add(i + 1);
        }

        int index = 0;
        while (n-- > 0) {
            Integer pop = list.get(index);
            bw.write(temp.get(index) + " ");
            list.remove(index);
            temp.remove(index);
            if (n != 0) {
                if(pop > 0){
                    index = (index + pop - 1) % list.size();
                }else{
                    index = (index + pop % list.size() + list.size()) % list.size();
                }
            }
        }
        bw.flush();
    }
}

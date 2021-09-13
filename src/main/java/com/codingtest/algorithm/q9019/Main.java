package com.codingtest.algorithm.q9019;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    int[] array;
    String[] how;
    StringTokenizer st;
    int start, end;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Main main;

        int test_case = Integer.parseInt(br.readLine());
        for (int t = 0; t < test_case; t++) {
            main = new Main();
            main.set(br.readLine());
            main.run();
            bw.write(main.getAnswer()+"\n");
        }
        bw.flush();
    }

    public Main() {
        array = new int[10000];
        how = new String[10000];
        Arrays.fill(array, Integer.MAX_VALUE);
        Arrays.fill(how, "");
    }

    public void set(String input) {
        st = new StringTokenizer(input, " ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        array[start] = 0;
    }

    public void run() {
        int number = start;

        Item[] next = {
                new Item(number, 'D'),
                new Item(number, 'S'),
                new Item(number, 'L'),
                new Item(number, 'R')
        };

        Queue<Item> queue = new LinkedList<>(Arrays.asList(next));

        while (!queue.isEmpty()) {
            Item item = queue.poll();

            if (array[item.value] > array[item.def_value] + 1) {
                array[item.value] = array[item.def_value] + 1;
                how[item.value] = how[item.def_value] + item.type;
                queue.add(new Item(item.value,'D'));
                queue.add(new Item(item.value,'S'));
                queue.add(new Item(item.value,'L'));
                queue.add(new Item(item.value,'R'));
            }
        }

    }

    public String getAnswer() {
        return this.how[end];
    }

    class Item {
        int def_value;
        int value;
        char type;

        public Item(int def_value, char type) {
            this.def_value = def_value;
            this.type = type;

            switch(type){
                case 'D':
                    this.value = (2 * this.def_value) % 10000;
                    break;
                case 'S':
                    this.value = (this.def_value + 9999) % 10000;
                    break;
                case 'L':
                    this.value = (this.def_value * 10) % 10000 + this.def_value / 1000;
                    break;
                case 'R':
                    this.value = (this.def_value / 10) + this.def_value %10 * 1000;
                    break;
            }
        }
    }
}

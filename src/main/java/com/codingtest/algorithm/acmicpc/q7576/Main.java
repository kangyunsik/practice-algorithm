package com.codingtest.algorithm.acmicpc.q7576;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public int m, n;
    public Plate plate;

    public void init(int m, int n, String[][] array) {
        this.m = m;
        this.n = n;
        plate = new Plate(array, n, m);
    }

    public void run() {
        while (plate.flag && plate.zeroCount != 0)
            plate.reap();

        if (plate.zeroCount != 0)
            plate.answer = -1;
    }

    public int getAnswer() {
        return this.plate.answer;
    }

    class Plate {
        public String[][] array;
        public int answer;
        public boolean flag;
        public int zeroCount;

        List<Integer> iSet;
        List<Integer> jSet;
        int[] vectorX;
        int[] vectorY;

        public Plate(String[][] array, int n, int m) {
            this.answer = 0;
            this.array = array;
            flag = true;
            zeroCount = 0;
            iSet = new ArrayList<>();
            jSet = new ArrayList<>();

            vectorX = new int[]{1, 0, -1, 0};
            vectorY = new int[]{0, 1, 0, -1};

            for (int i = 0; i < n * m; i++) {
                String target = array[i / m][i % m];
                if (target.equals("0"))
                    zeroCount++;
                else if (target.equals("1")) {
                    iSet.add(i / m);
                    jSet.add(i % m);
                }
            }
        }

        public void reap() {
            flag = false;
            answer++;

            List<Integer> aft_iSet = new ArrayList<>();
            List<Integer> aft_jSet = new ArrayList<>();

            int one_i;
            int one_j;

            for (int k = 0; k < iSet.size(); k++) {
                int i = iSet.get(k);
                int j = jSet.get(k);
                for (int l = 0; l < 4; l++) {
                    one_i = i + vectorX[l];
                    one_j = j + vectorY[l];
                    if (one_i < n && one_j < m && one_i >= 0 && one_j >= 0 &&
                            array[one_i][one_j].equals("0")) {
                        array[one_i][one_j] = "1";
                        aft_iSet.add(one_i);
                        aft_jSet.add(one_j);
                        zeroCount--;
                        flag = true;
                    }
                }
            }
            iSet = aft_iSet;
            jSet = aft_jSet;
        }
    }

    public static void main(String[] args) throws IOException {
        int m, n;
        String[][] array;
        StringTokenizer tokenizer;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        tokenizer = new StringTokenizer(br.readLine(), " ");

        m = Integer.parseInt(tokenizer.nextToken());
        n = Integer.parseInt(tokenizer.nextToken());

        array = new String[n][m];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; tokenizer.hasMoreTokens(); j++) {
                array[i][j] = tokenizer.nextToken();
            }
        }

        Main main = new Main();
        main.init(m, n, array);
        main.run();
        bw.write(main.getAnswer()+"");
        bw.flush();
    }
}

package com.codingtest.algorithm.q16236;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    int n;
    int[][] array;
    int lx, ly;
    int size;
    int eat_count;
    int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Main main = new Main(n);
        for (int i = 0; i < n; i++) {
            main.set(i,br.readLine());
        }
        main.run();
        bw.write(main.getAnswer()+"\n");
        bw.flush();
    }

    public Main(int n) {
        this.n = n;
        array = new int[n][n];
        size = 2;
        eat_count = 0;
        answer = 0;
    }

    void set(int index, String input) {
        StringTokenizer st = new StringTokenizer(input, " ");
        for (int i = 0; st.hasMoreTokens(); i++) {
            int value = Integer.parseInt(st.nextToken());
            array[index][i] = value;
            if (value == 9) {
                array[index][i] = 0;
                lx = index;
                ly = i;
            }
        }
    }

    void run() {
        PriorityQueue<Index> queue = new PriorityQueue<>();
        queue.add(new Index(lx, ly, 0));

        boolean[][] check = new boolean[n][n];

        while (!queue.isEmpty()) {
            Index index = queue.poll();

            if (!check[index.x][index.y] && array[index.x][index.y] <= size) {
                check[index.x][index.y] = true;

                int[] vx = {1, 0, -1, 0};
                int[] vy = {0, 1, 0, -1};
                for (int i = 0; i < 4; i++) {
                    int dx = index.x + vx[i];
                    int dy = index.y + vy[i];

                    if (dx >= 0 && dx < n
                            && dy >= 0 && dy < n
                            && !check[dx][dy]) {
                        queue.add(new Index(dx, dy, index.move + 1));
                    }
                }


                if (array[index.x][index.y] > 0 && array[index.x][index.y] < size) {
                    array[index.x][index.y] = 0;

                    if (++eat_count == size) {
                        size++;
                        eat_count = 0;
                    }

                    queue.clear();
                    queue.add(new Index(index.x,index.y,index.move));
                    check = new boolean[n][n];
                    answer = index.move;
                }
            }
        }
    }

    int getAnswer() {
        return this.answer;
    }

    class Index implements Comparable<Index> {
        int x;
        int y;
        int move;

        @Override
        public int compareTo(Index o) {
            return o.move == this.move ?
                    (o.x == this.x ? this.y - o.y : this.x - o.x)
                    : this.move - o.move;
        }

        public Index(int x, int y, int move) {
            this.x = x;
            this.y = y;
            this.move = move;
        }
    }

}

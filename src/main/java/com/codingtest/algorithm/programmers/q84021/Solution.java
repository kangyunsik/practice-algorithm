package com.codingtest.algorithm.programmers.q84021;

import java.util.*;

class Solution {
    static int n;
    static int answer = 0;

    public int solution(int[][] game_board, int[][] table) {
        Solution.n = table.length;

        List<Puzzle> table_puzzles = getPuzzles(table, 1);
        List<Puzzle> game_puzzles = getPuzzles(game_board, 0);

        Puzzle picked;
        for (Puzzle table_puzzle : table_puzzles) {
            picked = null;

            for (Puzzle game_puzzle : game_puzzles) {
                if(table_puzzle.isEqualTo(game_puzzle)){
                    answer+= table_puzzle.value;
                    picked = game_puzzle;
                    break;
                }
            }

            if(picked != null)
                game_puzzles.remove(picked);
        }

        return answer;
    }

    private List<Puzzle> getPuzzles(int[][] matrix, int value) {
        List<Puzzle> results = new ArrayList<>();
        boolean[][] check = new boolean[n][n];
        Queue<Index> queue;
        Queue<Index> indexes;
        Index min_index;
        Index max_index;

        int[] vx = {1, 0, -1, 0};
        int[] vy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queue = new LinkedList<>();
                indexes = new LinkedList<>();
                min_index = new Index(n, n);
                max_index = new Index(0, 0);

                if(!check[i][j] && matrix[i][j] == value) {
                    check[i][j] = true;
                    queue.add(new Index(i, j));

                    while (!queue.isEmpty()) {
                        Index index = queue.poll();
                        indexes.add(index);

                        min_index.x = Math.min(min_index.x, index.x);
                        min_index.y = Math.min(min_index.y, index.y);
                        max_index.x = Math.max(max_index.x, index.x);
                        max_index.y = Math.max(max_index.y, index.y);

                        int x = index.x;
                        int y = index.y;

                        for (int k = 0; k < 4; k++) {
                            int nx = x + vx[k];
                            int ny = y + vy[k];
                            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !check[nx][ny] && matrix[nx][ny] == value) {
                                check[nx][ny] = true;
                                queue.add(new Index(nx, ny));
                            }
                        }
                    }

                    Puzzle puzzle = new Puzzle( max_index.x - min_index.x + 1, max_index.y - min_index.y + 1);
                    puzzle.setInit(min_index.x, min_index.y);
                    puzzle.set(indexes);
                    results.add(puzzle);
                }

            }
        }

        return results;
    }

    class Index {
        int x, y;

        public Index(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public class Puzzle {
        int n, m;
        int x, y;
        int value;
        boolean[][] matrix;

        public Puzzle(int n, int m) {
            this.n = n;
            this.m = m;
            matrix = new boolean[n][m];
            value = 0;
        }

        public void set(Queue<Index> indexes) {
            while (!indexes.isEmpty()) {
                Index poll = indexes.poll();
                matrix[poll.x - x][poll.y - y] = true;
                value++;
            }
        }

        public void setInit(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Puzzle rotate() {
            Puzzle puzzle = new Puzzle(m, n);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    puzzle.matrix[j][n-i-1] = this.matrix[i][j];
                }
            }

            return puzzle;
        }

        public boolean isEqualTo(Puzzle puzzle){
            lb : for (int a = 0; a < 4; a++) {
                puzzle = puzzle.rotate();
                if(puzzle.n != this.n || puzzle.m != this.m)
                    continue;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if(this.matrix[i][j] != puzzle.matrix[i][j]) {
                            continue lb;
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }
}
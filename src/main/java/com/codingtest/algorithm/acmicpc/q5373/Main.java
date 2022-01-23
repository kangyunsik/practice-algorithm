package com.codingtest.algorithm.acmicpc.q5373;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int test_case = Integer.parseInt(br.readLine());
        for (int TEST_CASE = 0; TEST_CASE < test_case; TEST_CASE++) {
            int n = Integer.parseInt(br.readLine());
            Cube cube = new Cube();
            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < n; i++) {
                String query = st.nextToken();
                char o1 = query.charAt(0);
                char o2 = query.charAt(1);
                switch (o1) {
                    case 'U':
                        cube.up(o2);
                        break;
                    case 'D':
                        cube.down(o2);
                        break;
                    case 'F':
                        cube.front(o2);
                        break;
                    case 'B':
                        cube.back(o2);
                        break;
                    case 'L':
                        cube.left(o2);
                        break;
                    case 'R':
                        cube.right(o2);
                        break;
                }
            }
            cube.printUp(bw);
        }
    }

    static class Cube {
        char[][] status;

        public void printUp(BufferedWriter bw) throws IOException {
            for (int i = 3; i < 6; i++) {
                for (int j = 3; j < 6; j++) bw.write(status[i][j]);
                bw.write("\n");
            }
            bw.flush();
        }

        private void rotate(int a, int b, char dir) {
            char temp1 = status[a][b];
            char temp2 = status[a][b + 1];
            if (dir == '+') {
                status[a][b] = status[a + 2][b];
                status[a + 2][b] = status[a + 2][b + 2];
                status[a + 2][b + 2] = status[a][b + 2];
                status[a][b + 2] = temp1;

                status[a][b + 1] = status[a + 1][b];
                status[a + 1][b] = status[a + 2][b + 1];
                status[a + 2][b + 1] = status[a + 1][b + 2];
                status[a + 1][b + 2] = temp2;
            } else {
                status[a][b] = status[a][b + 2];
                status[a][b + 2] = status[a + 2][b + 2];
                status[a + 2][b + 2] = status[a + 2][b];
                status[a + 2][b] = temp1;

                status[a][b + 1] = status[a + 1][b + 2];
                status[a + 1][b + 2] = status[a + 2][b + 1];
                status[a + 2][b + 1] = status[a + 1][b];
                status[a + 1][b] = temp2;
            }

        }

        public void left(char dir) {
            rotate(3, 0, dir);
            if (dir == '+') {
                char temp1 = status[9][3];
                char temp2 = status[10][3];
                char temp3 = status[11][3];
                for (int i = 11; i > 2; i--) {
                    status[i][3] = status[i - 3][3];
                }
                status[0][3] = temp1;
                status[1][3] = temp2;
                status[2][3] = temp3;
            } else {
                char temp1 = status[0][3];
                char temp2 = status[1][3];
                char temp3 = status[2][3];
                for (int i = 0; i < 9; i++) {
                    status[i][3] = status[i + 3][3];
                }
                status[9][3] = temp1;
                status[10][3] = temp2;
                status[11][3] = temp3;
            }
        }

        public void right(char dir) {
            rotate(3, 6, dir);
            if (dir == '-') {
                char temp1 = status[9][5];
                char temp2 = status[10][5];
                char temp3 = status[11][5];
                for (int i = 11; i > 2; i--) {
                    status[i][5] = status[i - 3][5];
                }
                status[0][5] = temp1;
                status[1][5] = temp2;
                status[2][5] = temp3;
            } else {
                char temp1 = status[0][5];
                char temp2 = status[1][5];
                char temp3 = status[2][5];
                for (int i = 0; i < 9; i++) {
                    status[i][5] = status[i + 3][5];
                }
                status[9][5] = temp1;
                status[10][5] = temp2;
                status[11][5] = temp3;
            }
        }

        public void up(char dir) {
            rotate(3, 3, dir);
            if (dir == '+') {
                char temp1 = status[3][2];
                char temp2 = status[4][2];
                char temp3 = status[5][2];
                for (int i = 0; i < 3; i++) status[3 + i][2] = status[6][3 + i];
                for (int i = 0; i < 3; i++) status[6][3 + i] = status[5 - i][6];
                for (int i = 0; i < 3; i++) status[5 - i][6] = status[2][5 - i];
                status[2][5] = temp1;
                status[2][4] = temp2;
                status[2][3] = temp3;
            } else {
                char temp1 = status[2][3];
                char temp2 = status[2][4];
                char temp3 = status[2][5];
                for (int i = 0; i < 3; i++) status[2][5 - i] = status[5 - i][6];
                for (int i = 0; i < 3; i++) status[5 - i][6] = status[6][3 + i];
                for (int i = 0; i < 3; i++) status[6][3 + i] = status[3 + i][2];
                status[5][2] = temp1;
                status[4][2] = temp2;
                status[3][2] = temp3;
            }
        }

        public void down(char dir) {
            rotate(9, 3, dir);
            if (dir == '+') {
                char temp1 = status[0][3];
                char temp2 = status[0][4];
                char temp3 = status[0][5];
                for (int i = 0; i < 3; i++) status[0][i + 3] = status[i + 3][8];
                for (int i = 0; i < 3; i++) status[i + 3][8] = status[8][5 - i];
                for (int i = 0; i < 3; i++) status[8][5 - i] = status[5 - i][0];
                status[5][0] = temp1;
                status[4][0] = temp2;
                status[3][0] = temp3;
            } else {
                char temp1 = status[0][3];
                char temp2 = status[0][4];
                char temp3 = status[0][5];
                for (int i = 0; i < 3; i++) status[0][i + 3] = status[5 - i][0];
                for (int i = 0; i < 3; i++) status[5 - i][0] = status[8][5 - i];
                for (int i = 0; i < 3; i++) status[8][5 - i] = status[i + 3][8];
                status[3][8] = temp1;
                status[4][8] = temp2;
                status[5][8] = temp3;
            }
        }

        public void front(char dir) {
            rotate(6, 3, dir);
            if (dir == '+') {
                char temp1 = status[5][6];
                char temp2 = status[5][7];
                char temp3 = status[5][8];
                for (int i = 0; i < 6; i++) status[5][8 - i] = status[5][5 - i];
                for (int i = 0; i < 3; i++) status[5][2 - i] = status[9][3 + i];
                status[9][5] = temp1;
                status[9][4] = temp2;
                status[9][3] = temp3;
            } else {
                char temp1 = status[5][0];
                char temp2 = status[5][1];
                char temp3 = status[5][2];
                for (int i = 0; i < 6; i++) status[5][i] = status[5][i + 3];
                for (int i = 0; i < 3; i++) status[5][6 + i] = status[9][5 - i];
                status[9][5] = temp1;
                status[9][4] = temp2;
                status[9][3] = temp3;
            }
        }

        public void back(char dir) {
            rotate(0, 3, dir);
            if (dir == '+') {
                char temp1 = status[3][0];
                char temp2 = status[3][1];
                char temp3 = status[3][2];
                for (int i = 0; i < 6; i++) status[3][i] = status[3][i + 3];
                for (int i = 0; i < 3; i++) status[3][6 + i] = status[11][5 - i];
                status[11][5] = temp1;
                status[11][4] = temp2;
                status[11][3] = temp3;
            } else {
                char temp1 = status[3][6];
                char temp2 = status[3][7];
                char temp3 = status[3][8];
                for (int i = 0; i < 6; i++) status[3][8 - i] = status[3][5 - i];
                for (int i = 0; i < 3; i++) status[3][i] = status[11][5 - i];
                status[11][5] = temp1;
                status[11][4] = temp2;
                status[11][3] = temp3;
            }
        }

        public Cube() {
            status = new char[][]{
                    {'x', 'x', 'x', 'o', 'o', 'o', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'o', 'o', 'o', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'o', 'o', 'o', 'x', 'x', 'x'},
                    {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
                    {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
                    {'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b'},
                    {'x', 'x', 'x', 'r', 'r', 'r', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'r', 'r', 'r', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'r', 'r', 'r', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'y', 'y', 'y', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'y', 'y', 'y', 'x', 'x', 'x'},
                    {'x', 'x', 'x', 'y', 'y', 'y', 'x', 'x', 'x'}
            };
        }
    }
}

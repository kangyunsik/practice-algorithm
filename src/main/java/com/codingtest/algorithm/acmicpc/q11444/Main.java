package com.codingtest.algorithm.acmicpc.q11444;

import java.io.*;

public class Main {
    static final int mod = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        if(n == 0L){
            bw.write("0");
            bw.flush();
            return;
        }
        Matrix iv = new Matrix();
        iv.setInit();
        matrixSquare(iv, n - 1);
        bw.write(iv.values[1][0] + "");
        bw.flush();
    }

    static void matrixSquare(Matrix matrix, long n) {
        Matrix temp = Matrix.copyOf(matrix);
        while (n > 0) {
            if (n % 2 == 1) {
                matrix.multiply(temp);
            }
            temp.multiply(temp);
            n /= 2;
        }
    }
}

class Matrix {
    int[][] values;
    static final int mod = 1000000007;

    public Matrix() {
        this.values = new int[2][2];
    }

    static Matrix copyOf(Matrix matrix) {
        Matrix result = new Matrix();
        for (int i = 0; i < 4; i++) {
            result.values[i / 2][i % 2] = matrix.values[i / 2][i % 2];
        }
        return result;
    }

    public void setInit() {
        values[0][0] = values[0][1] = values[1][0] = 1;
        values[1][1] = 0;
    }

    public void multiply(Matrix other) {
        Matrix result = new Matrix();
        long temp;
        for (int i = 0; i < 4; i++) {
            temp = ((long) values[i / 2][0] * other.values[0][i % 2]) % mod;
            temp += (long) values[i / 2][1] * other.values[1][i % 2];
            result.values[i / 2][i % 2] = (int) (temp % mod);
        }
        for (int i = 0; i < 4; i++) {
            this.values[i / 2][i % 2] = result.values[i / 2][i % 2];
        }
    }
}

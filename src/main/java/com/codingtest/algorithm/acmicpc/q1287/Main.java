package com.codingtest.algorithm.acmicpc.q1287;

import java.io.*;
import java.math.BigInteger;
import java.util.Stack;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> operator = new Stack<>();
        Stack<BigInteger> nums = new Stack<>();
        int len = input.length();

        for (int i = 0; i < len; i++) {

            BigInteger temp = BigInteger.ZERO;
            boolean isDigit = false;
            while (i< len && Character.isDigit(input.charAt(i))) {
                temp = temp.multiply(BigInteger.TEN);
                temp = temp.add(BigInteger.valueOf(input.charAt(i)-'0'));
                i++;
                isDigit = true;
            }
            if(isDigit)
                nums.add(temp);

            if(i < len) {
                char c = input.charAt(i);
                if (c == ')') {
                    while (!operator.isEmpty() && operator.peek() != '(') {
                        if (!calc(nums, operator.pop())) {
                            return;
                        }
                    }
                    if (operator.isEmpty() || operator.peek() != '(') {
                        bw.write("ROCK");
                        bw.flush();
                        return;
                    }
                    operator.pop();
                } else if (c == '(') {
                    operator.push(c);
                } else {
                    while (!operator.isEmpty() && getPrio(operator.peek()) >= getPrio(c)) {
                        if (getPrio(operator.peek()) == -1 || getPrio(c) == -1) {
                            bw.write("ROCK");
                            bw.flush();
                            return;
                        }

                        if (!calc(nums, operator.pop())) {
                            return;
                        }
                    }
                    operator.add(c);
                }
            }
        }
        
        while (!operator.isEmpty()) {
            if (!calc(nums, operator.pop())) {
                return;
            }
        }
        if(nums.size() != 1){
            bw.write("ROCK\n");
            bw.flush();
        }else {
            bw.write(nums.pop().toString() + "\n");
            bw.flush();
        }
    }

    private static boolean calc(Stack<BigInteger> nums, char op) throws IOException {
        if (nums.size() < 2) {
            bw.write("ROCK");
            bw.flush();
            return false;
        }
        BigInteger p1 = nums.pop();
        BigInteger p2 = nums.pop();

        if (p1.equals(BigInteger.ZERO)) {
            bw.write("ROCK");
            bw.flush();
            return false;
        }

        if (op == '+')
            nums.push(p2.add(p1));
        else if (op == '-')
            nums.push(p2.subtract(p1));
        else if (op == '*')
            nums.push(p2.multiply(p1));
        else if (op == '/')
            nums.push(p2.divide(p1));
        else {
            bw.write("ROCK");
            bw.flush();
            return false;
        }
        return true;
    }

    private static int getPrio(int ch) {
        if (ch == '(') return 0;
        else if (ch == '*' || ch == '/') return 2;
        else if (ch == '+' || ch == '-') return 1;
        else return -1;
    }
}

package com.codingtest.algorithm.acmicpc.q2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int solution(String string) {
        int ans = 0;
        int val = 1;
        boolean flag = false;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {
            stack.push(string.charAt(i));

            if (stack.peek() == '(') {
                flag = true;
                val *= 2;
            } else if (stack.peek() == '[') {
                flag = true;
                val *= 3;
            } else {
                Character close = stack.pop();
                if (stack.isEmpty())
                    return 0;
                Character open = stack.pop();

                if ((open == '(' && close == ')') || (open == '[' && close == ']')) {
                    if (flag)
                        ans += val;
                    val /= (close == ')' ? 2 : 3);
                    flag = false;
                } else {
                    return 0;
                }
            }
        }

        return stack.isEmpty() ? ans : 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Main main = new Main();
        System.out.println(main.solution(sc.nextLine()));
    }
}

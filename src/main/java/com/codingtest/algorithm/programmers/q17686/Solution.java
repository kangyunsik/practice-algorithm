package com.codingtest.algorithm.programmers.q17686;

import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        int len = files.length;
        Name[] names = new Name[len];
        for (int i = 0; i < len; i++) {
            names[i] = new Name(i, files[i]);
        }
        Arrays.sort(names, (n1, n2) -> {
            int com1 = n1.head.toLowerCase().compareTo(n2.head.toLowerCase());
            int com2 = Integer.parseInt(n1.number) - Integer.parseInt(n2.number);
            return com1 == 0 ? (com2 == 0 ? n1.index - n2.index : com2) : com1;
        });
        return Arrays.stream(names).map(n -> n.origin).toArray(String[]::new);
    }

    static class Name {
        int index;
        String origin;
        String head;
        String number;
        String tail;

        public Name(int index, String string) {
            this.origin = string;
            this.index = index;
            int len = string.length();
            int begin = -1;
            int end = len;
            for (int i = 0; i < len; i++) {
                char c = string.charAt(i);
                if (Character.isDigit(c)) {
                    if (begin == -1)
                        begin = i;
                } else if (begin != -1) {
                    end = i;
                    break;
                }
            }
            this.head = string.substring(0, begin);
            this.number = string.substring(begin, end);
            this.tail = string.substring(end);
        }
    }
}
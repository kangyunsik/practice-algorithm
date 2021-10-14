package com.codingtest.algorithm.programmers.q42577;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingLong(s1 -> -s1.length()));
        HashSet<String> notAllow = new HashSet<>();

        for (String phoneNumber : phone_book) {
            if(notAllow.contains(phoneNumber))
                return false;

            for (int i = 0; i < phoneNumber.length(); i++) {
                notAllow.add(phoneNumber.substring(0,i+1));
            }
        }

        return true;
    }
}
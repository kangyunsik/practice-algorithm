package com.codingtest.algorithm.codility.lessons.lesson2.oddoccurrencesinarray;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if(set.contains(A[i]))
                set.remove(A[i]);
            else
                set.add(A[i]);
        }

        return set.iterator().next();
    }
}

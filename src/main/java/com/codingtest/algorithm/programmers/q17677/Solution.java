package com.codingtest.algorithm.programmers.q17677;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int solution(String str1, String str2) {
        List<String> con1 = getSubStrings(str1);
        List<String> con2 = getSubStrings(str2);
        Collections.sort(con1);
        Collections.sort(con2);
        int dup = getDuplicate(con1, con2);
        int size_sum = con1.size() + con2.size();
        if(size_sum - dup == 0) return 65536;
        return (65536 * dup) / (size_sum - dup);
    }

    private List<String> getSubStrings(String str){
        List<String> result = new ArrayList<>();
        for (int i = 0; i < str.length()-1; i++) {
            char a = str.charAt(i);
            char b = str.charAt(i+1);
            if(Character.isAlphabetic(a) && Character.isAlphabetic(b)){
                result.add(Character.toUpperCase(a)+""+Character.toUpperCase(b));
            }
        }
        return result;
    }

    private int getDuplicate(List<String> l1, List<String> l2){
        int i = 0;
        int j = 0;
        int ls1 = l1.size();
        int ls2 = l2.size();
        int result = 0;
        while(i < ls1 && j < ls2){
            if(l1.get(i).equals(l2.get(j))){
                result++;
                i++;
                j++;
            }else if(l1.get(i).compareTo(l2.get(j)) < 0){
                i++;
            }else{
                j++;
            }
        }
        return result;
    }
}

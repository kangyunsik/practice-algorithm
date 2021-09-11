package com.codingtest.algorithm.kakao.q2;

import java.util.*;

public class Solution {
    List<Integer> list;
    boolean[] check;
    final int n = 10000000;

    public int solution(int n, int k) {
        ArrayList<Integer> l = toList(n,k);
        initEratos();
        String s = myToString(l);
        int ans = 0;

        System.out.println("s = " + s);
        lb : for (String s1 : parse(s)) {
            System.out.println("s1 = " + s1);
            if (Long.parseLong(s1) < 10000000L && this.list.contains(Integer.parseInt(s1))) {
                System.out.println("plus");
                ans++;
            }else if(Long.parseLong(s1) >= 10000000L){
                for (int i = 2; i*(long)i < Long.parseLong(s1); i++) {
                    if(Long.parseLong(s1)%i == 0){
                        continue lb;
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    private ArrayList<String> parse(String s) {
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();

        s = s+"0";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0'){
                if(sb.toString().length() != 0) {
                    String temp = sb.toString();
                    list.add(temp);
                }
                sb = new StringBuilder();
            }else {
                sb.append(s.charAt(i));
            }
        }

        return list;
    }

    public void initEratos() {
        list = new ArrayList<>();
        check = new boolean[n+1];
        check[0] = true;
        check[1] = true;

        for (int i = 2; i*i <= n; i++) {
            if(!check[i]) {
                for (int j = i*i; j <= n; j+=i) {
                    check[j] = true;
                }
            }
        }

        for (int i = 2; i < n; i++) {
            if(!check[i])
                list.add(i);
        }
    }

    public String myToString(ArrayList<Integer> list){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i) + "");
        }
        return sb.toString();
    }

    public ArrayList<Integer> toList(int n, int k){
        Stack<Integer> s = new Stack<>();
        while(n > 0){
            s.push(n%k);
            n/=k;
        }
        ArrayList<Integer> integers = new ArrayList<>();
        while(!s.isEmpty()){
            integers.add(s.pop());
        }
        return integers;
    }
}

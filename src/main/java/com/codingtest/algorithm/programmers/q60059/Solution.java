package com.codingtest.algorithm.programmers.q60059;

class Solution {
    int[][][] keySet;
    public boolean solution(int[][] key, int[][] lock) {
        makeKetSet(key,lock.length);
        for (int i = 0; i < 4; i++) {
            if(isValid(keySet[i],lock))
                return true;
        }

        return false;
    }

    private boolean isValid(int[][] key, int[][] lock) {
        for (int i = 0; i < key.length-lock.length; i++) {
            lb : for (int j = 0; j < key.length- lock.length; j++) {
                for (int k = 0; k < lock.length; k++) {
                    for (int l = 0; l < lock.length; l++) {
                        if(lock[k][l] == key[i+k][j+l]){
                            continue lb;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void makeKetSet(int[][] key,int lock_len) {
        int key_len = key.length;
        keySet = new int[4][key_len + lock_len * 2 - 1][key_len + lock_len * 2 - 1];
        keySet[0] = padding(key,lock_len-1);
        for (int i = 1; i < 4; i++) {
            keySet[i] = padding(rotate(keySet[i-1]), lock_len-1);
        }
    }

    private int[][] padding(int[][] array, int ps){
        int[][] result = new int[array.length+ps*2][array.length+ps*2];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result[ps+i][ps+j] = array[i][j];
            }
        }
        return result;
    }

    private int[][] rotate(int[][] array){
        int[][] result = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                result[i][j] = array[array.length-j-1][i];
            }
        }
        return result;
    }
}
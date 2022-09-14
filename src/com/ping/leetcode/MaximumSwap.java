package com.ping.leetcode;

/**
 * You are given an integer num. You can swap two digits at most once to get the
 * maximum valued number.
 * 
 * Return the maximum valued number you can get.
 * 
 * Example 1:
 * 
 * Input: num = 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * 
 * Input: num = 9973
 * Output: 9973
 * Explanation: No swap.
 */
public class MaximumSwap {
    public int maximumSwap(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int maxNum = 0;
        int len = charArray.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (charArray[i] < charArray[j]) {
                    swap(charArray, i, j);
                    maxNum = Math.max(maxNum, Integer.parseInt(new String(charArray)));
                    swap(charArray, i, j);
                }
            }
        }
        return maxNum;
    }

    public int maximumSwap1(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int n = charArray.length;
        int maxIndex = n - 1;
        int i = -1, j = -1;
        for (int x = n - 1; x >= 0; x--) {
            if (charArray[x] > charArray[maxIndex]) {
                maxIndex = x;
            } else if (charArray[x] < charArray[maxIndex]) {
                i = x;
                j = maxIndex;
            }
        }
        if (i >= 0) {
            swap(charArray, i, j);
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }

    public void swap(char[] charArray, int i, int j) {
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
    }
}

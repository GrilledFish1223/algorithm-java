package com.ping.leetcode.Longest_Substring_Without_Repeating_Characters_0003;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 *
 * 解体思路：
 * 通过模拟队列， 从前往后循环的时候找到第一次出现重复的字符，重复字符前面的就是一个子串
 * 子串的其实位置需要不断维护
 */


class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return  0;
        }
        int maxSub = 0;
        int left = 0;
        Map<Character,Integer> m = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (m.containsKey(c)) {
                left = Math.max(left, m.get(c) + 1);
            }
            m.put(c, i);
            maxSub = Math.max(maxSub, i-left+1);

        }
        return maxSub;
    }
}
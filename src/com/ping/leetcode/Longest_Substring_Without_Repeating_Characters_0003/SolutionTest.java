package com.ping.leetcode.Longest_Substring_Without_Repeating_Characters_0003;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


class SolutionTest {

    @Test
    public void test() {
        Solution s = new Solution();
        assertEquals(1, s.lengthOfLongestSubstring("1"));
        assertEquals(1, s.lengthOfLongestSubstring("aaaaa"));
        assertEquals(3, s.lengthOfLongestSubstring("abcabcbb"));
    }

}
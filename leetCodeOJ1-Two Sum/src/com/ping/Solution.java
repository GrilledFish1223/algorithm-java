package com.ping;

import java.util.*;

/**
 * 题目：
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class Solution {
    public static void main(String[] args) {
//        int tartget = 26;
//        int[] nums = {2, 7, 11, 15};
//        int[] result = twoSum1(nums, tartget);
//        for (int i = 0; i < result.length; i++) {
//            System.out.print(result[i] + "\t");
//        }
        System.out.println(reverse1(-1230));

    }

    public static int[] twoSum(int[] nums, int tartget) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == tartget) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }

    public static int[] twoSum1(int[] nums, int tartget) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(tartget - nums[i]);
            if (index == null) {
                map.put(nums[i], i);
            } else {
                return new int[]{i, index};
            }
        }
        return new int[0];
    }

    public static int reverse(int x) {
        String str = String.valueOf(x);
        char[] ch = str.toCharArray();
        boolean flag = false;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < ch.length; i++) {
            String s = "" + ch[i];
            if ("-".equals(s)) {
                flag = true;
            } else {
                list.add(s);
            }
        }
        Collections.reverse(list);
        if (flag) {
            sb.append("-");
        }

        for (String r : list) {
            sb.append(r);
        }
        return Integer.parseInt(sb.toString());
    }

    public static int reverse1(int x) {
        int re = 0;
        if (x > Integer.MAX_VALUE/10 || x < Integer.MIN_VALUE/10) {
            return 0;
        }
        while (x != 0) {
            re = re * 10 + x % 10;
            x /= 10;
        }
        return re;
    }
}

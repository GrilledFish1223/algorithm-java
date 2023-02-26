package com.ping.hw;

import java.util.*;

public class One {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();

        HashSet<String> set = new HashSet<>();
        for (char ch :
                s2.toCharArray()) {
            set.add(ch + "");
        }
        int count = set.size();

        String disturb = "0123456789abcdef";
        List<String> validList = new ArrayList<>();
        int idx = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (disturb.contains(s1.charAt(i) + "")) {
                validList.add(s1.substring(idx, i));
                idx = i + 1;
            } else {
                if (i == s1.length() - 1) {
                    validList.add(s1.substring(idx));
                }
            }
        }

        String ans = "";
        for (String cur : validList) {
            if (cur.length() > 0) {
                HashSet<String> curSet = new HashSet<>();
                for (int j = 0; j < cur.length(); j++) {
                    curSet.add(cur.charAt(j) + "");
                }

                int curLen = curSet.size();
                if (curLen <= count) {
                    HashSet<String> ansSet = new HashSet<>();
                    for (int j = 0; j < ans.length(); j++) {
                        ansSet.add(ans.charAt(j) + "");
                    }
                    int ansLen = ansSet.size();

                    if (curLen > ansLen) {
                        ans = cur;
                    } else if (curLen == ansLen) {
                        if (cur.compareTo(ans) > 0) {
                            ans = cur;
                        }
                    }
                }
            }
        }
        ans = ans.length() > 0 ? ans : "Not Found";
        System.out.println(ans);
    }

}

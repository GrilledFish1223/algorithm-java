package com.ping.hw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Three {
    public static int  min_times = Integer.MAX_VALUE;
    public static  int countY;
    public static  int countL;


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(in.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        int m = nums.get(0);
        int n = nums.get(1);
        int x = nums.get(2);

        countY = m;
        countL = n;

        transport(m, n,x, 0);
        if (m+n <= x) {
            System.out.println(1);
        } else if (min_times == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(min_times);
        }

    }

    private static void transport(int m, int n, int x, int times) {
        if (x >= m + n) {
           min_times = Math.min(min_times, times);
        } else {
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if (i + j == 0 || (i+j > x)) {
                        continue;
                    }
                    if (m - i != 0 &&m-i<n-j){
                      continue;
                    }
                    if (countY-(m-i)!= 0 && (countY-(m-i)) < (countL-(n-1))) {
                        continue;
                    }
                    transport(m-i,n-j,x,times+1);
                }
            }
        }
    }
}

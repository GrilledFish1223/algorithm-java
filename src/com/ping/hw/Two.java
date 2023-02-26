package com.ping.hw;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Two {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(in.nextLine().split(" ")).
                map(Integer::parseInt).
                collect(Collectors.toList());

        int m = nums.get(0);
        int n = nums.get(1);
        int c = nums.get(2);
        int k = nums.get(2);

        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] num_strs = in.nextLine().split(" ");
            for (int j = 0;j<m;j++) {
                matrix[i][j] = Integer.parseInt(num_strs[j]);
            }
        }
        System.out.println(get_area(matrix, k, c));
    }

    private static int get_area(int[][] mat, int threshold, int c) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] s = new int[n+1][m+1];
        for (int i = 1; i <=n; ++i) {
            for (int j = 1; j <= m; ++j) {
                s[i][j] = s[i-1][j] + s[i][j-1] -s[i-1][j-1] + mat[i-1][j-1];
            }
        }
        int ans = 0;
        for (int i = c; i <= n; ++i) {
            for (int j = c;j<= m;++j) {
                if (s[i][j] - s[i-c][j] -s[i][j-c] + s[i-c][j-c] >= threshold) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}

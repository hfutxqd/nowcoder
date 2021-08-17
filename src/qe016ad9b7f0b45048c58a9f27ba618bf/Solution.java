package qe016ad9b7f0b45048c58a9f27ba618bf;

import java.util.Arrays;

public class Solution {

    public int findKth(int[] a, int start, int end, int K) {
        // write code here
        int little = start;
        int large = end;
        while (little < large) {

            while (a[little] <= a[end] && little < large) {
                little++;
            }
            while (a[large] >= a[end] && little < large) {
                large--;
            }
            if (little < large) {
                int tmp = a[little];
                a[little] = a[large];
                a[large] = tmp;
            }
        }

        int tmp = a[little];
        a[little] = a[end];
        a[end] = tmp;
        if (little == K) {
            return a[little];
        } else if (K < little) {
            return findKth(a, start, little - 1, K);
        } else {
            return findKth(a, little + 1, end, K);
        }
    }

    public int findKth(int[] a, int n, int K) {
        return findKth(a, 0, n - 1, n - K);
    }

    public static void main(String[] args) {
        int[] a = new int[] {1332802,1177178,1514891,871248,753214,123866,1615405,328656,1540395,968891,1884022,252932,1034406,1455178,821713,486232,860175,1896237,852300,566715,1285209,1845742,883142,259266,520911,1844960,218188,1528217,332380,261485,1111670,16920,1249664,1199799,1959818,1546744,1904944,51047,1176397,190970,48715,349690,673887,1648782,1010556,1165786,937247,986578,798663};
        System.out.println(new Solution().findKth(a, a.length, 24));
    }
}

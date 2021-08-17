package q89865d4375634fc484f3a24b7fe65665;

import java.util.Arrays;

public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int[] tmp = new int[m + n];
        int index = 0;
        for (int i = 0, j = 0;;) {
            if (i >= m && j >= n) {
                break;
            } else if (i >= m && j < n) {
                tmp[index] = B[j];
                index++;
                j++;
                continue;
            } else if ( i < m && j >= n) {
                tmp[index] = A[i];
                index++;
                i++;
                continue;
            }

            if (A[i] < B[j]) {
                tmp[index] = A[i];
                index++;
                i++;
            } else {
                tmp[index] = B[j];
                index++;
                j++;
            }

        }
        for (int i = 0; i < A.length; i++) {
            A[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        int[] A =  new int[] {1,2,3,0,0,0};
        new Solution().merge(A, 3, new int[] {2,5,6}, 3);
        System.out.println(Arrays.toString(A));

    }
}

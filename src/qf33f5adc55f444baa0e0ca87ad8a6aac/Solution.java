package qf33f5adc55f444baa0e0ca87ad8a6aac;

// 最长公共子串
public class Solution {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        String s = str1.length() < str2.length() ? str1 : str2; // 短串
        String b = str1.length() >= str2.length() ? str1 : str2; // 长串
        int maxLength = 0;
        int pos = 0;
        for (int l = 0, r = l; r < s.length();) {  // 滑动窗口，初始l=0,r=0
            int tmp = b.indexOf(s.substring(l, r + 1)); // 在 长串 中寻找 当前窗口子串
            if (tmp >= 0) { // 找到了
                if (r - l + 1 > maxLength) { // 长度 大于 之前的最大长度
                    maxLength = r - l + 1;
                    pos = tmp;
                }
                r++; // 右窗口指针右移
            } else { // 没找到
                l++; // 左窗口指针右移
            }
            if (r >= s.length()) { // 右窗口指针大于短串的最大长度
                break;
            }
        }
        return b.substring(pos, pos + maxLength);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LCS("2LQ74WK8Ld0x7d8FP8l61pD7Wsz1E9xOMp920hM948eGjL9Kb5KJt80","U08U29zzuodz16CBZ8xfpmmn5SKD80smJbK83F2T37JRqYfE76vh6hrE451uFQ100ye9hog1Y52LDk0L52SuD948eGjLz0htzd5YF9J1Y6oI7562z4T2"));
    }
}
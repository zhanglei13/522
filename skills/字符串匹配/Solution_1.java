package string;

/**
 * 字符串匹配算法
 * 暴力求解BF算法，时间复杂度O(m*n)
 */

public class Solution_1 {
    public int strStr(String haystack, String needle) {
        int i = 0, j = 0;

        while (i < haystack.length() && j < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        return j == needle.length() ? i - j : -1;
    }
}
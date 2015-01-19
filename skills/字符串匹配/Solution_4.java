package string;

/**
 * 字符串匹配算法
 * BM算法，时间复杂度O(n)
 */

public class Solution_4 {
    // ASCII表中的256个字符
    private final static int ASIZE = 256;

    public int strStr(String haystack, String needle) {
        return needle.length() == 0 ? 0 : bmSearch(haystack, needle);
    }

    private int bmSearch(String haystack, String needle) {
        int i, j = 0;
        int bmBc[] = preBmBc(needle);
        int bmGs[] = preBmGs(needle);

        while (j <= haystack.length() - needle.length()) {
            for (i = needle.length() - 1; i >= 0 && haystack.charAt(i + j) == needle.charAt(i); i--) ;
            if (i < 0)
                return j;
            else
                j += Math.max(bmGs[i], bmBc[haystack.charAt(i + j)] - needle.length() + 1 + i);
        }

        return -1;
    }

    // 构建坏字符表
    private int[] preBmBc(String needle) {
        int[] bmBc = new int[ASIZE];
        int length = needle.length();

        for (int i = 0; i < ASIZE; i++)
            bmBc[i] = length;

        for (int i = 0; i < length; i++)
            bmBc[needle.charAt(i)] = length - 1 - i;

        return bmBc;
    }

    private int[] preBmGs(String needle) {
        int length = needle.length();
        int[] bmGs = new int[length];
        int[] suffix = computeSuffix(needle);

        for (int i = 0; i < length; i++)
            bmGs[i] = length;

        for (int i = length - 1; i >= 0; i--)
            if (suffix[i] == i + 1)
                for (int j = 0; j < length - 1 - i; j++)
                    if (bmGs[j] == length)
                        bmGs[j] = length - 1 - i;

        for (int i = 0; i <= length - 2; i++)
            bmGs[length - 1 - suffix[i]] = length - 1 - i;

        return bmGs;
    }

    public int[] computeSuffix(String needle) {
        int length = needle.length();
        int[] suffix = new int[length];
        int i, j = length - 1, k = 0;
        suffix[length - 1] = length;

        for (i = length - 2; i >= 0; i--) {
            if (i > j && suffix[length - 1 + i - k] < i - j)
                suffix[i] = suffix[length - 1 + i - k];
            else {
                j = Math.min(i, j);
                k = i;
                while (j >= 0 && needle.charAt(j) == needle.charAt(length - 1 + j - k))
                    j--;
                suffix[i] = k - j;
            }
        }

        return suffix;
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        int s1 = haystack.length();
        int s2 = needle.length();
        for (int i = 0; i <= (s1 - s2); i++) {
            int j = 0;
            while (j < s2 && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == s2) {
                return i;
            }
        }
        return -1;
    }
}
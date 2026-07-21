class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int n = s.length();

        int ones = 0;
        for (char c : s.toCharArray())
            if (c == '1')
                ones++;

        String t = "1" + s + "1";
        int m = t.length();

        int ans = ones;

        int i = 1;

        while (i< m-1) {

            int leftZero = 0;
            while (i < m - 1 && t.charAt(i) == '0') {
                leftZero++;
                i++;
            }

            int oneStart = i;

            while (i < m - 1 && t.charAt(i) == '1')
                i++;

            int oneEnd = i - 1;

            if (oneStart <= oneEnd &&
                oneStart > 0 &&
                oneEnd < m - 1 &&
                t.charAt(oneStart - 1) == '0' &&
                t.charAt(oneEnd + 1) == '0') {

                int rightZero = 0;
                int j = i;

                while (j < m - 1 && t.charAt(j) == '0') {
                    rightZero++;
                    j++;
                }

                ans = Math.max(ans, ones + leftZero + rightZero);
            }
        }

        return ans;
    }
}
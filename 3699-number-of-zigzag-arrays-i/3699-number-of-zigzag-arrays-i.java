class Solution {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m + 2];
        long[] down = new long[m + 2];

        // Length = 2
        for (int v = 1; v <= m; v++) {
            up[v] = v - 1L;      // previous value is smaller
            down[v] = m - v;     // previous value is larger
        }

        for (int len = 3; len <= n; len++) {
            long[] prefDown = new long[m + 2];
            long[] sufUp = new long[m + 3];

            for (int v = 1; v <= m; v++) {
                prefDown[v] = (prefDown[v - 1] + down[v]) % MOD;
            }

            for (int v = m; v >= 1; v--) {
                sufUp[v] = (sufUp[v + 1] + up[v]) % MOD;
            }

            long[] newUp = new long[m + 2];
            long[] newDown = new long[m + 2];

            for (int v = 1; v <= m; v++) {
                // Last comparison becomes UP, so previous must be DOWN
                newUp[v] = prefDown[v - 1];

                // Last comparison becomes DOWN, so previous must be UP
                newDown[v] = sufUp[v + 1];
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int v = 1; v <= m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
            return (int) ans;
        }

        for (int v = 1; v <= m; v++) {
            ans = (ans + up[v] + down[v]) % MOD;
        }

        return (int) ans;
    }
}
import java.util.*;

class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long) x, map.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (long start : map.keySet()) {
            if (start == 1L) continue;

            long cur = start;
            int len = 0;

            while (true) {
                int cnt = map.getOrDefault(cur, 0);

                if (cnt >= 2) {
                    len += 2;

                    // Prevent overflow
                    if (cur > 1000000000L / cur) {
                        len--;      // use one as center
                        break;
                    }

                    long next = cur * cur;

                    // If next doesn't exist, current becomes the center
                    if (!map.containsKey(next)) {
                        len--;      // remove one copy to make center
                        break;
                    }

                    cur = next;
                } else if (cnt == 1) {
                    len++;          // current is the center
                    break;
                } else {
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}
// Hashmap se hi hoga
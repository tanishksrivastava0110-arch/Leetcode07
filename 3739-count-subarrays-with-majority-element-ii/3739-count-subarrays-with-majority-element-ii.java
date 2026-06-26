class Solution {

    class Fenwick {
        int[] bit;
        int n;

        Fenwick(int n) {
            this.n = n;
            bit = new int[n + 1];
        }

        void update(int i, int val) {
            while (i <= n) {
                bit[i] += val;
                i += i & -i;
            }
        }

        int query(int i) {
            int sum = 0;
            while (i > 0) {
                sum += bit[i];
                i -= i & -i;
            }
            return sum;
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;

        Fenwick ft = new Fenwick(2 * n + 1);

        int prefix = n + 1;      // shifted prefix sum
        ft.update(prefix, 1);

        long ans = 0;

        for (int x : nums) {
            if (x == target)
                prefix++;
            else
                prefix--;

            ans += ft.query(prefix - 1);
            ft.update(prefix, 1);
        }

        return ans;
    }
}
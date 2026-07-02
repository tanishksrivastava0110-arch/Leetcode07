class Solution {
    public int minimumOperations(int[] nums) {
        int op = 0;
        for (int num : nums) {
            int rem = num % 3;
            op += Math.min(rem, 3 - rem);
        }

        return op;
    }
}
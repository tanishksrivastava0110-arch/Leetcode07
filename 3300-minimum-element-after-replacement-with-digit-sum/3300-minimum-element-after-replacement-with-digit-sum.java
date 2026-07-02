class Solution {
    public int minElement(int[] nums) {
        int min=nums[0];
        for(int i=0;i<nums.length;i++){
            nums[i]=SumOf(nums[i]);
            if(nums[i]<min){
                min=nums[i];
            }
        }
        return min;
    }
    public int SumOf(int n){
        int sum=0;
        while(n>0){
            sum = sum+(n%10);
            n=n/10;
        }
        return sum;
    }
}
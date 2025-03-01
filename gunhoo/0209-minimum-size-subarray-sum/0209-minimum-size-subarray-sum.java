class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0, j=0, sum=0, min=Integer.MAX_VALUE;
        while(j<nums.length){
            sum += nums[j++];
            while(sum >= target){
                min = Math.min(j-i, min);
                sum -= nums[i++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
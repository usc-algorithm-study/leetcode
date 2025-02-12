class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) return new int[]{-1,-1};
        if(nums.length == 1) return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        int n = nums.length;
        int[] ans = {0, n-1};

        while(ans[0]<ans[1]){
            if(nums[ans[0]] < target){
                ans[0] += 1;
            }
            if(nums[ans[1]] > target){
                ans[1] -= 1;
            }
            if(nums[ans[0]] == nums[ans[1]] && nums[ans[1]] == target){
                return ans;
            }
        }
        return new int[]{-1,-1};
    }
}
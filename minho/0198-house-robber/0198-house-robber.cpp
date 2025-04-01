class Solution {
public:
    int rob(vector<int>& nums) {
        
        if (nums.size() == 1) return nums[0];
        nums[1] = max(nums[0], nums[1]);

        for (int i = 2; i < nums.size(); i++) {
            int rob = nums[i] + nums[i-2], notrob = nums[i-1];
            nums[i] = max(rob, notrob);
        }

        return nums[nums.size()-1];
        
    }
};
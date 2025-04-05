class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        vector<int> dp (n, 1);
        for (int i=0;i<n;i++) {
            int maxLen = 0;
            for (int j=i-1;j>=0;j--) {
                if (nums[i] > nums[j]) maxLen = max(maxLen, dp[j]);
            }
            dp[i] = maxLen + 1;
            
        }

        int res = 0;
        for (int i = 0; i<n;i++) {
            res = max(res, dp[i]);
        }
        return res;
    }
};
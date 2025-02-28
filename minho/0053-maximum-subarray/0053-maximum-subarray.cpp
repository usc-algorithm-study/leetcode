class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int cur_sum = 0;
        int max_sum = INT_MIN;
        for (int n : nums) {
            cur_sum += n;
            if (cur_sum <= n) {
                cur_sum = n;
            };
            max_sum = max(max_sum, cur_sum);
        };

        return max_sum;

    }
};
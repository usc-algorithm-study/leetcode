class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<int> current;
        vector<vector<int>> res;
        vector<bool> used(nums.size(), false);
        dfs(0, nums, used, current, res);
        return res;
    }
    void dfs(int idx, vector<int>&nums, vector<bool>& used, vector<int>& current, vector<vector<int>>& res) {
        if (current.size() == nums.size()) {
            res.push_back(current);
            return;
        }

        for (int i=0; i < nums.size(); i++) {
            if (used[i]) continue;
            used[i] = true;
            current.push_back(nums[i]);
            dfs(i+1, nums, used, current, res);
            used[i] = false;
            current.pop_back();
        }
    }
};
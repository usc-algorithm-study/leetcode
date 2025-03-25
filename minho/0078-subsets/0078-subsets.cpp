class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> curr_list;
        dfs(0, nums, curr_list, res);
        return res;
    }

    void dfs(int idx, vector<int>& nums, vector<int>& curr_list, vector<vector<int>>& res) {

        res.push_back(curr_list);
        for (int i = idx; i < nums.size(); i++) {
            curr_list.push_back(nums[i]);
            dfs(i+1, nums, curr_list, res);
            curr_list.pop_back();
        }
    }
};
class Solution {
public:
    bool wordBreak(string s, vector<string>& wordDict) {
        unordered_set<string> wordSet;

        vector<bool> dp(s.size()+1, false);
        dp[0] = true;

        for (int i=0; i<=s.size(); i++) {
            for (int j=0;j<i;j++) {
                if (dp[j] && wordSet.find(s.substr(j, i-j)) != wordSet.end()) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.size()];
    }
};
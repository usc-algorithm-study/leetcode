class Solution {
public:
    int coinChange(vector<int>& coins, int amount) {

        vector<int> min_list(amount + 1, INT_MAX);
        min_list[0] = 0;

        for(int i=0;i < amount + 1; ++i) {
            for (int coin : coins) {
                if (i - coin >= 0 && min_list[i - coin] != INT_MAX) {
                    min_list[i] = min(min_list[i], min_list[i-coin]+1);
                }
            }
        }

        if (min_list[amount] == INT_MAX) {
            return -1;
        }
        return min_list[amount];
    }
};
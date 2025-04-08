class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int m = matrix.size(), n = matrix[0].size(), count = 0;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (matrix[i][j] == '1') count++;
            }
        }

        if (count == 0) return 0;

        int d = int(sqrt(count));
        vector<vector<int>> dp(m, vector<int>(n,0));
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                dp[i][j] = (matrix[i][j] == '1') ? 1 : 0;;
            }
        }

        int res = 1;
        for (int i=1;i<m;i++) {
            for (int j=1;j<n;j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = 1 + min(dp[i-1][j], min(dp[i][j-1], dp[i-1][j-1]));
                    res = max(res, dp[i][j]);
                }
            }
        }

        return res * res;
    }
};
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        int top = 0;
        int bottom = matrix.size() - 1;
        int left = 0;
        int right = matrix[0].size() - 1;
        vector<int> res;

        while (top <= bottom && left <= right) {
            // Move left to right
            for (int i = left; i <= right; ++i)
                res.push_back(matrix[top][i]);
            top++;

            // Move top to bottom
            for (int i = top; i <= bottom; ++i)
                res.push_back(matrix[i][right]);
            right--;

            // Move right to left
            if (top <= bottom) {
                for (int i = right; i >= left; --i)
                    res.push_back(matrix[bottom][i]);
                bottom--;
            }

            // Move bottom to top
            if (left <= right) {
                for (int i = bottom; i >= top; --i)
                    res.push_back(matrix[i][left]);
                left++;
            }
        }

        return res;
    }
};

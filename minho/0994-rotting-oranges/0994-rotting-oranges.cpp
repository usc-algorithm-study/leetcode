class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size(), t = 0;
        vector<pair<int, int>> dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        queue<pair<int, int>> q;

        for (int i=0; i < m; ++i) {
            for (int j=0; j < n; ++j) {
                if (grid[i][j] == 2) {
                    q.push({i,j});
                }                    
            }
        }

        while (!q.empty()) {
            int size = q.size();
            bool found = false;

            for (int i = 0; i < size; ++i) {
                auto[sr, sc] = q.front();
                q.pop();

                for (auto [dr, dc] : dirs) {
                    int nr = sr + dr, nc = sc + dc;
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n || grid[nr][nc] != 1) {
                        continue;
                    }

                    grid[nr][nc] = 2;
                    q.push({nr, nc});
                    found = true;
                }
            }

            if (found) {
                ++t;
            }
        }

        // Check if any fresh oranges remain
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return t;
    }
};
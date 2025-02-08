#include <vector>
#include <string>

class Solution {
public:
    int m, n, t;
    std::vector<std::pair<int, int>> dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

    bool find(std::vector<std::vector<char>>& board, int sr, int sc, int target, const std::string& word) {
        // Base case: If character doesn't match, return false
        if (board[sr][sc] != word[target]) {
            return false;
        }

        // If we reach the last character and it's a match, return true
        if (target == t - 1) {
            return true;
        }

        // Temporarily mark the cell as visited
        char temp = board[sr][sc];
        board[sr][sc] = '#';  // Mark visited

        // Explore all 4 directions
        for (auto [dx, dy] : dirs) {
            int nr = sr + dx, nc = sc + dy;

            // Check boundaries and if cell is not visited
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] != '#') {
                if (find(board, nr, nc, target + 1, word)) {
                    return true;
                }
            }
        }

        // Restore the cell after backtracking
        board[sr][sc] = temp;
        return false;
    }

    bool exist(std::vector<std::vector<char>>& board, std::string word) {
        m = board.size();
        n = board[0].size();
        t = word.size();

        // Try to start DFS from every cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (find(board, i, j, 0, word)) {
                    return true;
                }
            }
        }

        return false;
    }
};

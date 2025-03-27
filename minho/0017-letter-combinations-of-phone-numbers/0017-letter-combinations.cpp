class Solution {
public:
    vector<string> letterCombinations(string digits) {
        
        unordered_map<char, vector<char>> digitMap = {
            {'2', {'a','b','c'}},
            {'3', {'d','e','f'}},
            {'4', {'g','h','i'}},
            {'5', {'j','k','l'}},
            {'6', {'m','n','o'}},
            {'7', {'p','q','r','s'}},
            {'8', {'t','u','v'}},
            {'9', {'w','x','y','z'}}
        };

        string curr_str;
        vector<string> res;
        if (digits.size() == 0) return res;
        dfs(0, digits, curr_str, res, digitMap);
     return res;   
    }
    void dfs(int idx, string& digits, string& curr_str, vector<string>& res, unordered_map<char, vector<char>>& digitMap) {
        if (curr_str.size() == digits.size()) {
            res.push_back(curr_str);
            return;
        }
        
        char digit = digits[idx];
        vector<char> letters = digitMap[digit];
        for (int i=0; i < letters.size(); i++) {
            string string_next = curr_str+letters[i];
            dfs(idx+1, digits, string_next, res, digitMap);
        }
    }
};

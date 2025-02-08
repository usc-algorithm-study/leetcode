class Solution {
    public:
    int ladderLength(string beginWord, string endWord, vector<string>& wordList) {
        unordered_set<string> wordSet(wordList.begin(), wordList.end());
        if (wordSet.find(endWord) == wordSet.end()) return 0;

        unordered_set<string> frontSet, backSet;
        frontSet.insert(beginWord);
        backSet.insert(endWord);
        int steps = 1;

        while (!frontSet.empty() && !backSet.empty()) {
            if (frontSet.size() > backSet.size())
                swap(frontSet, backSet); // Always expand the smaller set first

            unordered_set<string> nextSet;
            for (string word : frontSet) {
                for (int i = 0; i < word.size(); i++) {
                    char originalChar = word[i];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        word[i] = c;

                        if (backSet.find(word) != backSet.end()) return steps + 1;
                        if (wordSet.find(word) != wordSet.end()) {
                            nextSet.insert(word);
                            wordSet.erase(word);
                        }
                    }
                    word[i] = originalChar;
                }
            }
            frontSet = nextSet;
            steps++;
        }
        return 0;
    }
}
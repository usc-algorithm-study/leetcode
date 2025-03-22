struct Node {
    string word;
    unordered_map<string, Node*> nodeMap;
    bool isWord = false;

    Node() : word("") {}
    Node(string w) : word(w) {}
};

class Trie {
    Node* dummy = new Node();
private:
    void dfs(int idx, string word, Node* node) {
        if (idx == word.size()) {
            node->isWord = true;
            return;
        }

        string curr = word.substr(0, idx+1);
        if (node->nodeMap.find(curr) == node->nodeMap.end()) {
            node->nodeMap[curr] = new Node(curr);
        }
        dfs(idx+1, word, node->nodeMap[curr]);
        return;
    }

public:
    Trie() {        
    }
    
    void insert(string word) {
        dfs(0, word, dummy);
    }
    
    bool search(string word) {
        int idx = 0;
        Node* tail = dummy;
        while (idx < word.size()) {
            string curr = word.substr(0, idx+1);
            if (tail->nodeMap.find(curr) == tail->nodeMap.end()) {
                return false;
            }
            tail = tail->nodeMap[curr];
            idx++;
        }
        return tail->isWord;
    }
    
    bool startsWith(string prefix) {
        int idx = 0;
        Node* tail = dummy;
        while (idx < prefix.size()) {
            string curr = prefix.substr(0, idx+1);
            if (tail->nodeMap.find(curr) == tail->nodeMap.end()) {
                return false;
            }
            tail = tail->nodeMap[curr];
            idx++;
        }
        return true;
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */
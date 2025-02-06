class DSU {
public:
    unordered_map<string, string> parent;  // Parent mapping

    string find(string x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // Path compression
        }
        return parent[x];
    }

    void unionSet(string x, string y) {
        string rootX = find(x);
        string rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;  // Merge trees
        }
    }
};

vector<vector<string>> accountsMerge(vector<vector<string>>& accounts) {
    DSU dsu;
    unordered_map<string, string> emailToName;  // Mapping of email -> name

    // Step 1: Initialize DSU and map emails to accounts
    for (auto& account : accounts) {
        string name = account[0];
        string firstEmail = account[1];

        if (dsu.parent.find(firstEmail) == dsu.parent.end()) {
            dsu.parent[firstEmail] = firstEmail;  // Initialize parent
        }

        for (int i = 1; i < account.size(); i++) {
            string email = account[i];

            if (dsu.parent.find(email) == dsu.parent.end()) {
                dsu.parent[email] = email;  // Initialize new email
            }

            dsu.unionSet(firstEmail, email);  // Merge emails
            emailToName[email] = name;  // Store name
        }
    }

    // Step 2: Group emails by their root parent
    unordered_map<string, unordered_set<string>> mergedAccounts;
    for (auto& entry : emailToName) {
        string email = entry.first;
        string root = dsu.find(email);
        mergedAccounts[root].insert(email);
    }

    // Step 3: Sort and prepare the output
    vector<vector<string>> result;
    for (auto& entry : mergedAccounts) {
        string rootEmail = entry.first;
        vector<string> emails(entry.second.begin(), entry.second.end());
        sort(emails.begin(), emails.end());  // Sort emails lexicographically
        emails.insert(emails.begin(), emailToName[rootEmail]);  // Add name
        result.push_back(emails);
    }

    return result;
}

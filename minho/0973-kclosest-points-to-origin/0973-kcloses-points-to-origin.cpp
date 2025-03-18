class Solution {

public:
    vector<vector<int>> kClosest(vector<vector<int>>& points, int k) {
        vector<vector<int>> result(k);
        priority_queue<vector<int>> pq;

        for (auto& point : points) {
            pq.push({(point[0]*point[0]+point[1]*point[1]), point[0], point[1]});
            
            if (pq.size() > k) {
                pq.pop();
            }
        }

        for (int i = 0; i < k; ++i) {
            vector<int> top = pq.top();
            pq.pop();
            result[i] = {top[1], top[2]};
        }

        return result;
    }
};
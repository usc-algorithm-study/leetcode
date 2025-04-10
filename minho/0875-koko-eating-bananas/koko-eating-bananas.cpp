class Solution {
public:
    int minEatingSpeed(vector<int>& piles, int h) {
        int n = piles.size();

        long long l = 1;
        long long r = 0;
        for (auto pile : piles) {
            r = max(r, static_cast<long long>(pile));
        }
        int res = 0;
        while (l <= r) {
            long long m = l + (r-l)/2;
            long long cnt = 0;
            for (int i=0;i<n;i++) {
                cnt += (piles[i] + m - 1) / m;
            }
            if (cnt <= h) {
                res = m;
                r = m-1;
            } else {
                l = m+1;
            }
        }
        return res;

    }
};
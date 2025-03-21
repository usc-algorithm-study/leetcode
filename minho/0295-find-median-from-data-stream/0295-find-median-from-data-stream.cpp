class MedianFinder {
public:
    int minSize = 0, maxSize = 0;
    priority_queue<int> maxH;
    priority_queue<int, std::vector<int>, std::greater<int>> minH;

    MedianFinder() {
    }
    
    void addNum(int num) {
        if (maxH.empty() || num <= maxH.top()) {
            maxH.push(num);
        } else {
            minH.push(num);
        }

        // balance the heaps
        if (maxH.size() > minH.size() + 1) {
            minH.push(maxH.top());
            maxH.pop();
        }
        if (minH.size() > maxH.size()) {
            maxH.push(minH.top());
            minH.pop();
        }
    }
    
    double findMedian() {
        if (minH.size() < maxH.size()) return maxH.top(); 
        else return (minH.top() + maxH.top()) / 2.0;
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
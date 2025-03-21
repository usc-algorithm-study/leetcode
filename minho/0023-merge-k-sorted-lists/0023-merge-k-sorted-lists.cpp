/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

struct Compare {
    bool operator()(ListNode* a, ListNode* b) {
        return a->val > b->val; // min-heap: smaller val comes first
    }
};

class Solution {
public:
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        priority_queue<ListNode*, vector<ListNode*>, Compare> minHeap;

        for (auto& list : lists) {
            if (list) {
                minHeap.push(list);
            }
        }

        ListNode* dummy = new ListNode();
        ListNode* tail = dummy; 
        while (!minHeap.empty()) {
            ListNode* nextNode = minHeap.top();
            minHeap.pop();
            tail->next = nextNode;
            tail = tail->next;

            if (nextNode->next) {
                minHeap.push(nextNode->next);
            }
        }
        return dummy->next;
    }
};
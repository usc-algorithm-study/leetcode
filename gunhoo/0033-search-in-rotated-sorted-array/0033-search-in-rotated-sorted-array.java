class Solution {
    public int search(int[] nums, int target) {
        if(nums[0] == target) return 0;

        int n = nums.length;
        int answer = 0;

        if(nums[0] > nums[n-1]){ // rotated
            int k = 0, min = nums[0];
            for(int i=0; i<n; i++){
                if(min > nums[i]){
                    k = i-1;
                    break;
                }
            }
            if(nums[0] > target){
                answer = binarySearch(nums, k+1, n-1, target);
            } else {
                answer = binarySearch(nums, 0, k, target);
            }
        } else { // ascending order > binary search
            answer = binarySearch(nums, 0, n-1, target);
        }
        return answer;
    }

    private int binarySearch(int[] nums, int l, int r, int target){
        int m = (l+r)/2;
        if(nums[m] == target) return m;
        if(nums[r] == target) return r;
        if(nums[l] == target) return l;

        if(m == l && nums[r] != target) return -1;
        
        if(nums[m] < target){
            return binarySearch(nums, m+1, r, target);
        } else {
            return binarySearch(nums, l, m-1, target);
        }
    }
}
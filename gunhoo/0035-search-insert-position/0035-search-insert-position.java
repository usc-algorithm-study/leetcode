class Solution {
    public int searchInsert(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length-1);
    }

    private int binarySearch(int[] nums, int target, int l, int r){
        int m = (int)((l+r)/2);
        if(m == l) {
            if(nums[r] < target) return r+1;
            if(nums[m] < target) return m+1;
            return m;
        }
        if(target > nums[m]) return binarySearch(nums, target, m+1, r);
        return binarySearch(nums, target, l, m);
    }
}
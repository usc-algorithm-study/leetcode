class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;
        int max = -1;
        while(l<r){
            int minHeight = Math.min(height[l], height[r]);
            int cap = (r-l) * minHeight;
            max = Math.max(max, cap);
            while(l<r && height[r] <= minHeight) r--;
            while(l<r && height[l] <= minHeight) l++;
        }
        return max;
    }
}
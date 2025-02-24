class Solution {
    private List<List<Integer>> subsetList = new ArrayList<>();
    private int n;

    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        backtrack(nums, new ArrayList<Integer>(), 0);
        return subsetList;
    }

    private void backtrack(int[] nums, ArrayList<Integer> curr, int pointer){
        subsetList.add(new ArrayList(curr));
        for(int i=pointer; i<n; ++i){
            curr.add(nums[i]);
            backtrack(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
}
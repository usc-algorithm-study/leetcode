class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return answer;
    }

    private void backtrack(int[] nums, ArrayList<Integer> list){
        if(list.size() == nums.length) {
            answer.add(new ArrayList<>(list));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(list.contains(nums[i])) continue;
            list.add(nums[i]);
            backtrack(nums, list);
            list.remove(list.size()-1);
        }
    }
}
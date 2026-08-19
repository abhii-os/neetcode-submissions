class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        findCombinations(0,nums,target,result,ds);
        return result;
    }
    private void findCombinations(int index, int[]nums, int target, List<List<Integer>> result, List<Integer> ds){
        if(index == nums.length){
            if(target==0){
                result.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index]<=target){
            ds.add(nums[index]);
            findCombinations(index,nums,target-nums[index],result,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(index+1,nums,target,result,ds);
    }
}

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums,0,result,ds);
        return result;
    }

    private void backtrack(int[]nums, int index, List<List<Integer>> result, List<Integer> ds){
        result.add(new ArrayList<>(ds));

        for(int i=index; i<nums.length; i++){
            if(i>index&& nums[i]==nums[i-1]){
                continue;
            }

            ds.add(nums[i]);
            backtrack(nums,i+1,result,ds);
            ds.remove(ds.size()-1);
        }

    }

}

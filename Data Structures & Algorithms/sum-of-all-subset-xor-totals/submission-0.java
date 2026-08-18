class Solution {
    public int subsetXORSum(int[] nums) {
        return totalSum(nums,0,0);
    }
    private int totalSum (int[]nums, int index, int currentXOR){
        if(index==nums.length){
            return currentXOR;
        }
        int include = totalSum(nums,index+1,currentXOR ^ nums[index]);

        int exclude = totalSum(nums,index+1,currentXOR);

        return include + exclude;
    }
}
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        if(sum%k!=0 || nums.length==0)return false;
        int target = sum/k;
        Arrays.sort(nums);
        reverse(nums);
        if(nums[0]>target)return false;
        int [] subsets = new int[k];
        return backtrack(nums,0,subsets,target);
    
    }
    private boolean backtrack(int[]nums, int index, int[] subsets, int target){
        if(index==nums.length){
            return true;
        }
        int curr = nums[index];

        for(int i=0; i<subsets.length;i++){
            if(subsets[i]+curr<=target){
                subsets[i]+=curr;

                if(backtrack(nums,index+1,subsets,target)) return true;
                
                subsets[i]-= curr;
            }
            
        }
        return false;
    }
    private void reverse(int[]nums){
        int left = 0, right = nums.length-1;
        while(left<right){
            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
            left++;
            right--;
        }
    }
}
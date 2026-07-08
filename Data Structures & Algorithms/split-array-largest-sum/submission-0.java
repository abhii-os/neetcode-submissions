class Solution {
    public int splitArray(int[] nums, int k) {
       int low = 0;
       int high = 0;

       for(int i:nums){
        low = Math.max(low,i);
        high += i;
       }
       int ans = high;

       while(low<=high){
       int mid = low + (high-low)/2;

        if(canSplit(nums,k,mid)){
            ans = mid;
            high = mid-1;
        }
        else{
            low = mid+1;
        }
       }
       return ans;
    }

    public boolean canSplit(int[] nums, int k, int maxLimit){
        int subArrayCount = 1;
        int currentSum = 0;

        for(int num:nums){
            if(currentSum + num > maxLimit){
                subArrayCount++;
                currentSum = num;

                if(subArrayCount>k){
                    return false;
                }
                }
                else{
                    currentSum += num;
                }
            }
           return true;
        }
    }

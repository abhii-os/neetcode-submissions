class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0;
        int high = 0;
         
        for(int weight:weights){
            low = Math.max(low, weight);
            high += weight;
        }

        int result = high;

        while(low<=high){
            int mid = low +(high-low)/2;
            if (canShip(weights, mid, days)){
                result = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
    return result;
    }

    public boolean canShip(int[] weights, int capacity ,int days){
        int daysNeeded = 1;
        int currentWeight = 0;

        for(int w : weights){
            if(currentWeight + w>capacity){
                daysNeeded++;
                currentWeight = 0;
            }
            currentWeight += w;
        }
        return daysNeeded <= days;
    }

}
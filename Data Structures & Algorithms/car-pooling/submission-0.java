class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] change = new int[1001];

        for(int[] trip:trips){
            int numPassengers = trip[0];
            int from = trip[1];
            int to = trip[2];
        
        change[from] += numPassengers;
        change[to] -= numPassengers;
        }

        int currentPassengers = 0;
        for(int i=0; i<change.length;i++ ){
            currentPassengers += change[i];

            if(currentPassengers>capacity){
                return false;
            }
        }
        return true; 
    }

}
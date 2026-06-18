class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n==0) return 0;


        double[][]cars = new double[n][2];
        for(int i=0; i<n; i++){
            cars[i][0]=position[i];
            cars[i][1] = (double) (target-position[i])/speed[i];
        }
        Arrays.sort(cars,(a,b)->Double.compare(a[0],b[0]));

        int fleetCount = 0;
        double fleetTime = 0;

        for(int i = n-1; i >= 0;i-- ){
            if(cars[i][1]>fleetTime){
                fleetCount++;
                fleetTime = cars[i][1];
            }
        }
        return fleetCount;
    }
}

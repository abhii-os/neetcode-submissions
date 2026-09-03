class Solution {
    public boolean makesquare(int[] matchsticks) {
        if(matchsticks==null||matchsticks.length==0){
            return false;
        }
        int sum = 0;
        for(int i : matchsticks){
            sum += i;
        }
        if(sum%4!=0) return false;
        int target = sum/4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        if(matchsticks[0]>target) return false;
        int[] sides = new int[4];
        return backtrack(0,sides,target,matchsticks);
    }
    private boolean backtrack(int index, int[] sides,int target, int[] matchsticks){
        if(index==matchsticks.length){
            return sides[0]==target&& sides[1]==target && sides[2]==target && sides[3]==target ;
        }
        int current = matchsticks[index];
        for(int i =0;i<4;i++){
            if(sides[i]+current<=target){
                sides[i] += matchsticks[index];
                if(backtrack(index+1,sides,target,matchsticks)){
                    return true;
                }
                sides[i]-= current;
            }
            if(sides[i]==0){
                break;
            }
        }
        return false;
    }
    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
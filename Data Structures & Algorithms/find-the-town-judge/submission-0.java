class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] score = new int[n+1];

        for(int[] i : trust){
            int a = i[0];
            int b = i[1];

            score[a]--;
            score[b]++;
        }
        for(int i=0;i<=n;i++){
            if(score[i]==n-1){
                return i;
            }
        }
        return -1;
    }
}
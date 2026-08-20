class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
          List<Integer> ds = new ArrayList<>();
          boolean [] visit = new boolean[nums.length];
          backtrack(nums,visit,result,ds);
          return result; 
    }


    private void backtrack(int[] nums, boolean[] visit, List<List<Integer>> result, List<Integer> ds){
        if(ds.size()==nums.length){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i=0; i< nums.length;i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            ds.add(nums[i]);
            backtrack(nums,visit,result,ds);
            ds.remove(ds.size()-1);
            visit[i]=false;
        }
    }
}
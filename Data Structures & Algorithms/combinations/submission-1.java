class Solution {
    public List<List<Integer>> combine(int n, int k) {
         List<List<Integer>> result = new ArrayList<>();
          List<Integer> ds = new ArrayList<>();
          backtrack(n,1,k,result,ds);
          return result;
    }
    private void backtrack(int n, int start, int k, List<List<Integer>> result, List<Integer> ds){
        if(ds.size()==k){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i=start; i<= n-(k-ds.size())+1;i++){
            ds.add(i);
            backtrack(n,i+1,k,result,ds);
            ds.remove(ds.size()-1);
        }
    }
}
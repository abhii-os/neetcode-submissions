class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        findCombinations(0,target,candidates,result,ds);
        return result;
    }
    private void findCombinations(int index, int target, int[] arr, List<List<Integer>> result, List<Integer>ds){
        if(target==0){
            result.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index; i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            ds.add(arr[i]);
            findCombinations(i+1,target-arr[i],arr,result,ds);
            ds.remove(ds.size()-1);
        }
    }
}

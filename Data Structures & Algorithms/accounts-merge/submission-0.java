class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DSU dsu = new DSU(n);

        Map<String,Integer> emailToAc = new HashMap<>();

        for(int i=0;i<n;i++){
            List<String> account = accounts.get(i);

            for(int j=1; j<account.size();j++){
                String email = account.get(j);

                if(!emailToAc.containsKey(email)){
                    emailToAc.put(email,i);
                }
                else{
                    int previousAccount = emailToAc.get(email);
                    dsu.union(i,previousAccount);
                }
            }
        }

        Map<Integer, TreeSet<String>> leaderToEmails = new HashMap<>();
        for(String email : emailToAc.keySet()){
            int originalAcc = emailToAc.get(email);
            int ultimateLeader = dsu.find(originalAcc);

            leaderToEmails.putIfAbsent(ultimateLeader, new TreeSet<>());
            leaderToEmails.get(ultimateLeader).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for(int leaderAcc : leaderToEmails.keySet()){
            List<String> mergedAccount = new ArrayList<>();

            String ownerName = accounts.get(leaderAcc).get(0);

            mergedAccount.add(ownerName);

            mergedAccount.addAll(leaderToEmails.get(leaderAcc));
            
            result.add(mergedAccount);

        }
        return result;

    }
}
class DSU{
    private int[] parent;
    public DSU(int size){
        parent = new int[size];
        for(int i=0;i<size;i++){
            parent[i] = i;
        }
    }
    public int find(int i){
        if(parent[i]==i){
            return i;
        }
        return parent[i] = find(parent[i]);
    }

    public void union(int x, int y){
        int leaderX = find(x);
        int leaderY = find(y);
        if(leaderX!=leaderY) parent[leaderX] = leaderY;
    }
}
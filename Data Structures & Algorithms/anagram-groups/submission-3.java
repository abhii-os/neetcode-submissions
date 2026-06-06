
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       if (strs == null || strs.length == 0) return new ArrayList<>();

       Map<String, List<String>> map = new HashMap<>();

       for(String s:strs){
        int [] count = new int[26];
        for(char c:s.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i:count){
            sb.append("$");
            sb.append(i);
        }
        String key = sb.toString();

        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(s);
       }
       return new ArrayList<>(map.values());
    }
}
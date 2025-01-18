class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            // freq arr creation
           int [] freqArr = new int[26];
           for(int j = 0; j < str.length(); j++){
                char ch = str.charAt(j);
                int idx = ch - 'a';
                freqArr[idx]++;
           }
           StringBuilder key = new StringBuilder();
           for(int j = 0; j < 26; j++){
                if(freqArr[j] != 0){
                    char ch = (char)(j + 'a');
                    key.append(ch + "" + freqArr[j]);
                }
           }
           String keyStr = key.toString();
           if(map.containsKey(keyStr)){
            ArrayList<String> anagrams = map.get(keyStr);
            anagrams.add(str);
           
           }else{
            ArrayList<String> nli = new ArrayList<>();
            nli.add(str);
            map.put(keyStr, nli);
           }
        }
        List<List<String>> ans = new ArrayList<>();


        for(String key: map.keySet()){
            List<String> anagrams = map.get(key);
            ans.add(anagrams);
        }

        return ans;
    }
}

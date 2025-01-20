class Solution {
    public String minWindow(String s, String t) {
        int minLength = Integer.MAX_VALUE;
        int st = -1;
        int en = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char ch = t.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0;
        int j = 0;
        int count = map.size();
        while(j < s.length()){
            char ch = s.charAt(j);
            if(map.containsKey(ch) == true){
                int freq = map.get(ch) - 1;
                map.put(ch, freq);
                if(freq == 0){
                    count--;
                }
            }
            while(count == 0){
                int len = j - i + 1;
                if(len < minLength){
                    minLength = len;
                    st = i;
                    en = j + 1;
                }
                char chi = s.charAt(i);
                if(map.containsKey(chi)){
                    int freq = map.get(chi) + 1;
                    map.put(chi, freq);
                    if(freq > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        if(minLength == Integer.MAX_VALUE){
            return "";
        }
        return s.substring(st, en);



    }
}
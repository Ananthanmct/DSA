class Solution {
    public int lengthOfLIS(int[] nums) {
        // Yeh jo nlogn approach hai yeh dp ki nahi rahi balki yeh greedy ki ban chuki hai 
        int ans = 0;
        int [] dp = new int[nums.length];
        for(int val: nums){
            // Hum jis bhi element ke liye outer loop mai aate hai... Tab us element ko dekhte hai yeh increasing 
            // sub sequence ka part ban sakta hai ki nahi 
            // Toh hum already apne dp wale array mai naa ek increasing sequence bana rahe honge but yeh isko yeh
            // mat smjhana yeh aapka increasing subsequence hai.. 
            // Hum val ko koshish karainge ki increasing sequence mai kha adjust kare ?
            // Isliye humne binary search lagaya or increasing sequnce mai jaha val place ho sakta hai vo location dhundi 
            // agr binary search ke lagane ke baad lo humara ans pe pahuch jaata hai iska matlab yeh val pure increasing sequence mai sabse bada hai
            // agr lo kahi middle mai aagaya toh hum usse bhi update kardaige ? Haan 
            // example -> [2, 3, 5, 1] yeh array hai -> [2,3,5]
            // val 5 tak increasing sequence sahi banega vo array ko increasing subsequence lg raha hai... but later on 1 aayega toh hum toh dp mai 
            // [1, 3, 5] bana dainge jo ek increasing subsequnce nahi hai
            // but kya hi fark pad jaata hai update karne se pehle jo aapne increasing sequnce banaya tha or iska length same hi 
            // Binary seqrch se hume yeh faida ho raha hai jitne elementy increasing sequence mai aa rahe hai hum unhe apne ans array mai bhi increasing sequence rakh paa rahe hai 
            // agr koi chotta element aata hai toh usse peeche kisi bade se update kardete hai kya hi fark update karne se sequnece length same hi rahi 
            int i = 0;
            int j = ans;
            while(i < j){
                int mid = i + (j - i)/2;
                if(dp[mid] < val){
                   i = mid + 1;
                }else{
                    j = mid;
                }
            }
            dp[i] = val;
            if(i == ans){
                ans++;
            }
        }
        return ans;
        
    }
}

//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.findPages(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



//Back-end complete function Template for Java

class Solution {
    
    public static boolean allocatePages(int [] arr, int k, int maxAllowedPages){
        int sum = 0;
        int currStudent = 1;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxAllowedPages){
                return false;
            }
            if(sum + arr[i] <= maxAllowedPages){
                
                sum += arr[i];
            }else{
                //System.out.print(sum + " ");
                currStudent++;
                sum = arr[i];
            }
        }
        
        
        return currStudent <= k;
    }
    
    public static int findPages(int[] arr, int k) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
        }
        int lo = 0;
        int hi = sum;
        int ans = Integer.MAX_VALUE;
        
        if(k > arr.length){
            return -1;
        }
        
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            //System.out.println(mid);// At max how many pages i can allocate 
            if(allocatePages(arr, k, mid) == true){
                //System.out.println("Success");
                ans = Math.min(ans, mid);
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }
        }
        if(ans == Integer.MAX_VALUE){
            return -1;
        }
        return ans;
    }
}
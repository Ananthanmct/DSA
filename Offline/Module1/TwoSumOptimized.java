import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    
    public static int[] twoSum(int[] A, int x) {
       // Your code here

       int i = 0;
       int j = A.length - 1;

       while(i < j){
        int val1 = A[i];
        int val2 = A[j];
        int sum = val1 + val2;
        if(sum < x){
          i++;
        }else if(sum > x){
          j--;
        }else{
          int [] ans = {i +1, j + 1};
          return ans;
        }
       }

       

       return new int[1];
    }
	
    public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
	}
}




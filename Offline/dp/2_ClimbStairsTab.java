import java.util.*;
import static java.lang.Math.ceil;





public class Main {
    public int ClimbingStairs(int n, int [] dp) {
       dp[0] = 1;
       dp[1] = 1;
       for(int i = 2; i < dp.length; i++){
         dp[i] = dp[i - 1] + dp[i-2];
       }
       return dp[n];
   }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = ClimbingStairs(n, new int[n + 1]);
        return res;
    }
}

import java.util.*;
import static java.lang.Math.ceil;





public class Main {
        public int ClimbingStairs(int n, int [] dp) {
        if(n == 0){
            return 1;
        }
        if(dp[n] != 0){
            return dp[n];
        }
        int w1 = ClimbingStairs(n - 1, dp);
        int w2 = ClimbingStairs(n - 2, dp);
        dp[n] = w1 + w2;
        return w1 + w2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = ClimbingStairs(n, new int[n + 1]);
        return res;
    }
}

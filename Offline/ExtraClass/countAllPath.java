import java.util.*;

public class countAllPath {
    static int [][]  dir = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static boolean [][] isVisited;
    
    static int countAllPath(int i, int j, int n, int m)
    {
        if(i == n && j == m){
            return 1;
        }
        if(i > n || j > m || i < 1 || j <1 ){
            return 0;
        }
        if(isVisited[i][j] == true){
            return 0;
        }
        //System.out.println(i + " " + j);
       isVisited[i][j] = true;
       int count = 0;
       for(int d = 0; d < dir.length; d++){
        int nr = i + dir[d][0];
        int nc = j + dir[d][1];
        
        count += countAllPath(nr, nc, n, m);
       }
       isVisited[i][j] = false;
       return count;
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int m= sc.nextInt();
        isVisited = new boolean[n + 1][m + 1];
        System.out.println(countAllPath(1, 1, n,m));
    }
}
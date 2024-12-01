import java.util.*;
import java.io.*;
public class Main {
    public static void aMazePaths(int dr, int dc, String psf,int sr , int sc){
       //Write your code here
       if(sr > dr || sc > dc){
        return;
       }
      if(sr == dr && sc == dc){
        System.out.println(psf);
        return;
      }

      aMazePaths(dr, dc, psf + "h", sr, sc + 1);
      aMazePaths(dr, dc, psf + "v", sr + 1, sc);
		
    }
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputLine;
        inputLine = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inputLine[0]);
        inputLine = br.readLine().trim().split(" ");
        int m = Integer.parseInt(inputLine[0]);
        aMazePaths(n, m, "",1,1);
  }
}

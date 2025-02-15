import java.io.*;
import java.util.*;

public class Main {
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
        
        if(sr == dr && sc == dc){
            System.out.println(psf);
            return;
        }
        int hJumps = dc - sc;
        for(int j = 1; j <= hJumps; j++){
            printMazePaths(sr, sc + j, dr, dc, psf + "h" + j);
        }

        int vJumps = dr - sr;
        for(int j = 1; j <= vJumps; j++){
            printMazePaths(sr + j, sc, dr, dc, psf + "v" + j);
        }

        int dJumps = Math.min(vJumps, hJumps);
        for(int j = 1; j <= dJumps; j++){
            printMazePaths(sr + j, sc + j, dr, dc,  psf + "d" + j);
        }




       
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        printMazePaths(0, 0, n - 1, m - 1, "");
    }
}
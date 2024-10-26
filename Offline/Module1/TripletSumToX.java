import java.io.*;
import java.util.*;
public class Main {
	public static int triplets(ArrayList<Integer> arr, int X) {
		int count  = 0;
		int prevVal1 = Integer.MIN_VALUE;
		for(int i  = 0; i < arr.size() - 2; i++){
			int val1 = arr.get(i);
			if(val1 == prevVal1){
				continue;
			}
			prevVal1 = val1;
			int nTar = X - val1;
			int st = i + 1;
			int en = arr.size() - 1;
			int prevSt = Integer.MIN_VALUE;
			int prevEn = Integer.MAX_VALUE;
			while(st < en){
				int currSt = arr.get(st);
				int currEn = arr.get(en);
				int sum = arr.get(st) + arr.get(en);
				if(sum < nTar){
					st++;
				}else if(sum > nTar){
					en--;
				}else{
					if(currSt == prevSt && currEn == prevEn){
						st++;
						en--;
						continue;
					}
					count++;
					prevSt = currSt;
					prevEn = currEn;
					st++;
					en--;
				}
			}
		}

		return count;
	  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t;
    t = sc.nextInt();
    while (t > 0) {
      int n, X;
      n = sc.nextInt();
      ArrayList<Integer> arr = new ArrayList<Integer>(n);
      for (int i = 0; i < n; i++) arr.add(sc.nextInt());
      X = sc.nextInt();
      int result = triplets(arr, X);
      System.out.println(result);
      t--;
    }
    sc.close();
  }

  
}

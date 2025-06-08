import java.io.*;
import java.util.*;

public class Main {

    public static int searchInsert(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length - 1;
        int 
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < arr[mid]){
                hi = mid - 1;
            }else if(key > arr[mid]){
                lo = mid + 1;
            }else{
                return mid;
            }
        }
        return lo;
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(searchInsert(A,B));
    }
}

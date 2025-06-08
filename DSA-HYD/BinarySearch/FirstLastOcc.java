import java.util.*;

public class Main {
    public static void findPosition(int arr[], int n,int key)
    {
        int lo = 0;
        int hi = arr.length - 1;
        int firstOcc = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < arr[mid]){
                hi = mid - 1;
            }else if(key > arr[mid]){
                lo = mid + 1;
            }else{
                firstOcc = mid;
                hi = mid - 1;
            }
        }



        lo = 0;
        hi = arr.length - 1;
        int lastOcc = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(key < arr[mid]){
                hi = mid - 1;
            }else if (key > arr[mid]){
                lo = mid + 1;
            }else{
                lastOcc = mid;
                lo = mid + 1;
            }
        }

        System.out.println(firstOcc + " " + lastOcc);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        findPosition(array,n,k);
    }
}

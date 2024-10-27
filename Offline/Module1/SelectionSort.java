import java.util.*;

public class Main {
    public static int[] SelectionSort(int[] arr) {
        
        int n = arr.length;
        for(int itr = 0; itr < n - 1; itr++){
            int st = itr;
            int en = n - 1;
            int minEle = Integer.MAX_VALUE;
            int minIdx = -1;
            for(int i = st; i <= en; i++){
                if(minEle > arr[i]){
                    minEle = arr[i];
                    minIdx = i;
                }
            }

            int temp = arr[st];
            arr[st] = arr[minIdx];
            arr[minIdx] = temp;
        }

        return arr;

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = SelectionSort(arr);

        for(int a : ans)
            System.out.print(a + " ");
    }
}

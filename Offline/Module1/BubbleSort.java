import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int arr[] = new int[N];

        // Input of array
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        // bubble sort in descending order
        bubbleSort(N, arr);
        // printing array elements
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void bubbleSort(int n, int[] arr) {
        // your code here


        for(int itr = 0; itr < arr.length - 1; itr++){
            int rightRange = n - itr - 1;

            for(int i = 0; i < rightRange; i++){
                int val1 = arr[i];
                int val2 = arr[i + 1];
                if(val1 > val2){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i + 1] = temp;
                }
            }

        }


    }
}

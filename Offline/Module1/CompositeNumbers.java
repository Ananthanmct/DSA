import java.util.*;

class Main
{

public static boolean isPrime(int num){
	for(int i = 2; i*i <= num; i++){
		if(num%i == 0){
			return false;
		}
	}
	return true;
}

static ArrayList<Integer> removeComposite(int arr[], int len)
{
	ArrayList<Integer> ans = new ArrayList<>();
	for(int i  = 0; i < arr.length; i++){
		int element = arr[i];
		boolean res = isPrime(element);
		if(res == true){
			ans.add(element);
		}
	}
	return ans;
}

public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
        arr[i] = sc.nextInt();
    }
	ArrayList<Integer> list = removeComposite(arr, n);
    for(int val : list) System.out.print(val+" ");

}
}

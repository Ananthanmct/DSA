import java.util.*;

// https://miro.com/app/board/uXjVLN8NmAA=/?share_link_id=270676025077

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<ArrayList<Integer>> triangle = pascalTriangle(n);
        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                System.out.print(triangle.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

	public static ArrayList<ArrayList<Integer>> pascalTriangle(int n) { // 1
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>(); // // [[1]]
            ArrayList<Integer> zerothLi = new ArrayList<>(); // [1]
            zerothLi.add(1); 
            ans.add(zerothLi);

            if(n == 1){
                return ans;
            }

            ArrayList<Integer> firstLi = new ArrayList<>(); // [1, 1]
            firstLi.add(1);
            firstLi.add(1);
            ans.add(firstLi);

            for(int row = 2; row < n; row++){ // row = 

                ArrayList<Integer> curr = new ArrayList<>(); // [1, 4, 6, 4, 1]
                curr.add(1);                                             // j
                ArrayList<Integer> prev = ans.get(row - 1); // [1, 3, 3, 1]

                for(int j = 0; j < prev.size() - 1; j++){ // j = 3
                    int val1 = prev.get(j); // 3
                    int val2 = prev.get(j + 1); // 1
                    int sum = val1 + val2; // 4
                    curr.add(sum); 
                }

                curr.add(1);

                ans.add(curr);

            }

            return ans;

    }
}

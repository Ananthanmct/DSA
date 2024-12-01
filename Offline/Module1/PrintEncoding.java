import java.util.*;

public class Main {
    public static void printEncodings(String str) {
        // Write your code here
		pE(str, "");
    }

    public static void pE(String input, String esf){
        if(input.length() == 0){
            System.out.println(esf);
            return;
        }
        char ch = input.charAt(0);
        if(ch == '0'){
            return;
        }
        String fD = input.substring(0, 1);
        String ros = input.substring(1);
        int fdInt = Integer.parseInt(fD);
        char eqChar = (char)((fdInt - 1) + 'a');
        pE(ros, esf + eqChar);
        if(input.length() >= 2){
            String twoChar = input.substring(0, 2);
            ros = input.substring(2);
            int twoCharInt = Integer.parseInt(twoChar);
            if(twoCharInt > 9 && twoCharInt <= 26){
                eqChar = (char)((twoCharInt - 1) + 'a');
                pE(ros,esf +  eqChar);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        printEncodings(str);
    }
}

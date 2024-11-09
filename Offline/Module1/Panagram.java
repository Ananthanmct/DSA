import java.util.*;
import java.io.*;

public class Main {
     public  static void isPangram(String s)
      {
		// for(int i = 0; i < s.length(); i++){
		// 	char ch = s.charAt(i);
		// 	if(ch >= 'A' && ch <= 'Z'){
		// 		char small = (char)(ch - 'A' + 'a');
		// 		s += small;
		// 	}else{
		// 		s += ch;
		// 	}
		// }

		s = s.toLowerCase();

		boolean [] history = new boolean[26];
		// 0 -> false 

		for(int i = 0; i < s.length(); i++){
			char ch = s.charAt(i);
			if(ch == ' '){

			}else{
				int idx = ch - 'a';
				history[idx] = true;
			}
		}

		boolean flag = true;
		for(int i = 0; i < history.length; i++){
			if(history[i] == false){
				flag = false;
				break;
			}
		}

		if(flag == true){
			System.out.println("pangram");
		}else{
			System.out.println("not pangram");
		}


    }
    public static void main(String args[]) {
   Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        isPangram(s);
        
    }
}

import java.io.*;
import java.util.*;
class MyStack
{
    LinkedList<Integer> mainQ = new LinkedList<>();
    LinkedList<Integer> helperQ = new LinkedList<>();
    void push(int a)
    {
       mainQ.addLast(a);
    }
    
    int pop()
    {
       if(mainQ.size() == 0){
        return -1;
       }
       while(mainQ.size() > 1){
        int val  = mainQ.removeFirst();
        helperQ.addLast(val);
       }
       int removedVal = mainQ.removeFirst();

       while(helperQ.size() != 0){
        mainQ.addLast(helperQ.removeFirst());
       }

       return removedVal;
    }	
}
public class Main {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);    
        Stack g = new Stack();			
        int q = sc.nextInt();
        MyStack st = new MyStack();
        while(q>0)
        {
            int QueryType = sc.nextInt();
            if(QueryType == 1){
                int a = sc.nextInt();
                    // call push function here
                    st.push(a);
            }
            else if(QueryType == 2){
                    // call pop function here
                    int val  = st.pop();
                    System.out.print(val + " ");
            }
            q--;
        }	


       
    }
}

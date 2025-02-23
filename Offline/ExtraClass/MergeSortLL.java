/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode getMid(ListNode head){
        ListNode fp = head;
        ListNode sp = head;
        while(fp.next != null && fp.next.next != null){
            fp = fp.next.next;
            sp = sp.next;
        }
        return sp;
    }
    public ListNode merge2SortedLL(ListNode h1, ListNode h2){
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        ListNode temp1 = h1;
        ListNode temp2 = h2;

        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
                temp = temp.next;
            }else{
                temp.next = temp2;
                temp2 = temp2.next;
                temp = temp.next;
            }
        }

        if(temp1 != null){
            temp.next = temp1;
        }
        if(temp2 != null){
            temp.next = temp2;
        }

        return dummyHead.next;
    }
    public ListNode mergeSort(ListNode head){
        if(head.next == null){
            return head;
        }
        // mid of the linkedList
        ListNode mid = getMid(head);
        ListNode h2 = mid.next;
        mid.next = null;
        ListNode h1 = mergeSort(head);
        h2 = mergeSort(h2);

        return merge2SortedLL(h1, h2);
    }
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        return mergeSort(head);
    }
}

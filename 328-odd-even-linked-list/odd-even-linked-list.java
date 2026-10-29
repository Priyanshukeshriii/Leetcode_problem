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
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return head;
        if (head.next == null) return head;
        if (head.next.next == null) return head;
        ListNode even = head.next;
        ListNode tempO = head;
        ListNode tempE = head.next;
        while(tempE.next != null && tempE.next.next != null){
            tempO.next = tempO.next.next;
            tempE.next = tempE.next.next;
            tempO = tempO.next;
            tempE = tempE.next;
        }
        if(tempO.next != null && tempO.next.next != null){
            tempO.next = tempO.next.next;
            tempO = tempO.next;
        }
        if(tempE.next != null &&tempE.next.next != null){
            tempE.next = tempE.next.next;
            tempE = tempE.next;

        }else if(tempE.next != null &&tempE.next.next == null){
            tempE.next = null;
        } 
        tempO.next = even;
        return head;
        
    }
}
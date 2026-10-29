/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int n1= 0, n2 =0;
        while(temp1 != null){
            n1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            n2++;
            temp2 = temp2.next;
        }
        int diff = Math.abs(n1-n2);
        if(n1 > n2){
            temp1 = headA;
            temp2 = headB;
        }else{
            temp1 = headB;
            temp2 = headA;
        }
        while (temp1 != temp2){
            if(diff <= 0){
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
            diff--;
        }
        return temp1;

        
    }
}
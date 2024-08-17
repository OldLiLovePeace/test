package cn.limy.test.leetcode.testSolution;

public class Solution203 {
    public static void main(String[] args) {
    }

    static class ListNode{

        ListNode(int val,ListNode node){
            this.val = val;
            this.next = node;
        }
         int val;
         ListNode next ;
    }

    static ListNode method(ListNode head,int val){
        ListNode dummy = new ListNode(-1,head);
        ListNode pre = dummy;
        ListNode cur = head;

        while(cur != null){
            if(cur.val == val){
                pre.next = cur.next;
            }else{
                pre=cur;
            }
            cur = cur.next;
        }

        return dummy.next;
    }
}

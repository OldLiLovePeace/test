package cn.limy.test.leetcode.testSolution;

public class Solution206 {
    public static void main(String[] args) {

    }

    static class ListNode{

        ListNode(int val, ListNode node){
            this.val = val;
            this.next = node;
        }
        int val;
        ListNode next ;
    }

    static void method(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        ListNode temp = null;

        while(cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
    }






}

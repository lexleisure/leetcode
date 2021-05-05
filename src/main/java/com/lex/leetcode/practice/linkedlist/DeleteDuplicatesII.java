package com.lex.leetcode.practice.linkedlist;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii/
 * 中等
 *
 * @author lifeng
 */
public class DeleteDuplicatesII {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            ListNode cur = this;
            StringBuilder sb = new StringBuilder();
            while (cur != null) {
                sb.append(cur.val).append(" ");
                cur = cur.next;
            }
            return sb.toString();
        }
    }

    public ListNode build(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        for (int n : nums) {
            cur.next = new ListNode(n);
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 升序的链表
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int v = cur.next.val;
                while (cur.next != null && cur.next.val == v) {
                    // 不断删除值为v的节点，知道节点值不再为v
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        {
            DeleteDuplicatesII solution = new DeleteDuplicatesII();
            ListNode head = solution.build(new int[]{
                    1, 2, 3, 3, 4, 4, 5
            });
            ListNode nh = solution.deleteDuplicates(head);
            // 1 2 5
            System.out.println(nh.toString());
        }

        {
            DeleteDuplicatesII solution = new DeleteDuplicatesII();
            ListNode head = solution.build(new int[]{
                    1, 1, 1
            });
            ListNode nh = solution.deleteDuplicates(head);
            // true
            System.out.println(nh == null);
        }

        {
            DeleteDuplicatesII solution = new DeleteDuplicatesII();
            ListNode head = solution.build(new int[]{
                    1, 1, 1, 2, 3
            });
            ListNode nh = solution.deleteDuplicates(head);
            // 2,3
            System.out.println(nh.toString());
        }
    }

}

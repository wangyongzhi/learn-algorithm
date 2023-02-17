package radishdata.top;

/**
 * 206. 反转链表
 * 递归反转整个链表
 * https://leetcode.cn/problems/reverse-linked-list/
 * @author wangyongzhi
 * @date 2023-02-17
 */
public class E206ReverseLinkedList {

    /**
     * 完全反转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //把后面的作为一个整体与head比较。当前head指向 这个整体，这个整体里面都已经反向。
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }


    ListNode successor = null; // 后驱节点

    /**
     * 反转前n个节点
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseListN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }

        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseListN(head.next, n - 1);
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }


    /**
     * 反转链表的一部分，m节点到n节点
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseListN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1,2,3,4,5,6);
        ListNode.print(listNode1);

        E206ReverseLinkedList list = new E206ReverseLinkedList();
        ListNode result1 = list.reverseList(listNode1);
        ListNode.print(result1);

        System.out.println("——————————————————————————————————");

        ListNode listNode2 = ListNode.build(1,2,3,4,5,6);
        ListNode.print(listNode2);

        ListNode result2 = list.reverseListN(listNode2,3);
        ListNode.print(result2);


        System.out.println("——————————————————————————————————");

        ListNode listNode3 = ListNode.build(1,2,3,4,5,6);
        ListNode.print(listNode3);

        ListNode result3 = list.reverseBetween(listNode3,2,4);
        ListNode.print(result3);



    }
}

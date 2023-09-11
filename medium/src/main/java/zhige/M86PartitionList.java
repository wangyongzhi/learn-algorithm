package zhige;

/**
 * 分隔链表：https://leetcode.cn/problems/partition-list/
 * @author wangyongzhi
 * @date 2023-02-16
 */
public class M86PartitionList {

    public ListNode partition(ListNode head, int x) {
        //相当于把一个链表分成两个，需要创建两个新的临时链表，然后在拼接在一起。

        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);

        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;

        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;

        //把小于x的放虚拟链表1，大于x的放虚拟链表2。注意要把每个指向next的去掉。
        while (p != null) {
            if (p.val >= x) {
                p2.next = p;
                p2 = p2.next;
            }else {
                p1.next = p;
                p1 = p1.next;
            }

            //需要把p的next断掉，不然dummy拼接的是整个链表，而不只是当前节点。
            //断掉的同时需要把p指向p.next
            ListNode temp = p.next;
            p.next = null;
            p = temp;

        }

        // 连接两个链表
        //把p1的末尾拼接上p2除了虚拟节点的部分
        p1.next = dummy2.next;

        //返回p1除了虚拟节点的整个部分。
        return dummy1.next;

    }



    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1,4,3,2,5,2);
        M86PartitionList list = new M86PartitionList();
        ListNode listNode = list.partition(listNode1, 3);

        ListNode.print(listNode);

    }
}

package radishdata.top;


/**
 * @author wangyongzhi
 * @date 2023-02-15
 */
public class E21MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 虚拟头结点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;

        while (p1 != null && p2 != null) {
            // 比较 p1 和 p2 两个指针
            // 将值较小的的节点接到 p 指针
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            // p 指针不断前进
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (p2 != null) {
            p.next = p2;
        }

        return dummy.next;

    }


    public static void main(String[] args) {
        ListNode listNode1 = ListNode.build(1, 2, 4);
        ListNode listNode2 = ListNode.build(1, 3, 4);
        E21MergeTwoLists twoLists = new E21MergeTwoLists();
        ListNode listNode = twoLists.mergeTwoLists(listNode1, listNode2);

        ListNode.print(listNode);



    }
}

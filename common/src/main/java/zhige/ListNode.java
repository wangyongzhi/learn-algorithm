package zhige;

/**
 * @author wangyongzhi
 * @date 2023-02-15
 */
public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    /**
     * 打印
     * @param head
     */
    public static void print(ListNode head) {
        if (head == null) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListNode p = head; p != null; p = p.next) {
            if (p.next == null) {
                //最后一个不需要打印逗号
                sb.append(p.val).append("]");
                continue;
            }
            sb.append(p.val).append(",");
        }

        String s = sb.toString();
        System.out.println(s);

    }



    /**
     * 初始化一个环形链表
     * @param arr
     * @return
     */
    public static ListNode buildCycle(Integer... arr) {

        if (arr.length == 0) {
            return null;
        }

        if (arr.length == 1) {
            return new ListNode(arr[0]);
        }

        ListNode head = new ListNode(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                insert(head, arr[i], true);
            }else {
                insert(head, arr[i]);
            }
        }


        return head;

    }



    /**
     * 初始化一个链表
     * @param arr
     * @return
     */
    public static ListNode build(Integer... arr) {

        if (arr.length == 0) {
            return null;
        }

        if (arr.length == 1) {
            return new ListNode(arr[0]);
        }

        ListNode head = new ListNode(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            insert(head, arr[i]);
        }


        return head;

    }


    /**
     * 添加链表元素
     *
     * @param head
     * @param t
     */
    public static void insert(ListNode head, int t, boolean hasCycle) {
        //找到当前最后一个结点
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        //创建新结点，保存元素t

        ListNode next = null;
        //如果有环，最后一个指向头结点的下一个节点。只适合我的工程使用，其他可能有错。
        if (hasCycle) {
            next = head;
            if (head.next != null && head.next.next != null) {
                next = head.next;
            }
        }

        ListNode now = new ListNode(t, next);
        //让当前最后一个结点指向新结点
        p.next = now;
    }

    /**
     * 添加链表元素
     * @param head
     * @param t
     */
    public static void insert(ListNode head, int t) {
        insert(head, t, false);
    }
}

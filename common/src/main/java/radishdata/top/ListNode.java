package radishdata.top;

/**
 * @author wangyongzhi
 * @date 2023-02-15
 */
public class ListNode {
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
     * @param head
     * @param t
     */
    public static void insert(ListNode head, int t) {
        //找到当前最后一个结点
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        //创建新结点，保存元素t
        ListNode now = new ListNode(t,null);
        //让当前最后一个结点指向新结点
        p.next = now;
    }
}

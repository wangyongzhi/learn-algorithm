package zhige;

/**
 * 双向链表
 * @author wangyongzhi
 * @date 2023-02-15
 */
public class Node {

    int key;
    int value;
    Node last;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }


    public Node(int value) {
        this.value = value;
    }





}

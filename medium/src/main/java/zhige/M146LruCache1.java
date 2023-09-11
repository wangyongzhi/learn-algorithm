package zhige;

import java.util.LinkedHashMap;

/**
 *
 * 146. LRU 缓存
 *
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * https://leetcode.cn/problems/lru-cache/
 *
 * @author wangyongzhi
 * @date 2023/9/8
 */
public class M146LruCache1 {

    /**
     * 由于需要让 put 和 get 方法的时间复杂度为 O(1)，只是链表，get复杂度不行，只是hash，但是hash表无序，
     * 所以结合一下，形成一种新的数据结构：哈希链表 LinkedHashMap。
     *
     * LRU 缓存算法的核心数据结构就是哈希链表，双向链表和哈希表的结合体。
     *
     * 利用Java自带的数据结构LinkedHashMap。
     */
    private LinkedHashMap<Integer, Integer> map;

    private int capacity;

    public M146LruCache1(int capacity) {
        this.map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        //判断是否存在，不存在返回-1
        if (!map.containsKey(key)) {
            return -1;
        }
        //存在的情况下，把值取出来，并且要把这个key移到队尾
        Integer value = map.get(key);
        moveNodeToTail(key);
        return value;

    }

    public void put(int key, int value) {
        //如果已经包含了这个key，需要先修改value，再把key放在队尾
        if (map.containsKey(key)) {
            map.put(key, value);
            moveNodeToTail(key);
            return;
        }

        //如果不包含这个key，新增一条数据，放在队尾。不过还要判断一下是否已经满了，如果满了，需要把最久未使用的删除。
        if (this.capacity == map.size()) {
            Integer oldestKey = map.keySet().iterator().next();
            map.remove(oldestKey);
        }

        map.put(key, value);
    }


    public void moveNodeToTail(int key) {
        Integer value = map.get(key);
        map.remove(key);
        map.put(key, value);
    }
}

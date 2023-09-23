package zhige;

import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 *
 * https://leetcode.cn/problems/all-paths-from-source-to-target/
 *
 * @author wangyongzhi
 * @date 2023/9/23
 */
public class M797AllPathsFromSourceToTarget {
    // 记录所有路径
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        traverse(graph, 0);
        return res;
    }

    private void traverse(int[][] graph, int s) {
        // 添加节点 s 到路径
        path.addLast(s);
        if (s == graph.length - 1) {
            res.add(new LinkedList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
            // path.removeLast();
            // return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }

        for (int v : graph[s]) {
            traverse(graph, v);
        }

        path.removeLast();
    }

}

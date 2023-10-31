package zhige;


/**
 * 200. 岛屿数量
 *
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * https://leetcode.cn/problems/number-of-islands/
 *
 * @see M200NumberOfIslands 岛屿数量
 * @see M695MaxAreaOfIsland 岛屿的最大面积
 *
 * @author wangyongzhi
 * @date 2023/9/23
 */
public class M200NumberOfIslands {

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    // 每发现一个岛屿，岛屿数量加一
                    res++;
                    // 然后使用 DFS 将岛屿淹了，淹了的目的是为了不走回头路。或者用一个visited数组也可以。
                    dfs(grid, i, j);
                }
            }
        }
        return res;

    }

    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }

        if (grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';

        dfs(grid, i + 1, j);
        dfs(grid, i -1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }


    public static void main(String[] args) {
        M200NumberOfIslands islands = new M200NumberOfIslands();
        char[][] grid = {{'1','1','0','0'},{'1','0','0','1'}};
        int res = islands.numIslands(grid);
        System.out.println(res);
    }
}

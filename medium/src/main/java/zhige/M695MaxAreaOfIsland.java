package zhige;


/**
 * 695. 岛屿的最大面积
 *
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * https://leetcode.cn/problems/max-area-of-island/description/
 *
 * @see M200NumberOfIslands
 * @see M695MaxAreaOfIsland
 *
 * @author wangyongzhi
 * @date 2023/9/23
 */
public class M695MaxAreaOfIsland {

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹没岛屿，并更新最大岛屿面积
                    res = Math.max(res, dfs(grid, i, j));
                }
            }
        }
        return res;

    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length;
        int n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return 0;
        }

        if (grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        return dfs(grid, i + 1, j) +
                dfs(grid, i - 1, j) +
                dfs(grid, i, j - 1) +
                dfs(grid, i, j + 1) + 1;
    }

    public static void main(String[] args) {
        M695MaxAreaOfIsland islands = new M695MaxAreaOfIsland();
        int[][] grid = {{1, 1, 0, 0}, {1, 0, 0, 1}};
        int res = islands.maxAreaOfIsland(grid);
        System.out.println(res);
    }
}

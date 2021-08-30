package q0c9664d1554e466aa107d899418e814e;


/**
 * NC109 岛屿数量
 * 给一个01矩阵，1代表是陆地，0代表海洋， 如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * 岛屿: 相邻陆地可以组成一个岛屿（相邻:上下左右） 判断岛屿个数。
 */
public class Solution {

    public int visit(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (visit[x][y] == 1) {
            return 0;
        }
        visit[x][y] = 1;
        if (grid[x][y] == '1') {
            int result = 1;
            result += visit(grid, x - 1, y); // 向左探索
            result += visit(grid, x + 1, y); // 向右探索
            result += visit(grid, x, y - 1);// 向上探索
            result += visit(grid, x, y + 1);// 向下探索
            return result;
        }
        return 0;
    }

    byte[][] visit;
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] grid) {
        visit = new byte[grid.length][grid[0].length];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (visit(grid, i, j) > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().solve(new char[][] {
                {'1', '1', '0', '0', '0'},
                {'0', '1', '0', '1', '1'},
                {'0', '0', '0', '1', '1'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '1', '1', '1'}
        }));
    }
}

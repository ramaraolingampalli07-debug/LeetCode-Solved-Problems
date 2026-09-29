class Solution {
    private boolean[][][] vis;
    private int m;
    private int n;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        vis = new boolean[m][n][m + n];
        return dfs(grid, 0, 0, 0);
    }

    private boolean dfs(char[][] grid, int i, int j, int k) {
        if (grid[i][j] == '(') {
            k++;
        } else {
            k--;
        }
        if (k < 0 || k > (m + n - 2 - i - j)) {
            return false;
        }
        if (i == m - 1 && j == n - 1) {
            return k == 0;
        }
        if (vis[i][j][k]) {
            return false;
        }
        vis[i][j][k] = true;
        if (i + 1 < m && dfs(grid, i + 1, j, k)) {
            return true;
        }
        if (j + 1 < n && dfs(grid, i, j + 1, k)) {
            return true;
        }
        return false;
    }
}

package dynamic;

/*
63. 不同路径 II
一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

网格中的障碍物和空位置分别用 1 和 0 来表示。

说明：m 和 n 的值均不超过 100。

示例 1:

输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
 */
public class LeetCode63 {

    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 1},
                {0, 0, 0}
        };

        uniquePathsWithObstacles3(obstacleGrid, 0, 0);
        System.out.println(count);

        System.out.println(uniquePathsWithObstacles(obstacleGrid));

        System.out.println(uniquePathsWithObstacles2(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i ++) {
            res[0][i] = 1;
        }
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i ++) {
            res[i][0] = 1;
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 1; j < n; j ++) {
                if (obstacleGrid[i][j] == 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        int m = obstacleGrid.length - 1, n = obstacleGrid[0].length - 1;
        boolean flag = false;
        for (int i = 0; i <= n; i ++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
                flag = true;
            } else {
                obstacleGrid[0][i] = 1;
            }
            if (flag) {
                obstacleGrid[0][i] = 0;
            }
        }
        flag = false;
        for (int i = 1; i <= m; i ++) {
            if (obstacleGrid[i][0] == 1) {
                obstacleGrid[i][0] = 0;
                flag = true;
            } else {
                obstacleGrid[i][0] = 1;
            }
            if (flag) {
                obstacleGrid[i][0] = 0;
            }
        }
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
            }
        }
        return obstacleGrid[m][n];
    }

    private static int count = 0;
    private static void uniquePathsWithObstacles3(int[][] grid, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || grid[i][j] == 1 || grid[i][j] == -1) {
            return;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            count ++;
        }
        grid[i][j] = -1;
        uniquePathsWithObstacles3(grid, i + 1, j);
        uniquePathsWithObstacles3(grid, i, j + 1);
        grid[i][j] = 0;
    }

}

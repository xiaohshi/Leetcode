package backtracking;

/*
526. 优美的排列
假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，我们就称这个数组为一个优美的排列。条件：

第 i 位的数字能被 i 整除
i 能被第 i 位上的数字整除
现在给定一个整数 N，请问可以构造多少个优美的排列？

示例1:

输入: 2
输出: 2
解释:

第 1 个优美的排列是 [1, 2]:
  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除

第 2 个优美的排列是 [2, 1]:
  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
说明:

N 是一个正整数，并且不会超过15。
 */
public class LeetCode526 {

    public static void main(String[] args) {
        System.out.println(countArrangement(2));
    }

    private static int res = 0;

    public static int countArrangement(int N) {
        boolean[] visited = new boolean[N];
        helper(visited, N, 1);
        return res;
    }

    private static void helper(boolean[] visited, int n, int num) {
        if (num > n) {
            res ++;
            return;
        }
        for (int i = 1; i <= n; i ++) {
            if (!visited[i - 1] && (num % i == 0 || i % num == 0)) {
                visited[i - 1] = true;
                helper(visited, n, num + 1);
                visited[i - 1] = false;
            }
        }
    }
}

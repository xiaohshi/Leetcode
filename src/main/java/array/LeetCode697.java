package array;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
给定一个非空且只包含非负数的整数数组nums, 数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。

示例 1:

输入: [1, 2, 2, 3, 1]
输出: 2
解释:
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.
示例 2:

输入: [1,2,2,3,1,4,2]
输出: 6

链接：https://leetcode-cn.com/problems/degree-of-an-array
 */
public class LeetCode697 {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        System.out.println(findShortestSubArray(nums));
    }

    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(), map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            int num = nums[i];
            left.putIfAbsent(num, i);
            right.put(num, i);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = nums.length, max = Collections.max(map.values());
        for (int key : map.keySet()) {
            if (map.get(key) == max) {
                res = Math.min(res, right.get(key) - left.get(key) + 1);
            }
        }
        return res;
    }

}
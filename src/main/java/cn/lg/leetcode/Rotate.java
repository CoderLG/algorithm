package cn.lg.leetcode;

import jdk.net.SocketFlow;

public class Rotate {

    public static void reverse(int[] nums, int start, int end) {
        int temp = -1;
        while (start < end) {
            temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }


    public static void main(String[] args) {
        int[] nums = {1,2};
        int k = 3 % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

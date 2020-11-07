package cn.lg.leetcode;

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> contains = new HashSet<>();
        for (int num : nums) {
            if (contains.contains(num)) {
                return true;
            }
            contains.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));

    }
}

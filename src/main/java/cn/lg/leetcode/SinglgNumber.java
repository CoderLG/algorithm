package cn.lg.leetcode;

/**
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 说明：
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 作者：力扣 (LEETCODE)
 * 链接：HTTPS://LEETCODE-CN.COM/LEETBOOK/READ/TOP-INTERVIEW-QUESTIONS-EASY/X21IB6/
 * 来源：力扣（LEETCODE）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 解题方案:
 * 如果没有时间复杂度和空间复杂度的限制，这道题有很多种解法，可能的解法有如下几种。
 *
 * 使用集合存储数字。遍历数组中的每个数字，如果集合中没有该数字，则将该数字加入集合，如果集合中已经有该数字，则将该数字从集合中删除，最后剩下的数字就是只出现一次的数字。
 *
 * 使用哈希表存储每个数字和该数字出现的次数。遍历数组即可得到每个数字出现的次数，并更新哈希表，最后遍历哈希表，得到只出现一次的数字。
 *
 * 上述三种解法都需要额外使用 O(N)O(N) 的空间，其中 NN 是数组长度。如果要求使用线性时间复杂度和常数空间复杂度，上述三种解法显然都不满足要求。那么，如何才能做到线性时间复杂度和常数空间复杂度呢？
 *
 * 答案是使用位运算。对于这道题，可使用异或运算 \OPLUS⊕。异或运算有以下三个性质。
 *
 * 任何数和 00 做异或运算，结果仍然是原来的数，即 A \OPLUS 0=AA⊕0=A。
 * 任何数和其自身做异或运算，结果是 00，即 A \OPLUS A=0A⊕A=0。
 * 异或运算满足交换律和结合律，即 A \OPLUS B \OPLUS A=B \OPLUS A \OPLUS A=B \OPLUS (A \OPLUS A)=B \OPLUS0=BA⊕B⊕A=B⊕A⊕A=B⊕(A⊕A)=B⊕0=B。
 *
 *
 * 作者：LEETCODE-SOLUTION
 * 链接：HTTPS://LEETCODE-CN.COM/PROBLEMS/SINGLE-NUMBER/SOLUTION/ZHI-CHU-XIAN-YI-CI-DE-SHU-ZI-BY-LEETCODE-SOLUTION/
 * 来源：力扣（LEETCODE）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 *CTRL + SHIFT
 */
public class SinglgNumber {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println( singleNumber(nums));
    }
    public static int singleNumber(int[] nums) {
        int res = 0;
        for (int num : nums) {
            res = res ^ num;
        }
        return res;
    }
}

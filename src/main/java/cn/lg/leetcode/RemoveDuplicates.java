package cn.lg.leetcode;

/**
 * 给定一个 排序 数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * 双指针法
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] inputrArr = {1, 1, 2};
        int index = 0;
        int lowIndex = 0;
        int heightIndex = 1;

        while (heightIndex <= inputrArr.length - 1) {
            if (inputrArr[lowIndex ++] != inputrArr[heightIndex++])
                inputrArr[++index] = inputrArr[lowIndex];
        }

        for (int i = 0; i < index +1; i++) {
            System.out.println(inputrArr[i] );
        }
    }
}

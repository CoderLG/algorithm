package cn.lg.algorithm;

import java.lang.reflect.Array;

/**
 *  两个数组，一个数组A  一个数组B，打印B数组中在A数组中的出现的元素
 *  A：1 3 5 6 8 9           m个
 *  B: 2 5 7                 n个
 *
 *
 * 时间复杂度
 * 计算机所有的操作时间都是一定的  寻址 比较 计算 ...
 * 所以时间复杂的就和 计算的次数相关，多少计算次数时间复杂的就是多少
 *
 *
 * 1.遍历B数组 在遍历A数组   时间复杂度为  O(m*n)
 * 2.二分查找          n/2  n/4 n/8    时间复杂度为  O(n*logm）
 * 3.双指针法（官方叫法不明）            时间复杂度为  O(n+m)
 *
 * 时间复杂的： 只要高阶 不要低阶  忽略高阶的系数  分析时候按照最差的情况分析(比如完全倒叙，完全正序)
 *
 * 双指针法（官方叫法不明）：前提为有序，利用双指针便利比较两部分,根据大小移动双指针，目标到头则停止
 *
 */
public class TimeComplexity {
    public static void main(String[] args) {
        /**
         * 数组的初始化
         */
        int[] arr1 = new int[10];
        arr1[1] = 55;
//        System.out.println(arr1[1]);
        int[] arrA = {1, 3, 5, 9,10 };
        int[] arrB = {1,5};

        int n = 0;
        int m = 0;
//        到头
        boolean nFlag = false;
        boolean mFlag = false;

        do {
            if(n == arrA.length-1)
                nFlag = true;

            if(m == arrB.length-1)
                mFlag = true;


            if (arrA[n] == arrB[m]) {
                System.out.println(arrB[m]);
                if(!nFlag)
                    n++;
                if(!mFlag)
                    m++;
            }else if (arrA[n] > arrB[m]) {
                if(!mFlag)
                  m++;
            }else  if (arrA[n] < arrB[m]) {
                if(!nFlag)
                   n++;
            }

            if(nFlag && arrA[n] < arrB[m])
                break;

            if(mFlag && arrA[n] > arrB[m])
                break;


        } while (true);

    }



}

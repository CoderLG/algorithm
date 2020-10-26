package cn.lg.utils;

import static com.sun.xml.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

public class AlgorithmUtils {

    /**
     * 不小于一个数的最小2的幂次方
     *
     * 因为取余运算 代价 大大大于 位运算
     *
     *  >>> 向右移位，并将高位补0
     *  开始 减1 为了避免目标数就是2的指数倍，得到的结果为 2*num
     *
     *  位运算： 将目标数的 高位到低位都搞成 1
     *  那么 加1 后就得到了 不小于这个数的最小2的幂次方
     */
    public static Integer highestOneBit( int num){
        int n = num - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }




}

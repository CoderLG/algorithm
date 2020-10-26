package cn.lg.sort;

import org.aspectj.weaver.ast.Var;

/**
 * 快速排序：排第一个数，左小右大，递归
 */
public class Quick {
    public static int[] arr = {49, 38, 65, 97, 76, 13, 27, 49};

    public  static void quickSort(int[] arr,int start, int end){
        boolean startRun = false;
        int targetNum = arr[start];
        int startN = start;
        int endN = end;


        while (start < end) {
            if (startRun) {
                if (targetNum < arr[start]) {
                    arr[end] = arr[start];
                    arr[start] = targetNum;
                    startRun = false;
                    end--;
                } else {
                    start++;
                }
            } else {
                if (targetNum > arr[end]) {
                    arr[start] = arr[end];
                    arr[end] = targetNum;
                    startRun = true;
                    start++;
                } else {
                    end--;
                }
            }
        }

        for (int i : arr) {
            System.out.print(i + "   ");
        }
        System.out.println();

        if(startN < start -1)
            quickSort(arr, startN, start - 1);
        if(start+1 <endN)
            quickSort(arr, start+1, endN);



    }
    public static void main(String[] args) {

        quickSort(arr,0,arr.length-1);

    }



}

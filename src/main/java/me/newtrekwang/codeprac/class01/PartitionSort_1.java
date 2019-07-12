package me.newtrekwang.codeprac.class01;

import java.util.Arrays;
/**
 *  荷兰国旗问题
 * @author newtrekWang
 * @email  wangjiaxing20160101@gmail.com
 * @time   2019/7/12  0:34
 */
public class PartitionSort_1 {

    public static void main(String[] args){
        int[] arr = generateRandomArray(10,10);
        System.out.println(Arrays.toString(arr));
        partitionSort(arr,4);
        System.out.println(Arrays.toString(arr));
    }


    public static void partitionSort(int[] arr,int num){
        if (arr == null || arr.length < 2 ){
            return;
        }
        int less = -1;
        int more = arr.length;
        int cur = 0;
        while (cur < more){
            if (arr[cur] < num){
                SortUtils.swap(arr,cur++,++less);
            }else if (arr[cur] > num ){
                SortUtils.swap(arr,cur,--more);
            }else {
                cur++;
            }
        }
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0;i < arr.length;i++){
            arr[i] =  (int) ((maxValue+1)*Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }
}

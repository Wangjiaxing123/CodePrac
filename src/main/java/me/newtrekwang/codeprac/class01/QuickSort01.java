package me.newtrekwang.codeprac.class01;

import java.util.Arrays;

public class QuickSort01 {

    public static void main(String[] args){
        int[] temp = {9,8,7,32,4,6,8};
        System.out.println("排序前："+Arrays.toString(temp));
        quickSort(temp,7);
        System.out.println("排序后："+Arrays.toString(temp));
    }


    public static void quickSort(int[] arr,int n){
        sortProcess(arr,0,n-1);
    }

    public static void sortProcess(int[] arr,int l,int r){
        if (l < r){
            // 加上这个就是随机快排，有期望值
            SortUtils.swap(arr,(int)(l+(Math.random()*(r-l+1))),r);

            int[] p = partition(arr,l,r);
            sortProcess(arr,l,p[0]-1);
            sortProcess(arr,p[1]+1,r);
        }

    }

    public static int[] partition(int[] arr,int l,int r){
        int less = l-1;
        int more = r;
        while (l < more){
            if (arr[l] < arr[r]){
                SortUtils.swap(arr,++less,l++);
            }else if (arr[l] > arr[r]){
                SortUtils.swap(arr,l,--more);
            }else {
                l++;
            }
        }
        SortUtils.swap(arr,more,r);
        return new int[]{less+1,more};
    }

    // for test
    public static int comparator(int[] arr){
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0;i < arr.length;i++){
            arr[i] =  (int) ((maxValue+1)*Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0;i<res.length;i++){
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int[] arr1,int[] arr2){
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)){
            return false;
        }
        if (arr1 == null && arr2 == null){
            return true;
        }
        if (arr1.length != arr2.length){
            return false;
        }
        for (int i = 0;i<arr1.length;i++){
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

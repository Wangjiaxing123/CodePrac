package me.newtrekwang.codeprac.class01;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args){
        int[] arr = generateRandomArray(10,10);
        System.out.println(Arrays.toString(arr));
        headSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] generateRandomArray(int maxSize,int maxValue){
        int[] arr = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0;i < arr.length;i++){
            arr[i] =  (int) ((maxValue+1)*Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static void headSort(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        // 首先调整为大根堆 O(N)
        for (int i=0;i<arr.length;i++){
            heapInsert(arr,i);
        }
        // 第一个数和最后一个数交换
        int size = arr.length;
        SortUtils.swap(arr,0,--size);
        while (size > 0){
            heapify(arr,0,size);
            SortUtils.swap(arr,0,--size);
        }
    }

    public static void heapInsert(int[] arr,int index){
            while (arr[index] > arr[(index-1)/2]){
                SortUtils.swap(arr,index,(index-1)/2);
                index = (index-1)/2;
            }
    }

    public static void heapify(int[] arr,int index,int size){
        int l = index*2+1;
        while (l < size){
            int largest = l+1 < size && arr[l] < arr[l+1] ? l+1:l;
            largest = arr[largest] > arr[index] ? largest:index;
            if (largest == index){
                break;
            }
            SortUtils.swap(arr,largest,index);
            index = largest;
            l = index*2+1;
        }
    }

}

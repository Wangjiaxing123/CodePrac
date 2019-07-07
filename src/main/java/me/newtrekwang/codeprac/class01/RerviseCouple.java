package me.newtrekwang.codeprac.class01;

/**
 *  打印数组中的逆序对
 * @author newtrekWang
 * @email  wangjiaxing20160101@gmail.com
 * @time   2019/7/7  11:57
 */
public class RerviseCouple {
    public static void main(String[] args){
        int[] arr = generateRandomArray(10,10);
        printArray(arr);
        printRerviseCouple(arr);
        printArray(arr);

    }

    public static void printRerviseCouple(int[] arr){
        if (arr == null || arr.length < 2){
            return;
        }
        mergeProcess(arr,0,arr.length-1);
    }

    public static void mergeProcess(int[] arr,int l,int r){
        if (l == r){
            return;
        }
        int mid = l+((r-l)>>1);
        mergeProcess(arr,l,mid);
        mergeProcess(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int p1= l;
        int p2= mid+1;
        int i=0;
        while (p1 <= mid && p2<= r){
            if (arr[p1] < arr[p2]){
                for(int j = p2;j <= r ;j++){
                    System.out.println(arr[p1]+","+arr[p2]);
                }
            }
            help[i++] = arr[p1]<arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0 ;i<help.length;i++){
            arr[l+i] = help[i];
        }
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



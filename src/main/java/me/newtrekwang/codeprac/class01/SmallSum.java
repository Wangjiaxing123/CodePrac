package me.newtrekwang.codeprac.class01;

public class SmallSum {

    public static void main(String[] args){
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

    /**
     * 求小和数  每次merge找右边数组元素比左边数组元素大的个数，然后也要排序
     * @param arr
     * @return
     */
    public static int smallSum(int[] arr){
        if (arr == null || arr.length < 2){
            return 0;
        }
        return mergeProcess(arr,0,arr.length-1);
    }

    public static int mergeProcess(int[] arr,int l,int r){
        if (l == r){
            return 0;
        }
        int mid = l+((r-l)>>1);
        return mergeProcess(arr,l,mid)+mergeProcess(arr,mid+1,r)+merge(arr,l,mid,r);
    }

    public static int merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int res = 0;
        int p1 = l;
        int p2 = mid+1;
        int i = 0;
        while (p1<=mid && p2<= r){
            res += arr[p1] < arr[p2] ? arr[p1]*(r-p2+1):0;
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }
        while (p1 <= mid){
            help[i++] = arr[p1++];
        }
        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for (i = 0;i<help.length;i++){
            arr[l+i] = help[i];
        }
        return res;
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

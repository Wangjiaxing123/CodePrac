package me.newtrekwang.codeprac.class01;

public class Sort {

    /**
     * 冒泡排序 复杂度N*N
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr,int n){
        for (int i = n-1 ;i > 0;i-- ){
            // 如果长度为n,则总共冒n-1次
            for(int j = 0 ;j < i;j++){
                //每冒完一次，会得到一个最大值，排到最后面
                if (arr[j] > arr[j+1]){
                    SortUtils.swap(arr,j,j+1);
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @param n
     * @return
     */
    public static int[] sectionSort(int[] arr,int n){
        for(int i = 0;i < n-1;i++){
            // 如果长度为n,则需要选择n-1次，每次选择都会得出一个最小的数
            // i作为index最大会到n-2,不会出现越界
            for(int j = i+1;j <= n-1;j++){
                // j作为index最大会到n-1，不会出现越界
                if (arr[i] > arr[j]){
                    SortUtils.swap(arr,i,j);
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序 优化
     * @param arr
     * @param n
     * @return
     */
    public static int[] sectionSort_1(int[] arr,int n){
        for(int i = 0;i < n-1;i++){
            // 如果长度为n,则需要选择n-1次，每次选择都会得出一个最小的数
            // i作为index最大会到n-2,不会出现越界
            int minIndex = i;
            for(int j = i+1;j <= n-1;j++){
                // j作为index最大会到n-1，不会出现越界
                if (arr[i] > arr[j]){
                    minIndex = j;
                }
            }
            if (minIndex != i){
                SortUtils.swap(arr,minIndex,i);
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @param n
     * @return
     */
    public static int[] insertSort(int[] arr,int n){
        if (n == 0){
            return arr;
        }
        for (int i = 1;i< n;i++){
            for (int j = i;j > 0;j--){
                if (arr[j] < arr[j-1]){
                    SortUtils.swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
        return arr;
    }

    /**
     * 归并排序 a*N(b/2)+O(N) a=2,b=2,d=0 T(N) = N*logN
     * @param arr
     * @param n
     * @return
     */
    public static int[] mergeSort(int[] arr,int n){
        if (n==0 || n < 2){
            return arr;
        }
        mergeProcess(arr,0,n-1);
        return arr;
    }

    public static void mergeProcess(int[] arr,int l,int r){
        if (l == r){
            return;
        }
        int mid = l+ ((r-l) >> 1) ;
        mergeProcess(arr,l,mid);
        mergeProcess(arr,mid+1,r);
        merge(arr,l,mid,r);
    }

    public static void merge(int[] arr,int l,int mid,int r){
        int[] help = new int[r-l+1];
        int p1 = l;
        int p2 = mid + 1;
        int i = 0;
        while (p1 <= mid && p2 <= r){
            help[i++] = arr[p1] < arr[p2] ? arr[p1++]:arr[p2++];
        }

        while (p1 <= mid){
            help[i++] = arr[p1++];
        }

        while (p2 <= r){
            help[i++] = arr[p2++];
        }
        for(i=0;i<help.length;i++){
            arr[l+i] = help[i];
        }
    }
}

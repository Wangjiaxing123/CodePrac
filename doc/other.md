## 1 求小和数

![小和问题](https://upload-images.jianshu.io/upload_images/2608869-d14ddbebea97899a.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

```java
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

```

时间复杂度：T(N) = 2*T(N/2)+O(N),即a/b=1=d=1,即`O(N*logN)`


## 2 打印逆序对

```java
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
```

时间复杂度：T(N) = 2*T(N/2)+O(N),即a/b=1=d=1,即`O(N*logN)`


## 3 荷兰国旗问题

给定一个数组arr,和一个数num,请把小于等于num的数放在数组的左边，大于num的数放在数组的右边。

要求额外空间复杂度O(1),时间复杂度O(N)

```java
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
```

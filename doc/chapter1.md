# 字符串去重

### 1.利用集合类

遍历字符串，如果字符在集合内不存在，则加入集合，最有拼接集合内的字符串

```
   /**
     * 字符串去重 使用集合类
     */
    public static String rejectRepeat(String str){
        char[] temp=str.toCharArray();
        StringBuilder stringBuilder=new StringBuilder();
        List<String>  list=new ArrayList<String >();
        for (int i=0;i<temp.length;i++){
            if (!list.contains(String.valueOf(temp[i]))){
                list.add(String.valueOf(temp[i]));
                stringBuilder.append(temp[i]);
            }
        }
        return stringBuilder.toString();
    }
```

### 2.优雅解法 时间复杂度O\(n2\)

遍历字符串，遇到相同的字符，就将其置为‘\0’,注意有index的使用

```
 /**
     *  字符串去重 优雅解法 时间复杂度O(n2)
     *  遍历字符串，遇到相同的字符，就将其置为‘\0’,注意有index的使用
     * @param string
     * @return
     */
    public static String rejectRepeat_2(String string){
        if (string==null){
            return null;
        }
        char[] str=string.toCharArray();
        int len=string.length();
        int i,j;
        int index=0;
        for (i=0;i<len;i++){
            if (str[i]!='\0'){
                str[index++]=str[i];
                for (j=i+1;j<len;++j){
                    if (str[j]==str[i]){
                        str[j]='\0';
                    }
                }
            }
            System.out.println("index  >>"+index);
        }
//        打印
       StringBuilder stringBuilder=new StringBuilder();
        for (int c=0;c<index;c++){
            stringBuilder.append(str[c]);
        }
        return  stringBuilder.toString();
    }
```

### 3.暴力 时间复杂度O\(n3\)

遍历字符串，遇到相同的字符，就将其删除，然后后面的字符向前移动






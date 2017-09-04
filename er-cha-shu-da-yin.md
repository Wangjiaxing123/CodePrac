有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。

给定二叉树的根结点**root**，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。



二叉树结点类

```
/**
 * Created by Newtrek on 2017/9/1.
 * 二叉树节点
 */
public class TreeNode {
    int val=0;
    TreeNode left=null;
    TreeNode right=null;

    public TreeNode(int val) {
        this.val = val;
    }
}

```

算法

```

      public static int[][] printTree1(TreeNode root){
            if (root==null){
                throw new IllegalArgumentException();
            }
          LinkedList<TreeNode>  queue=new LinkedList<>();
          queue.addLast(root);
          int last=root.val;
          int nlast=Integer.MAX_VALUE;
          int row=0;//行号
            List<List<Integer>>  res=new ArrayList<>();
            res.add(new ArrayList<>());
          while (!queue.isEmpty()){
              TreeNode curr=queue.removeFirst();
              if (curr.left!=null){
                  queue.addLast(curr.left);
                  nlast=curr.left.val;
              }
              if (curr.right!=null){
                  queue.addLast(curr.right);
                  nlast=curr.right.val;
              }

              res.get(row).add(curr.val);

              if (curr.val==last){
                  last=nlast;
                  row++;
                  res.add(new ArrayList<>());
              }
          }
          int[][] arr=new int[res.size()][];
          for (int i=0;i<res.size();i++){
              arr[i]=new int[res.get(i).size()];
              for (int j=0;j<res.get(i).size();j++){
                  arr[i][j]=res.get(i).get(j);
              }
          }
          return arr;
      }
```




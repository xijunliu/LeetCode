package Top100;

import java.util.LinkedList;
import java.util.Stack;

public class lc337 {
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

    public int rob(TreeNode root) {
        if(root == null) return 0;
        //可以通过添加一个hashtable避免每个节点重复计算，当遇到hash表中存在的节点则直接返回hash表中的值
        int temp = root.val;
        if(root.left != null) temp += rob(root.left.left) + rob(root.left.right);
        if(root.right != null) temp += rob(root.right.left) + rob(root.right.right);
        int temp1 = rob(root.left) + rob(root.right);
        return Math.max(temp, temp1);
    }



}

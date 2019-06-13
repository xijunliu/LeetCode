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
        if(root==null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addFirst(root);
        int sumAll = 0;
        int sum = 0;
        int level = 0;
        int toBePrint = 1;
        int flag = 1;
        TreeNode node = null;
        while (!queue.isEmpty()){
            if(toBePrint>0){
                node = queue.pollLast();
                if(node != null){
                    sumAll+=node.val;
                    if(flag == 1){
                        sum+=node.val;
                    }
                }
                    toBePrint--;
                }
                if(node.left != null) {
                    queue.addFirst(node.left);
                    level++;
                }
                if (node.right != null){
                    queue.addFirst(node.right);
                    level++;
                }
            }
            if(toBePrint==0){
                toBePrint = level;
                level = 0;
                flag = -flag;
            }
        return  sum >sumAll? sum : sumAll ;
        }

}

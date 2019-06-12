package Top100;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class lc102 {
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List list = new ArrayList<Integer>();
        if(root == null) return res;
        queue.addFirst(root);
        int level = 0;

        int toBePrint = 1;
        TreeNode node = null;
        while (!queue.isEmpty()){
            if(toBePrint>0){
                node = queue.pollLast();
                if(node != null){
                    list.add(node.val);
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
                res.add(new ArrayList<>(list));
                list.clear();
                toBePrint = level;
                level = 0;
            }
        }
        return res;
    }

}

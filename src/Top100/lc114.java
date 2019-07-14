package Top100;

public class lc114 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public void flatten(TreeNode root) {
        if(root == null) return ;
        flatten(root.left);
        flatten(root.right);
        if(root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode node = root.right;
            while (node.right != null){
                node = node.right;
            }
            node.right = temp;
        }
        return;
    }
}

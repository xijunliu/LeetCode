package Top100;


public class lc105 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || inorder == null || preorder.length != inorder.length || preorder.length<1) return null;
        return helper(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);
    }

    public TreeNode helper( int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright){
        if (preleft > preright || inleft > inright) return null;
        TreeNode root = new TreeNode(preorder[preleft]);
        // if(preleft==preright) return root;
        int index = 0;
        for(int i=0; i<inorder.length; i++){
            if(inorder[i] == preorder[preleft]){
                index = i;
                break;
            }
        }
        root.left = helper(preorder, preleft+1, preleft+index-inleft, inorder, inleft, index-1);
        root.right = helper(preorder, preleft+1+(index-inleft),preright , inorder, index+1, inright);
        return root;
    }

    public static void main(String[] args) {
        lc105 l = new lc105();
        int[] pre = {3,9,20,15,7};
        int[] in = {9,3,15,20,7};
        l.buildTree(pre,in);
    }
}


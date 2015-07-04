package com.tree;

public class BottomView {
	public static void main(String[] args)
    {
        TreeNode root = new TreeNode(20);
       root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        
        
        
      /*  TreeNode root = new TreeNode('a');
        root.left = new TreeNode('b');
        root.right = new TreeNode('d');
       root.left.left = new TreeNode('c');
        root.right.right = new TreeNode('e');*/
        
        TreeNode S = new TreeNode('a');
        S.left = new TreeNode('b');
        S.right = new TreeNode('d');
       S.left.left = new TreeNode('c');
        S.right.right =new TreeNode('e');
           
        Tree tree = new Tree(root);
        System.out.println("Bottom view of the given binary tree:");
        //tree.bottomView();
        //System.out.println(tree.isSubTree(root, S));
        //tree.levelOrder(root);
        //tree.verticalOrder(root);
        Integer param = 0;
      //  TreeNode root1=tree.transformTree(root);
       // tree.inorder(root1);
       TreeNode root1= tree.alternateLevel(root);
        tree.inorder(root1);
        
    }

}

package com.tree;

public class TreeMain {
	public static void main(String[] args) {
        /* Create following Binary Tree
              1
            /    \
          2        3
         / \      / \
        4   5    6   7
 
        */
        BSTNode root = new BSTNode(1);
        root.setLeft(new BSTNode(2));
        root.setRight(new BSTNode(3));
        root.getLeft().setLeft(new BSTNode(4));
        root.getLeft().setRight(new BSTNode(5));
        root.getRight().setLeft(new BSTNode(6));
        root.getRight().setRight(new BSTNode(7));
        BST t = new BST(root);
 
        System.out.println("Following are the values of vertical sums with "
                + "the positions of the columns with respect to root ");
        //t.verticalSum(root);
        BSTNode root1 = new BSTNode(8);
        root1.setLeft(new BSTNode(10));
        root1.setRight(new BSTNode(12));
       // BSTNode r=t.mergeTrees(root, root1, 7, 3); 
        //print(r);
        //System.out.println(t.ceilBST());
        int pre[] = {10, 5, 1, 7, 40, 50};
      
        //BSTNode a=t.constructBSTPreorder(pre,pre.length);
        //print(a);
       // t.iterativePreorder();
        //t.boundaryTraversal();
        System.out.println(t.checkAllLeaves());
        
    }
	public static void print(BSTNode r)
	{
	if(r==null)
		return;
	else
	{
		
		print(r.getLeft());
		System.out.println(r.getData());
		print(r.getRight());
	}
}
}

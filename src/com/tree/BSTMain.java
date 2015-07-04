package com.tree;

public class BSTMain {
	public static void main(String[] args) {
		BST bst=new BST();
		
		bst.insert(2);
		bst.insert(5);
		bst.insert(3);
		bst.insert(1);
		bst.insert(6);
		System.out.println(bst.search(6));
	//	bst.inorder();
		//bst.preorder();
		//bst.postorder();
		//System.out.println(bst.countNodes());
	
		System.out.println(bst.maxDepth());
		//it.identical(a, b);
        // bst.delete();
         //System.out.println(bst.countNodes());
		//BSTNode r=bst.mirror();
		//print(r);
		//bst.printAllpath();
	//	BSTNode r=bst.LCA();
		//System.out.println(r.getData());
		//bst.levelOrder();
		System.out.println(bst.isChildreinSum());
		System.out.println(bst.diameter());
		char in[] = {'D', 'B', 'E', 'A', 'F', 'C'};
		  char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
		  int l=in.length;
		 // BSTNode r1=bst.constructBST(in,pre,0,l-1);
		  //print(r1);
		  //BSTNode r2=bst.DoubleTree();
		  //print(r2);
		 // System.out.println(bst.rootToLeafSum());
		//  System.out.println(bst.isFoldable());
		 // bst.printNodesK();
		  //bst.rangekeys();
		 // bst.printAncestors();
		  //System.out.println(bst.getLevel());
		  int arr[]={1,2,3,4,5};
		  //BSTNode k=bst.sortedArrayToBST(arr, 0, 4);
		  //print(k);
		  System.out.println(bst.convertToSumTree());
	}
	
	public static void print(BSTNode r)
	{
	if(r==null)
		return;
	else
	{
		System.out.println(r.getData());
		print(r.getLeft());
		print(r.getRight());
	}
		
	}
}

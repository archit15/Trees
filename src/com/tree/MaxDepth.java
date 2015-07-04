package com.tree;

public class MaxDepth {
	public int maxDepth(BSTNode root)
	{
		int lheight,rheight;
		if(root==null)
			return 0;
		lheight=maxDepth(root.left);
		rheight=maxDepth(root.right);
		return Math.max(lheight, rheight);
	}

}

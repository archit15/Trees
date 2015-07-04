package com.tree;

public class IdenticalTrees {
	public boolean identical(BSTNode a,BSTNode b)
	{
		if(a==null && b==null)
			return true;
		else
		{
			return a.getData()==b.getData() && identical(a.left, b.left) && identical(a.right, b.right);
		}
		
	}

}

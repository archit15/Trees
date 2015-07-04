package com.tree;

class TreeNode
{
    int data; //data of the node
    int hd; //horizontal distance of the node
    TreeNode left, right; //left and right references
 
    // Constructor of tree node
    public TreeNode(int i)
    {
        data = i;
        hd = Integer.MAX_VALUE;
        left = right = null;
    }
}

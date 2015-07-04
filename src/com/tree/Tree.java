package com.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Tree {
	TreeNode root; //root node of tree
	 int m;
	 Map<Integer, ArrayList<Integer>> mp;
	int sum=0;
	int index=0;
    // Default constructor
    public Tree() {}
 
    // Parameterized tree constructor
    public Tree(TreeNode node)
    {
        root = node;
    }
 
    // Method that prints the bottom view.
    public void bottomView()
    {
        if (root == null)
            return;
 
        // Initialize a variable 'hd' with 0 for the root element.
        int hd = 0;
        
        Map<Integer, Integer> mp=new HashMap<Integer, Integer>();
        java.util.Queue<TreeNode> queue=new LinkedList<TreeNode>();
        root.hd=hd;
        queue.add(root);
        while(!queue.isEmpty())
        {
        	TreeNode temp=queue.remove();
        	hd=temp.hd;
        	mp.put(hd, (int) temp.data);
        	if(temp.left!=null)
        	{
        		temp.left.hd=hd-1;
        		queue.add(temp.left);
        	}
        	if(temp.right!=null)
        	{
        		temp.right.hd=hd+1;
        		queue.add(temp.right);
        	}
        }
        
        Set<Entry<Integer, Integer>> set=mp.entrySet();
        Iterator<Entry<Integer, Integer>> iterator=set.iterator();
        while(iterator.hasNext())
        {
        	Map.Entry<Integer, Integer> me=iterator.next();
        	System.out.println(me.getValue());
        }
    }
    
    
    public boolean isSubTree(TreeNode S,TreeNode T)
    {
    	if(S==null)
    		return true;
    	if(T==null)
    		return false;
    	int m=0;
		int n=0;
    	char inS[]=new char[100];
    	char inT[]=new char[100];
    	//storeInorder(S,inS);
    	//storeInorder(T,inT);
    	inS[m]='\0';
    	inT[n]='\0';
    	String s=new String(inS);
    	System.out.println(s);
    	String t=new String(inT);
    	System.out.println(t);
    	if(s.compareToIgnoreCase(t)==0)
    		return true;
		return false;
    	
    }

	private void storeInorder(TreeNode s, int[] inS) {
		
		if(s==null)
		{
			inS[m++]='$';
			return;
		}
		storeInorder(s.left, inS);
		inS[m++]=s.data;
		storeInorder(s.right, inS);
		
	}
	
	public void levelOrder(TreeNode root)
	{
		java.util.Queue<TreeNode> queue=new LinkedList<TreeNode>();
		queue.add(root);
		int level=0;
		while(!queue.isEmpty())
		{
			TreeNode temp=queue.remove();
			System.out.println(temp.data);
			if(temp.left!=null)
				queue.add(temp.left);
			if(temp.right!=null)
				queue.add(temp.right);
			level++;
		}
		System.out.println(level);
	}
	
	public void topview(TreeNode root)
	{
		if (root == null) {  return;  }
		 
        // Creates an empty hashset
        HashSet<Integer> set = new HashSet<>();
        java.util.Queue<QItem> Q = new LinkedList<QItem>();
        Q.add(new QItem(root, 0));
        while(!Q.isEmpty())
        {
        	QItem qi=Q.remove();
        	int hd=qi.hd;
        	TreeNode node=qi.node;
        	if (!set.contains(hd))
            {
                set.add(hd);
                System.out.print(node.data + " ");
            }
 
            // Enqueue left and right children of current node
            if (node.left != null)
                Q.add(new QItem(node.left, hd-1));
            if (node.right != null)
                Q.add(new QItem(node.right, hd+1));
        }
	}
	
	public void verticalOrder(TreeNode root)
	{
	mp=new HashMap<Integer, ArrayList<Integer>>();
	int hd=0;
	vertical(root,hd);
	
	Set<Entry<Integer, ArrayList<Integer>>> set=mp.entrySet();
	Iterator<Entry<Integer, ArrayList<Integer>>> iterator=set.iterator(); 
	while(iterator.hasNext())
    {
    	Entry<Integer, ArrayList<Integer>> me=iterator.next();
    	System.out.println(me.getKey());
    }
	}

	private void vertical(TreeNode root2, int hd) {
		if(root2==null)
			return;
		ArrayList<Integer> al=new ArrayList<Integer>();
		al.add(root2.data);
		mp.put(hd, al);
		vertical(root2.left, hd-1);
		vertical(root2.right, hd+1);
		
	}
	public 	TreeNode transformTree(TreeNode root)
	{
		if(root==null)
			return null;
		transformTree(root.right);
		sum+=root.data;
		root.data=sum-root.data;
		transformTree(root.left);
		return root;
	}


public void inorder(TreeNode r)
{
    if (r != null)
    {
        inorder(r.left);
        System.out.print(r.data +" ");
        inorder(r.right);
    }
}

public TreeNode alternateLevel(TreeNode root)
{
	int []arr = new int[100];
   
    // First store nodes of alternate levels
    storeAlternate(root, arr,0);
    reverse(arr);
    modifyTree(root, arr,0);
    return root;
}

private void modifyTree(TreeNode root2, int[] arr,int i) {
	// TODO Auto-generated method stub
	if (root2 == null) return;
	 
    // Store elements of left subtree
    modifyTree(root2.left, arr,i+1);
 
    // Store this node only if this is a odd level node
    if (i%2 != 0)
    {
        arr[index] = root2.data;
        index++;
    }
 
    // Store elements of right subtree
    modifyTree(root2.right, arr, i+1);
   
	
	
}

private void reverse(int[] arr) {
	// TODO Auto-generated method stub
	 int l = 0, r = index-1;
	    while (l < r)
	    {
	        int temp = arr[l];
	        arr[l] = arr[r];
	        arr[r] = temp;
	        l++; 
	        r--;
	    }
	
}

private void storeAlternate(TreeNode root2, int[] arr,int i) {
	if (root2 == null) return;
	 
    // Store elements of left subtree
    storeAlternate(root2.left, arr,i+1);
 
    // Store this node only if this is a odd level node
    if (i%2 != 0)
    {
        arr[index] = root2.data;
        index++;
    }
 
    // Store elements of right subtree
    storeAlternate(root2.right, arr, i+1);
	
}
}
class QItem
{
   TreeNode node;
   int hd;
   public QItem(TreeNode n, int h)
   {
        node = n;
        hd = h;
   }
}
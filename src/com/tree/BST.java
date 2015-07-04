package com.tree;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;


public class BST {
	static BSTNode root;
	
	public boolean isEmpty()
	{
		return root==null;
	}
	public void insert(int data)
    {
        root = insert(root, data);
    }
	BST(BSTNode node)
	{
		root=node;
	}
    public BST() {
		// TODO Auto-generated constructor stub
	}
	/* Function to insert data recursively */
    public BSTNode insert(BSTNode node, int data)
    {
    	 if (node == null)
             node = new BSTNode(data);
    	else
        {
            if (data <= node.getData())
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    	
    }
    public boolean search(int val)
    {
    	return search(root,val);
    }
	private boolean search(BSTNode s, int val) {
		if(s==null)
			return false;
		if(val==s.getData())
			return true;
		if(val<=s.getData())
			return search(s.left,val);
		else
			return search(s.right,val);
		
	}
	public void inorder()
    {
        inorder(root);
    }
    private void inorder(BSTNode r)
    {
        if (r != null)
        {
            inorder(r.getLeft());
            System.out.print(r.getData() +" ");
            inorder(r.getRight());
        }
    }
    /* Function for preorder traversal */
    public void preorder()
    {
        preorder(root);
    }
    private void preorder(BSTNode r)
    {
        if (r != null)
        {
            System.out.print(r.getData() +" ");
            preorder(r.getLeft());             
            preorder(r.getRight());
        }
    }
    /* Function for postorder traversal */
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(BSTNode r)
    {
        if (r != null)
        {
            postorder(r.getLeft());             
            postorder(r.getRight());
            System.out.print(r.getData() +" ");
        }
    }    
    public int countNodes()
    {
        return countNodes(root);
    }
    /* Function to count number of nodes recursively */
    private int countNodes(BSTNode r)
    {
        if (r == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.getLeft());
            l += countNodes(r.getRight());
            return l;
        }
    }
    public int maxDepth(BSTNode root)
	{
		int lheight,rheight;
		if(root==null)
			return 0;
		lheight=maxDepth(root.left);
		rheight=maxDepth(root.right);
		return Math.max(lheight, rheight)+1;
	}
	public int maxDepth() {
		// TODO Auto-generated method stub
		return maxDepth(root);
	}
	
	public void delete()
	{
		delete(root);
	}
	public void delete(BSTNode root2) {
		if(root2==null)
			return;
		delete(root2.left);
		delete(root2.right);
		System.out.println(root2.data);
		root=null;
		
	}
	public BSTNode mirror()
	{
		 return mirror(root);
	}
	public BSTNode mirror(BSTNode root) {
		BSTNode temp;
		if(root==null)
			return null;
		mirror(root.left);
		mirror(root.right);
		
		temp=root.left;
		root.left=root.right;
		root.right=temp;
		return root;
	}
	public void printAllpath()
	{
		int path[]=new int[1000];
		printAllpath(root,path,0);
	}
	private void printAllpath(BSTNode root,int path[],int pathLen) {
		if(root==null)
			return;
		path[pathLen]=root.getData();
		pathLen++;
		if(root.getLeft()==null && root.getRight()==null)
		{
		 printArray(path,pathLen);	
		}
		else
		{
		printAllpath(root.left,path,pathLen);
		printAllpath(root.right,path,pathLen);
		}
	}
	private void printArray(int[] path, int pathLen) {
		for(int i=0;i<pathLen;i++)
		{
			System.out.print(path[i]);
			System.out.println();
		}
		
	}
	public BSTNode LCA()
	{
		return LCA(root,3,6);
	}
	private BSTNode LCA(BSTNode root1, int i, int j) {
		if(root1==null)
			return null;
		if(root1.getData()>i && root1.getData()<j)
			return root1;
		else if(root1.getData()>i && root1.getData()>j)
		{
			return LCA(root1.left,i,j);
		}
		else 
			return LCA(root1.right,i,j);
		
	}
	public void levelOrder()
	{
		levelOrder(root);
	}
	private void levelOrder(BSTNode root2) {
		Queue<BSTNode> q=new PriorityQueue<BSTNode>();
		q.add(root2);
		while(q!=null)
		{
			System.out.println(q.poll().toString());
			if(root2.getLeft() != null)
			q.offer(root2.left);
			if(root2.getRight() != null)
			q.offer(root2.right);
			
		}
		
	}
	public void isBST()
	{
		isBST(root);
	}
	private void isBST(BSTNode root2) {
	 if(root2==null)
		 return;
	 
		
	}
	public boolean isChildreinSum()
	{
		return isChildreinSum(root);
	}
	private boolean isChildreinSum(BSTNode root2) {
		int left=0,right=0;
		if(root2==null || root2.getLeft()==null && root2.getRight()==null)
			return true;
		if(root2.getLeft()!=null)
			left=root2.getLeft().getData();
		if(root2.getRight()!=null)
			right=root2.getRight().getData();
		return ((root2.getData()==left+right) &&isChildreinSum(root2.left) && isChildreinSum(root2.right));
		
	}
	public int diameter()
	{
		return diameter(root);
	}
	private int diameter(BSTNode root2) {
		int ldia,rdia,h;
		if(root2==null)
			return 0;
		ldia=diameter(root2.left);
		rdia=diameter(root2.right);
		return Math.max(maxDepth(), Math.max(ldia,rdia));
	}
public BSTNode constructBST(char[] in, char[] pre, int j,int len)
{
	int preIndex=0;
	
	BSTNode r=new BSTNode(pre[preIndex++]);
	if(j==len)
		return r;
	int inIndex=search(in,j,len,r.getData());
	r.left=constructBST(in, pre, j,inIndex-1);
	r.right=constructBST(in, pre, inIndex+1, len);
	return r;
}
private int search(char[] in, int j, int len, int data) {
	for(int i=0;i<=len;i++)
	{
		if(in[i]==data)
			return i;
		
	}
	return 0;
	
}

public  BSTNode DoubleTree()
{
	return DoubleTree(root);
}
private BSTNode DoubleTree(BSTNode root2) {
	BSTNode oldleft;
	if(root2==null)
		return null;
	DoubleTree(root2.left);
	DoubleTree(root2.right);
	
	oldleft=root2.left;
	root2.left=new BSTNode(root2.getData());
	root2.getLeft().left=oldleft;
	return root2;
}

public boolean rootToLeafSum()
{
	return rootToLeafSum(root,11);
}
private boolean rootToLeafSum(BSTNode root2, int i) {
	if(root2==null)
		return false;
	int sum=i-root2.getData();
	if(root2.getLeft()==null && root2.getRight()==null && sum==0)
	return true;
	return rootToLeafSum(root2.left, sum) || rootToLeafSum(root2.right, sum);
}

public boolean isFoldable()
{
	return isFoldable(root);
}
private boolean isFoldable(BSTNode root2) {
	if(root2==null)
		return true;
	return isFoldableUtil(root2.left,root2.right);
	
}
private boolean isFoldableUtil(BSTNode left, BSTNode right) {
	if(right==null && left==null)
		return true;
	if(right==null || left==null)
		return false;
	return isFoldableUtil(left.left, right.right) && isFoldableUtil(left.right, right.left);
	
	
	
}

public void printNodesK()
{
	printNodesK(root,1);
}
private void printNodesK(BSTNode root2, int i) {

	if(root2==null)
		return;
	
	if(i==0)
	{
		System.out.println(root2.getData());
	}
	printNodesK(root2.left,i-1);
	printNodesK(root2.right,i-1);
}

public void kthSmallest()
{
	kthSmallest(root,2);
}
private void kthSmallest(BSTNode root2, int i) {
	if(root2==null)
		return;
	kthSmallest(root2.left,i);
	
}

public void rangekeys()
{
	rangekeys(root,1,6);
}
private void rangekeys(BSTNode root2, int i, int j) {
	if(root2==null)
		return;
	if(i < root2.getData())
		rangekeys(root2.left, i, j);
	if(root2.getData()>i && root2.getData()<j)
		System.out.println(root2.getData());
	if(root2.getData() < j)
	rangekeys(root2.right, i, j);
}

public void printAncestors()
{
	printAncestors(root,6);
}
private boolean printAncestors(BSTNode root2, int i) {
if(root2==null)
	return false;
if(root2.getData()==i)
	return true;
if(printAncestors(root2.left, i) || printAncestors(root2.right, i))
{
System.out.println(root2.getData());
return true;
}	
return false;
}
public int getLevel()
{
	return getLevel(root,6,1);
}
private int getLevel(BSTNode root2, int i,int level) {
if(root2.getData()==i)
	return level;
if(root2.getData()>i)
	return getLevel(root2.left, i, level+1);
if(root2.getData()<i)
	return getLevel(root2.right, i, level+1);
return 0;
	
}
public BSTNode sortedArrayToBST(int arr[],int start,int end)
{
	if(start>end)
		return null;
	int mid=(start+end)/2;
	BSTNode r1=new BSTNode(arr[mid]);
	r1.left=sortedArrayToBST(arr,start,mid-1);
	r1.right=sortedArrayToBST(arr, mid+1, end);
	return r1;
	
}
public int convertToSumTree()
{
	return convertToSumTree(root);
}
private int convertToSumTree(BSTNode root2) {
	
	if(root2==null)
		return 0;
	int oldValue=root2.getData();
	root2.data=convertToSumTree(root2.left)+convertToSumTree(root2.right);
	return oldValue+root2.getData();
}
public void verticalSum()
{
	verticalSum(root);
}
public void verticalSum(BSTNode root2) {
if(root2==null)
	return;
HashMap<Integer, Integer> hm=new HashMap<Integer, Integer>();
verticalSum(root2,0,hm);
if(hm!=null)
	System.out.println(hm.entrySet());
	
}
private void verticalSum(BSTNode root2, int i, HashMap<Integer, Integer> hm) {
if(root2==null)
	return;
verticalSum(root2.getLeft(), i-1, hm);
int prevSum = (hm.get(i) == null) ? 0 : hm.get(i);
hm.put(i, prevSum + root2.getData());

// Store the values in hM for right subtree
verticalSum(root2.getRight(), i + 1, hm);
	
}

public void maxSumrootToLeaf()
{
	int sum=0;
	maxSumrootToLeaf(root,sum);
}
private void maxSumrootToLeaf(BSTNode root2,int sum) {
	
	if(root2==null)
		return;
	int maxsum;
	
	
	
}

public BSTNode mergeTrees(BSTNode root1,BSTNode root2,int m,int n)
{
	int[] arr1=new int[m];
	int i=0;
	arr1=storeInorder(root1,arr1,i);
	int[] arr2=new int[n];
	int j=0;
	arr2=storeInorder(root2,arr2,j);
	int[] merged=merge(arr1,arr2,m,n);
	return sortedArrayToBST(merged, 0, m+n-1);
	
}
public int[] storeInorder(BSTNode root1, int[] arr1, int i) {
	
	if(root1==null)
		return null;
	storeInorder(root1.left, arr1, i);
	i=i+1;
	arr1[i]=root1.getData();
	
	storeInorder(root1.right, arr1, i);
	return arr1;
	
}
public int[] merge(int[]arr1,int[]arr2,int m,int n)
{
	int[] mergedArr=new int[m+n];
	 int i = 0, j = 0, k = 0;
	 
	    // Traverse through both arrays
	    while (i < m && j < n)
	    {
	        // Pick the smaler element and put it in mergedArr
	        if (arr1[i] < arr2[j])
	        {
	            mergedArr[k] = arr1[i];
	            i++;
	        }
	        else
	        {
	            mergedArr[k] = arr2[j];
	            j++;
	        }
	        k++;
	    }
	    while (i < m)
	    {
	        mergedArr[k] = arr1[i];
	        i++; k++;
	    }
	 
	    // If there are more elements in second array
	    while (j < n)
	    {
	        mergedArr[k] = arr2[j];
	        j++; k++;
	    }
	 
	    return mergedArr;
}
public int ceilBST()
{
	return ceilBST(root,5);
}
private int ceilBST(BSTNode root2,int input) {
	if(root2==null)
		return -1;
	if(root2.getData()==input)
	{
		return root2.getData();
	}
	if(root2.getData()<input)
		return ceilBST(root2.right,input);
	int ceil=ceilBST(root2.left, input);
	return (ceil>=input)?ceil:root2.getData();
	
}
public BSTNode constructBSTPreorder(int pre[],int size)
{
	int preIndex=0;
	return constructBSTPreorder(pre,preIndex,pre[0],Integer.MIN_VALUE,Integer.MAX_VALUE, size);
}
private BSTNode constructBSTPreorder(int[] pre, int preIndex, int i, int minValue,
		int maxValue, int size) {
	
	if(preIndex>=size)
		return null;
	BSTNode root1=null;
	if(i>minValue && i<maxValue)
	{
		root1=new BSTNode(i);
		preIndex++;
		if(preIndex <size)
		{
			root1.left=constructBSTPreorder(pre, preIndex, pre[preIndex], minValue, i, size);
			root1.right=constructBSTPreorder(pre, preIndex, pre[preIndex], i, maxValue, size);
		}
	}
	return root1;
}

public void iterativePreorder()
{
	//iterativePreorder(root);
}
/*private void iterativePreorder(BSTNode root2) {
	if(root2==null)
		return;
	//Stack<BSTNode>stack = new Stack<BSTNode>(5);
	
	while(!stack.empty())
	{
		BSTNode node=stack.peek();
		System.out.println(node.getData());
		stack.pop();
		if(node.getRight()!=null)
		stack.push(node.right);
		if(node.getLeft()!=null)
		stack.push(node.left);	
	}
}*/
public void boundaryTraversal()
{
	boundaryTraversal(root);
}
private void boundaryTraversal(BSTNode root2) {
if(root2==null)
	return;
printBoundaryLeft(root2);
printLeaves(root2.left);
printLeaves(root2.right);
printBoundaryRight(root2);
	
}
public void printBoundaryLeft(BSTNode root)
{
    if (root!=null)
    {
        if (root.getLeft()!=null)
        {
            // to ensure top down order, print the node
            // before calling itself for left subtree
           System.out.println(root.getData());
            printBoundaryLeft(root.left);
        }
        else if( root.getRight()!=null )
        {
           System.out.println(root.getData());
            printBoundaryLeft(root.right);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
}
public void printBoundaryRight(BSTNode root)
{
    if (root!=null)
    {
        if (root.getRight()!=null)
        {
            // to ensure top down order, print the node
            // before calling itself for left subtree
           System.out.println(root.getData());
            printBoundaryRight(root.right);
        }
        else if( root.getLeft()!=null )
        {
           System.out.println(root.getData());
            printBoundaryRight(root.left);
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    }
}
public void printLeaves(BSTNode root)
{
	if (root!=null)
    {
		printLeaves(root.left);
    	
            // to ensure top down order, print the node
            // before calling itself for left subtree
    	if(root.left==null &&root.right==null)
           System.out.println(root.getData());
    	printLeaves(root.right);
            
        }
        // do nothing if it is a leaf node, this way we avoid
        // duplicates in output
    
}
public void isPresent()
{
	isPresent(root,11);
}
private void isPresent(BSTNode root2, int i) {

	Stack s1=new Stack(100);
	Stack s2=new Stack(100);
	 boolean done1 = false, done2 = false;
	    int val1 = 0, val2 = 0;
	BSTNode curr1=root2;
	BSTNode curr2=root2;
	while(true)
	{
		while(done1==false)
		{
			if(curr1!=null)
			{
				
			}
		}
	}
}

public boolean checkAllLeaves()
{
	int level=0;
	int leafLevel=0;
	return checkAllLeaves(root,level,leafLevel);
}
private boolean checkAllLeaves(BSTNode root2, int level, int leafLevel) {
if(root2==null)
	return false;
  if(root2.getLeft()==null && root2.getRight()==null)
  {
	  if(leafLevel==0)
	  {
		  leafLevel=level;
	  return true;
	  }
	  return (level==leafLevel);
  }
  return checkAllLeaves(root2.left, level+1, leafLevel)&& checkAllLeaves(root2.right, level+1, leafLevel);
  
  }
	


}

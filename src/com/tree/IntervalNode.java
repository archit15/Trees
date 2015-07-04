package com.tree;

public class IntervalNode {
	Interval i;
	int max;
	IntervalNode left,right;
	public IntervalNode newNode(Interval i)
	{
		IntervalNode temp=new IntervalNode();
		temp.i=new Interval();
		temp.max=i.high;
		temp.left=temp.right=null;
		return temp;
	}

	public IntervalNode insert(IntervalNode root,Interval i)
	{
		if(root==null)
			return newNode(i);
		int l=root.i.low;
		if(i.low<l)
			root.left=insert(root.left, i);
		else
			root.right=insert(root.right, i);
		if(root.max<i.high)
			root.max=i.high;
		return root;
		
	}
	public boolean doOverlap(Interval i1,Interval i2)
	{
		if (i1.low < i2.high && i2.low < i1.high)
	        return true;
	    return false;
		
		
	}
	
	public Interval overlapSearch(IntervalNode root,Interval i)
	{
		if(root==null)
			return null;
		if(doOverlap(root.i, i))
			return root.i;
		if (root.left != null && root.left.max >= i.low)
	        return overlapSearch(root.left, i);
		return overlapSearch(root.right, i);
	}
	
	public void printConflicting(Interval arr[],int n)
	{
		 IntervalNode root = null;
	     root = insert(root, arr[0]);
	     for(int i=1;i<n;i++)
	     {
	    	 Interval i1=overlapSearch(root, arr[i]);
	    	 if(i1!=null)
	    	 {
	    		 System.out.println(arr[i].low + ""+ arr[i].high + "Conflicts with" +"" + i1.low+ ""+i1.high);
	    	 }
	    	 root=insert(root, arr[i]);
	     }
	}
	public static void main(String args[])
	{
		 Interval appt[] =new Interval[5];
		 appt[0]=new Interval();
		 appt[0].low=2;
		 appt[0].high=5;
		 IntervalNode n=new IntervalNode();
		 n.printConflicting(appt, appt.length);
	}
}

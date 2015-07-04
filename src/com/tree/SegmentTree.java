package com.tree;

public class SegmentTree {
	static int []st;
	
	public static int getMid(int s, int e) {  return s + (e -s)/2;  }
	public static int getSumUtil(int ss, int se, int qs, int qe, int index)
	{
	    // If segment of this node is a part of given range, then return the 
	    // sum of the segment
	    if (qs <= ss && qe >= se)
	        return st[index];
	 
	    // If segment of this node is outside the given range
	    if (se < qs || ss > qe)
	        return 0;
	 
	    // If a part of this segment overlaps with the given range
	    int mid = getMid(ss, se);
	    return getSumUtil(ss, mid, qs, qe, 2*index+1) +
	           getSumUtil(mid+1, se, qs, qe, 2*index+2);
	}

	public static  int[] constructST(int arr[], int n)
	{
	    // Allocate memory for segment tree
	    int x = (int)(Math.ceil(Math.log(n))); //Height of segment tree
	    int max_size = 2*(int)Math.pow(2, x) - 1; //Maximum size of segment tree
	    st = new int[max_size];
	 
	    // Fill the allocated memory st
	    constructSTUtil(arr, 0, n-1,0);
	 
	    // Return the constructed segment tree
	    return st;
	}
	public static int constructSTUtil(int arr[], int ss, int se,int si)
	{
	    // If there is one element in array, store it in current node of
	    // segment tree and return
	    if (ss == se)
	    {
	        st[si] = arr[ss];
	        return arr[ss];
	    }
	 
	    // If there are more than one elements, then recur for left and
	    // right subtrees and store the sum of values in this node
	    int mid = getMid(ss, se);
	    st[si] =  constructSTUtil(arr, ss, mid, si*2+1) +
	              constructSTUtil(arr, mid+1, se, si*2+2);
	    return st[si];
	}
	public static int getSum(int n, int qs, int qe)
	{
	    // Check for erroneous input values
	    if (qs < 0 || qe > n-1 || qs > qe)
	    {
	       System.out.println("Invalid input");
	        return -1;
	    }
	 
	    return getSumUtil(0, n-1, qs, qe, 0);
	}
	void updateValue(int arr[],int n, int i, int new_val)
	{
	    // Check for erroneous input index
	    if (i < 0 || i > n-1)
	    {
	       System.out.println("Invalid input");
	        return;
	    }
	 
	    // Get the difference between new value and old value
	    int diff = new_val - arr[i];
	 
	    // Update the value in array
	    arr[i] = new_val;
	 
	    // Update the values of nodes in segment tree
	    updateValueUtil(0, n-1, i, diff, 0);
	}
	void updateValueUtil(int ss, int se, int i, int diff, int index)
	{
	    // Base Case: If the input index lies outside the range of this segment
	    if (i < ss || i > se)
	        return;
	 
	    // If the input index is in range of this node, then update the value
	    // of the node and its children
	    st[index] = st[index] + diff;
	    if (se != ss)
	    {
	        int mid = getMid(ss, se);
	        updateValueUtil(ss, mid, i, diff, 2*index + 1);
	        updateValueUtil(mid+1, se, i, diff, 2*index + 2);
	    }
	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
	 
	    // Build segment tree from given array
	    int []st = constructST(arr,arr.length-1);
	 
	    // Print sum of values in array from index 1 to 3
	    System.out.println("Sum of values in given range = %d\n"+getSum(arr.length-1, 1, 3));
	}
}

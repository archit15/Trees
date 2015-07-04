package com.tree;

public class Heap {
	private static int[] arr;
    private int size;
    private int maxsize;
    private static int N;
    
    public Heap(int maxsize)
    {
        this.maxsize = maxsize;
        this.size = 0;
        arr = new int[this.maxsize + 1];
        arr[0] = Integer.MAX_VALUE;
    }
	private int parent(int pos)
    {
        return pos / 2;
    }
 
    private int leftChild(int pos)
    {
        return (2 * pos);
    }
 
    private int rightChild(int pos)
    {
        return (2 * pos) + 1;
    }
 
    private boolean isLeaf(int pos)
    {
        if (pos >=  (size / 2)  &&  pos <= size)
        {
            return true;
        }
        return false;
    }
 
    private static void swap(int fpos,int spos)
    {
        int tmp;
        tmp = HeapArr[fpos];
        HeapArr[fpos] = HeapArr[spos];
        HeapArr[spos] = tmp;
    }
    public static void heapify(int arr[])
    {
        N = arr.length-1;
        for (int i = N/2; i >= 0; i--)
            maxheap(arr, i);
        
        for(int i=0;i<arr.length;i++)
        	System.out.println(arr[i]);
    }
    /* Function to swap largest element in heap */        
    public static void maxheap(int arr[], int i)
    { 
        int left = 2*i ;
        int right = 2*i + 1;
        int max = i;
        if (left <= N && arr[left] > arr[i])
            max = left;
        if (right <= N && arr[right] > arr[max])        
            max = right;
 
        if (max != i)
        {
            swap(i, max);
            maxheap(arr, max);
        }
    }    
 public static void main(String[] args) {
	Heap hp=new Heap(5);
	//arr={2,3,5,4,6};
	hp.heapify(arr);
}

}

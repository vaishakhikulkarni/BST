/*
 * Vaishakhi Kulkarni
 * Net Id: vpk140230
 */

//package DAY1;
import java.util.LinkedList;

public class BST<T extends Comparable<? super T>> {
    T data;
    BST<T> left, right;
    
    //parameterized constructor
    BST(T x)	
    {
    	data = x;
    	left = null;
    	right = null;
    }
    
    //default constructor
    BST()
    {
    	data = null;
    	left=null;
    	right=null;
    }
    
    /** return a balanced binary search tree using elements of sorted subarray arr[p..r] */
    public static<E extends Comparable<? super E>> BST<E> buildBST(E[] arr, int p, int r) {
    	
    	if(p > r)	// to check whether p > r
    		return null;
    	
    		int mid = (p+r) >>> 1; //find the mid of array
    		BST<E> node = new BST<E>(arr[mid]);  //create a node
    		node.left = buildBST(arr,p,mid-1);	//move left side
    		node.right = buildBST(arr,mid+1,r); //move right side
    	return node;
    }

    /** return a balanced binary search tree using elements of sorted list */
    public static<E extends Comparable<? super E>> BST<E> buildBST(LinkedList<E> lst) {
    	
    	if(lst.size()==0) //if size is zero return null
    		return null;
    	
    	int mid = lst.size() >>> 1;//find the mid of list
    	BST<E> node = new BST<E>(lst.get(mid)); //create a node
    	
    	LinkedList<E> list1 = new LinkedList<E>(); 
    	LinkedList<E> list2 = new LinkedList<E>();
    	
    	int i;
    	for(i=0;i<mid;i++)
    		list1.add(lst.get(i));
    	for(i=mid+1;i<lst.size();i++)
    		list2.add(lst.get(i));
    		
    	node.left = buildBST(list1);	//move left side
    	node.right = buildBST(list2); 	//move right side
    	
        return node; 	
    }
    
    // Inorder traversal to check the data
    public static void inorder(BST<Integer> root)
    {
    	if(root==null)
    		return;
    	inorder(root.left);
    	System.out.print("  "+root.data);
    	inorder(root.right);
    }
    
    public static void main(String args[])
    {
    	System.out.println("*****Array implementation*****");
    	System.out.println(" ");
    	Integer arr[] = {4,5,6,6,7,8,9,10};
    	int x = arr.length;
    	//Constructing tree from sorted list
    	BST<Integer> rootarray = buildBST(arr,0,x-1);
    	//Inorder Traversal
    	inorder(rootarray);
    	
    	System.out.println("\n ");
    	System.out.println("*****LinkedList implementation*****");
    	System.out.println(" ");
    	LinkedList<Integer> list = new LinkedList<Integer>(); 
    	list.add(4);
    	list.add(5);
    	list.add(6);
    	list.add(6);
    	list.add(7);
    	list.add(8);
    	list.add(9);
    	list.add(10);
     	//Constructing tree from linked list
    	BST<Integer> rootlist = buildBST(list);
    	//Inorder Traversal
    	inorder(rootlist);
    }
}

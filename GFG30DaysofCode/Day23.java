/*1. Lucy's Neighbours 
Medium Accuracy: 98.25% Submissions: 459 Points: 4
Lucy lives in house number X. She has a list of N house numbers in the society. Distance between houses can be determined by studying the difference between house numbers. Help her find out K closest neighbors.
Note: If two houses are equidistant and Lucy has to pick only one, the house with the smaller house number is given preference.

Example 1:

Input:
N = 5, X = 0, K = 4
a[] = {-21, 21, 4, -12, 20}, 
Output:
-21 -12 4 20
Explanation:
The closest neighbour is house
number 4. Followed by -12 and 20. -21 and 21 
are both equal distance from X=0. Therefore, 
Lucy can only pick 1. Based on the given 
condition she picks -21 as it is the smaller 
of the two. 
Example 2:

Input:
N = 6, X = 5, K = 3 
a[] = {10, 2, 14, 4, 7, 6},
Output:
4 6 7 
Your Task:  
You don't need to read input or print anything. Complete the function  Kclosest() which takes the array arr[], size of array N, X, and K as input parameters, and returns the list of numbers in sorted order.

Expected Time Complexity: O(NlogN)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ K ≤ N ≤ 105 
-104 ≤ X, arr[i] ≤ 104

Topic Tags
 Heap
 
 */
 //Back-end complete function Template for Java


class Info{
	int distance;
	int houseno;

	Info(int x,int y)
	{
		distance = x;
		houseno = y;
	}
}

class Compare implements Comparator<Info>{ 
	public int compare (Info p1,Info p2 )
	{
		if (p1.distance == p2.distance)	{
			if (p1.houseno < p2.houseno)
				return +1;
			if (p1.houseno > p2.houseno)
				return -1;
			return 0;
		}

		else {
		   	if (p1.distance < p2.distance)
				return +1;
			if (p1.distance > p2.distance)
				return -1;
			return 0;
		}
	}
}

class Solution 
{ 
	public  ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
		ArrayList<Integer> result= new ArrayList<Integer>();
		PriorityQueue<Info> pq = new PriorityQueue<Info>(k, new Compare()); 

		for (int i = 0; i < k; i++) 
		{
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj); 
		}

		for (int i = k; i < n; i++) 
		{ 
			int diff = Math.abs(arr[i] - x); 
			if (diff > pq.peek().distance) 
				continue; 

			if (diff == pq.peek().distance && arr[i] > pq.peek().houseno) 
				continue; 

			pq.remove();
			Info obj = new Info(Math.abs(arr[i] - x) , arr[i] );
			pq.add(obj);
		} 
		while (pq.size() >0) { 
			result.add(pq.peek().houseno);
			pq.remove();
		}
		Collections.sort(result);
		return result;
	}    
} 



//Initial Template for Java

import java.io.*;
import java.util.*; 
import java.lang.*;

 // } Driver Code Ends


//User function Template for Java

class Solution
{ 
	public ArrayList<Integer> Kclosest(int arr[], int n, int x, int k) 
	{ 
	    ArrayList<Integer> al=new ArrayList<>();
	    ArrayList<Integer> Al=new ArrayList<>();
	    Arrays.sort(arr);
	    //HashMap<Integer,Integer> hs=new HashMap<>();
	    int[] ar=new int[n];
	    for(int i=0;i<n;i++){
	        ar[i]=Math.abs(arr[i]-x);
	        Al.add(ar[i]);
	    }
	    Arrays.sort(ar);
	    for(int j=0;j<k;j++){
	        int pos=Al.indexOf(ar[j]);
	        if(al.contains(arr[pos])){
	            pos=Al.lastIndexOf(ar[j]);
	        }
	        al.add(arr[pos]);
	    }
	    Collections.sort(al);
	    return al;
	    
	}
}

// { Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int x = sc.nextInt();
        	int k = sc.nextInt();
        	int arr[] = new int[n];
        	for(int i=0; i<n; i++)
        	{
        		arr[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.Kclosest(arr,n,x,k);

            for (int i=0; i<ans.size(); i++) 
        	    System.out.print(ans.get(i)+" "); 
            System.out.println();
            t--;
        }
    } 
} 



  // } Driver Code Ends
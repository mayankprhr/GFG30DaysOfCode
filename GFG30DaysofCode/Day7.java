/*Given an array of size N, find the number of distinct pairs {a[i], a[j]} (i != j) in the array with their sum greater than 0.

Example 1:

Input: N = 3, a[] = {3, -2, 1}
Output: 2
Explanation: {3, -2}, {3, 1} are two 
possible pairs.
Example 2:

Input: N = 4, a[] = {-1, -1, -1, 0}
Output: 0
Explanation: There are no possible pairs.

*/
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int array[] = new int[n];
        	for (int i=0; i<n ;i++ ) {
        		array[i] = sc.nextInt();
        	}
            Solution ob = new Solution();
            System.out.println(ob.ValidPair(array,n));
            t--;
        }
    } 
} 


class Solution 
{ 
    static long ValidPair(int a[], int n) 
	{ 
	    // Your code goes here
	    
	    if (n==1)
	     return 0;
	     
	    long count=0;
	    int low =0;
	    int high=n-1;
	    Arrays.sort(a);
	    
	   while(low<high)
	   {
	       if (a[low]+a[high]>0)
	       {
	           count+=high-low;
	           high--;
	       }
	       else
	        low++;
	   }
	    return count;
	}
} 


//Solution provided
class Solution 
{ 
    static int lowerBound(int a[], int x)
    {
        int l = -1, r = a.length;
        while(l + 1 < r)
        {
            int m = (l+r)>>>1;
            
            if(a[m] >= x) 
                r = m;
            else 
                l = m;
        }
        return r;
    }

    static long ValidPair(int a[], int n) 
	{ 
	    Arrays.sort(a);
    	long ans = 0; 
    	for (int i = 0; i < n; ++i) { 
    		if (a[i] <= 0) 
    			continue; 
    		// search for first element >= (-a[i] + 1)
    		int j = lowerBound(a, -a[i] + 1);
    		ans += (i - j); 
    	} 
    	return ans; 
	}
} 

/*
In Geekland there is a grid of coins of size N x N. You have to find the maximum sum of coins in any sub-grid of size K x K.
Note: Coins of the negative denomination are also possible at Geekland.

Example 1:

Input: N = 5, K = 3 
mat[[]] = {1, 1, 1, 1, 1} 
          {2, 2, 2, 2, 2} 
          {3, 8, 6, 7, 3} 
          {4, 4, 4, 4, 4} 
          {5, 5, 5, 5, 5}
Output: 48
Explanation: {8, 6, 7}
             {4, 4, 4}
             {5, 5, 5}
has the maximum sum

Example 2:

Input: N = 1, K = 1
mat[[]] = {{4}} 
Output: 4
Your Task:  
You don't need to read input or print anything. Complete the function Maximum_Sum() which takes the matrix mat[], size of Matrix N, and value K as input parameters and returns the maximum sum.

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N2)

Constraints:
1 ≤ K ≤ N ≤ 103
-5*105 ≤ mat[i][j] ≤ 5*105


import java.io.*;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int a[][] = new int[n][n];
		    
		    for(int i=0;i<n;i++)
		    {
		        for(int j=0;j<n;j++)
		        {
		            a[i][j] = Integer.parseInt(sc.next());
		        }
		    }
		    
		    int k = Integer.parseInt(sc.next());
		    Solution T = new Solution();
		    System.out.println(T.Maximum_Sum(a,n,k));
		}
	}
}// } Driver Code Ends
*/

import java.io.*;
import java.util.*;

public class Main
{
  public static void main (String[]args)
  {

    //Scanner sc = new Scanner (System.in);
    //int t = Integer.parseInt (sc.next ());
    //while (t-- > 0)
     // {
	//int n = Integer.parseInt (sc.next ());
	int n=5;
	//int a[][] = new int[n][n];
	 int a[][]={{1, 1, 1, 1, 1},{2, 2, 2, 2, 2},{3, 8, 6, 7, 3},{4, 4, 4, 4, 4},{5, 5, 5, 5, 5},};

	Solution T = new Solution ();
	
	System.out.println (T.Maximum_Sum (a, n, 3));
  }
}				// } Driver Code Ends


class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        // Your code goes here
        
        
        int res=0;
        int startrow=0;
        int startcol=0;
        //int[][] stripSum = new int[N][N];
        while(startcol<=(N-K))
    {
            while(startrow<=(N-K))
        {
        //{
            int sum=0;
            for (int i=startrow;i<startrow+K;i++)
            {
                for (int j=startcol;j<startcol+K;j++)
                {
                    sum+=mat[i][j];
                }
            }
            if (res<sum)
                res=sum;
        
             startrow++;
        }    
        startcol++;
        startrow=0;
        
    }
    
        return res;        
    }        
        
}
/*
5
1 1 1 1 1
2 2 2 2 2
3 8 6 7 3
4 4 4 4 4
5 5 5 5 5
3
*/


//Solution provided
class Solution
{
    public int Maximum_Sum(int mat[][],int N,int K){
        
        int stripSum[][] = new int[N][N],sum = 0; 
            
            
        for(int j=0;j<N;j++) 
        { 
            sum = 0;
            
            for (int i=0; i<K; i++) 
                sum += mat[i][j]; 
            
            stripSum[0][j] = sum; 
    
            for (int i=1; i<N-K+1; i++) 
            { 
                sum += (mat[i+K-1][j] - mat[i-1][j]); 
                stripSum[i][j] = sum; 
            } 
        } 
        
        int max_sum = Integer.MIN_VALUE; 
        for (int i=0; i<N-K+1; i++) 
        { 
            sum = 0; 
            for (int j = 0; j<K; j++) 
                sum += stripSum[i][j];
                
            if (sum > max_sum) 
                max_sum = sum;
    
            for (int j=1; j<N-K+1; j++) 
            { 
                sum += (stripSum[i][j+K-1] - stripSum[i][j-1]);
                if (sum > max_sum) 
                    max_sum = sum;
            } 
        }
        
        return max_sum;
    }
}

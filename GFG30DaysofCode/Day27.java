/*

1. Police and Thieves 
Medium Accuracy: 87.49% Submissions: 604 Points: 4
Given an array of size n such that each element contains either a 'P' for policeman or a 'T' for thief. Find the maximum number of thieves that can be caught by the police. 
Keep in mind the following conditions :

Each policeman can catch only one thief.
A policeman cannot catch a thief who is more than K units away from him.
Example 1:

Input:
N = 5, K = 1
arr[] = {P, T, T, P, T}
Output: 2
Explanation: Maximum 2 thieves can be 
caught. First policeman catches first thief 
and second police man can catch either second 
or third thief.
Example 2:

Input:
N = 6, K = 2
arr[] = {T, T, P, P, T, P}
Output: 3
Explanation: Maximum 3 thieves can be caught.
Your Task:  
You dont need to read input or print anything. Complete the function catchThieves() that takes n, k and arr[ ] as input parameters and returns the maximum number of thieves that can be caught by the police. 

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ n ≤ 105
1 ≤ k ≤ 100
arr[i] = 'P' or 'T'

Company Tags
Topic Tags
 Greedy

If you are facing any issue on this page. Please let us know.



Test against custom input
  


*/


//Back-end complete function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
		int result = 0; 
		ArrayList<Integer> thief = new ArrayList<Integer>(); 
		ArrayList<Integer> police = new ArrayList<Integer>(); 

		for (int i = 0; i < n; i++) { 
			if (arr[i] == 'P') 
			police.add(i); 
			else if (arr[i] == 'T') 
			thief.add(i); 
		} 

		// track lowest current indices of 
        // thief: thi[l], police: pol[r] 
		int l = 0, r = 0; 
		while (l < thief.size() && r < police.size()) { 
			// can be caught
			if (Math.abs(thief.get(l) - police.get(r)) <= k) { 
				result++; 
				l++; 
				r++; 
			} 
			else if (thief.get(l) < police.get(r)) 
				l++; 
			else
				r++; 
		} 
		return result; 
	} 
} 


//Initial Template for Java

import java.io.*;
import java.util.*; 


 // } Driver Code Ends


//User function Template for Java

class Solution 
{ 
    static int catchThieves(char arr[], int n, int k) 
	{ 
       int count=0;
       
       for(int i=0;i<n;i++){
           if(arr[i]=='P'){
               int j=Math.max(0,i-k);
               boolean flag=true;
               for(int m=j;m<i;m++)
               {
                   if(arr[m]=='T')
                   {
                       arr[m]='U';
                       count++;
                       flag=false;
                   break;
                    }
               }
               if(flag)
        {
            j=Math.min(i+k,n-1);
                for(int m=i+1;m<=j;m++)
             {
               if(arr[m]=='T')
               {
                   arr[m]='U';
                   count++;
                   flag=false;
                   break;
                 }
            }
                
        }
    }
}
           
       
       return count;
	} 
} 



// { Driver Code Starts.
class GFG{
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0)
        {
            int n = sc.nextInt();
            int k = sc.nextInt();
			char arr[] = new char[n];
			for(int i=0; i<n; i++)
         		arr[i] = sc.next().charAt(0);

			Solution ob = new Solution();
            System.out.println(ob.catchThieves(arr, n, k));
            t--;
        }
    }
}         // } Driver Code Ends
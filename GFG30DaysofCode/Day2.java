//Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 .

/*

Given a positive integer N. You have to find Nth natural number after removing all the numbers containing digit 9 .


Example 1:

Input:
N = 8
Output:
8
Explanation:
After removing natural numbers which contains
digit 9, first 8 numbers are 1,2,3,4,5,6,7,8
and 8th number is 8.
Example 2:

Input:
N = 9
Output:
10
Explanation:
After removing natural numbers which contains
digit 9, first 9 numbers are 1,2,3,4,5,6,7,8,10
and 9th number is 10.
 

Your Task:
You don't need to read input or print anything. Complete the function findNth() which accepts an integer N as input parameter and return the Nth number after removing all the numbers containing digit 9.


Expected Time Complexity: O(logN)
Expected Auxiliary Space: O(1)
**/
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0)
		{
		    long n=ob.nextLong();
		    Solution ab=new Solution();
		    long k=ab.findNth(n);
		    System.out.println(k);
		}
	}
}

    
// } Driver Code Ends

Solution1:
class Solution {
    long findNth(long N)
    {
        long ans=0;
        long mul=1;
        
        while (N!=0)
        {
            long dig=N%9;
            N=N/9;
            ans+=(mul*dig);
            mul=mul*10;
        }
        
        return ans;
    }

}


Solution2:
//Back-end complete function Template for Java
class Solution {
    // function to change N
    // from base10 to base9
    long findNth(long N)
    {
        String s="";
        // taking remainders by 9
        // till N become 0
        while(N!=0)
        {
            s=(char)(N%9+'0')+s;
            N=N/9;
        }
        return Long.parseLong(s);
    }
}
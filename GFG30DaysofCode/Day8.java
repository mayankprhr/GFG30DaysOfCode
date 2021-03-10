
/*Geek wants to make a special space for candies on his bookshelf. Currently, it has N books of different heights and unit width. Help him select 2 books such that he can store maximum candies between them by removing all the other books from between the selected books. The task is to find out the area between 2 books that can hold the maximum candies without changing the original position of selected books. 

Example 1:

Input: N = 3, height[] = {1, 3, 4}
Output: 1
Explanation:
1. Area between book of height 1 and book of 
height 3 is 0 as there is no space between 
them.
2. Area between book of height 1 and book of 
height 4 is 1 by removing book of height 3.
3. Area between book of height 3 and book of 
height 4 is 0 as there is no space between them.

Example 2:

Input: N = 6, height[] = {2, 1, 3, 4, 6, 5}
Output: 8
Explanation: We remove the 4 books in the middle 
creating length = 4 for the candy dam. Height 
for dam will be min(2,5) = 2. Area between book 
of height 2 and book of height 5 is 2 x 4 = 8.
Your Task:  
You don't need to read input or print anything. Complete the function maxCandy() which takes the array height[] and size of array N as input parameters and returns the maximum candies geek can store

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)
*/


import java.io.*;
import java.util.*; 

class Solution { 
	static int maxCandy(int height[], int n) 
	{ 

		// To store the maximum water so far 
		int max = 0; 

		// Both the pointers are pointing at the first 
		// and the last buildings respectively 
		int i = 0, j = n - 1; 

		// While the water can be stored between 
		// the currently chosen buildings 
		while (i < j) { 

			// Update maximum water so far and increment i 
			if (height[i] < height[j]) { 
				max = Math.max(max, (j - i - 1) * height[i]); 
				i++; 
			} 

			// Update maximum water so far and decrement j 
			else if (height[j] < height[i]) { 
				max = Math.max(max, (j - i - 1) * height[j]); 
				j--; 
			} 

			// Any of the pointers can be updated (or both) 
			else { 
				max = Math.max(max, (j - i - 1) * height[i]); 
				i++; 
				j--; 
			} 
		} 

		return max; 
	} 
}

class GFG{
	public static void main(String[] args) 
	{ 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            int n = sc.nextInt();
            int height[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                height[i] = sc.nextInt();
            }

            Solution ob = new Solution();
            System.out.println(ob.maxCandy(height,n));
            t--;
        }
	} 
} 


class Solution 
{ 
	static int maxCandy(int height[], int n) 
	{ 
	    // Your code goes here
	   if (n<=1)
	        return 0;
	        
	   if (n==2)
	    return 0;
	    
	   int area=0;
	   int p1=0;
	   int p2=n-1;
	   
	   while (p1<p2)
	   {
	       
	       area=Math.max(area,Math.min(height[p1],height[p2]) * (p2-p1-1));
	       if(height[p1]<height[p2])
	        p1++;
	        
	       else
	        p2--;
	       
	   }
        
        return area;
	   
	}
}
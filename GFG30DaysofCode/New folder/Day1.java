/*
1. Rearrange Geek and his Classmates 
Easy Accuracy: 60.9% Submissions: 7110 Points: 2
Geek and his classmates are playing a prank on their Computer Science teacher. They change places every time the teacher turns to look at the blackboard. 

Each of the N students in the class can be identified by a unique roll number X and each desk has a number i associated with it. Only one student can sit on one desk. 
Each time the teacher turns her back, a student with roll number X sitting on desk number i gets up and takes the place of the student with roll number i.

If the current position of N students in the class is given to you in an array, such that i is the desk number and a[i] is the roll number of the student sitting on the desk, can you modify a[ ] to represent the next position of all the students ? 


Example 1:

Input:
N = 6
a[] = {0, 5, 1, 2, 4, 3}
Output: 0 3 5 1 4 2
Explanation: After reshuffling, the modified 
position of all the students would be 
{0, 3, 5, 1, 4, 2}.

Example 2:

Input:
N = 5
a[] = {4, 3, 2, 1, 0}
Output: 0 1 2 3 4 
Explanation: After reshuffling, the modified 
position of all the students would be 
{0, 1, 2, 3, 4}.

Your Task:  
You dont need to read input or print anything. Complete the function prank() which takes the array a[ ] and its size N as input parameters and modifies the array in-place to reflect the new arrangement.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(1)

*/
//Initial Template for Java
import java.io.*;
import java.util.*; 
public class Day1{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            int n = Integer.parseInt(read.readLine());
            
            String input_line[] = read.readLine().trim().split("\\s+");
            long a[]= new long[n];
            for(int i = 0; i < n; i++)
                a[i] = Long.parseLong(input_line[i]);

            Solution ob = new Solution();
            ob.prank(a, n); 

            for (int i=0;i<n;i++) 
                System.out.print(a[i]+" "); 
            System.out.println();
        }
    } 
} // } Driver Code Ends

class Solution
{
	void prank(long [] a, int N)
	{
		long [] b= new long [N];
		
		for (int i=0;i<N;i++)
		{
			int X= (int)a[i];
			b[i]=a[X];
		}
		
		for (int i=0;i<N;i++)
			a[i]=b[i];
	}
}
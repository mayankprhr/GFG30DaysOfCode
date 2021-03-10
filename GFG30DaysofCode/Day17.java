/*Help Classmates 
Medium Accuracy: 100.0% Submissions: 693 Points: 4
Professor X wants his students to help each other in the chemistry lab. He suggests that every student should help out a classmate who scored less marks than him in chemistry and whose roll number appears after him. But the students are lazy and they don't want to search too far. They each pick the first roll number after them that fits the criteria. Find the marks of the classmate that each student picks.
Note: one student may be selected by multiple classmates.

Example 1:

Input: N = 5, arr[] = {3, 8, 5, 2, 25}
Output: 2 5 2 -1 -1
Explanation: 
1. Roll number 1 has 3 marks. The first person 
who has less marks than him is roll number 4, 
who has 2 marks.
2. Roll number 2 has 8 marks, he helps student 
with 5 marks.
3. Roll number 3 has 5 marks, he helps student 
with 2 marks.
4. Roll number 4 and 5 can not pick anyone as 
no student with higher roll number has lesser 
marks than them. This is denoted by -1.
Output shows the marks of the weaker student that 
each roll number helps in order. ie- 2,5,2,-1,-1

Example 2:

Input: N = 4, a[] = {1, 2, 3, 4}
Output: -1 -1 -1 -1 
Explanation: As the marks ars in increasing order. 
None of the students can find a classmate who has 
a higher roll number and less marks than them.
Your Task:  
You don't need to read input or print anything. Complete the function help_classmate() which takes the array arr[] and size of array N as input parameters and returns a list of numbers. If a student is unable to find anyone then output is -1.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 106

*/


import java.util.*; 
import java.io.*; 

class GFG 
{ 
	public static void main (String[] args) { 
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
            int array[] = new int[n];
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }

            Solution ob = new Solution();

            int ans[] = ob.help_classmate(array,n);

           	for (int i=0; i<n; i++) 
                System.out.print(ans[i]+" "); 
            System.out.println();
            t--;
        }
	} 
} 

// } Driver Code Ends


//User function Template for Java

class Solution {
	public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    
	    //List<Integer> res=new ArrayList<>();
	    
	   /* int [] ans=new int [n];
	    
	    for(int i=0;i<n;i++)
	    {
	        for (int j=i+1;j<n;j++)
	        {
	            if (arr[i]>arr[j])
	            {
	                ans[i]=arr[j];
	                break;
	            }
	            else
	                ans[i]=-1;
	        }
	    }
	    
	    ans[n-1]=-1;
	    return ans;
	    */

        Stack <Integer> s=new Stack<>();
        int res[]=new int [n];
        Arrays.fill(res,-1);
        for (int i=0;i<n;i++)
        {
            if(s.empty())
            {
                s.push(i);
                continue;
            }
            while (s.empty()==false && arr[s.peek()]> arr[i])
            {
                res[s.peek()]=arr[i];
                s.pop();
            }
            s.push(i);
        }
	    
	    return res;
	} 
}

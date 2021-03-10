/*Given two strings A and B, find the minimum number of times A has to be repeated such that B becomes a substring of the repeated A. If B cannot be a substring of A no matter how many times it is repeated, return -1.

Example 1:

Input: A = "abcd", B = "cdabcdab"
Output: 3
Explanation: After repeating A three times, 
we get "abcdabcdabcd".
Example 2:

Input: A = "aa", B = "a"
Output: 1
Explanation: B is already a substring of A.
Your Task:  
You don't need to read input or print anything. Complete the function repeatedStringMatch() which takes strings A and B as input parameters and returns the minimum number of operations to complete the task. If it is not possible then return -1.

Expected Time Complexity: O(|A| * |B|)
Expected Auxiliary Space: O(1)*/


import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t > 0){
            String A = sc.nextLine();
            String B = sc.nextLine();
            Solution ob = new Solution();
            System.out.println(ob.repeatedStringMatch(A,B));
            t--;
        }
    } 
} 
        

//My tried sol
class Solution 
{ 
	static int repeatedStringMatch(String A, String B) 
	{ 
        // Your code goes here
        int count=1;
        String str=A;
        //StringBuffer Asb=new StringBuffer (A);
        //StringBuffer Bsb=new StringBuffer (B);
            
        if (A.contains(B))
            return 1;
            
        else if (B.contains(A)!=true)
            return -1;    
        else
        {
            for(int i=0;i<B.length()/A.length();i++)
            {
                str+=str;
                count++;
            }
        }
        return count;
        
	}  
		
//providedsol		
static int repeatedStringMatch(String A, String B) 
	{ 
        // Your code goes here		
        String strA=A;
        int blen=B.length()/A.length();
        int count=1;
        for (int i=0;i<blen+2;i++)
        {
            if(A.contains(B))
            return count;
            
            else
            {
                A+=strA;
                count++;
            }
        }
        return -1;*/
	} 
} 


//GFGSol

class Solution 
{ 
	static boolean issubstring(String str2, String rep1) 
	{ 
		int M = str2.length(); 
		int N = rep1.length(); 

		for (int i = 0; i <= N - M; i++) 
		{ 
			int j; 
			for (j = 0; j < M; j++) 
				if (rep1.charAt(i + j) != str2.charAt(j)) 
					break; 
			if (j == M) 
				return true; 
		}
		return false; 
	} 

	static int repeatedStringMatch(String A, String B) 
	{ 
		int ans = 1; 
		String S = A; 
		
		while(S.length() < B.length()) 
		{ 
			S += A; 
			ans++; 
		} 
		 
		if (issubstring(B, S)) return ans; 
		if (issubstring(B, S + A)) 
			return ans + 1; 
		return -1; 
	} 
} 

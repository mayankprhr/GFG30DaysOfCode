/*Professor McGonagall teaches transfiguration at Hogwarts. She has given Harry the task of changing himself into a cat. She explains that the trick is to analyze your own DNA and change it into the DNA of a cat. The transfigure spell can be used to pick any one character from the DNA string, remove it and insert it in the beginning. 
Help Harry calculates minimum number of times he needs to use the spell to change himself into a cat.

Example 1:

Input: 
A = "GEEKSFORGEEKS" 
B = "FORGEEKSGEEKS"
Output: 3
Explanation:The conversion can take place 
in 3 operations:
1. Pick 'R' and place it at the front, 
   A="RGEEKSFOGEEKS"
2. Pick 'O' and place it at the front, 
   A="ORGEEKSFGEEKS"
3. Pick 'F' and place it at the front, 
   A="FORGEEKSGEEKS"
Example 2:

Input: 
A = "ABC" 
B = "BCA"
Output: 2
Explanation: The conversion can take place 
in 2 operations:
1. Pick 'C' and place it at the front, 
   A = "CAB"
2. Pick 'B' and place it at the front, 
   A = "BCA"
Your Task:  
You don't need to read input or print anything. Complete the function transfigure() which takes strings A and B as input parameters and returns the minimum number of spells needed. If it is not possible to convert A to B then return -1.

Expected Time Complexity: O(max(|A|, |B|))
Expected Auxiliary Space: O(1)
*/

//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            BufferedReader br = new BufferedReader( new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            while(t-->0)
                {
                    String arr[] = br.readLine().split(" ");
                    String A = arr[0];
                    String B = arr[1];
                    Solution obj = new Solution();
                    System.out.println(obj.transfigure (A, B));
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    int transfigure (String A, String B)
    {
    	// Your code goes here.
    	/*char[] Ach = A.toCharArray();
    	char[] Bch = B.toCharArray();
    	
    	HashMap<Character,Integer> hmA=new HashMap <>();
    	HashMap<Character,Integer> hmB=new HashMap <>();
    	for (char c: Ach)
    	{
    	   if(hmA.containsKey(c))
    	    {
    	        hmA.put(c,hmA.get(c)+1);
    	    }
    	    
    	   else 
    	        hmA.put(c,1);
    	}
    	
    	for (char c: Bch)
    	{
    	    if(hmA.containsKey(c))
    	    {
    	        hmA.put(c,hmB.get(c)+1);
    	    }
    	    
    	   else 
    	        hmA.put(c,1);
    	}
    	
    	int aLast=A.length()-1;
    	int bLast=B.length()-1;
    	*/
    	int n=A.length()-1;int m=B.length()-1;
/*Below line checks whether every character in string A is in String B or not*/ 
if(!Arrays.equals(A.chars().sorted().toArray(),B.chars().sorted().toArray()))
          return -1;
    	int ans=0;
    	while(n>=0)
    	{
    	    if(A.charAt(n)==B.charAt(m))
    	    {
    	        m--;
    	        ans++;
    	    }
    	    n--;
    	}
    	return A.length()-ans;
    }
}

class Solution
{
    
    int transfigure (String A, String B)
    {
    	if (A.length () != B.length ())
    	{
    		return -1;
    	}
        
        HashMap<Character,Integer> m = new HashMap<Character,Integer>();
    	int n = A.length ();
    	for	(int i = 0; i < n; i++)
	    {
	        if(m.containsKey(A.charAt(i)))
	            m.put(A.charAt(i), m.get(A.charAt(i)) + 1);
	        else
	            m.put(A.charAt(i),1);
	    }
    
    	for(int i = 0; i < n; i++)
	    {
	        if(m.containsKey(B.charAt(i)))
	            m.put(B.charAt(i),m.get(B.charAt(i)) - 1 );
	    }
    	
        
        for(Map.Entry<Character,Integer> entry : m.entrySet())
        {
            if (entry.getValue() != 0)
			    return -1;
        }
    	
    	int i = n - 1, j = n - 1;
    	int res = 0;
    	while (i >= 0 && j >= 0)
    	{
    		while (i >= 0 && A.charAt(i) != B.charAt(j))
    		{
    			i--;
    			res++;
    		}
    
    		i--;
    		j--;
    	}
    
    	return res;
    }
}
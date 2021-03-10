/*
1. Secret Cipher 
Hard Accuracy: 100.0% Submissions: 925 Points: 8
Geek wants to send an encrypted message in the form of string S to his friend Keeg along with instructions on how to decipher the message. To decipher the message, his friend needs to iterate over the message string from left to right, if he finds a '*', he must remove it and add all the letters read so far to the string. He must keep on doing this till he gets rid of all the '*'.
Can you help Geek encrypt his message string S? 

Note: If the string can be encrypted in multiple ways, find the smallest encrypted string. 

Example 1:

Input: S = "ababcababcd"
Output: ab*c*d
Explanation: We can encrypt the string 
in following way : "ababcababcd" -> 
"ababc*d" -> "ab*c*d"
Example 2:

Input: S = "zzzzzzz"
Output: z*z*z
Explanation: The string can be encrypted 
in 2 ways: "z*z*z" and "z**zzz". Out of 
the two "z*z*z" is smaller in length.
Your Task: 
You don't need to read input or print anything. Complete the function secretCipher() which takes the message string S as input parameter and returns the shortest possible encrypted string.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints: 
1 ≤ |S| ≤ 105
*/


//Back-end complete function Template for Java
/*
class Solution {
	void fillArray(String s, int[] a) {
		a[0] = 0;
		for (int i = 1; i<s.length(); i++) {
			int series = a[i - 1];
			while (series > 0) {
				if (s.charAt(series) == s.charAt(i)) {
					a[i] = series + 1;
					break;
				}
				series = a[series - 1];
			}
			if (series == 0) {
				if (s.charAt(i) == s.charAt(0))
					a[i] = 1;
				else
					a[i] = 0;
			}
		}
	}
	public String compress(String s) {
		int[] a = new int[s.length()];
		
		// ith element of array a stores the length of longest
        // proper suffix which is also a proper prefix
        // for substr s[0] to s[i]
		fillArray(s, a);

		Stack<Character> shortened = new Stack<Character>();
		
        // for even index, string length is odd
        // hence it cannot be divided into two
        // so we simply push ith character in stack
		for (int i = s.length() - 1; i > 0; i--) {
			if (i % 2 == 0) {
				shortened.push(s.charAt(i));
				continue;
			}
            // star_here will be made TRUE if substring s[0] to s[i]
            // can be divided into identical halves
			boolean star_here = false;
			
			// suffix and substring length are also meant for
            // substring s[0] to s[i]
			int suffix = a[i];
			int substrlen = i + 1;
            
            // these conditions, if true, imply that, substring
            // can be divided into 2 identical halves
			if (suffix * 2 >= substrlen)
				if (substrlen % (substrlen - suffix) == 0)
					if ((substrlen / (substrlen - suffix)) % 2 == 0)
						star_here = true;
            
            // adding * to stack and moving index as required
			if (star_here == true) {
				shortened.push('*');
				i = i / 2 + 1;
			} 
			
            // else, simply adding character to stack
			else
				shortened.push(s.charAt(i));
		}

		StringBuilder ret = new StringBuilder();
		ret.append(s.charAt(0));

        // since we analysed input string from end to start
        // removing elements from stack and pushing back to
        // output string will reverse them back to required order
		while (!shortened.empty()) {
			ret.append(shortened.peek());
			shortened.pop();
		}

		return ret.toString();
	}
}

*/


//Initial Template for Java
import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		while (tc--> 0) {
			String s = br.readLine().trim();
			Solution sln = new Solution();
			String ans = sln.compress(s);
			System.out.println(ans);
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    
	public String compress(String s) {
		
		StringBuilder result = new StringBuilder();
		int sLen = s.length();
		int suffix[] = new int[sLen];
		fill(s,suffix);
		
		Stack<Character> datas = new Stack<>();
		
		for(int i=sLen-1;i>0;i--){
		    
		    if(i%2==0){
		        datas.push(s.charAt(i));
		        continue;
		    }
		    
		    int suffixLen = suffix[i];
		    int subStrLen = i+1;
		    
		    boolean isFound = false;
		    
		    if(2*suffixLen>=subStrLen){
		        if((subStrLen)%(subStrLen-suffixLen)==0){
		            if(((subStrLen)/(subStrLen-suffixLen))%2==0){
		                isFound=true;
		            }
		        }
		    }
		    
		    if(isFound){
		        datas.push('*');
		        i=i/2+1;
		    }else{
		       datas.push(s.charAt(i));  
		    }
		  
		}
		
		datas.push(s.charAt(0));
		
		while(!datas.isEmpty()){
		    result.append(datas.pop());
		}
		
		return result.toString();
	}
	
	private void fill(String s,int suffix[]){
	 
	    for(int i=1;i<s.length();i++){
	        
	        int series = suffix[i-1];
	        
	        while(series>0){
	            
	            if(s.charAt(series)==s.charAt(i)){
	                suffix[i]=series+1;
	                break;
	            }
	            series = suffix[series-1];
	        }
	        
	        if(series==0){
    	        if(s.charAt(i)==s.charAt(0)){
    	            suffix[i]=1;
    	        }else{
    	        }
    	            suffix[i]=0;
	        }
	    }
	    
	    //System.out.println(Arrays.toString(suffix));
	}
}


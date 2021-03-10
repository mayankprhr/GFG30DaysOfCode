Restrictive Candy Crush 
Medium Accuracy: 93.79% Submissions: 1266 Points: 4
Given a string S and an integer K, the task is to reduce the string by applying the following operation:
Choose a group of K consecutive identical characters and remove them. The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
K = 2
S = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geegsforgeeks" -> "gksforgks"
Example 2:

Input:
K = 2
S = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
Your Task:  
You don't need to read input or print anything. Complete the function Reduced_String() which takes integer K and string S as input parameters and returns the reduced string.

Expected Time Complexity: O(|S|)
Expected Auxiliary Space: O(|S|)


//Initial Template for Java

import java.util.*;
import java.math.*;

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int k = Integer.parseInt(sc.next());
            String s = sc.next();
            Solution T = new Solution();
            System.out.println(T.reduced_String(k, s));
            
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static String reduced_String(int k, String s)
    {
        

        Stack<Character> datas = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            
            char currChar = s.charAt(i);
            
            if(datas.size()<k){
                datas.push(currChar);
            }else{
                StringBuilder tmpStr = new StringBuilder();
                int tmpK = k;
                char prevChar = ' ';
                
                while(tmpK>0){
                    if(prevChar==' ' ||prevChar==datas.peek()){
                         tmpStr.insert(0,datas.peek()+"");
                    }else{
                        break;
                    }
                    prevChar=datas.peek();
                    datas.pop();
                    tmpK--;
                }
                
                if(tmpK!=0){
                    for(int j=0;j<tmpStr.length();j++){
                        datas.push(tmpStr.charAt(j));
                    }
                }
                datas.push(currChar);
   
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        if(datas.size()>=k){
            
            StringBuilder tmpStr = new StringBuilder();
            int tmpK = k;
            char prevChar = ' ';
                
            while(tmpK>0){
                if(prevChar==' ' ||prevChar==datas.peek()){
                        tmpStr.insert(0,datas.peek()+"");
                }else{
                    break;
                }
                    prevChar=datas.peek();
                    datas.pop();
                    tmpK--;
                }
                
                if(tmpK!=0){
                    for(int j=0;j<tmpStr.length();j++){
                        datas.push(tmpStr.charAt(j));
                    }
                }
         }
        
        
        while(datas.size()>0){
            result.insert(0,datas.pop());
        }
        
        return result.toString();
    }
}






class Pair{
    char c;
    int ctr;
    Pair(char c,int ctr)
    {
        this.c = c;
        this.ctr = ctr;
    }
}
class Solution
{
    public static String reduced_String(int k, String s)
    {
        if(k == 1){
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int ctr = 0;
        for(int i=0;i<l;i++)
        {
            if(st.size() == 0)
            {
                st.push(new Pair(s.charAt(i),1));
                continue;
            }
            if(st.peek().c == s.charAt(i))
            {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if(p.ctr == k)
                {
                    continue;
                }
                else
                {
                    st.push(p);
                }
            }
            else{
                 st.push(new Pair(s.charAt(i),1));
            }
        }
        String ans = "";
        while(st.size() > 0)
        {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while(cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        return ans;
    }
}






class Pair{
    char c;
    int ctr;
    Pair(char c,int ctr)
    {
        this.c = c;
        this.ctr = ctr;
    }
}
class Solution
{
    public static String reduced_String(int k, String s)
    {
        if(k == 1){
            String ans = "";
            return ans;
        }
        Stack<Pair> st = new Stack<Pair>();
        int l = s.length();
        int ctr = 0;
        for(int i=0;i<l;i++)
        {
            if(st.size() == 0)
            {
                st.push(new Pair(s.charAt(i),1));
                continue;
            }
            if(st.peek().c == s.charAt(i))
            {
                Pair p = st.peek();
                st.pop();
                p.ctr += 1;
                if(p.ctr == k)
                {
                    continue;
                }
                else
                {
                    st.push(p);
                }
            }
            else{
                 st.push(new Pair(s.charAt(i),1));
            }
        }
        String ans = "";
        while(st.size() > 0)
        {
            char c = st.peek().c;
            int cnt = st.peek().ctr;
            while(cnt-- > 0)
                ans = c + ans;
            st.pop();
        }
        return ans;
    }
}

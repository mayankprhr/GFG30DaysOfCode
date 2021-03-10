/*

1. Escape the Forbidden Forest 
Medium Accuracy: 93.1% Submissions: 434 Points: 4
Penelope and her classmates are lost in the Forbidden Forest and the Devil is out to get them. But Penelope has magical powers that can build bridges across the dangerous river and take her friends to safety. The only bridges that can withstand the Devil's wrath are the ones built between two similar trees in the forest. 
Given str1 and str2 denoting the order of trees on either side of the river, find the maximum number of bridges that Penelope can build and save everyone from the Devil. 
Note: Each tree in the forest belongs to one of the 3 categories represented by * or # or @

Example 1:

Input:
str1 = "*@#*" 
str2 = "*#"
Output:
2
Explanation:
str1 = "*@#*" and str2 = "*#" 
Two bridges can be built between the banks 
of the river in the following manner. 
* @ # *
|      |
*     #
Example 2:

Input:
str1 = "***"
str2 = "##"
Output:
0
Your Task:
You don't need to read input or print anything. Complete the function build_bridges() that takes str1 and str2 as input parameters and returns the maximum number of bridges that can be built. 

Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)

Constraints:
1 ≤ N, M ≤ 100
Where, N and M are the size of the string str1 and str2 respectively.

Topic Tags
 Strings LCS Dynamic Programming


*/


//Java Solution

int m=str1.length();
int n=str2.length();

int dp[][] = new int[m+1][n+1];

for (int[] row : dp)
Arrays.fill(row, 0);

for(int i=1;i<=m;i++) {
for(int j= 1;j<=n;j++) {
if(str1.charAt(i-1) == str2.charAt(j-1))
dp[i][j]=dp[i-1][j-1]+1;
else
dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
}
}
return dp[m][n];


class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[105][105];
        
        for(int i =0;i<105;i++)
            for(int j = 0 ;j<105;j++)
                dp[i][j] = -1;
                
        return build_bridges_util(0,0,str1,str2,n,m,dp);
    }
    public static int build_bridges_util(int i , int j , String str1 , String str2 , int n , int m , int dp[][])
    {
        if(i>=n || j>=m)
            return 0;

        int ans = dp[i][j];
        if(ans!=-1)
            return ans;
        
        ans = 0;
        if(str1.charAt(i)==str2.charAt(j))
            ans = 1 + build_bridges_util(i+1, j+1 , str1 , str2 , n , m , dp);
        
        ans = Math.max(ans, build_bridges_util(i+1, j , str1 , str2 , n , m , dp));
        ans = Math.max(ans, build_bridges_util(i, j+1 , str1 , str2  , n , m , dp));
        
        dp[i][j] = ans;
        return ans;
    }
}


import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
        {
            String str1 = sc.next();
            String str2 = sc.next();
            Sol obj = new Sol();
            System.out.println(obj.build_bridges(str1,str2));
        }
    }
}// } Driver Code Ends


class Sol
{
    public static int build_bridges(String str1 , String str2)
    {
       if(str1.length()==0 || str2.length()==0){
           return 0;
       }
       int m=str1.length();
int n=str2.length();
int[][] dp=new int[m+1][n+1];
for(int i=0;i<=m;i++)
dp[i][0]=0;
for(int i=0;i<=n;i++)
dp[0][i]=0;
for(int i=1;i<=m;i++)
{
for(int j=1;j<=n;j++)
{
if(str1.charAt(i-1)==str2.charAt(j-1))
dp[i][j]=dp[i-1][j-1]+1;
else
dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
}
}
return dp[m][n];
    }
}
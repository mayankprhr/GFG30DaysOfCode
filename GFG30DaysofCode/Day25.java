/*
1. Spidey Sense 
Medium Accuracy: 99.69% Submissions: 324 Points: 4
Spiderman is stuck in a difficult situation. His arch-enemy the Green Goblin has planted several of his infamous Pumpkin Bombs in various locations in a building. Help Spiderman activate his Spidey Sense and identify the impact zones. 
He has a blueprint of the building which is a M x N matrix that is filled with the characters ‘O’, ‘B’, and ‘W’ where: 
‘O’ represents an open space.
‘B’ represents a bomb.
‘W’ represents a wall.
You have to replace all of the O’s (open spaces) in the matrix with their shortest distance from a bomb without being able to go through any walls. Also, replace the bombs with 0 and walls with -1 in the resultant matrix. If no path exists between a bomb and an open space replace the corresponding 'O' with -1.

Example 1:

Input: N = 3, M = 3
A[] = {{O, O, O}, 
       {W, B, B}, 
       {W, O, O}}
Output: {{2, 1, 1}, 
         {-1, 0, 0},  
         {-1, 1, 1}}
Explanation: The walls at (1,0) and (2,0) 
are replaced by -1. The bombs at (1,1) and 
(1,2) are replaced by 0. The impact zone 
for the bomb at (1,1) includes open spaces 
at index (0,0), (0,1) and (2,1) with distance 
from bomb calculated as 2,1,1 respectively.
The impact zone for the bomb at (1,2) 
includes open spaces at index (0,3) and (2,2) 
with distance from bomb calculated as 1,1 
respectively.

Example 2:

IInput: N = 2, M = 2
A[] = {{O, O},
       {O, O}} 
Output: {{-1, -1}
         {-1, -1}
Your Task:  
You don't need to read input or print anything. Complete the function findDistance() which takes the matrix A[], M, and N as input parameters and the resultant matrix

Expected Time Complexity: O(M*N)
Expected Auxiliary Space: O(M*N)


Constraints:
1 ≤ N*M ≤ 106

Topic Tags
 BFS Queue Graph

*/


import java.math.*;

class Pair{
    
    int x,y;
    Pair(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
}

class Gfg
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.next());
        while(t-- > 0)
        {
            int m = Integer.parseInt(sc.next());
            int n = Integer.parseInt(sc.next());
            char mat[][] = new char[m][n];
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.next().charAt(0);
                }
            }
           
            Solution T = new Solution();
            int ans[][] = T.findDistance(mat, m, n);
            
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends



class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
         int ans[][] = new int[m][n];
        Queue <Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 'B')
                {
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
                else 
                    ans[i][j] = -1;
            }
        }
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair p = q.peek();
                int i = p.x;
                int j = p.y;
                q.remove();
                
                if(i + 1 < m && mat[i+1][j] == 'O' && ans[i+1][j] == -1)
                {
                    ans[i+1][j] = 1+ ans[i][j];
                    q.add(new Pair(i+1,j));
                }
                
                if(i - 1 >= 0 && ans[i-1][j] == -1 && mat[i-1][j] == 'O')
                {
                    ans[i-1][j] = 1 + ans[i][j];
                    q.add(new Pair(i-1,j));
                }
                
                if(j + 1 < n && ans[i][j + 1] == -1 && mat[i][j + 1] == 'O')
                {
                    ans[i][j + 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j + 1));
                }
                
                if(j - 1 >= 0 && mat[i][j - 1] == 'O' && ans[i][j-1] == -1)
                {
                    ans[i][j - 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j - 1));
                }
            }
        }
        
        return ans;
    }
}


class Solution
{
    public static int[][] findDistance(char mat[][], int m,int n)
    {
        int ans[][] = new int[m][n];
        Queue <Pair> q = new LinkedList<Pair>();
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j] == 'B')
                {
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
                else 
                    ans[i][j] = -1;
            }
        }
        
        while(q.size() > 0)
        {
            int size = q.size();
            while(size-- > 0)
            {
                Pair p = q.peek();
                int i = p.x;
                int j = p.y;
                q.remove();
                
                if(i + 1 < m && mat[i+1][j] == 'O' && ans[i+1][j] == -1)
                {
                    ans[i+1][j] = 1+ ans[i][j];
                    q.add(new Pair(i+1,j));
                }
                
                if(i - 1 >= 0 && ans[i-1][j] == -1 && mat[i-1][j] == 'O')
                {
                    ans[i-1][j] = 1 + ans[i][j];
                    q.add(new Pair(i-1,j));
                }
                
                if(j + 1 < n && ans[i][j + 1] == -1 && mat[i][j + 1] == 'O')
                {
                    ans[i][j + 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j + 1));
                }
                
                if(j - 1 >= 0 && mat[i][j - 1] == 'O' && ans[i][j-1] == -1)
                {
                    ans[i][j - 1] = 1+ ans[i][j];
                    q.add(new Pair(i,j - 1));
                }
            }
        }
        
        return ans;
    }
}

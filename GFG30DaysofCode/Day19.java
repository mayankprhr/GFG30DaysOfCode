/*
1. Restricted Pacman 
Medium Accuracy: 99.0% Submissions: 806 Points: 4
In the game of Restricted Pacman, an infinite linear path is given. Pacman has to start at position 0 and eat as many candies as possible. In one move he can only jump a distance of either M or N.  If M and N are coprime numbers, find how many candies will be left on the board after the game is over.
Note: The result is always finite as after a point X every index in the infinite path can be visited. 

Example 1:

Input: M = 2, N = 5
Output: 2
Explanation: From index 0, the indices that 
can be visited are
0 + 2 = 2
0 + 2 + 2 = 4
0 + 5 = 5
0 + 2 + 2 + 2 = 6
0 + 2 + 5 = 7
0 + 2 + 2 + 2 + 2 = 8
0 + 2 + 2 + 5 = 9
0 + 5 + 5 = 10
and so on.
1 and 3 are the only indices that cannot be 
visited. Therefore the candies at these two 
positions will be left on the board. 

Example 2:

Input: M = 2, N = 7
Output: 3 
Example 3:

Input: M = 25, N = 7
Output: 72
Your Task:  
You don't need to read input or print anything. Complete the function candies() which take M and N as input parameters and return the answer.

Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)

Constraints:
1 < M, N ≤ 500

Topic Tags
 Queue Mathematical Hash
*/

class Solution{
    static int candies(int m, int n)
    {
        // Your code goes here 
        int x=(m*n)-(m+n);
        return x/2 + 1;
    }
}


//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
     public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            int m = sc.nextInt();
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.candies(m,n));
            t--;
        }
    } 
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int candies(int m, int n)
    {
        // Your code goes here 
        int x=(m*n)-(m+n);
        return x/2 + 1;
    }
}


//gfg sol
//Back-end complete function Template for Java

class Solution{
    static int candies(int m, int n)
    {
        int X = (m * n) - m - n;

        HashSet<Integer> hash_set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        hash_set.add(X);

        int count = 0;
        while (!queue.isEmpty()) {

            int curr = queue.poll();
            count++;
            
            int key = curr-m;
            if (key > 0 && hash_set.contains(key)==false ) {
                queue.add(key);
                hash_set.add(key);
            }
            
            key = curr - n;
            if (key > 0 && hash_set.contains(key)==false) {
                queue.add(key);
                hash_set.add(key);
            }
        }

        return count;
    }
}

/*

1. Project Manager 
Medium Accuracy: 91.91% Submissions: 210 Points: 4
An IT company is working on a large project. The project is broken into N modules and distributed to different teams. The amount of time (in months) required to complete each module is given in an array duration[ ] i.e. time needed to complete ith module is duration[i] months. 
You are also given M dependencies such that for each i (1 ≤ i ≤ M)  dependencies[i][1]th module can be started after dependencies[i][0]th module is completed.
As the project manager, compute the minimum time required to complete the project.
Note: It is guaranteed that a module is not dependent on itself.

Example 1:

Input:
N = 6, M = 6
duration[] = {1, 2, 3, 1, 3, 2}
dependencies:
5 2
5 0
4 0 
4 1
2 3
3 1
Output: 
8
Explanation: 
graph
The Graph of dependency forms this and 
the project will be completed when Module 
1 is completed which takes 8 months.
Example 2:

Input:
N = 3, M = 3
duration[] = {5, 5, 5}
dependencies:
0 1
1 2
2 0
Output: 
-1
Explanation: 
There is a cycle in the dependency graph 
hence the project cannot be completed.
Your Task:
Complete the function minTime() which takes N, M, duration array, and dependencies array as input parameter and return the minimum time required. Return -1 if the project can not be completed. 

Expected Time Complexity: O(N+M)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 105
1 ≤ M ≤ 2*105
1 ≤ duration[i] ≤ 105

Topic Tags
 DFS Graph Sorting

*/

//Use topological sorting. Check for cycle, and use back tracking dfs to calculate the answer.

/*


Potta Lokesh • 8 days ago
The question was not clear how the 8 came for the example test case.....

3 
•
Reply
•
Share ›
Avatar
Manav Mohata  Potta Lokesh • 7 days ago
5 -> 2 -> 3 -> 1 is the ans for the sample test case. You have to take the sum of corresponding indices

•
Reply
•
Share ›
Avatar
Potta Lokesh  Manav Mohata • 7 days ago
But how ?? I could not understand.

•
Reply
•
Share ›
Avatar
Raghu Gr  Potta Lokesh • 7 days ago • edited
Sample test case can result to 6 hours
bec if we take a topological order of the graph starting with 0 as initial vertex
0
1
3 -> 2
4
5

this will be the order breaking every time we reach empty queue.
So 0, 1, 3, 4, 5 all can parallel start. only 2 will execute after 3 finishes.

Not too sure which point am I missing here to get 8 hours as answer

•
Reply
•
Share ›
Avatar
João Gabriel Trombeta • 8 days ago
Can someone help me understand the following scenario?
Input:
10 7
0 2 6 11 14 9 12 16 3 9
5 5
5 8
5 3
5 4
3 8
0 6
5 0

Its Correct output is:
16

5 depends on 5, which by itself it's already a cycle. Even if we ignore this cycle 8 takes 3 months. It depends on 3, that takes 11 months. 3 depends on 5, which takes 9 months. That is 23 months to complete 3, the project cannot be completed in 16 months

1 
•
Reply
•
Share ›
Avatar
Raghu Gr  João Gabriel Trombeta • 7 days ago
Hi

I have not cleared all the test cases it now.
But I am assuming that if you take topological order of the above.
We will get below result keeping 0 as the initial vertex.

1->3->2
0->5
4
6
7
8
9

now if you calculate the sum of indices 7 module will finish at 16. All the module will be finish before that. So that is the reason 16 is the correct ans here. Hoping you got my answer.

2 
•
Reply
•
Share ›
Avatar
Wilson Chuks  João Gabriel Trombeta • 7 days ago • edited
Same thing here.

Another case is this but Online Judge outputs 11
(3,3) - cycle
(4,0) -(0,4)
(4,3) - (3,4)

7 10
13 12 1 10 17 11 3
3 6
4 0
3 2
2 1
3 4
6 2
3 3
0 4
4 3
1 0

2 
•
Reply
•
Share ›
Avatar
Manav Mohata  João Gabriel Trombeta • 7 days ago
I have the same doubt

2 
•
Reply
•
Share ›
Avatar
João Gabriel Trombeta  João Gabriel Trombeta • 7 days ago
Thanks for the replies. I think I get Raghu explained, but there's something clearly wrong if it's accepting cicles. I guess I'll just skip the challange for today, I'd rather not spend too much time on it if the test results are not matching the problem.

•
Reply
•
Share ›
Avatar
Asipu Pawan Kumar • 2 days ago
Hi, Geeks!!
Test cases of this problem are now updated

•
Reply
•
Share ›
Avatar
唐博 • 6 days ago
I'm confused.
10 7
9 10 13 17 19 13 15 18 4 9
5 5
5 8
5 3
5 4
3 8
0 6
5 0
Expected Result is 18.
How? Even the 4th module takes 19 monthes.

•
Reply
•
Share ›
−
Avatar
Debajyoti Shit • 7 days ago
first try ,then go for the given code link ,then go to twitter then click on code link for solusion
https://twitter.com/DebajyotiShit/status/1363166424512958464




*/




// Initial Template for Java

import java.io.*;
import java.util.*;

class pair {
    int x, y;
    pair() {
        this.x = 0;
        this.y = 0;
    }
    pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] nm = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            String[] dr = br.readLine().trim().split(" ");
            int[] duration = new int[dr.length];
            for (int i = 0; i < dr.length; i++) {
                duration[i] = Integer.parseInt(dr[i]);
            }
            ArrayList<pair> dependency = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                String[] xy = br.readLine().trim().split(" ");
                dependency.add(
                    new pair(Integer.parseInt(xy[0]), Integer.parseInt(xy[1])));
            }
            Solution sln = new Solution();
            System.out.println(sln.minTime(dependency, duration, n, m));
        }
    }
}// } Driver Code Ends


// User function Template for Java

// please refer the custom pair class in driver code for more clarification
class Solution {
    class cycleHelper {
        boolean[] visited;
        boolean[] isStack;
        cycleHelper(int n) {
            this.visited = new boolean[n];
            this.isStack = new boolean[n];
        }
    }
    // refer https://www.geeksforgeeks.org/detect-cycle-in-a-graph/
    // for cycle detection in directed graph
      public boolean
        checkCycle(int nd, ArrayList<ArrayList<Integer>> adj,
                   cycleHelper cyHlp) {
        // insert into stack
        cyHlp.isStack[nd] = true;
        for (int it : adj.get(nd)) {
            // if next node is visited
            if (cyHlp.visited[it] == true) {
                // if the node is in stack then cycle is found
                if (cyHlp.isStack[it] == true) return true;
                continue;
            }
            cyHlp.visited[it] = true;
            if (checkCycle(it, adj, cyHlp)) return true;
        }
        // removing from stack
        cyHlp.isStack[nd] = false;
        return false;
    }
    /*
        nd: current node
        adj: adjacency list of the graph
        duration: time to complete each module
        reqTime: time to complete project from ith module to end
    */
    public int dfs(int nd, ArrayList<ArrayList<Integer>> adj, int[] duration,
            int[] reqTime) {
        // return the time to complete the project starting from the node i if
        // it is
        // already calculated
        if (reqTime[nd] != -1) return reqTime[nd];
        int maxi = 0;
        for (int it : adj.get(nd)) {
            maxi = Math.max(maxi, dfs(it, adj, duration, reqTime));
        }
        // time to complete this module and maximum time to complete child
        // modules
        reqTime[nd] = maxi + duration[nd];
        return reqTime[nd];
    }
    public int minTime(ArrayList<pair> dependency, int[] duration, int n, int m) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }
        // stores number of modules should be completed before ith module
        int[] independent = new int[n];
        for (int i = 0; i < m; i++) {
            // create graph from dependency of modules
            adj.get(dependency.get(i).x).add(dependency.get(i).y);
            independent[dependency.get(i).y]++;
        }

        int flag = 0;
        for (int i = 0; i < n; i++) {
            // if independent module or not
            if (independent[i] == 0) {
                flag = 1;
            }
        }
        // no independent module return -1
        if (flag == 0) {
            return -1;
        }
        cycleHelper cyHlp = new cycleHelper(n);
        for (int i = 0; i < n; i++) {
            if (independent[i] != 0) {
                continue;
            }
            cyHlp.visited[i] = true;
            // check if cycle is present then return -1
            if (checkCycle(i, adj, cyHlp)) return -1;
        }
        int[] reqTime = new int[n];
        Arrays.fill(reqTime, -1);
        int ans = 0;
        // starting from any independent module find the maximum time to
        // complete
        // the project
        for (int i = 0; i < n; i++)
            if (independent[i] == 0)
                ans = Math.max(ans, dfs(i, adj, duration, reqTime));

        return ans;
    }
}
/*

1. Corona Vaccine 
Hard Accuracy: 92.49% Submissions: 213 Points: 8
Geek has developed an effective vaccine for Corona virus and he wants each of the N houses in Geek Land to have access to it. Given a binary tree where each node represents a house in Geek Land, find the minimum number of houses that should be supplied with the vaccine kit if one vaccine kit is sufficient for that house, its parent house and it's immediate child nodes.  

 

Example 1:

Input:
    1
   / \
  2   3 
        \
         4
          \
           5
            \
             6

Output:
2
Explanation:
The vaccine kits should be 
supplied to house numbers 1 and 5. 
Example 2:

Input:
    1
   / \
  2   3 
Output:
1
Explanation:
The vaccine kits should be 
supplied to house number 1.

Your Task:
You don't need to read input or print anything. Complete the function supplyVaccine() which takes the root of the housing tree as input parameter and returns the minimum number of houses that should be supplied with the vaccine kit.


Expected Time Complexity: O(N)
Expected Auxiliary Space: O(N)


Constraints:
1 ≤ N ≤ 105

Topic Tags
 Tree

*/


//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GFG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());

        while(t > 0){
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution g = new Solution();
            System.out.println(g.supplyVaccine(root));
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

/* 
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
} 
*/

class Solution
{
    static int ans = 0;
    
    public static int post(Node node)
    {
        boolean zero = false , two = false;
        if(node.left==null && node.right==null)
            return 0;
        
        if(node.left!=null)
        {
            int get = post(node.left);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
            
        }
        
        if(node.right!=null)
        {
            int get = post(node.right);
            if(get==0)
                zero = true;
            if(get==2)
                two = true;
        }
        
        if(zero==true)
        {
            ans++;
            return 2;
        }
        
        if(two==true)
        {
            return 1;
        }
        return 0; 
    }

    public static int supplyVaccine(Node root)
    {
        ans = 0;    
        int result = post(root);
        if(result==0)
            return ans + 1;
        return ans;
    }
}

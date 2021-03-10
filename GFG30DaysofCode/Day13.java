/*Given Preorder, Inorder and Postorder traversals of some tree of size N. The task is to check if they are all of the same tree or not.

Example 1:

Input:
N = 5
preorder[] = {1, 2, 4, 5, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 5, 2, 3, 1}
Output: Yes
Explanation: 
All of the above three traversals 
are of the same tree.
           1
         /   \
        2     3
      /   \
     4     5
Example 2:

Input:
N = 5
preorder[] = {1, 5, 4, 2, 3}
inorder[] = {4, 2, 5, 1, 3}
postorder[] = {4, 1, 2, 3, 5}
Output: No
Explanation: The three traversals can 
not be of the same tree.

Your Task:
You don't need to read input or print anything. Complete the function checktree() which takes the array preorder[ ], inorder[ ], postorder[ ] and integer N as input parameters and returns true if the three traversals are of the same tree or not. 

Expected Time Complexity: O(N2)
Expected Auxiliary Space: O(N)

Constraints:
1 ≤ N ≤ 103
*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
        	int n = sc.nextInt();
        	int[] preorder = new int[n];
        	int[] inorder = new int[n];
        	int[] postorder = new int[n];
            for(int i=0; i<n; i++)
                preorder[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                inorder[i] = sc.nextInt();
            for(int i=0; i<n; i++)
                postorder[i] = sc.nextInt();
            Solution ob = new Solution();
            if(ob.checktree(preorder, inorder, postorder, n) )
			System.out.println("Yes");
			else
			System.out.println("No");
            t--;
        }
    }
}
// } Driver Code Ends


class Solution
{
    
     static List<Integer> postOrderTraversal = new ArrayList<>();
      
    static boolean checktree(int preorder[], int inorder[], int postorder[], int N){
        
        int preLen = preorder.length;
        int inLen = inorder.length;
        int postLen = postorder.length;
        
        if(preLen!=inLen || inLen!=postLen){
            return false;
        }
        
        Solution s1 = new Solution();
        
        TreeNode root = s1.createTree(preorder,inorder,0,preLen-1,0,inLen-1);
        s1.traversal(root);
   
        for(int i=0;i<postLen;i++){
            if(postorder[i]!=postOrderTraversal.get(i).intValue()){
                postOrderTraversal.clear();
                return false;
            }
        }
        
        postOrderTraversal.clear();
        
        return true;
    }
    
    private void traversal(TreeNode root){
        
        if(root==null){
            return;
        }
        
        traversal(root.lNext);
        traversal(root.rNext);
        postOrderTraversal.add(root.val);
        
    }
    
    private TreeNode createTree(int preorder[],int inorder[],int preSIndex,int preEIndex
    ,int inSIndex,int inEIndex){
        
        if(preSIndex>preEIndex || inSIndex>inEIndex){
            return null;
        }
        
        TreeNode root = new TreeNode();
        root.val = preorder[preSIndex];
        
        int i=inSIndex;
        int count = 0;
        
        boolean isFound = false;
        
        for(i=inSIndex;i<=inEIndex;i++){
            if(inorder[i]==preorder[preSIndex]){
                isFound=true;
                break;
            }
            count++;
        }
        
        if(!isFound){
            return null;
        }
        
        root.lNext=createTree(preorder,inorder,preSIndex+1,preSIndex+count,inSIndex,i-1);
        root.rNext=createTree(preorder,inorder,preSIndex+count+1,preEIndex,i+1,inEIndex);
        
        return root;
    }
    
     class TreeNode{
        int val;
        TreeNode lNext;
        TreeNode rNext;
     }
}


class Solution
{
    static boolean check(int preorder[], int i1, int inorder[], int i2, int postorder[], int i3, int len)
    {
        if(len==0) return true;
        
        // if array lengths are 1, then check if all of them are equal 
        if(len==1) return ( (preorder[i1]==inorder[i2]) && (inorder[i2] == postorder[i3]) );
        
        // search for first element of preorder in inorder array 
        int idx=-1;
        for(int i=0 ; i<len ; i+=1)
            if( inorder[i2+i] == preorder[i1] )
            {
                idx = i2+i;
                break;
            }
        if(idx==-1) return false;
        
        // matching element in postorder array
        if( preorder[i1] != postorder[i3+len-1] ) return false;
        
        // nodes in left subtree =
        int left = idx-i2;
        
        // check for the left subtree 
        boolean ret1 = check(preorder, i1+1, inorder, i2, postorder, i3, left);
        
        // check for the right subtree 
        boolean ret2 = check(preorder , i1+1+left , inorder , i2+1+left , postorder , i3+left , len-left-1);
        
        // return 1 only if both of them are correct else 0 
        return (ret1 && ret2);
    }
    static boolean checktree(int preorder[], int inorder[], int postorder[], int N)
    {
        return check(preorder, 0, inorder, 0, postorder, 0, N);
    }
}

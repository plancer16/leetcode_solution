//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 栈 树 广度优先搜索 
// 👍 450 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;

        Deque<TreeNode> oddQueue=new ArrayDeque<TreeNode>();
        Deque<TreeNode> evenQueue=new ArrayDeque<TreeNode>();
        int level=1;
        oddQueue.addLast(root);
        while (!oddQueue.isEmpty()||!evenQueue.isEmpty()){
            if (level%2==1){
                List<Integer> temp=new ArrayList<>();
                while(!oddQueue.isEmpty()){//判断队列为空用empty
                    TreeNode cur=oddQueue.removeLast();
                    temp.add(cur.val);
                    if (cur.left!=null) evenQueue.addLast(cur.left);
                    if (cur.right!=null) evenQueue.addLast(cur.right);
                }
                res.add(temp);
                level++;
            }else {
                List<Integer> temp=new ArrayList<>();
                while(!evenQueue.isEmpty()){
                    TreeNode cur=evenQueue.removeLast();
                    temp.add(cur.val);
                    if (cur.right!=null) oddQueue.addLast(cur.right);
                    if (cur.left!=null) oddQueue.addLast(cur.left);
                }
                res.add(temp);
                level++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

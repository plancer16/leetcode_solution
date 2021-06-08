//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1212 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();
        backtrack(nums,0,res,temp);
        return res;
    }
    public void backtrack(int[] nums,int start,List<List<Integer>> res,List<Integer> temp){
        res.add(new ArrayList<>(temp));

        for (int i = start; i <nums.length ; i++) {
            temp.add(nums[i]);
            backtrack(nums,i+1,res,temp);
            temp.remove(temp.size()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

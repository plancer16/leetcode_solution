//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1395 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums.length==0) return res;
        boolean[] used=new boolean[nums.length];

        List<Integer> temp=new ArrayList<>();
        backtrack(nums,used,res,temp);
        return res;
    }
    public void backtrack(int[] nums,boolean[] used,
                          List<List<Integer>> res,
                          List<Integer> temp){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            used[i]=true;
            temp.add(nums[i]);
            backtrack(nums,used,res,temp);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

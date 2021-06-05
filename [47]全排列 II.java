//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 回溯算法 
// 👍 713 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums.length==0) return res;
        boolean[] used=new boolean[nums.length];

        List<Integer> temp=new ArrayList<>();
        Arrays.sort(nums);
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
            if (used[i]) continue;//更深的深度不能使用同一个数
            if (i>0&&!used[i-1]&&nums[i]==nums[i-1]) continue;//同一层剪枝：前一个数没有使用，当前数和前一个数相同，前一个索引>=0
            used[i]=true;
            temp.add(nums[i]);
            backtrack(nums,used,res,temp);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

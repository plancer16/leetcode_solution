//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3407 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if (nums==null|| nums.length==0) return res;

        Arrays.sort(nums);

        for (int i=0;i<nums.length-2;i++){
            if (nums[i]>0) break;
            if (i>0&&nums[i-1]==nums[i]) continue;//前一个相等的数当不包含当前的i，就相当于前一个初始数为当前初始数的情况
            int left=i+1,right=nums.length-1;
            while (left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if (sum<0){
                    left++;
                }else if (sum>0){
                    right--;
                }else {
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    res.add(temp);
                    while (left<right&&nums[left]==nums[left+1]){
                        left++;
                    }
                    while (left<right&&nums[right]==nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1183 👎 0

//          测试用例:[1,3,2] 2 3 1
//			测试结果:[3,1,2]
//			期望结果:[2,1,3]
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int i=nums.length-2;
        //找到第一个上升的点i（其右边比左边大）
        while (i>=0&&nums[i+1]<=nums[i]) {
            i--;
        }
        //从右往左，找到第一个比i大的点j，交换i和j
        if (i>=0){
            for (int j=nums.length-1;j>i;j--){
                if (nums[j]>nums[i]){
                    swap(nums,i,j);
                    break;
                }
            }
        }
        //把i右边的数字倒序
        reverse(nums,i+1,nums.length-1);
    }
    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums,int i,int j){
        while (i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

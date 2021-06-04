//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 295 👎 0


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static Random random = new Random();

    public int[] sortArray(int[] nums) {
        int len = nums.length;
        int l = 0, r = len - 1;
        quicksort(nums, l, r);
        return nums;
    }

    public void quicksort(int[] nums, int l, int r) {
        if (l <= r) {
            int index = partition(nums, l, r);
            quicksort(nums, l, index - 1);
            quicksort(nums, index + 1, r);
        }
    }

    //随机选择一个数，完成将这个数安排到它指定位置的功能
    public int partition(int[] nums, int l, int r) {
        int pointer = random.nextInt(r - l + 1) + l;
        int flag = nums[pointer];
        swap(nums, l, pointer);

        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < flag) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, l);
        return j;
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

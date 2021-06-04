//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 1118 👎 0


import java.util.Random;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public static Random random=new Random();
    public int findKthLargest(int[] nums, int k) {
        int len=nums.length;
        int target=len-k;

        int left=0,right=len-1;
        while (left<=right){
            int index=partition(nums,left,right);
            if (index==target){
                return nums[index];
            }else if (index<target){
                left=index+1;
            }else{
                right=index-1;
            }
        }
        return -1;
    }
    public static int partition(int[] nums,int left,int right){
        int random_index=random.nextInt(right-left+1)+left;
        int flag=nums[random_index];
        swap(nums,left,random_index);
        int j=left;
        for (int i = left+1; i <=right; i++) {
            if (nums[i]<flag){
                j++;
                swap(nums,j,i);
            }
        }
        swap(nums,j,left);
        return j;
    }
    public static void swap(int[] nums,int left,int right){
        int temp=nums[left];
        nums[left]=nums[right];
        nums[right]=temp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

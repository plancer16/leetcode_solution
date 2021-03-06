//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2387 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        if(height==null||height.length==0) return 0;
        int len=height.length;
        int[] max_left=new int[len];
        int[] max_right=new int[len];
        max_left[0]=height[0];
        max_right[len-1]=height[len-1];

        for (int i=1;i<len;i++){
            max_left[i]=Math.max(height[i],max_left[i-1]);
        }
        for (int j=len-2;j>=0;j--){
            max_right[j]=Math.max(height[j],max_right[j+1]);
        }
        int res=0;
        for (int i=0;i<len;i++){
            res+=Math.min(max_left[i],max_right[i])-height[**i];
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

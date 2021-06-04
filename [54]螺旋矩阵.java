//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 
// 👍 795 👎 0


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rows=matrix.length,cols=matrix[0].length;
        int left=0,right=cols-1,up=0,down=rows-1;
        List<Integer> res=new ArrayList<>();
        while (true){
            if (left>right) break;
            for (int j=left;j<=right;j++){
                res.add(matrix[up][j]);
            }
            up++;
            if (up>down) break;
            for (int i=up;i<=down;i++){
                res.add(matrix[i][right]);
            }
            right--;
            if (left>right) break;
            for (int j = right; j>=left ; j--) {
                res.add(matrix[down][j]);
            }
            down--;
            if (up>down) break;
            for (int i=down;i>=up;i--){
                res.add(matrix[i][left]);
            }
            left++;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

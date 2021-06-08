//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 排序 数组 
// 👍 963 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1,int[] o2){
                return o1[0]-o2[0];
            }
        });
        LinkedList<int[]> temp=new LinkedList<>();
        for (int i=0;i<intervals.length;i++){
            if (temp.isEmpty()||temp.getLast()[1]<intervals[i][0]){
                temp.add(intervals[i]);
            }else {
                temp.getLast()[1]=Math.max(temp.getLast()[1],intervals[i][1]);
            }
        }
        int[][] res=new int[temp.size()][2];
        int size=temp.size();
        for (int i = 0; i < size; i++) {//temp的size在变化
            res[i]=temp.removeFirst();
        }
//        int idx=0;
//        while (!temp.isEmpty()){
//            res[idx++]=temp.removeFirst();
//        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

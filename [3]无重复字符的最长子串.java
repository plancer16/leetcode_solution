//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 5573 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len=s.length();
        if (len==0) return 0;
        char[] ch=s.toCharArray();
        int i=0,j=1;
        Map<Character,Integer> window=new HashMap<>();
        window.put(ch[0],0);
        int max=1;
        while (j<len&&i<=j){
            if (window.containsKey(ch[j])){
                window.remove(ch[i]);//abcb，一定是除去b
                i++;
            }else {//只有在右窗口往右边添加的时候才可能产生新的max
                window.put(ch[j],j);
                int temp=j-i+1;
                if (temp>max){
                    max=temp;
                }
                j++;
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

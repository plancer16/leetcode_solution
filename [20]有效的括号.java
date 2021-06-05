//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2439 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        char[] ch=s.toCharArray();
        int len=ch.length;
        if (len==0) return false;
        Stack<Character> stack=new Stack();
        for (int i=0;i<len;i++){
            if (ch[i]=='('||ch[i]=='{'||ch[i]=='['){
                stack.push(ch[i]);
            }else if (ch[i]==']'){//只有]的情况
                if (stack.isEmpty()||stack.pop()!='[') return false;
            }else if (ch[i]=='}'){
                if (stack.isEmpty()||stack.pop()!='{') return false;
            }else if (ch[i]==')'){
                if (stack.isEmpty()||stack.pop()!='(') return false;
            }
        }
        if (!stack.isEmpty()) return false;//((的情况
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

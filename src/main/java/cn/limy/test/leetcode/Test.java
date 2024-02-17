package cn.limy.test.leetcode;

import com.alibaba.fastjson.JSON;

import java.util.*;

public class Test {
    public static void main(String[] args) {
//        System.out.println(Solution.replaceSpace("We are happy."));
//        System.out.println(Solution2.reverseLeftWords("abcdef", 2));

       int[] preorder = {3,9,5,6,20,15,7};
       int[] inorder = {5,9,6,3,15,20,7};
        TreeNode treeNode = new Solution6().buildTree(preorder, inorder);
        System.out.println(JSON.toJSONString(treeNode));
        Node node11 = new Node(11);
        Node node22 = new Node(22);
        Node node33 = new Node(33);

        node11.next = node22;
        node11.random = node33;

        node22.next = node33;
        node22.random = node11;

        node33.random = node22;

        Node node = new Solution9().copyRandomList(node11);
        System.out.println(JSON.toJSONString(node));


    }
}

//Offer 05. 替换空格
class Solution {
    public static String replaceSpace(String s) {
        int length = s.length();
        char[] array = new char[length * 3];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }
}

//面试题58 - II. 左旋转字符串（切片 / 列表 / 字符串，清晰图解）
class Solution2 {
    public static String reverseLeftWords(String s, int n) {
        StringBuilder res = new StringBuilder();
        for(int i = n; i < n + s.length(); i++) {
            res.append(s.charAt(i % s.length()));
        }
        return res.toString();
    }
}

//面试题58 - II. 左旋转字符串（切片 / 列表 / 字符串，清晰图解）
class Solution3 {
    public static String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n; i < s.length(); i++){
            stringBuilder.append(s.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

}

class Solution4 {
    public static boolean isNumber(String s) {
        Map[] states = {
                new HashMap<Object, Object>() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap<Object, Object>() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap<Object, Object>() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap<Object, Object>() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap<Object, Object>() {{ put('d', 3); }},                                        // 4.
                new HashMap<Object, Object>() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap<Object, Object>() {{ put('d', 7); }},                                        // 6.
                new HashMap<Object, Object>() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap<Object, Object>() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                t = 'd';
            } else if(c == '+' || c == '-') {
                t = 's';
            } else if(c == 'e' || c == 'E') {
                t = 'e';
            } else if(c == '.' || c == ' ') {
                t = c;
            } else {
                t = '?';
            }
            if(!states[p].containsKey(t)) {
                return false;
            }
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}

//二维数组中的查找
class Solution5 {
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;
    }
}



 class TreeNode {
    int val;
    TreeNode left;
     TreeNode right;
    TreeNode(int x) { val = x; }
 }
//     剑指 Offer 07. 重建二叉树
class Solution6 {
//    int[] preorder = {3,9,5,6,20,15,7};
//    int[] inorder = {5,9,6,3,15,20,7};
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for(int i = 0; i < inorder.length; i++) {
            dic.put(inorder[i], i);
        }
        return recur(0, 0, inorder.length - 1);
    }
    TreeNode recur(int root, int left, int right) {
        if(left > right) {
            return null;                          // 递归终止
        }
        TreeNode node = new TreeNode(preorder[root]);          // 建立根节点
        int i = dic.get(preorder[root]);                       // 划分根节点、左子树、右子树
        node.left = recur(root + 1, left, i - 1);              // 开启左子树递归
        node.right = recur(root + i - left + 1, i + 1, right); // 开启右子树递归
        return node;                                           // 回溯返回根节点
    }
}

//    剑指 Offer 67. 把字符串转换成整数
class Solution7 {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) {
            return 0;
        }
        int res = 0,bndry = Integer.MAX_VALUE/10;
        int i = 1, sign = 1;
        if(c[0] == '-'){
            sign = -1;
        }else if(c[0] != '+'){
            i = 0;
        }

        for(int j = i; j<c.length; j++){
            if(c[j] < '0' || c[j] > '9'){
                break;
            }
            if(res > bndry || res == bndry && c[j] > 7){
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + (c[j] - '0');
        }

        return sign * res;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

//    剑指 Offer 24. 反转链表 迭代
class Solution8 {
    public ListNode reverseList(ListNode head) {
        ListNode cur = head,pre = null;
        while(cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return head;
    }
}


// Definition for a Node.
class Node {
    int val;
    Node next, random;
    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution9 {
    public Node copyRandomList(Node head) {
        if(head == null) {
            return null;
        }
        Node cur = head;
        Map<Node, Node> map = new HashMap<>();
        // 3. 复制各节点，并建立 “原节点 -> 新节点” 的 Map 映射
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        // 4. 构建新链表的 next 和 random 指向
        while(cur != null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        // 5. 返回新链表的头节点
        return map.get(head);
    }

    class Solution10 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.right != null){
                    stack.push(node.right);
                }
                if (node.left != null){
                    stack.push(node.left);
                }
            }
            return result;
        }
    }
}







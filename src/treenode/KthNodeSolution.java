package treenode;

import java.util.Stack;

/*给定一棵二叉搜索树，请找出其中的第k小的结点。
例如,(5，3，7，2，4，6，8)中，按结点数值大小顺序第三小结点的值为4。
*/
public class KthNodeSolution {

    //非递归中序遍历
    TreeNode KthNode2(TreeNode pRoot, int k)
    {
        if (pRoot==null||k<=0){
            return null;
        }
        TreeNode node=pRoot;
        int count=0;
        Stack<TreeNode> stack=new Stack<>();
        do {
            if (node!=null){
                stack.push(node);
                node=node.left;
            }else{//node==null
                node=stack.pop();
                count++;
                if(count==k) return node;
                node=node.right;
            }
        }while (node!=null && !stack.empty());
        return null;
    }

    //递归实现中序遍历
    int count=0;
    TreeNode KthNode(TreeNode pRoot , int k){
        if(pRoot!=null){
            TreeNode node=KthNode(pRoot.left,k);
            if(node!=null) return node;
            count++;
            if(count==k) return pRoot;
            node=KthNode(pRoot.right, k);
            if(node!=null) return node;
        }
        return null;

    }

}

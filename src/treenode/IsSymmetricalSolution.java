package treenode;

import java.util.ArrayList;

//请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
public class IsSymmetricalSolution {

    //递归版本，大佬说这样发掘不出这题的价值
    boolean isSymmetrical(TreeNode pRoot){
        if(pRoot==null) return true;
        return isMirror(pRoot.left,pRoot.right);
    }

    boolean isMirror(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left!=null && right!=null){
            if(left.val==right.val){
                return isMirror(left.left,right.right)&&isMirror(left.right,right.left);
            }else{
                return false;
            }
        }
        return false;
    }

    //只要采用前序、中序、后序、层次遍历等任何一种遍历方法，分为先左后右和先
    //右后左两种方法，只要两次结果相等就说明这棵树是一颗对称二叉树。
    //此处是层次遍历
    boolean isSymmetrical2(TreeNode pRoot){
        if(pRoot==null) return true;
        ArrayList<TreeNode> listLeft=new ArrayList<>(), listRight=new ArrayList<>();
        TreeNode left=pRoot.left, right=pRoot.right;
        listLeft.add(left);
        listRight.add(right);

        while (!listLeft.isEmpty() && !listRight.isEmpty()){
            left=listLeft.remove(0);
            right=listRight.remove(0);

            if(left==null&&right==null) continue;
            if(left==null||right==null) return false;
            if(left.val!=right.val) return false;
            listLeft.add(left.left);
            listLeft.add(left.right);
            listRight.add(right.right);
            listRight.add(right.left);

        }
        return true;
    }

}

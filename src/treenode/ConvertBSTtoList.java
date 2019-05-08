package treenode;

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
public class ConvertBSTtoList {

    //这是自己的想法,网上跑测试用例时要返回头节点,不然过不了
    public TreeNode Convert(TreeNode pRootOfTree){
        if(pRootOfTree==null){
            return null;
        }
        TreeNode head=getLeftList(pRootOfTree);
        getRightList(pRootOfTree);
        return head;
    }

    TreeNode getLeftList(TreeNode root){
        if(root.left==null){
            return root;
        }
        if(root.left.right==null){//右子树为空
            root.left.right=root;
            return getLeftList(root.left);
        }else{//右子树不为空
            root.left.right.left=root.left;
            root.left.right.right=root;
            root.left=root.left.right;
            return getLeftList(root.left.left);
        }
    }

    void getRightList(TreeNode root){
        if(root.right==null){
            return;
        }
        if(root.right.left==null){
            root.right.left=root;
            getRightList(root.right);
        }else{
            root.right.left.right=root.right;
            root.right.left.left=root;
            root.right=root.right.left;
            getRightList(root.right.right);
        }
    }

    //前序遍历,多声明一个前继节点就行
    TreeNode pre=null;
    TreeNode lastLeft=null;
    public TreeNode Convert2(TreeNode pRootOfTree) {
        if(pRootOfTree==null){
            return null;
        }
        Convert2(pRootOfTree.left);
        pRootOfTree.left=pre;
        if(pre!=null)pre.right=pRootOfTree;
        pre=pRootOfTree;
        lastLeft=lastLeft==null?pRootOfTree:lastLeft;
        Convert2(pRootOfTree.right);
        return lastLeft;
    }

}
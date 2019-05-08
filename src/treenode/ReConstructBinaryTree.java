package treenode;

/*
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||pre.length==0){
            return null;
        }
        int root=pre[0];
        int i;
        for(i=0;i<in.length;i++){
            if(root==in[i]){
                break;
            }
        }
        int leftLen=i;
        int rightLen=pre.length-i-1;
        TreeNode treeNode=new TreeNode(root);
        if(leftLen==0){
            treeNode.left=null;
        }else{
            int[] leftPre=new int[leftLen];
            int[] leftIn=new int[leftLen];
            System.arraycopy(pre,1,leftPre,0,leftLen);
            System.arraycopy(in,0,leftIn,0,leftLen);
            treeNode.left=reConstructBinaryTree(leftPre,leftIn);
        }
        if(rightLen==0){
            treeNode.right=null;
        }else {
            int[] rightPre = new int[rightLen];
            int[] rightIn = new int[rightLen];
            System.arraycopy(pre, leftLen + 1, rightPre, 0, rightLen);
            System.arraycopy(in, leftLen + 1, rightIn, 0, rightLen);
            treeNode.right = reConstructBinaryTree(rightPre, rightIn);
        }
        return treeNode;
    }

}

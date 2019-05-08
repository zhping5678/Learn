package treenode;

//输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
public class HasSubTree {

    public Boolean HasSubtree(TreeNode root1, TreeNode root2){
        if(root1==null||root2==null){
            return false;
        }
        Boolean result=false;
        if(root1.val==root2.val){//根节点值相同，判断
            result=isSame(root1,root2);
        }
        //根节点相同，但是两棵树不一样
        if(!result){
            result=HasSubtree(root1.left,root2);
        }
        if(!result){
            result=HasSubtree(root1.right,root2);
        }
        return result;
    }

    public Boolean isSame(TreeNode n1,TreeNode n2){

        if(n2==null){//子树已经遍历结束还是相同，说明是子树
            return true;
        }
        if(n1==null){
            return false;
        }
        //判断根节点
        if(n1.val!=n2.val){
            return false;
        }
        //根节点相同，继续判断各自的左子树和右子树是否相同
        return isSame(n1.left,n2.left)&&isSame(n1.right,n2.right);
    }

}

package treenode;

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
/*
它或者是一棵空树，或者是具有下列性质的二叉树：
若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值
*/
public class VerifyBinarySearchTree {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null||sequence.length==0){
            return true;
        }
        return isBST(sequence,0,sequence.length-1);
    }

    public boolean isBST(int[] sequence, int begin, int end){
        if(begin>=end){
            return true;
        }
        //找到左右子树节点的分界线
        int limit=begin;
        int root=sequence[end];
        for(;limit<end;limit++){
            if(sequence[limit]>root){
                break;
            }
        }
        System.out.println("limit:"+limit);
        //以上循环能够判断左子树小于根，下面循环判断右侧是否都大于根
        for(int j=limit;j<end;j++){
            if (sequence[j]<root){
                return false;
            }
        }
        return isBST(sequence,begin,limit-1)&&isBST(sequence,limit,end-1);
    }

    //以上是递归做法
    //以下是非递归做法，非常秀
    public boolean VerifySequenceOfBST(int [] sequence){
        int size = sequence.length;
        if(0==size)return false;

        int i = 0;
        while((--size)>0)
        {
            //在比跟大的地方break
            while(sequence[i++]<sequence[size]);
            while(sequence[i++]>sequence[size]);

            if(i<size)return false;
            i=0;
        }
        return true;
    }
}

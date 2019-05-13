package dfs;

/*
请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子。
例如 a b c e s f c s a d e e 这样的3 X 4 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
*/
public class HasPathSolution {


    private boolean[][] isVisited;
    private int row,col;
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(str==null||matrix==null||str.length<=0||rows<=0||cols<=0||matrix.length<str.length){
            return false;
        }
        isVisited=new boolean[rows][cols];
        row=rows;
        col=cols;
        boolean result=false;
        for (int i=0;i<matrix.length;i++){
            if (matrix[i]==str[0]){

                result= result || match(matrix,i/cols,i%cols,str,0);
            }
        }
        return result;
    }

    private boolean match(char[] matrix,int r, int c, char[] str, int index){
        if(index==str.length) return true;
        if (r<0 || c<0 || r>=row || c>=col) return false;
        int now=col*r+c;
        if(isVisited[r][c]|| matrix[now]!=str[index]) return false;

        isVisited[r][c]=true;
        boolean b= match(matrix,r+1,c,str,index+1)||match(matrix,r-1,c,str, index+1)||
                    match(matrix,r,c+1,str,index+1)|| match(matrix,r,c-1,str,index+1);
        isVisited[r][c]=false;
        return b;
    }
}

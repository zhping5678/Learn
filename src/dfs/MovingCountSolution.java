package dfs;


/*
地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，
但是不能进入行坐标和列坐标的数位之和大于k的格子。
例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
*/
public class MovingCountSolution {

    private boolean[][] isVisited;
    private int sum=0;

    public int movingCount(int threshold, int rows, int cols)
    {
        if(threshold<0){
            return 0;
        }
        isVisited=new boolean[rows][cols];
        DFS(0,0,rows,cols,threshold);
        return sum;
    }

    private void DFS(int r, int l, int rows, int cols, int limit){

        if( r>=0 && l>=0 && r<rows && l<cols &&!isVisited[r][l]&&canReach(limit,r,l)){
            sum++;
            isVisited[r][l]=true;
            DFS(r+1,l,rows,cols,limit);
            DFS(r-1,l,rows,cols,limit);
            DFS(r,l+1,rows,cols,limit);
            DFS(r,l-1,rows,cols,limit);
        }
    }

    private boolean canReach(int threshold, int rows, int cols){
        int result=0;
        while (rows!=0){
            result+=(rows%10);
            rows/=10;
        }
        while (cols!=0){
            result+=(cols%10);
            cols/=10;
        }
        return result<=threshold;
    }
}

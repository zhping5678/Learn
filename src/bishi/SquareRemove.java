package bishi;

public class SquareRemove {

    //有10*10个不同颜色的方块，每个方块可能是红、绿、蓝、黄、紫5种颜色之一。
    //当点击其中某一个方块时，如果它有相邻的同颜色方块，则将所有与此方块连续同颜色相邻的方块消除；
    //剩下的方块中，如果下方有空位则向下移动，如果左侧整列都为空位则向左移动。
    public static void main(String[] args){
        int RED = 0, GREEN = 1, BLUE = 2, YELLOW = 3, PURPLE = 4;

        int p[][] = new int[][]{

            {RED,RED,BLUE,BLUE,GREEN,YELLOW,BLUE,YELLOW,RED,PURPLE},

            {GREEN,GREEN,GREEN,BLUE,RED,PURPLE,RED,YELLOW,YELLOW,BLUE},

            {BLUE,RED,RED,YELLOW,YELLOW,PURPLE,BLUE,GREEN,GREEN,BLUE},

            {YELLOW,RED,BLUE,YELLOW,BLUE,RED,PURPLE,GREEN,GREEN,RED},

            {YELLOW,RED,BLUE,BLUE,PURPLE,GREEN,PURPLE,RED,YELLOW,BLUE},

            {PURPLE,YELLOW,RED,RED,YELLOW,RED,PURPLE,YELLOW,RED,RED},

            {YELLOW,YELLOW,GREEN,PURPLE,GREEN,RED,BLUE,YELLOW,BLUE,GREEN},

            {RED,YELLOW,BLUE,BLUE,YELLOW,GREEN,PURPLE,RED,BLUE,GREEN},

            {GREEN,GREEN,YELLOW,YELLOW,RED,RED,PURPLE,BLUE,BLUE,GREEN},

            {PURPLE,BLUE,RED,RED,PURPLE,YELLOW,BLUE,RED,RED,GREEN}};
    }

    //清除的方块编号
    static void removeAsquare(int[][] p,int num){


    }

}

// package Backtraking;
//Traverse all path up down left and right

import java.util.Arrays;

public class Allpath {
    public static void main(String[] args) {
        boolean[][] board = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
    };
    int[][] path = new int[board.length][board[0].length];


    allpathTraverse("", board,0,0);

    allpathPrint("", board, 0, 0, path, 1);
    }


    public static void allpathTraverse(String p,boolean [][]maze,int row,int col)
    {
        if(row==maze.length-1 && col==maze[0].length-1)
        {
            System.out.println(p);
            return;
        }
        if(!maze[row][col])
        {
            return;
        }

        // i am considering this block in my path
        maze[row][col]=false;

        if(row<maze.length-1)
        {
            allpathTraverse(p+'D', maze, row+1, col);
        }
        if(col<maze[0].length-1)
        {
            allpathTraverse(p+'R', maze, row, col+1);
        }
        if(row>0)
        {
            allpathTraverse(p+'U', maze, row-1, col);
        }
        if(col>0)
        {
            allpathTraverse(p+'L', maze, row, col-1);
        }
          // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
      
        maze[row][col]=true;
    }
    


    public static void allpathPrint(String p,boolean [][]maze,int row,int col,int [][]path,int step)
    {
        if(row==maze.length-1 && col==maze[0].length-1)
        {
            path[row][col]=step;
            for(int[]arr:path)
            {
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        if(!maze[row][col])
        {
            return;
        }

        // i am considering this block in my path
        maze[row][col]=false;
        path[row][col]=step;
        if(row<maze.length-1)
        {
            allpathPrint(p+'D', maze, row+1, col,path,step+1);
        }
        if(col<maze[0].length-1)
        {
            allpathPrint(p+'R', maze, row, col+1,path,step+1);
        }
        if(row>0)
        {
            allpathPrint(p+'U', maze, row-1, col,path,step+1);
        }
        if(col>0)
        {
            allpathPrint(p+'L', maze, row, col-1,path,step+1);
        }
          // this line is where the function will be over
        // so before the function gets removed, also remove the changes that were made by that function
      
        maze[row][col]=true;
        path[row][col]=0;
    }
    
}

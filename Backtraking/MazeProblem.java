import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CountedCompleter;

public class MazeProblem {
    public static void main(String[] args) {
        //To print Total path count
        System.out.println(CountPath(3,3));

        //To print total path
        pathPrint("", 3, 3);
        
        //To print total path through list
        ArrayList<String> ans=pathPrintList("", 3, 3);
        System.out.println(ans);
        
        //Including diagonal path 
        //now representation Vertical -V
        //Horizontal -H
        //Diagonal -D
        //In Diagonal if both row and col are greater than 1 then only we go
        ArrayList<String> ans1=pathPrintDiagonal("", 3, 3);
        System.out.println(ans1);


        //Maze with obstacles
        
        boolean[][] board = {
            {true, true, true},
            {true, false, true},
            {true, true, true}
    };

    pathRestriction("", board, 0, 0);

    }

    //Program to count total path from point A To B draw in copy

    public static int CountPath(int row ,int col)
    {
        //If either row is one or column is one which means only one direction to travel
        //either go straight right or straight left
        if(row==1||col==1)
        {
            return 1;
        }
        int left=CountPath(row-1, col); //Going to down which means reduction in row
        int right=CountPath(row, col-1); //Going to right which means reduction of column
        return left + right;
    }

    //Progra to print all paths

    public static void pathPrint(String p,int row,int col)
    {
        if(row==1 && col==1)
        {
            System.out.println(p);
            return;
        }
        if(row>1)
        {
            pathPrint(p+'D', row-1, col);
        }
        if(col>1)
        {
            pathPrint(p+'R', row, col-1);
        }
        return;
    }

    //If i have to return ans in arrayList
    public static ArrayList<String> pathPrintList(String p,int row,int col)
    {
        if(row==1 && col==1)
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();

        if(row>1)
        {
            list.addAll(pathPrintList(p+'D', row-1, col));
        }
        if(col>1)
        {
            list.addAll(pathPrintList(p+'R', row, col-1));
            
        }
        return list;
    }

    //Traverse all path Diagonal also

    public static ArrayList<String> pathPrintDiagonal(String p,int row,int col)
    {
        if(row==1 && col==1)
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(row>1)
        {
            list.addAll(pathPrintDiagonal(p+'V', row-1, col));
        }
        if(row>1 && col>1)
        {
            list.addAll(pathPrintDiagonal(p+'D', row-1, col-1));
        }
        if(col>1)
        {
            list.addAll(pathPrintDiagonal(p+'H', row, col-1));
        }
        return list;
    }

    //Path restriction "Maze problem with obstacle"

    public static void pathRestriction(String p,boolean[][]maze,int row,int col)
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
        if(row<maze.length-1)
        {
            pathRestriction(p+'D', maze, row+1, col);
        }
        if(col<maze[0].length-1)
        {
            pathRestriction(p+'R', maze, row, col+1);
        }
    }


}

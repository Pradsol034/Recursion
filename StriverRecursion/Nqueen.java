// package Recursion.StriverRecursion;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Nqueen {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Solution obj=new Solution();
        List<List<String>> result = obj.solveNQueens(4);
        
        for (List<String> solution : result) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println(); // Print a blank line between solutions
        }
        
    }
}
class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean [][]board=new boolean[n][n];
        List<List<String>> ans=new ArrayList<>(); 
        Queen(board, 0,ans);
        
        return ans;
    }
    public void Queen(boolean [][]board,int row,List<List<String>> ans)
    {
        if(row==board.length)
        {
            construct(board,ans);
            return ;
        }
        for(int col=0;col<board.length;col++)
        {
            if(isSafe(board,row,col))
            {
                board[row][col]=true;
                Queen(board,row+1,ans);
                board[row][col]=false;    
            }

        }

    }
    public static boolean isSafe(boolean[][]board,int row,int col)
    {
        //vertical checking
        for (int i = 0; i < row; i++) {
            if(board[i][col])
            {
                return false;
            }
        }

        //horizontal left checking
        int leftMax=Math.min(row,col);
        for(int i=1;i<=leftMax;i++)
        {
            if(board[row-i][col-i])
            {
                return false;
            }
        }
        //Horizontal right checking
        int rightMax=Math.min(row,board.length-col-1);
        for (int i = 1; i <=rightMax; i++) {
            if(board[row-i][col+i])
            {
                return false;
            }
        }
        return true;
        
    }
    public static void construct(boolean [][]board,List<List<String>> ans)
    {
        List<String> list=new ArrayList<>();

        for (boolean []i : board) {
            StringBuilder sb=new StringBuilder();
            for (boolean element : i) {
                if(element)
                {
                    sb.append("Q");
                }
                else{
                    sb.append(".");
                }
            }
            list.add(sb.toString());
            
        }
        ans.add(list);
    }
}
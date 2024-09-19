// package Recursion.StriverRecursion;

import java.util.ArrayList;

public class RateInMaze {
    public static void main(String[] args) {
       int[][] mat= {{1, 0, 0, 0},
                {1, 1, 0, 1}, 
                {1, 1, 0, 0},
                {0, 1, 1, 1}
    };
    Solution obj = new Solution();
    System.out.println(obj.findPath(mat));
    }
}
class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans=new ArrayList<>();
        if(mat[0][0]==1)
        {
            RateInMaze("",mat,0,0,ans);
        }
        
        return ans;
    }
    public void RateInMaze(String p,int [][]mat,int row,int col,ArrayList<String> ans)
    {
        if(row==mat.length-1 && col==mat.length-1 && mat[row][col]==1)
        {
            ans.add(p);
            return;
        }
        if(mat[row][col]==0)
        {
            return;
        }
        mat[row][col]=0;
        if(row<mat.length-1){
            RateInMaze(p+'D',mat,row+1,col,ans);
        }
        if(col<mat.length-1){
            RateInMaze(p+'R',mat,row,col+1,ans);
        }
        if(row>0)
        {
            RateInMaze(p+'U',mat,row-1,col,ans);
        }
        if(col>0)
        {
            RateInMaze(p+'L',mat,row,col-1,ans);
        }
        mat[row][col]=1;
    }
}
// package RecursionPatterns;

import java.nio.channels.SelectableChannel;
import java.util.Arrays;

//Bubble Sort using recursion
public class BubbleSort {
    public static void main(String[] args) {
        int []arr={5,4,3,2,1};
        int row=arr.length,col=0;
        // System.out.println(Arrays.toString(Bubblesort(arr,row,col)));
        selection(arr, row, col, col);
        System.err.println(Arrays.toString(arr));
    }
    public static int []Bubblesort(int[]arr,int row,int col)
    {
        if(row==0)
        return arr;
        else{
            if(col<row-1){
            if(arr[col]>arr[col+1])
            {
                int temp=arr[col];
                arr[col]=arr[col+1];
                arr[col+1]=temp;
            }
            return Bubblesort(arr, row,col+1);
            
        }
            else {
                return Bubblesort(arr, row-1, 0);
            }
        }

    }
    
    static void selection(int[] arr, int r, int c, int max) {
        if (r == 0) {
            return;
        }
        if (c < r) {
            if (arr[c] > arr[max]) {
                selection(arr, r, c+1, c);
            } else {
                selection(arr, r, c+1, max);
            }
        } else {
            int temp = arr[max];
            arr[max] = arr[r-1];
            arr[r-1] = temp;
            selection(arr, r-1, 0, 0);
        }
    }

}

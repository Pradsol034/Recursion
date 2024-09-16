package Recursion;
//Binary Search using recursion
public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[]arr={2,3,4,5,99};
        int target=5;
        int start=0;
        int end=arr.length-1;
        System.out.println(search(arr,target,start,end));
    }
    static int search(int []arr,int target,int start,int end)
    {
        if(start>end)
        return -1;

        int mid=start+(end-start)/2;
        if(arr[mid]>target)
        {
            return search(arr, target, start, mid-1);
        }
        return search(arr, target, mid+1, end);
        
    
}
}

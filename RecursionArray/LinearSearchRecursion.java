//Program of linear Search using recursion

import java.util.ArrayList;

public class LinearSearchRecursion {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 4, 4, 5};
        System.out.println(find(arr, 4, 0));
        System.out.println(findindex(arr, 4, 0));
        Findall(arr, 4, 0, list);
        System.out.println(list);
        ArrayList<Integer> an=FindallIndex(arr, 4, 0);
        System.out.println(an);

    }
    //To find element present in the array or not
    public static boolean find(int[]arr,int target,int index)
    {
        if(index==arr.length)
        {
            return false;
        }
        return arr[index]==target ||find(arr,target,index+1);
    }

    //Finde index from array
    public static int findindex(int[]arr,int target,int index)
    {
        if(index==arr.length)
        {
            return -1;
        }
        if(arr[index]==target)
        {
            return index;
        }
        else
        return findindex(arr,target,index+1);

    }

    //Find all index of target element
    static ArrayList<Integer> list=new ArrayList<>();
    static ArrayList<Integer> Findall(int[]arr,int target,int index,ArrayList<Integer> list)
    {
        if(index==arr.length)
        {
           return list;
        }
        if(arr[index]==target)
        {
            list.add(index);
        }
        return Findall(arr,target,index+1,list);


    }

    //Return the list without passing the argument of type list

    public static ArrayList<Integer> FindallIndex(int[]arr,int target,int index)
    {
        ArrayList<Integer> list=new ArrayList<>();
        if(index==arr.length)
        return list;
         // this will contain answer for that function call only
        if(arr[index]==target)
        {
            list.add(index);
        }
        ArrayList<Integer> belowelements=FindallIndex(arr, target, index+1);

        list.addAll(belowelements);
        return list;
    }



}

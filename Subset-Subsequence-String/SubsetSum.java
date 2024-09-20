import java.util.ArrayList;
/* Input: n = 2, arr[] = {2, 3}
Output: 0 2 3 5
Explanation: When no elements is taken then Sum = 0. When only 2 is taken then Sum = 2. When only 3 is taken then Sum = 3. When element 2 and 3 are taken then Sum = 2+3 = 5. */
public class SubsetSum {
    public static void main(String[] args) {
        ArrayList<Integer> arr=new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(1);

        /* 
        Approach First:-Convert ArrayList to String (unprocess) and then solve
        Solution obj=new Solution();
        System.out.println(obj.subsetSums(arr,3));
        
        */
        Solution obj=new Solution();
        System.out.println(obj.subsetSums(arr,3));
    }
}
/* 

This will give error when arr=[2 5 8 11 13] because elements are two digit
so string became 2581113 gives error
class Solution {
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        
        //Convert ArrayList to String
        String unprocess="";
        for(Integer num: arr)
        {
            unprocess+=num;
        }
        // System.out.println(unprocess);
        
        int process=0;
        
        subsetSequence(process,unprocess,ans);
        
        return ans;
    }
    public void subsetSequence(int process,String unprocess,ArrayList<Integer> ans)
    {
        if(unprocess.isEmpty())
        {
            ans.add(process);
            return;
        }
        int digit=unprocess.charAt(0)-'0';
        
        //Taking the element
        subsetSequence(process+digit,unprocess.substring(1),ans);
        subsetSequence(process,unprocess.substring(1),ans);
    }
} */


//To Solve Above problem Iterate on arrylist itself don't create string
//consider arrylist as unprocess 
//since we are using arraylist to base condition is when we reach to last in arraylist
//so we have to use index for itrating


class Solution {
    // Corrected method to calculate subset sums
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        subsetSequence(0, arr, 0, ans); // Start with index 0 and sum as 0
        return ans;
    }
    
    // This method works on the array list directly
    public void subsetSequence(int index, ArrayList<Integer> arr, int currentSum, ArrayList<Integer> ans) {
        // Base case: if we've processed all elements
        if (index == arr.size()) {
            ans.add(currentSum); // Add the current sum to the result list
            return;
        }
        
        // Recursively explore both possibilities: taking or not taking the current element
        
        // Include the current element
        subsetSequence(index + 1, arr, currentSum + arr.get(index), ans);
        
        // Exclude the current element
        subsetSequence(index + 1, arr, currentSum, ans);
    }
}
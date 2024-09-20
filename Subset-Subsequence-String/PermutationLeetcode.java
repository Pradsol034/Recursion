import java.util.*;
class Solution {
    //Approach 2 : Easy just swap the elements
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
     approach2(0,nums,ans);
     return ans;
    }
    public void approach2(int index,int[]nums,List<List<Integer>> ans)
    {
        if(index==nums.length)
        {
            List<Integer>ds=new ArrayList<>();
            for(Integer ele:nums)
            {
                ds.add(ele);
            }
            ans.add(new ArrayList<>(ds));
            return;
        }

        for(int i=index;i<nums.length;i++)
        {
            swap(nums,i,index);
            approach2(index+1,nums,ans);
            swap(nums,i,index);
            
        }
    }
    public void swap(int[]nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;

    }

}
/* 
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        //Approach I which is more time taking
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        boolean[]freq=new boolean[nums.length];
        approach1(ds,freq,nums,ans);
        return ans;
    }
    public void approach1(List<Integer> ds,boolean[]freq,int[]nums,List<List<Integer>> ans)
    {
        if(ds.size()==nums.length)
        {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!freq[i])
            {
                ds.add(nums[i]);
                freq[i]=true;
                approach1(ds,freq,nums,ans);
                ds.remove(ds.size()-1);
                freq[i]=false;
            }
        }
    }
}
 */
public class PermutationLeetcode {
    public static void main(String[] args) {
        int[]arr={1,2,3};
        Solution obj=new Solution();
        obj.permute(arr);
        //Caling to approach II which is more optimized

    }

}

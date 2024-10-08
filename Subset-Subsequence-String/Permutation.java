// package Subset-Subsequence-String;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
        // permutation("", "abc");
        ArrayList<String> ans=permutationsList("", "abc");
        System.out.println(ans);


        //Permutation Count
        System.out.println(permutationCount("", "abc"));
    }

    public static void permutation(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        for (int i = 0; i < p.length()+1 ; i++) {
            {
                String firstsub=p.substring(0, i);
                String secondsub=p.substring(i, p.length());
                permutation(firstsub+ch+secondsub, up.substring(1));

            }
            
        }
    }   
    
    //ArrayList return type
    
    static ArrayList<String> permutationsList(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);

        // local to this call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ans.addAll(permutationsList(f + ch + s, up.substring(1)));
        }
        return ans;
    }

    static int permutationCount(String p,String up)
    {
        if(up.isEmpty())
        {
            return 1;
        }
        int count=0;
        char ch=up.charAt(0);
        for (int i = 0; i < p.length()+1; i++) {
            String f=p.substring(0, i);
            String s=p.substring(i);
            count=count+permutationCount(f+ch+s, up.substring(1));
        }
        return count;
    }
}

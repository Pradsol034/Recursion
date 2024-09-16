//Letter Combination Problem
//https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/

import java.util.ArrayList;

public class Phonepad {
    public static void main(String[] args) {
        pad("","12");

        //ArrayList return Type
        ArrayList<String> ans=LetterCombination("","12");
        System.out.println(ans);
        
        System.out.println(padCount("", "12"));
    }
    public static void pad(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3 /*Included in range */; i < digit*3/*Excluded from range */; i++) {
            char ch=(char)('a'+i);
            pad(p+ch, up.substring(1));
        }
    }


    //Return output as in ArrayList

    public static ArrayList<String> LetterCombination(String p,String up)
    {
        ArrayList<String> list=new ArrayList<>();
        if(up.isEmpty())
        {
            list.add(p);
            return list;
        }
        ArrayList<String> ans=new ArrayList<>();
        int digit=up.charAt(0)-'0';
        for(int i=(digit-1)*3;i<digit*3;i++)
        {
            char ch=(char)('a'+i);
            ans.addAll(LetterCombination(p+ch, up.substring(1)));
        }
        return ans;
    }


    public static int padCount(String p,String up)
    {
        if(up.isEmpty())
        {
            return 1;
        }
        int count=0;
        int digit=up.charAt(0)-'0';
        for (int i = (digit-1)*3 /*Included in range */; i < digit*3/*Excluded from range */; i++) {
            char ch=(char)('a'+i);
            count =count + padCount(p+ch, up.substring(1));
        }
        return count;
    }
}

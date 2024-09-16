// package Subset-Subsequence-String;

import java.util.ArrayList;

public class SubSeq {
    public static void main(String[] args) {
        subseq("", "abc");

        ArrayList<String> str=SubSeqReturnType("", "abc");
        System.out.println(str);
    }
    //p=process or Result
    //up=unprocess or input String
    static void subseq(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        subseq(p+ch, up.substring(1)); //Goint to left or Taking a character
        subseq(p, up.substring(1)); // Going to right or ignoring the character

    }
    //Return list without argument in the input string
    static ArrayList<String> SubSeqReturnType(String p,String up)
    {
        ArrayList<String> list=new ArrayList<>();
        if(up.isEmpty())
        {
            list.add(p);
            return list;
        }
        char ch=up.charAt(0);
        ArrayList<String> left=SubSeqReturnType(p+ch, up.substring(1));
        ArrayList<String> right=SubSeqReturnType(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}

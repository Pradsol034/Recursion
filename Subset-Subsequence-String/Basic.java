// package Subset-Subsequence-String;
//Given a string baccad from 'a' from string and print ans 'bccd'
public class Basic {
    public static void main(String[] args) {
        String str="baccad";
        char key='a';
        StringBuilder sb=new StringBuilder();
        int index=0;
        sb=RemoveCharcter(str,key,sb,index);
        System.err.println(sb);

        //Kunal Approach
        skip("", "baccad"); //Skipping a from string

        //Skipping Substring 'apple' from String 'bcdapplert' ans will be 'bcdrt'
        String ans=skipSubString("bcdapplert");
        System.out.println(ans);
        
        //Skip the substring app from string but not delete the sub app from apple
        String ans1=skipAppNotApple("bcdapplertzzzappttt");
        System.out.println(ans1);

    }

    //My approach brute force
     static StringBuilder RemoveCharcter(String str,char key,StringBuilder sb,int index)
    {
        if(index==str.length())
        {
            return sb;
        }
            char e=str.charAt(index);
            if(e!=key)
            {
                sb.append(e);
            }

        return RemoveCharcter(str, key, sb, index+1);
    }

    //Kunal Approach

    static void skip(String p,String up)
    {
        if(up.isEmpty())
        {
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a')
        {
            skip(p, up.substring(1));
        }
        else{
            skip(p+ch, up.substring(1));
        }
    }

    //Return the String of same above Question
    static String skip(String up) {
        if (up.isEmpty()) {
            return "";
        }

        char ch = up.charAt(0);

        if (ch == 'a') {
            return skip(up.substring(1));
        } else {
            return ch + skip(up.substring(1));
        }
    }

    //Skip the entire substring in the String

    static String skipSubString(String up)
    {
        if(up.isEmpty())
        {
            return "";
        }
        if(up.startsWith("apple"))
        {
            return skipSubString(up.substring(5));
        }
        else{
            return up.charAt(0)+skipSubString(up.substring(1));
        }
    }

    
    static String skipAppNotApple(String up) {
        if (up.isEmpty()) {
            return "";
        }
        if (up.startsWith("app") && !up.startsWith("apple")) {
            return skipAppNotApple(up.substring(3));
        } else {
            return up.charAt(0) + skipAppNotApple(up.substring(1));
        }
    }
    
}

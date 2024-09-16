package Recursion;

public class RecursiveMsg {
    public static void main(String[] args) {
        int n=1;
        printt(n);
    }
    static void printt(int n)
    {
        if(n==10)   return;
        System.out.println(n);
        printt(n+1);
    }
}

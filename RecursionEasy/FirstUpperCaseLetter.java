public class FirstUpperCaseLetter {
    public static void main(String[] args) {
        String s = "geekSforGeekS";
        fun(s,s.length()-1);
    }
    static void fun(String s,int n)
    {
        if(n<0) 
        return;
        char c=s.charAt(n);
        if(c>='A' && c<='Z')
        {
            System.out.println(c);
            return;
        }
        
        fun(s,n-1);
    }
}

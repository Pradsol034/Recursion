//Program to find the minimum value in the array using recursion
public class MinValue {
    public static void main(String[] args) {
        int[] a={11,6,8,71};
        System.out.println(mainVal(a,a.length));
    }
    static int mainVal(int a[],int n)
    {
        if(n==1) return a[0];
        
        return Math.min(a[n-1],mainVal(a, n-1));
    }
}
